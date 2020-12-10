package Models;

import Data.Application;
import org.bson.types.ObjectId;

import java.io.IOException;
import java.util.List;

public interface ApplicationModel {
    List<Application> getAllApplications() throws IOException, ClassNotFoundException;
    Application getApplication(String applicationId) throws IOException, ClassNotFoundException;
    void createApplication(Application application) throws IOException, ClassNotFoundException;
    Application updateApplication(Application application) throws IOException, ClassNotFoundException;
    void removeApplication(Application application) throws IOException, ClassNotFoundException;

}
