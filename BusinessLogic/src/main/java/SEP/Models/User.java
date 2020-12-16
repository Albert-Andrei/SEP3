package SEP.Models;

import org.bson.types.ObjectId;

/**
 * User class
 */
public class User {
    private ObjectId _id;
    private String username;
    private String password;
    private int securityLevel;
    private String firstName;
    private String lastName;
    private String emali;
    private String userType;

    /**
     * Non argument constructor
     */
    public User() {
    }

    /**
     * Constructor with two parameters
     * @param firstName
     * @param lastName
     */
    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * A multi value constructor
     * @param _id
     * @param username
     * @param password
     * @param securityLevel
     * @param firstName
     * @param lastName
     * @param phoneNr
     * @param emali
     * @param city
     * @param userType
     */
    public User(ObjectId _id, String username, String password, int securityLevel, String firstName, String lastName, String phoneNr, String emali, String city, String userType) {
        this._id = _id;
        this.username = username;
        this.password = password;
        this.securityLevel = securityLevel;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emali = emali;
        this.userType = userType;
    }

    /**
     * Returns the ID value
     * @return ID value
     */
    public ObjectId get_id() {
        return _id;
    }

    /**
     * Sets the ID value
     * @param _id
     */
    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    /**
     * Returns the username value
     * @return username value
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the password value
     * @return password value
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the securityLevel value
     * @return securityLevel value
     */
    public int getSecurityLevel() {
        return securityLevel;
    }

    /**
     * Sets tje security level
     * @param securityLevel
     */
    public void setSecurityLevel(int securityLevel) {
        this.securityLevel = securityLevel;
    }

    /**
     * Returns the firstName value
     * @return firstName value
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the lastName value
     * @return lastName value
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the emali value
     * @return emali value
     */
    public String getEmali() {
        return emali;
    }

    /**
     * Stes the emali
     * @param emali
     */
    public void setEmali(String emali) {
        this.emali = emali;
    }

    /**
     * Returns the userType value
     * @return userType value
     */
    public String getUserType() {
        return userType;
    }

    /**
     * Sets the user type
     * @param userType
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * Returns a string with all information about the User
     * @return String with all information
     */
    @Override
    public String toString() {
        return "User{" +
                "_id=" + _id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", securityLevel=" + securityLevel +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emali='" + emali + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }
}
