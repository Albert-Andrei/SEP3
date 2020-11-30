package Models;

import Data.User;

public interface UserModel {
    User ValidateUser(String userName);
    void CreateUser(User user);
}
