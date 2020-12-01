package SEP.Managers;

import SEP.Models.User;

import java.io.IOException;

public interface UserRemoteModel {
    User validateUser(String username, String password) throws IOException, ClassNotFoundException;
    void createUser(User user) throws IOException, ClassNotFoundException;
}
