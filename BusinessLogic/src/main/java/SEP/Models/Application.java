package SEP.Models;

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
    private String user;

    public Application() {
    }

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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public ObjectId getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(ObjectId applicationId) {
        this.applicationId = applicationId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobExperience() {
        return jobExperience;
    }

    public void setJobExperience(String jobExperience) {
        this.jobExperience = jobExperience;
    }

    public String getDrivingLicenses() {
        return drivingLicenses;
    }

    public void setDrivingLicenses(String drivingLicenses) {
        this.drivingLicenses = drivingLicenses;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getPreferableWorkTime() {
        return preferableWorkTime;
    }

    public void setPreferableWorkTime(String preferableWorkTime) {
        this.preferableWorkTime = preferableWorkTime;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

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
