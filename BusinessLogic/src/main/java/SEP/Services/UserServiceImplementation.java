package SEP.Services;


import SEP.Managers.UserClient;
import SEP.Managers.UserRemoteModel;
import SEP.Models.User;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * UserServiceImplementation class implements UserService class
 */
@Service
public class UserServiceImplementation implements UserService {

    private UserRemoteModel remoteModel;

    /**
     * Constructor, initialize the variables
     *
     * @throws IOException
     */
    public UserServiceImplementation() throws IOException {
        this.remoteModel = new UserClient();
    }

    /**
     * Calls validateUser method from UserRemoteModel in order to get a user from database with same username
     * Checking if the passwords match with the user that is stored in database
     *
     * @param username
     * @param password
     * @return A User
     * @throws IOException
     * @throws ClassNotFoundException
     */
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
        } else {
            return userFromDb;
        }
    }

    /**
     * Calls createUser method from UserRemoteModel in order to store a user in database
     * Sets the security level before sending to database
     *
     * @param user
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void createUser(User user) throws IOException, ClassNotFoundException {
        if (user.getUserType().equals("Employee")) {
            user.setSecurityLevel(3);
        } else {
            user.setSecurityLevel(4);
        }

        System.out.println(user.getUsername().toLowerCase() + " <New user + usermae");
        User userFromDb = remoteModel.validateUser(user.getUsername(), user.getPassword());

        if (userFromDb == null) {
            remoteModel.createUser(user);
        } else {
            throw new IOException("Username already used");
        }
    }

    /**
     * Not implemented
     *
     * @param user
     */
    @Override
    public void updateUser(User user) {
        // Not implemented yet
    }

    /**
     * Not implemented
     *
     * @param id
     */
    @Override
    public void removeUser(int id) {
        // Not implemented yet
    }
}
