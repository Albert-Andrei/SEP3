package Data;


import com.google.gson.annotations.SerializedName;
import org.bson.types.ObjectId;


import java.util.Date;
import java.util.List;

class MongoDate {
    @SerializedName("$date")
    Date date;
}

public class Shift {
    private ObjectId _id;
    private String username;
    private String companyName;
    private MongoDate endDate;
    private MongoDate startDate;
    private String description;
    private String requirements;
    private float hourWage;
    private List<String> pendingList;
    private List<String> approvedList;
    private List<String> rejectedList;

    public Shift() {
    }

    public Shift(ObjectId _id, String username, String companyName, MongoDate endDate, MongoDate startDate, String description, String requirements, float hourWage, List<String> pendingList, List<String> approvedList, List<String> rejectedList) {
        this._id = _id;
        this.username = username;
        this.companyName = companyName;
        this.endDate = endDate;
        this.startDate = startDate;
        this.description = description;
        this.requirements = requirements;
        this.hourWage = hourWage;
        this.pendingList = pendingList;
        this.approvedList = approvedList;
        this.rejectedList = rejectedList;
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

    public MongoDate getEndDate() {
        return endDate;
    }

    public void setEndDate(MongoDate endDate) {
        this.endDate = endDate;
    }

    public MongoDate getStartDate() {
        return startDate;
    }

    public void setStartDate(MongoDate startDate) {
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
