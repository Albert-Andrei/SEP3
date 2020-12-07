package Models;

import Data.Shift;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class ShiftModelImplementation implements ShiftModel{

    private final MongoCollection<Document> shiftCollection;

    /**
     * Initialising the table Shift from Bd in constructor
     * @param database
     */
    public ShiftModelImplementation(MongoDatabase database) {
        shiftCollection = database.getCollection("Shift");;
    }

    /**
     * This method adds a new Shift to DB
     * @param shift
     */
    @Override
    public void CreateShift(Shift shift) {

        //Preparing a document
        Document document = new Document();
        document.append("username", shift.getUsername());
        document.append("companyName", shift.getCompanyName());
        document.append("startDate", shift.getStartDate());
        document.append("startDate", shift.getStartDate());
        document.append("endDate", shift.getEndDate());
        document.append("requirements", shift.getRequirements());
        document.append("hourWage", shift.getHourWage());
        document.append("pendingList", shift.getPendingList());
        document.append("approvedList", shift.getApprovedList());
        document.append("rejectedList", shift.getRejectedList());

        //Inserting the document into the collection
        shiftCollection.insertOne(document);
        System.out.println("Shift inserted successfully " + shift);
    }
}
