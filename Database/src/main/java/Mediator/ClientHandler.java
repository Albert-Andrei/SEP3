package Mediator;
import Data.Shift;
import Data.User;
import Models.ShiftModel;
import Models.ShiftModelImplementation;
import Data.Application;
import Data.User;
import Models.ApplicationModel;
import Models.UserModel;
import Network.*;
import com.google.gson.Gson;

import java.util.List;
import java.io.*;
import java.net.Socket;
import java.util.List;

public class ClientHandler implements Runnable {
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private UserModel userModelManager;
    private ShiftModel shiftModelManager;
    private ApplicationModel applicationModel;
    private Gson gson;


    public ClientHandler(Socket socket, UserModel userModelManager, ShiftModel shiftModelManager, ApplicationModel applicationModel) throws IOException {
        this.socket = socket;
        inputStream = socket.getInputStream();
        outputStream = socket.getOutputStream();
        this.userModelManager = userModelManager;
        this.shiftModelManager = shiftModelManager;
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

                        System.out.println("Opa db> " + shiftToCreate);
                        shiftModelManager.CreateShift(shiftToCreate);
                        break;

                    case SEND_USERNAME:
                        StringPackage usernameFromT2 = gson.fromJson(message, StringPackage.class);
                        String username = usernameFromT2.getString();

                        List<Shift> listToBusiness = shiftModelManager.GetAllShiftsForOneUser(username);
                        ListPackage outgoingListPackage = new ListPackage(NetworkType.GET_SHIFTS_ONE_USER, listToBusiness);

                        String listOfShifts = gson.toJson(outgoingListPackage);
                        send(outputStream, listOfShifts);
                        break;

                    case GET_ALL_SHIFTS:
                        List<Shift> listOfAllShifts = shiftModelManager.GetAllShifts();
                        ListPackage outgoingListOfAllPackage = new ListPackage(NetworkType.SEND_ALL_SHIFTS, listOfAllShifts);

                        String AllShifts = gson.toJson(outgoingListOfAllPackage);
                        send(outputStream, AllShifts);
                        break;

                    case ERROR:
                        send(outputStream, "ERROR");
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
                        send(outputStream, response3);
                        break;
                    case GET_APPLICATION:
                        QueryPackage queryPackage = gson.fromJson(message,QueryPackage.class);
                        Object object = queryPackage.getObject();
                        String idToGetApplication = object.toString();
                        Application application1 = applicationModel.getApplication(idToGetApplication);

                        ApplicationPackage applicationPackage1 = new ApplicationPackage(NetworkType.GET_APPLICATION, application1);
                        String response4 = gson.toJson(applicationPackage1);
                        send(outputStream,response4);
                        break;
                    case UPDATE_APPLICATION:
                        ApplicationPackage applicationPackage4 = gson.fromJson(message, ApplicationPackage.class);
                        Application application3 = applicationPackage4.getApplication();
                        String getApplicationStringId = application3.getId();
                        applicationModel.updateApplication(getApplicationStringId,application3);
                        break;
                    case DELETE_SHIFT:
                        QueryPackage shiftPackage = gson.fromJson(message,QueryPackage.class);
                        Object object1 = shiftPackage.getObject();
                        String idToGetShift = object1.toString();
                        shiftModelManager.removeShift(idToGetShift);

                        break;
                }

            } catch (Exception e) {
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
