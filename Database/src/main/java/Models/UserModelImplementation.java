package Models;

import Data.User;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class UserModelImplementation implements UserModel {

    private final MongoCollection<Document> usersCollection;

    public UserModelImplementation(MongoDatabase database) {
        usersCollection = database.getCollection("Users");;
    }

    /**
     * This method checks if there is a existing user in db with the given username and returns it
     * @param username
     * @return User
     */

    @Override
    public User ValidateUser(String username) {
        {
            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("username", username);

            if (usersCollection.find(whereQuery).first() != null) {
                String userJson = usersCollection.find(whereQuery).first().toJson();
                Gson gson = new Gson();
                User userFromDatabase = gson.fromJson(userJson, User.class);
                return userFromDatabase;
            }
            return null;
        }
    }


    /**
     * This method creates a new user in the Database with values that came from tear 2.
     * @param user
     */

    @Override
    public void CreateUser(User user) {
        //Preparing a document
        Document document = new Document();
        document.append("username", user.getUsername());
        document.append("firstName", user.getFirstName());
        document.append("lastName", user.getLastName());
        document.append("userType", user.getUserType());
        document.append("password", user.getPassword());
        document.append("emali", user.getEmali());
        document.append("securityLevel", user.getSecurityLevel());

        //Inserting the document into the collection
        usersCollection.insertOne(document);
        System.out.println("Document inserted successfully " + user);
    }
}
