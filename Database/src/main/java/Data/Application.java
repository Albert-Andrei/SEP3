package Data;

import com.google.gson.annotations.Expose;
import org.bson.types.ObjectId;

public class Application {

    private ObjectId applicationId;
    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String jobExperience;
    private String drivingLicenses;
    private String languages;
    private String preferableWorkTime;
    private boolean available;
    @Expose(serialize = true, deserialize = true)
    private String user;

    /**
     * Non argument constructor
     */
    public Application() {
    }

    /**
     * Class constructor to create a Application from input from user
     * @param applicationId
     * @param id
     * @param firstName
     * @param lastName
     * @param phoneNumber
     * @param email
     * @param jobExperience
     * @param drivingLicenses
     * @param languages
     * @param preferableWorkTime
     * @param available
     * @param user
     */
    public Application(ObjectId applicationId, String id, String firstName, String lastName, String phoneNumber, String email, String jobExperience, String drivingLicenses, String languages, String preferableWorkTime, boolean available, String user) {
        this.applicationId = applicationId;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.jobExperience = jobExperience;
        this.drivingLicenses = drivingLicenses;
        this.languages = languages;
        this.preferableWorkTime = preferableWorkTime;
        this.available = available;
        this.user = user;
    }

    /**
     * Getter fot username
     * @return username
     */
    public String getUser() {
        return user;
    }

    /**
     * Setts the username
     * @param user
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Getter fot applicationId
     * @return applicationId
     */
    public ObjectId getApplicationId() {
        return applicationId;
    }

    /**
     * Sets the applicationId
     * @param applicationId
     */
    public void setApplicationId(ObjectId applicationId) {
        this.applicationId = applicationId;
    }

    /**
     * Getter fot id
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter fot firstName
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the firstName
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter fot lastName
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the lastName
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter fot phoneNumber
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phoneNumber
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Getter fot email
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the Email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter fot jobExperience
     * @return jobExperience
     */
    public String getJobExperience() {
        return jobExperience;
    }

    /**
     * Sets the Job Experience
     * @param jobExperience
     */
    public void setJobExperience(String jobExperience) {
        this.jobExperience = jobExperience;
    }

    /**
     * Getter fot drivingLicense
     * @return drivingLicense
     */
    public String getDrivingLicenses() {
        return drivingLicenses;
    }

    /**
     * Sets the Drive Licence
     * @param drivingLicenses
     */
    public void setDrivingLicenses(String drivingLicenses) {
        this.drivingLicenses = drivingLicenses;
    }

    /**
     * Getter fot language
     * @return language
     */
    public String getLanguages() {
        return languages;
    }

    /**
     * Sets the language
     * @param languages
     */
    public void setLanguages(String languages) {
        this.languages = languages;
    }

    /**
     * Getter fot preferableWorkTime
     * @return preferableWorkTime
     */
    public String getPreferableWorkTime() {
        return preferableWorkTime;
    }

    /**
     * Sets the Prferable Work Time
     * @param preferableWorkTime
     */
    public void setPreferableWorkTime(String preferableWorkTime) {
        this.preferableWorkTime = preferableWorkTime;
    }

    /**
     * Gets the application state
     * @return true or false
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Sets the state
     * @param available
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * Updates all values in application
     * @param toUpdate
     */
    public void Update(Application toUpdate) {
        firstName = toUpdate.firstName;
        lastName = toUpdate.lastName;
        email = toUpdate.email;
        phoneNumber = toUpdate.phoneNumber;
        jobExperience = toUpdate.jobExperience;
        languages = toUpdate.languages;
        drivingLicenses = toUpdate.drivingLicenses;
        preferableWorkTime = toUpdate.preferableWorkTime;
        available = toUpdate.available;
    }

    /**
     * Returns a string with all information about the shift
     * @return String with all infotmation
     */
    @Override
    public String toString() {
        return "Application{" +
                "applicationId=" + applicationId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", jobExperience='" + jobExperience + '\'' +
                ", drivingLicenses='" + drivingLicenses + '\'' +
                ", languages='" + languages + '\'' +
                ", preferableWorkTime='" + preferableWorkTime + '\'' +
                ", available=" + available +
                '}';

}
}


