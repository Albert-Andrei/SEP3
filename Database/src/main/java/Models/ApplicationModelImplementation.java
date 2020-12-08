package Models;

import Data.Application;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import javax.management.Query;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ApplicationModelImplementation implements ApplicationModel {

    private final MongoCollection<Document> applicationCollection;

    public ApplicationModelImplementation(MongoDatabase database) {
        applicationCollection = database.getCollection("Applications");;
    }

    @Override
    public List<Application> getAllApplications() throws IOException, ClassNotFoundException {
        MongoCursor<Document> cursor = applicationCollection.find().iterator();
        List<Application> huina = new ArrayList<>();
        try {
            while (cursor.hasNext()) {
                String uia = cursor.next().toJson();
                Gson gson = new Gson();
                Application applicationFromDatabase = gson.fromJson(uia, Application.class);
                huina.add(applicationFromDatabase);
            }
            System.out.println(huina.size());
            return huina;
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return null;


 }

    @Override
    public Application getApplication(ObjectId applicationId) throws IOException, ClassNotFoundException {
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("_id", applicationId);

        if (applicationCollection.find(whereQuery).first() != null) {
            String applicationJson = applicationCollection.find(whereQuery).first().toJson();
            Gson gson = new Gson();
            System.out.println("Gson from Bd >" + applicationJson);
            Application applicationFromDatabase = gson.fromJson(applicationJson, Application.class);
           return applicationFromDatabase;
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
    public void updateApplication(Application application) throws IOException, ClassNotFoundException {
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
    public void removeApplication(Application application) throws IOException, ClassNotFoundException {

    }


}
