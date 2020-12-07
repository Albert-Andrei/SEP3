package Mediator;

import Data.Shift;
import Data.User;
import Models.ShiftModel;
import Models.ShiftModelImplementation;
import Models.UserModel;
import Network.NetworkPackage;
import Network.NetworkType;
import Network.ShiftPackage;
import Network.UserPackage;
import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private UserModel userModelManager;
    private ShiftModel shiftModelManager;
    private Gson gson;


    public ClientHandler(Socket socket, UserModel userModelManager, ShiftModel shiftModelManager) throws IOException {
        this.socket = socket;
        inputStream = socket.getInputStream();
        outputStream = socket.getOutputStream();
        this.userModelManager = userModelManager;
        this.shiftModelManager = shiftModelManager;
        this.gson = new Gson();
    }


    @Override
    public void run() {
        while (true) {
            try {
                //reading message from the client
                String message = read(inputStream);

                //incoming data
                System.out.println("Client > " + message);
                NetworkPackage incoming = gson.fromJson(message, NetworkPackage.class);

                switch (incoming.getType()) {
                    case USER:
                        UserPackage incomingUserPackageNumber = gson.fromJson(message, UserPackage.class);
                        User user = incomingUserPackageNumber.getUser();

                        User returnedUser = userModelManager.ValidateUser(user.getUsername());
                        UserPackage outgoingUserPackage = new UserPackage(NetworkType.USER, returnedUser);

                        String response = gson.toJson(outgoingUserPackage);
                        send(outputStream, response);

                        break;
                    case CREATE_USER:
                        UserPackage userToCreateFromClient = gson.fromJson(message, UserPackage.class);
                        User userToCreate = userToCreateFromClient.getUser();

                        userModelManager.CreateUser(userToCreate);
                        break;

                    case CREATE_SHIFT:
                        ShiftPackage shiftToCreateFromClient = gson.fromJson(message, ShiftPackage.class);
                        Shift shiftToCreate = shiftToCreateFromClient.getShift();

                        System.out.println("Opa db");
                        shiftModelManager.CreateShift(shiftToCreate);
                        break;
                    case ERROR:
                        send(outputStream, "ERROR");
                        break;
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Client disconnected");
                break;
            }
        }
    }

    private static void send(OutputStream outputStream, String toSend) throws IOException {
        byte[] toSendBytes = toSend.getBytes();
        int toSendLen = toSendBytes.length;
        byte[] toSendLenBytes = new byte[4];
        toSendLenBytes[0] = (byte) (toSendLen & 0xff);
        toSendLenBytes[1] = (byte) ((toSendLen >> 8) & 0xff);
        toSendLenBytes[2] = (byte) ((toSendLen >> 16) & 0xff);
        toSendLenBytes[3] = (byte) ((toSendLen >> 24) & 0xff);
        outputStream.write(toSendLenBytes);
        outputStream.write(toSendBytes);
    }

    private static String read(InputStream inputStream) throws IOException {
        //translating input
        byte[] lenBytes = new byte[4];
        inputStream.read(lenBytes, 0, 4);
        int len = (((lenBytes[3] & 0xff) << 24) | ((lenBytes[2] & 0xff) << 16) |
                ((lenBytes[1] & 0xff) << 8) | (lenBytes[0] & 0xff));
        byte[] receivedBytes = new byte[len];
        inputStream.read(receivedBytes, 0, len);

        String receivedFromClient = new String(receivedBytes, 0, len);

        return receivedFromClient;
    }
}
