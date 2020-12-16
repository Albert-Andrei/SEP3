package SEP.Network;

import SEP.Models.User;

public class UserPackage extends NetworkPackage {

    private User user;

    /**
     * Constructor
     * @param type
     * @param user
     */
    public UserPackage(NetworkType type, User user) {
        super(type);
        this.user = user;
    }

    /**
     * Returns the user
     * @return user
     */
    public User getUser()
    {
        return user;
    }

    /**
     * String value of the all information in the user class and the enum network type
     * @return A string with information
     */
    public String toString()
    {
        return getType() + ": " + user;
    }
}
