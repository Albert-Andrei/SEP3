package SEP.Mediator;

import SEP.Models.User;
import SEP.Network.NetworkPackage;
import SEP.Network.NetworkType;
import SEP.Network.UserPackage;
import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;

public class UserClient implements UserRemoteModel{
    public static final String HOST = "localhost";
    public static final int PORT = 2910;
    private String host;
    private int port;
    private Socket socket;
    private Gson gson;
    OutputStream outputStream;
    InputStream inputStream;
    User checked;
    private static UserClient instance;
    private static Object lock = new Object();


    private UserClient() throws IOException {
        this.port = PORT;
        this.host = HOST;
        this.gson = new Gson();
        connect();
    }

    public static UserClient getInstance() throws IOException
    {
        if(instance == null)
        {
            synchronized (lock)
            {
                if (instance == null)
                {
                    instance = new UserClient();
                }
            }
        }
        return instance;
    }

    @Override public void connect() throws IOException
    {
        this.socket = new Socket(host, port);
        this.outputStream = socket.getOutputStream();
        this.inputStream = socket.getInputStream();
    }

    @Override public void disconnect() throws IOException
    {
        this.inputStream.close();
        this.outputStream.close();
        socket.close();
    }

    @Override public User validateUser(String username, String password) throws IOException, ClassNotFoundException {
        User toCheck = new User();
        toCheck.setUsername(username);
        toCheck.setPassword(password);

        NetworkPackage toServer = new UserPackage(NetworkType.USER, toCheck);
        String gsonToServer = gson.toJson(toServer);
        send(outputStream,gsonToServer);

        String respose = read(inputStream);
        UserPackage checked = gson.fromJson(respose, UserPackage.class);
        return checked.getUser();
    }

    @Override
    public void createUser(User user) throws IOException, ClassNotFoundException {
        NetworkPackage toServer = new UserPackage(NetworkType.CREATE_USER, user);
        String gsonToServer = gson.toJson(toServer);
        send(outputStream,gsonToServer);
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
}
