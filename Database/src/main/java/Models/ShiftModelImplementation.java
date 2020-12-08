package Models;

import Data.Shift;
import Data.User;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.Cursor;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.sql.DatabaseMetaData;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ShiftModelImplementation implements ShiftModel {

    private final MongoCollection<Document> shiftCollection;

    /**
     * Initialising the table Shift from Bd in constructor
     *
     * @param database
     */
    public ShiftModelImplementation(MongoDatabase database) {
        shiftCollection = database.getCollection("Shift");
    }

    /**
     * This method adds a new Shift to DB
     *
     * @param shift
     */
    @Override
    public void CreateShift(Shift shift) {

        //Preparing a document
        Document document = new Document();
        document.append("username", shift.getUsername());
        document.append("companyName", shift.getCompanyName());
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

    @Override
    public List<Shift> GetAllShiftsForOneUser(String username) {

        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("username", username);
        List<Shift> toReturn = new ArrayList<>();

        if (shiftCollection.find(whereQuery).first() != null) {

            MongoCursor<Document> cursor = shiftCollection.find(whereQuery).iterator();
            Gson gson = new Gson();
        //    FindIterable<Document> iterDoc = shiftCollection.find(whereQuery);
        //    Iterator it = iterDoc.iterator();
            while (cursor.hasNext()) {
//                String shiftFromDB = shiftCollection.find(whereQuery).first().toJson();
//                System.out.println(shiftFromDB);
//                Shift ble = gson.fromJson(shiftFromDB, Shift.class);
//                System.out.println(ble);

                System.out.println(cursor.next());
                Document document = cursor.next();

                String json = document.toJson();
                System.out.println(json);

                Shift opa = gson.fromJson(json, Shift.class);
                System.out.println(opa.getStartDate());
               toReturn.add(opa);
            }
        }
        return toReturn;
    }
}