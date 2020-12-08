package Mediator;

import Models.ApplicationModel;
import Models.ApplicationModelImplementation;
import Models.UserModel;
import Models.UserModelImplementation;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientConnector implements Runnable {
    final int PORT = 2910;
    private ServerSocket welcomeSocket;
    private UserModel userModel;
    private ApplicationModel applicationModel;

    public ClientConnector() throws IOException {
        this.welcomeSocket = new ServerSocket(PORT);
        MongoClient mongoClient = MongoClients.create(
                "mongodb+srv://shared:12345@cluster0.anhd1.mongodb.net/Cluster0?retryWrites=true&w=majority");
        MongoDatabase database = mongoClient.getDatabase("SEP");
        this.userModel = new UserModelImplementation(database);
        this.applicationModel = new ApplicationModelImplementation(database);
    }

    @Override
    public void run() {
        System.out.println("Server started...");
        while (true) {
                System.out.println("Waiting for client...");
            try {
                Socket socket = welcomeSocket.accept();
                ClientHandler clientHandler = new ClientHandler(socket, userModel,applicationModel);
                Thread t = new Thread(clientHandler);
                t.setDaemon(true);
                t.start();
                System.out.println("Client connected");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

