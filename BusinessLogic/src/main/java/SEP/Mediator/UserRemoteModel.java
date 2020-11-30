package SEP.Mediator;

import SEP.Models.User;

import java.io.IOException;

public interface UserRemoteModel {
    void connect() throws IOException;
    void disconnect() throws IOException;
    User validateUser(String username, String password) throws IOException, ClassNotFoundException;
    void createUser(User user) throws IOException, ClassNotFoundException;
}
