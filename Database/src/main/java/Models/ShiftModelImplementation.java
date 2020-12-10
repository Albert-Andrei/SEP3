package Models;

import Data.Application;
import Data.Shift;
import Data.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBObject;
import com.mongodb.Cursor;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.io.IOException;
import java.sql.DatabaseMetaData;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class ShiftModelImplementation implements ShiftModel {

    private final MongoCollection<Document> shiftCollection;
    private List<Shift> toReturn;

    /**
     * Initialising the table Shift from Bd in constructor
     *
     * @param database
     */
    public ShiftModelImplementation(MongoDatabase database) {
        shiftCollection = database.getCollection("Shift");
        toReturn = new ArrayList<>();
    }

    /**
     * This method adds a new Shift to DB
     *
     * @param shift
     */
    @Override
    public void CreateShift(Shift shift) {

        System.out.println(shift + " < Shift to create before creating");

        //Preparing a document
        Document document = new Document();
        document.append("username", shift.getUsername());
        document.append("companyName", shift.getCompanyName());
        document.append("jobTitle", shift.getJobTitle());
        document.append("hourWage", shift.getHourWage());
        document.append("description", shift.getDescription());
        document.append("requirements", shift.getRequirements());
        document.append("pendingList", shift.getPendingList());
        document.append("approvedList", shift.getApprovedList());
        document.append("rejectedList", shift.getRejectedList());
        document.append("startDate", shift.getStartDate());
        document.append("endDate", shift.getEndDate());

        //Inserting the document into the collection
        shiftCollection.insertOne(document);
        System.out.println("Shift inserted successfully " + shift);
    }

    @Override
    public List<Shift> GetAllShiftsForOneUser(String username) throws ParseException {

        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("username", username);

        if (shiftCollection.find(whereQuery).first() != null) {
        toReturn.clear();

            MongoCursor<Document> cursor = shiftCollection.find(whereQuery).iterator();
//            Gson gson = new Gson();
            Gson gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .create();
            while (cursor.hasNext()) {

                Document document = cursor.next();
                String json = document.toJson();

                String startDate = document.get("startDate").toString();
                String endDate = document.get("endDate").toString();

                // Formatter for the input date
                final DateFormat inputFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
//                // The parsed date
                final Date startDateParsed = inputFormat.parse(startDate);
                final Date endDateParsed = inputFormat.parse(endDate);

                Shift opa = gson.fromJson(json, Shift.class);
                opa.setStartDate(startDateParsed);
                opa.setEndDate(endDateParsed);
                System.out.println(opa);
                toReturn.add(opa);
            }
        }
        return toReturn;
    }

    @Override
    public List<Shift> GetAllShifts() throws ParseException {
        toReturn.clear();

            MongoCursor<Document> cursor = shiftCollection.find().iterator();
            Gson gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .create();
            while (cursor.hasNext()) {

                Document document = cursor.next();
                String json = document.toJson();

                String startDate = document.get("startDate").toString();
                String endDate = document.get("endDate").toString();

                // Formatter for the input date
                final DateFormat inputFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
               // The parsed date
                final Date startDateParsed = inputFormat.parse(startDate);
                final Date endDateParsed = inputFormat.parse(endDate);

                Shift opa = gson.fromJson(json, Shift.class);
                opa.setStartDate(startDateParsed);
                opa.setEndDate(endDateParsed);
                System.out.println(opa);
                toReturn.add(opa);
            }
            return toReturn;
    }

    @Override
    public void removeShift(String shiftId) throws IOException, ClassNotFoundException {
        if (shiftCollection.find(eq("_id", new ObjectId(shiftId))).first() != null) {
        shiftCollection.deleteOne(new Document("_id", new ObjectId(shiftId)));;
    }
    }
}
