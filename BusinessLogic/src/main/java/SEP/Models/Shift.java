package SEP.Models;

import org.bson.types.ObjectId;

import java.util.Date;

public class Shift {
    private ObjectId _id;
    private String username;
    private String companyName;
    private Date date;
    private String startHour;
    private String endHour;
    private String description;
    private String requirements;
    private float hourWage;

    public Shift() {
    }

    public Shift(ObjectId _id, String username, String companyName, Date date, String startHour, String endHour, String description, String requirements, float hourWage) {
        this._id = _id;
        this.username = username;
        this.companyName = companyName;
        this.date = date;
        this.startHour = startHour;
        this.endHour = endHour;
        this.description = description;
        this.requirements = requirements;
        this.hourWage = hourWage;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public String getEndHour() {
        return endHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public float getHourWage() {
        return hourWage;
    }

    public void setHourWage(float hourWage) {
        this.hourWage = hourWage;
    }

    @Override
    public String toString() {
        return "Shift{" +
                "_id=" + _id +
                ", username='" + username + '\'' +
                ", companyName='" + companyName + '\'' +
                ", date=" + date +
                ", startHour='" + startHour + '\'' +
                ", endHour='" + endHour + '\'' +
                ", description='" + description + '\'' +
                ", requirements='" + requirements + '\'' +
                ", hourWage=" + hourWage +
                '}';
    }
}
