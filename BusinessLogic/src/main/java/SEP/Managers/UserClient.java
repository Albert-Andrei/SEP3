package SEP.Managers;

import SEP.Mediator.ConnectionHandler;
import SEP.Mediator.ConnectionImplementation;
import SEP.Models.User;
import SEP.Network.NetworkPackage;
import SEP.Network.NetworkType;
import SEP.Network.UserPackage;
import com.google.gson.Gson;

import java.io.*;

public class UserClient implements UserRemoteModel{
    private Gson gson;
    ConnectionHandler handler;


    /**
     * Constructor
     * @throws IOException
     */
    public UserClient() throws IOException {
        this.gson = new Gson();
        this.handler = ConnectionImplementation.getInstance();
    }

    /**
     * Creates a new user and set the username and password // NOT THE BEST WAY OF DOING IT BUT IT WORKS
     * Creates a new NetworkPackage of UserPackage type and serialize it
     * Send the gson to data tire
     * Deserializing the response from data tire
     * Returning the user
     *
     * @param username
     * @param password
     * @return user
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override public User validateUser(String username, String password) throws IOException, ClassNotFoundException {
        User toCheck = new User();
        toCheck.setUsername(username);
        toCheck.setPassword(password);

        NetworkPackage toServer = new UserPackage(NetworkType.USER, toCheck);
        String gsonToServer = gson.toJson(toServer);
        handler.sendToDb(gsonToServer);

        String respose = handler.readFromDb();
        UserPackage checked = gson.fromJson(respose, UserPackage.class);
        return checked.getUser();
    }

    /**
     * Creates a new NetworkPackage of UserPackage type and serialize it
     * Send the gson to data tire
     *
     * @param user
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void createUser(User user) throws IOException, ClassNotFoundException {
        NetworkPackage toServer = new UserPackage(NetworkType.CREATE_USER, user);
        String gsonToServer = gson.toJson(toServer);
        handler.sendToDb(gsonToServer);
    }
}
