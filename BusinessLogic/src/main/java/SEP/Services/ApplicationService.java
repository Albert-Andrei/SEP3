package SEP.Services;

import SEP.Models.Application;
import org.bson.types.ObjectId;

import java.io.IOException;
import java.util.List;

public interface ApplicationService {
    List<Application> getAllApplications() throws  IOException, ClassNotFoundException;
    Application getApplication(ObjectId applicationId) throws IOException, ClassNotFoundException;
    void createApplication(Application application) throws IOException, ClassNotFoundException;
   /* void updateUser(Application application);
    void removeUser(int id);*/
}
