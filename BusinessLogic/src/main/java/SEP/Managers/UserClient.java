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


    public UserClient() throws IOException {
        this.gson = new Gson();
        this.handler = ConnectionImplementation.getInstance();
    }

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

    @Override
    public void createUser(User user) throws IOException, ClassNotFoundException {
        NetworkPackage toServer = new UserPackage(NetworkType.CREATE_USER, user);
        String gsonToServer = gson.toJson(toServer);
        handler.sendToDb(gsonToServer);
    }
}
