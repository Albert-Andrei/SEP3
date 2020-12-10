package Models;

import Data.Application;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
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
    public void updateApplication(Application application) throws IOException, ClassNotFoundException {

        Application application1 = new Application();
        application1.Update(application);

        Bson filter = eq("firstName");
        Bson updateOperation = set("firstName", application1);
        UpdateResult updateResult = applicationCollection.updateOne(filter, updateOperation);
        return updateResult;

        System.out.println("=> Updating the doc with {\"student_id\":10000}. Adding comment.");
        //Preparing a document

        applicationCollection.updateOne(Filters.eq("firstName", application., set("firstName", application.getFirstName()));
        applicationCollection.updateOne(Filters.eq("lastName", application.getFirstName()), set("lastName", application.getLastName()));
        applicationCollection.updateOne(Filters.eq("phoneNumber", application.getFirstName()), set("phoneNumber", application.getPhoneNumber()));
        applicationCollection.updateOne(Filters.eq("email", application.getFirstName()), set("email", application.getEmail()));
        applicationCollection.updateOne(Filters.eq("jobExperience", application.getFirstName()), set("jobExperience", application.getJobExperience()));
        applicationCollection.updateOne(Filters.eq("drivingLicenses", application.getFirstName()), set("drivingLicenses", application.getDrivingLicenses()));
        applicationCollection.updateOne(Filters.eq("languages", application.getFirstName()), set("languages", application.getLanguages()));
        applicationCollection.updateOne(Filters.eq("preferableWorkTime", application.getFirstName()), set("preferableWorkTime", application.getPreferableWorkTime()));

/*        applicationCollection.updateOne("firstName", application1.setFirstName(application.getFirstName()));
        applicationCollection.updateOne("lastName", application.getLastName());
        applicationCollection.updateOne("phoneNumber", application.getPhoneNumber());
        applicationCollection.updateOne("email", application.getEmail());
        applicationCollection.updateOne("jobExperience", application.getJobExperience());
        applicationCollection.updateOne("drivingLicenses", application.getDrivingLicenses());
        applicationCollection.updateOne("languages", application.getLanguages());
        applicationCollection.updateOne("preferableWorkTime", application.getPreferableWorkTime());
        applicationCollection.updateOne("available", application.isAvailable());*/

        //Inserting the document into the collection
        System.out.println("Document inserted successfully " + application);
    }

    @Override
    public void removeApplication(Application application) throws IOException, ClassNotFoundException {

    }


}
