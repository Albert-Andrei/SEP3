package Models;

import Data.Application;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;


public class ApplicationModelImplementation implements ApplicationModel {

    private final MongoCollection<Document> applicationCollection;

    public ApplicationModelImplementation(MongoDatabase database) {
        applicationCollection = database.getCollection("Applications");;
    }

    @Override
    public List<Application> getAllApplications() throws IOException, ClassNotFoundException {
        MongoCursor<Document> cursor = applicationCollection.find().iterator();
        List<Application> applicationList = new ArrayList<>();
        try {
            while (cursor.hasNext()) {
                String application = cursor.next().toJson();
                Gson gson = new Gson();
                Application applicationFromDatabase = gson.fromJson(application, Application.class);
                applicationList.add(applicationFromDatabase);
            }
            return applicationList;
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return null;
    }
    @Override
    public Application getApplication(String applicationId) throws IOException, ClassNotFoundException {
        if (applicationCollection.find(eq("_id", new ObjectId(applicationId))).first() != null) {
            Document application = applicationCollection.find(eq("_id", new ObjectId(applicationId))).first();
            Gson gson = new Gson();
            Application applicationID = gson.fromJson(application.toJson(),Application.class);
            String objectId = application.get("_id").toString();
            applicationID.setId(objectId);
            return applicationID;
        }
        return null;
    }

    /**
     * This method creates a new user in the Database with values that came from tear 2.
     *
     * **/

    @Override
    public void createApplication(Application application) throws IOException, ClassNotFoundException {
        //Preparing a document
        Document document = new Document();
        document.put("firstName", application.getFirstName());
        document.put("lastName", application.getLastName());
        document.put("phoneNumber", application.getPhoneNumber());
        document.put("email", application.getEmail());
        document.put("jobExperience", application.getJobExperience());
        document.put("drivingLicenses", application.getDrivingLicenses());
        document.put("languages", application.getLanguages());
        document.put("preferableWorkTime", application.getPreferableWorkTime());
        document.put("available", application.isAvailable());

        //Inserting the document into the collection
        applicationCollection.insertOne(document);
        System.out.println("Document inserted successfully " + application);
    }

    @Override
    public void updateApplication(String applicationId, Application application) throws IOException, ClassNotFoundException {
        if (applicationCollection.find(eq("_id", new ObjectId(applicationId))).first() != null) {
            Document application123 = applicationCollection.find(eq("_id", new ObjectId(applicationId))).first();
            Gson gson = new Gson();
            Application applicationToUpdate = gson.fromJson(application123.toJson(),Application.class);
            applicationToUpdate.Update(application);
            System.out.println(applicationToUpdate.toString());
            applicationCollection.updateOne(eq("_id", application.getApplicationId()), new Document("$set", new Document("firstName", applicationToUpdate.getFirstName())));
            applicationCollection.updateOne(eq("_id", application.getApplicationId()), new Document("$set", new Document("lastName", applicationToUpdate.getLastName())));
            applicationCollection.updateOne(eq("_id", application.getApplicationId()), new Document("$set", new Document("email", applicationToUpdate.getEmail())));
            applicationCollection.updateOne(eq("_id", application.getApplicationId()), new Document("$set", new Document("phoneNumber", applicationToUpdate.getPhoneNumber())));
            applicationCollection.updateOne(eq("_id", application.getApplicationId()), new Document("$set", new Document("jobExperience", applicationToUpdate.getJobExperience())));
            applicationCollection.updateOne(eq("_id", application.getApplicationId()), new Document("$set", new Document("languages", applicationToUpdate.getLanguages())));
            applicationCollection.updateOne(eq("_id", application.getApplicationId()), new Document("$set", new Document("drivingLicenses", applicationToUpdate.getDrivingLicenses())));
            applicationCollection.updateOne(eq("_id", application.getApplicationId()), new Document("$set", new Document("preferableWorkTime", applicationToUpdate.getPreferableWorkTime())));
            // Available
/*
            applicationCollection.updateOne(eq("_id", application.getApplicationId()), new Document("$set", new Document("firstName", applicationToUpdate.())));
*/
        }
    }

    @Override
    public void removeApplication(Application application) throws IOException, ClassNotFoundException {
        Bson filter = eq("_id", application.getApplicationId());
        applicationCollection.deleteOne(filter);
    }


}
