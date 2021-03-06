package SEP.Services;

import SEP.Models.Application;
import org.bson.types.ObjectId;

import java.io.IOException;
import java.util.List;

public interface ApplicationService {
    List<Application> getAllApplications() throws  IOException, ClassNotFoundException;
    Application getApplication(String applicationId) throws IOException, ClassNotFoundException;
    void createApplication(Application application) throws IOException, ClassNotFoundException;
    void updateApplication(Application application) throws IOException, ClassNotFoundException;
    Application getApplicationMyApplication(String user) throws IOException, ClassNotFoundException;

}
