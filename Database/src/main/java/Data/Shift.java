package Data;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.bson.types.ObjectId;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Shift {
    private ObjectId _id;
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
    private Date endDate;
    @Expose(serialize = true, deserialize = false)
    private Date startDate;

    public Shift() {
        pendingList = new ArrayList<>();
    }

    public Shift(ObjectId _id, String username, String companyName, String jobTitle, Date endDate, Date startDate, String description, String requirements, float hourWage, List<String> pendingList, List<String> approvedList, List<String> rejectedList) {
        this._id = _id;
        this.username = username;
        this.companyName = companyName;
        this.jobTitle =jobTitle;
        this.endDate = endDate;
        this.startDate = startDate;
        this.description = description;
        this.requirements = requirements;
        this.hourWage = hourWage;
        this.pendingList = pendingList;
        this.approvedList = approvedList;
        this.rejectedList = rejectedList;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
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

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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

    public List<String> getPendingList() {
        return pendingList;
    }

    public void setPendingList(List<String> pendingList) {
        this.pendingList = pendingList;
    }

    public List<String> getApprovedList() {
        return approvedList;
    }

    public void setApprovedList(List<String> approvedList) {
        this.approvedList = approvedList;
    }

    public List<String> getRejectedList() {
        return rejectedList;
    }

    public void setRejectedList(List<String> rejectedList) {
        this.rejectedList = rejectedList;
    }
}
