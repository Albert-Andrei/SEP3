package SEP.Services;


import SEP.Managers.UserClient;
import SEP.Managers.UserRemoteModel;
import SEP.Models.User;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserServiceImplementation implements UserService {
    private UserRemoteModel remoteModel;

    public UserServiceImplementation() throws IOException {
        this.remoteModel = new UserClient();
    }


    @Override
    public User validateUser(String username, String password) throws IOException, ClassNotFoundException {
        User userFromDb = remoteModel.validateUser(username, password);
        User oopse = new User();

        if (userFromDb == null) {
            oopse.setUsername("User not found");
            return oopse;
        } else if (!userFromDb.getPassword().equals(password)) {
            oopse.setUsername("Wrong password");
            return oopse;
        } else
        {
            return userFromDb;
        }
    }

    @Override
    public void createUser(User user) throws IOException, ClassNotFoundException {
        remoteModel.createUser(user);
    }


    @Override
    public void updateUser(User user) {

    }

    @Override
    public void removeUser(int id) {

    }
}
