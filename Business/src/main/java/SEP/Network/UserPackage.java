package SEP.Network;

import SEP.Models.User;

public class UserPackage extends NetworkPackage {

    private User user;

    public UserPackage(NetworkType type, User user) {
        super(type);
        this.user = user;
    }

    public User getUser()
    {
        return user;
    }

    public String toString()
    {
        return getType() + ": " + user;
    }
}
