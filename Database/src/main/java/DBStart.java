import Mediator.ClientConnector;

import java.io.IOException;

public class DBStart {
    public static void main(String[] args) throws IOException {

        ClientConnector clientConnector = new ClientConnector();
        Thread serverThread = new Thread(clientConnector);
        serverThread.start();
    }
}
