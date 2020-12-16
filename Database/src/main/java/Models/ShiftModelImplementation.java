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
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
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
        document.append("date", shift.getDate());
        document.append("preferableWorkTime", shift.getPreferableWorkTime());

        //Inserting the document into the collection
        shiftCollection.insertOne(document);
        System.out.println("Shift inserted successfully " + shift);
    }

    /**
     * Return a list of shifts by given username
     *
     * @param username
     * @return A list of shifts
     * @throws ParseException
     */
    @Override
    public List<Shift> GetAllShiftsForOneUser(String username) throws ParseException {
        if (shiftCollection.find( eq("username", username) ).first() != null) {
            toReturn.clear();

            MongoCursor<Document> cursor = shiftCollection.find( eq("username", username) ).iterator();
//            Gson gson = new Gson();
            Gson gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .create();
            while (cursor.hasNext()) {

                Document document = cursor.next();
                String json = document.toJson();

                String date = document.get("date").toString();
                // Formatter for the input date
                final DateFormat inputFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
//                // The parsed date

                final Date dateParsed = inputFormat.parse(date);

                // Getting the string value of object id
                String shiftId = document.get("_id").toString();


                Shift opa = gson.fromJson(json, Shift.class);
                opa.setDate(dateParsed);
                opa.setShiftId(shiftId);
                System.out.println(opa);
                toReturn.add(opa);
            }
        }
        return toReturn;
    }

    /**
     * Returns allShifts that are in the database
     *
     * @return all shifts that are in the database
     * @throws ParseException
     */
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

            String date = document.get("date").toString();
            // Formatter for the input date
            final DateFormat inputFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
//                // The parsed date

            final Date dateParsed = inputFormat.parse(date);

            // Getting the string value of object id
            String shiftId = document.get("_id").toString();


            Shift opa = gson.fromJson(json, Shift.class);
            opa.setDate(dateParsed);
            opa.setShiftId(shiftId);
            System.out.println(opa);
            toReturn.add(opa);
        }
        return toReturn;
    }

    /**
     * Return a Shift from database by given ID
     * @param shiftId
     * @return A shift
     * @throws ParseException
     */
    @Override
    public Shift GetShiftById(String shiftId) throws ParseException {
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        if (shiftCollection.find(eq("_id", new ObjectId(shiftId))).first() != null) {
            Document shift = shiftCollection.find(eq("_id", new ObjectId(shiftId))).first();
            String json = shift.toJson();

            String date = shift.get("date").toString();
            String stringId = shift.get("_id").toString();

            // Formatter for the input date
            final DateFormat inputFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
            // The parsed date
            final Date dateParsed = inputFormat.parse(date);

            Shift shif = gson.fromJson(json, Shift.class);
            shif.setDate(dateParsed);
            shif.setShiftId(stringId);
            return shif;
        }
        return null;
    }

    /**
     * Removes a shift from database by given ID
     * @param shiftId
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void removeShift(String shiftId) throws IOException, ClassNotFoundException {
        try {
            if (shiftCollection.find(eq("_id", new ObjectId(shiftId))).first() != null) {
                shiftCollection.deleteOne(new Document("_id", new ObjectId(shiftId)));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Writes the given username into Pending list of a shift by given shift ID
     * @param shiftId
     * @param username
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void applyToShift(String shiftId, String username) throws IOException, ClassNotFoundException {
        if (shiftCollection.find(eq("_id", new ObjectId(shiftId))).first() != null) {
            shiftCollection.updateOne(eq("_id", new ObjectId(shiftId)), Updates.addToSet("pendingList", username));
        }
    }

    /**
     * Updates a shift by moving a username from pending list to approved list into
     * a shift by given shift ID
     * @param shiftId
     * @param username
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void Approve(String shiftId, String username) throws IOException, ClassNotFoundException {
        if (shiftCollection.find(eq("_id", new ObjectId(shiftId))).first() != null) {
            shiftCollection.updateOne(eq("_id", new ObjectId(shiftId)), Updates.pull("pendingList", username));
            shiftCollection.updateOne(eq("_id", new ObjectId(shiftId)), Updates.addToSet("approvedList", username));
        }
    }

    /**
     * Updates a shift by moving a username from pending or approved list to rejected list into
     * a shift by given shift ID
     * @param shiftId
     * @param username
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void Reject(String shiftId, String username) throws IOException, ClassNotFoundException {
        if (shiftCollection.find(eq("_id", new ObjectId(shiftId))).first() != null) {

            try {
                Shift shift = GetShiftById(shiftId);

                if (shift.getPendingList().size() != 0) {
                    for (String uname : shift.getPendingList()) {
                        if (username.equals(uname)) {
                            shiftCollection.updateOne(eq("_id", new ObjectId(shiftId)), Updates.pull("pendingList", username));
                            shiftCollection.updateOne(eq("_id", new ObjectId(shiftId)), Updates.addToSet("rejectedList", username));
                        }
                    }
                } else if (shift.getApprovedList().size() != 0)
                for (String uname : shift.getApprovedList()) {
                    if (username.equals(uname)) {
                    } else {
                        shiftCollection.updateOne(eq("_id", new ObjectId(shiftId)), Updates.pull("approvedList", username));
                        shiftCollection.updateOne(eq("_id", new ObjectId(shiftId)), Updates.addToSet("rejectedList", username));
                    }
                }
            } catch (ParseException e) {
                e.printStackTrace();
                System.out.println(e);
            }
        }
    }
}
