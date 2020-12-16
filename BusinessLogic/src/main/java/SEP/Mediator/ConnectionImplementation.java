package SEP.Mediator;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * ConnectionImplementation implements ConnectionHandler interface
 */
public class ConnectionImplementation implements ConnectionHandler {
    public static final String HOST = "localhost";
    public static final int PORT = 2020;
    private String host;
    private int port;
    private Socket socket;
    OutputStream outputStream;
    InputStream inputStream;
    private static Object lock = new Object();
    private static ConnectionImplementation instance;

    /**
     * Constructor
     * Initialise the port and, host  and calls connect method
     *
     * @throws IOException
     */
    private ConnectionImplementation() throws IOException {
        this.port = PORT;
        this.host = HOST;
        connect();
    }

    /**
     * Checks if there is any instance of this class and returns it or creates it
     *
     * @return An instance of ConnectionImplementation
     * @throws IOException
     */
    public static ConnectionImplementation getInstance() throws IOException {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new ConnectionImplementation();
                }
            }
        }
        return instance;
    }

    /**
     * Initialise the socket, outputStream and inputStream
     *
     * @throws IOException
     */
    private void connect() throws IOException {
        this.socket = new Socket(host, port);
        this.outputStream = socket.getOutputStream();
        this.inputStream = socket.getInputStream();
    }

    /**
     * Close all connections
     *
     * @throws IOException
     */
    @Override
    public void disconnect() throws IOException {
        this.inputStream.close();
        this.outputStream.close();
        socket.close();
    }

    /**
     * Calls method read
     *
     * @return A string with values from read method
     * @throws IOException
     */
    @Override
    public String readFromDb() throws IOException {
        return read(inputStream);
    }

    /**
     * Calls local send method
     *
     * @param toServer
     * @throws IOException
     */
    @Override
    public void sendToDb(String toServer) throws IOException {
        send(outputStream, toServer);
    }

    /**
     * Deserialise the byte message from data tire
     *
     * @param inputStream
     * @return A json string from data tire
     * @throws IOException
     */
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

    /**
     * Serialize in byte the message and sends it to data tire
     *
     * @param outputStream
     * @param toSend
     * @throws IOException
     */
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
