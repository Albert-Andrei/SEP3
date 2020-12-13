package SEP.Managers;

import SEP.Models.Application;
import org.bson.types.ObjectId;

import java.io.IOException;
import java.util.List;

public interface ApplicationRemoteModel {
    List<Application> getAllApplications() throws  IOException, ClassNotFoundException;
    void createApplication(Application application) throws IOException, ClassNotFoundException;
    Application getApplication(String applicationId) throws IOException, ClassNotFoundException;
    void updateApplication(Application application) throws IOException, ClassNotFoundException;

}
