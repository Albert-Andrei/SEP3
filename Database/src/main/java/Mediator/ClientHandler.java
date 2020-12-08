package Mediator;

import Data.Application;
import Data.User;
import Models.ApplicationModel;
import Models.UserModel;
import Network.*;
import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class ClientHandler implements Runnable {
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private UserModel modelManager;
    private ApplicationModel applicationModel;
    private Gson gson;


    public ClientHandler(Socket socket, UserModel modelManager,ApplicationModel applicationModel) throws IOException {
        this.socket = socket;
        inputStream = socket.getInputStream();
        outputStream = socket.getOutputStream();
        this.modelManager = modelManager;
        this.applicationModel = applicationModel;
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

                        User returnedUser = modelManager.ValidateUser(user.getUsername());
                        UserPackage outgoingUserPackage = new UserPackage(NetworkType.USER, returnedUser);

                        String response = gson.toJson(outgoingUserPackage);
                        send(outputStream, response);

                        break;
                    case CREATE_USER:
                        UserPackage userToCreateFromClient = gson.fromJson(message, UserPackage.class);
                        User userToCreate = userToCreateFromClient.getUser();

                        modelManager.CreateUser(userToCreate);
                        break;
                    case ERROR:
                        send(outputStream,"ERROR");
                        break;
                    case CREATE_APPLICATION:
                        ApplicationPackage applicationPackage = gson.fromJson(message, ApplicationPackage.class);
                        Application application = applicationPackage.getApplication();

                        applicationModel.createApplication(application);
                        break;
                    case GET_ALL_APPLICATIONS:
                        ApplicationListPackage applicationPackageAll = gson.fromJson(message, ApplicationListPackage.class);
                        List<Application> applicationAll = applicationPackageAll.getApplicationList();

                        List<Application> applicationAll1 = applicationModel.getAllApplications();
                        ApplicationListPackage applicationPackage3 = new ApplicationListPackage(NetworkType.GET_ALL_APPLICATIONS, applicationAll1);

                        String response3 = gson.toJson(applicationPackage3);
                        System.out.println(response3 + "MESSAGE");
                        send(outputStream, response3);
                        break;
                    case GET_APPLICATION:
                        ApplicationPackage applicationPackage1 = gson.fromJson(message, ApplicationPackage.class);
                        Application application1 = applicationPackage1.getApplication();

                        Application application2 = applicationModel.getApplication(application1.getApplicationId());
                        ApplicationPackage applicationPackage2 = new ApplicationPackage(NetworkType.GET_APPLICATION, application2);

                        String response1 = gson.toJson(applicationPackage2);
                        send(outputStream, response1);
                        break;
                    case DELETE_APPLICATION:
                        break;
                    case UPDATE_APPLICATION:
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
