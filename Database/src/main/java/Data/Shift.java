package Data;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.bson.types.ObjectId;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Shift {
    private ObjectId _id;
    private String shiftId;
    @Expose(serialize = true, deserialize = true)
    private String username;
    @Expose(serialize = true, deserialize = true)
    private String companyName;
    @Expose(serialize = true, deserialize = true)
    private String jobTitle;
    @Expose(serialize = true, deserialize = true)
    private String description;
    @Expose(serialize = true, deserialize = true)
    private String requirements;
    @Expose(serialize = true, deserialize = true)
    private float hourWage;
    @Expose(serialize = true, deserialize = true)
    private List<String> pendingList;
    @Expose(serialize = true, deserialize = true)
    private List<String> approvedList;
    @Expose(serialize = true, deserialize = true)
    private List<String> rejectedList;
    @Expose(serialize = true, deserialize = false)
    private Date date;
    @Expose(serialize = true, deserialize = true)
    private String preferableWorkTime;


    /**
     * A non argument constructor
     * Set initialise all lists
     */
    public Shift() {
        pendingList = new ArrayList<>();
        approvedList = new ArrayList<>();
        rejectedList = new ArrayList<>();
    }

    /**
     * Class constructor to create a Shift from input from user
     * @param _id
     * @param shiftId
     * @param username
     * @param companyName
     * @param jobTitle
     * @param description
     * @param requirements
     * @param hourWage
     * @param pendingList
     * @param approvedList
     * @param rejectedList
     * @param date
     * @param preferableWorkTime
     */
    public Shift(ObjectId _id, String shiftId, String username, String companyName, String jobTitle, String description, String requirements, float hourWage, List<String> pendingList, List<String> approvedList, List<String> rejectedList, Date date, String preferableWorkTime) {
        this._id = _id;
        this.shiftId = shiftId;
        this.username = username;
        this.companyName = companyName;
        this.jobTitle = jobTitle;
        this.description = description;
        this.requirements = requirements;
        this.hourWage = hourWage;
        this.pendingList = pendingList;
        this.approvedList = approvedList;
        this.rejectedList = rejectedList;
        this.date = date;
        this.preferableWorkTime = preferableWorkTime;
    }

    /**
     * Return the shiftId
     * @return The shift ID
     */
    public String getShiftId() {
        return shiftId;
    }

    public void setShiftId(String shiftId) {
        this.shiftId = shiftId;
    }

    /**
     * Return the Job Title
     * @return The Job Title
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * Set the Job title
     * @param jobTitle
     */
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    /**
     * Return the ID
     * @return The ID
     */
    public ObjectId get_id() {
        return _id;
    }

    /**
     * Sets the ID
     * @param _id
     */
    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    /**
     * Return the Username
     * @return The Username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the Username
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Return the Company Name
     * @return The company name
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Sets the company name
     * @param companyName
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * Return the date
     * @return The date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Return the Preferable work time
     * @return The preferable work time
     */
    public String getPreferableWorkTime() {
        return preferableWorkTime;
    }

    /**
     * Sets the preferable work time
     * @param preferableWorkTime
     */
    public void setPreferableWorkTime(String preferableWorkTime) {
        this.preferableWorkTime = preferableWorkTime;
    }

    /**
     * Return the shift description
     * @return The shift description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the shift description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Return the shift requirements
     * @return The shift requirements
     */
    public String getRequirements() {
        return requirements;
    }

    /**
     * Sets the shift requirements
     * @param requirements
     */
    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    /**
     * Return the hourwage
     * @return The hourwage
     */
    public float getHourWage() {
        return hourWage;
    }

    /**
     * Sets the hourwage
     * @param hourWage
     */
    public void setHourWage(float hourWage) {
        this.hourWage = hourWage;
    }

    /**
     * Return the pendingList
     * @return The pending list
     */
    public List<String> getPendingList() {
        return pendingList;
    }

    /**
     * Setst the pendingList
     * @param pendingList
     */
    public void setPendingList(List<String> pendingList) {
        this.pendingList = pendingList;
    }

    /**
     * Return the approvedList
     * @return The approvedList
     */
    public List<String> getApprovedList() {
        return approvedList;
    }

    /**
     * Setst the approvedList
     * @param approvedList
     */
    public void setApprovedList(List<String> approvedList) {
        this.approvedList = approvedList;
    }

    /**
     * Return the rejectedList
     * @return The rejectedList
     */
    public List<String> getRejectedList() {
        return rejectedList;
    }

    /**
     * Sets the rejectedList value
     * @param rejectedList
     */
    public void setRejectedList(List<String> rejectedList) {
        this.rejectedList = rejectedList;
    }

}
