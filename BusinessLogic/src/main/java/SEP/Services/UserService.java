package SEP.Services;

import SEP.Models.User;
import java.io.IOException;

public interface UserService {
    User validateUser(String username, String password) throws IOException, ClassNotFoundException;
    void createUser(User User) throws IOException, ClassNotFoundException;
    void updateUser(User user);
    void removeUser(int id);
}
