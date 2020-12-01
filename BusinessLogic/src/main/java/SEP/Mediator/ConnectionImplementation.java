package SEP.Mediator;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ConnectionImplementation implements ConnectionHandler{
    public static final String HOST = "localhost";
    public static final int PORT = 2910;
    private String host;
    private int port;
    private Socket socket;
    OutputStream outputStream;
    InputStream inputStream;
    private static Object lock = new Object();
    private static ConnectionImplementation instance;

    private ConnectionImplementation() throws IOException {
        this.port = PORT;
        this.host = HOST;
        connect();
    }

    public static ConnectionImplementation getInstance() throws IOException
    {
        if(instance == null)
        {
            synchronized (lock)
            {
                if (instance == null)
                {
                    instance = new ConnectionImplementation();
                }
            }
        }
        return instance;
    }

    private void connect() throws IOException {
        this.socket = new Socket(host, port);
        this.outputStream = socket.getOutputStream();
        this.inputStream = socket.getInputStream();
    }

    @Override
    public void disconnect() throws IOException {
        this.inputStream.close();
        this.outputStream.close();
        socket.close();
    }

    @Override
    public String readFromDb() throws IOException {
        return read(inputStream);
    }

    @Override
    public void sendToDb(String toServer) throws IOException {
        send(outputStream,toServer);
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
