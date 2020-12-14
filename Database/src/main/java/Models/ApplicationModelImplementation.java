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

    /**
     *
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
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

    /**
     *
     * @param applicationId
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public Application getApplication(String applicationId) throws IOException, ClassNotFoundException {
        if (applicationCollection.find(eq("_id", new ObjectId(applicationId))).first() != null) {
            Document application = applicationCollection.find(eq("_id", new ObjectId(applicationId))).first();
            Gson gson = new Gson();
            Application applicationID = gson.fromJson(application.toJson(),Application.class);
            return applicationID;
        }
        return null;
    }

    /**
     * This method creates a new user in the Database with values that came from tear 2.
     *
     * **/

    /**
     *
     * @param application
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void createApplication(Application application) throws IOException, ClassNotFoundException {
        //Preparing a document
        Document document = new Document();
        document.append("firstName", application.getFirstName());
        document.append("lastName", application.getLastName());
        document.append("phoneNumber", application.getPhoneNumber());
        document.append("email", application.getEmail());
        document.append("jobExperience", application.getJobExperience());
        document.append("drivingLicenses", application.getDrivingLicenses());
        document.append("languages", application.getLanguages());
        document.append("preferableWorkTime", application.getPreferableWorkTime());
        document.append("available", application.isAvailable());
        document.append("user", application.getUser());
        //Inserting the document into the collection
        applicationCollection.insertOne(document);


        System.out.println("Document inserted successfully " + application);
    }

    /**
     *
     * @param application
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void updateApplication(Application application) throws IOException, ClassNotFoundException {
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("user", application.getUser());

        if (applicationCollection.find(whereQuery).first() != null) {
            String userJson = applicationCollection.find(whereQuery).first().toJson();
            Gson gson = new Gson();
            Application applicationToUpdate = gson.fromJson(userJson,Application.class);
            applicationToUpdate.Update(application);
            applicationCollection.updateOne(eq("user", application.getUser()), new Document("$set", new Document("firstName", applicationToUpdate.getFirstName())));
            applicationCollection.updateOne(eq("user", application.getUser()), new Document("$set", new Document("lastName", applicationToUpdate.getLastName())));
            applicationCollection.updateOne(eq("user", application.getUser()), new Document("$set", new Document("email", applicationToUpdate.getEmail())));
            applicationCollection.updateOne(eq("user", application.getUser()), new Document("$set", new Document("phoneNumber", applicationToUpdate.getPhoneNumber())));
            applicationCollection.updateOne(eq("user", application.getUser()), new Document("$set", new Document("jobExperience", applicationToUpdate.getJobExperience())));
            applicationCollection.updateOne(eq("user", application.getUser()), new Document("$set", new Document("languages", applicationToUpdate.getLanguages())));
            applicationCollection.updateOne(eq("user", application.getUser()), new Document("$set", new Document("drivingLicenses", applicationToUpdate.getDrivingLicenses())));
            applicationCollection.updateOne(eq("user", application.getUser()), new Document("$set", new Document("preferableWorkTime", applicationToUpdate.getPreferableWorkTime())));
        }
    }

    /**
     *
     * @param user
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public Application getApplicationMyApplication(String user) throws IOException, ClassNotFoundException {
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("user", user);
        if (applicationCollection.find(whereQuery).first() != null) {
            String userJson = applicationCollection.find(whereQuery).first().toJson();
            Gson gson = new Gson();
            Application userFromDatabase = gson.fromJson(userJson, Application.class);
            return userFromDatabase;
        }
        return null;
    }

}
