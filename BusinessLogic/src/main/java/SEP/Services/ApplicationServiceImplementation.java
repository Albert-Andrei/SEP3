package SEP.Services;

import SEP.Managers.ApplicationClient;
import SEP.Managers.ApplicationRemoteModel;
import SEP.Models.Application;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@Service
public class ApplicationServiceImplementation implements ApplicationService {
    private ApplicationRemoteModel remoteModel;

    public ApplicationServiceImplementation() throws IOException {
        this.remoteModel = new ApplicationClient();
    }

    @Override
    public List<Application> getAllApplications() throws IOException, ClassNotFoundException {
        return remoteModel.getAllApplications();
    }

    @Override
    public Application getApplication(String applicationId) throws IOException, ClassNotFoundException {
         return remoteModel.getApplication(applicationId);

    }

    @Override
    public void createApplication(Application application) throws IOException, ClassNotFoundException {

        remoteModel.createApplication(application);
    }

    @Override
    public void updateApplication(Application application) throws IOException, ClassNotFoundException {
         remoteModel.updateApplication(application);
    }

    @Override
    public Application getApplicationMyApplication(String user) throws IOException, ClassNotFoundException {
        if(remoteModel.getApplicationMyApplication(user) == null)
        {
            Application application = new Application();
            application.setAvailable(true);
            return application;
        }
         return remoteModel.getApplicationMyApplication(user);
    }

    }

