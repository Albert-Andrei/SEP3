package SEP.Services;

import SEP.Managers.ApplicationClient;
import SEP.Managers.ApplicationRemoteModel;
import SEP.Models.Application;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 * ApplicationServiceImplementation class implements ApplicationService
 */
@Service
public class ApplicationServiceImplementation implements ApplicationService {
    private ApplicationRemoteModel remoteModel;

    /**
     * The constructor
     *
     * @throws IOException
     */
    public ApplicationServiceImplementation() throws IOException {
        this.remoteModel = new ApplicationClient();
    }

    /**
     * Calls getAllApplications method from remoteModel
     *
     * @return A list of applications
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public List<Application> getAllApplications() throws IOException, ClassNotFoundException {
        return remoteModel.getAllApplications();
    }

    /**
     * Calls the getApplication
     *
     * @param applicationId
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public Application getApplication(String applicationId) throws IOException, ClassNotFoundException {
        return remoteModel.getApplication(applicationId);

    }

    /**
     * Calls the createApplication method from remote model in order ti send to data tire
     * an application to store in database
     *
     * @param application
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void createApplication(Application application) throws IOException, ClassNotFoundException {

        remoteModel.createApplication(application);
    }

    /**
     * Calls the updateApplication from remote model
     *
     * @param application
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void updateApplication(Application application) throws IOException, ClassNotFoundException {
        remoteModel.updateApplication(application);
    }

    /**
     * Checking if the application exist in database by calling getApplicationMyApplication
     *
     * @param user
     * @return The application
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public Application getApplicationMyApplication(String user) throws IOException, ClassNotFoundException {
        if (remoteModel.getApplicationMyApplication(user) == null) {
            Application application = new Application();
            application.setAvailable(true);
            return application;
        }
        return remoteModel.getApplicationMyApplication(user);
    }
}

