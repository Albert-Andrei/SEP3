package SEP.Managers;

import SEP.Mediator.ConnectionHandler;
import SEP.Mediator.ConnectionImplementation;
import SEP.Models.Application;
import SEP.Network.*;
import com.google.gson.Gson;
import org.bson.types.ObjectId;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleToIntFunction;

public class ApplicationClient implements ApplicationRemoteModel {

    private Gson gson;
    ConnectionHandler handler;

    /**
     * Constructor
     *
     * @throws IOException
     */
    public ApplicationClient() throws IOException {
        this.gson = new Gson();
        this.handler = ConnectionImplementation.getInstance();
    }

    /**
     * Creating a network package with application and name
     * Converts to json the network package
     * Send the gson to data tier
     * Deserialize the response from data tire
     * Returns a list with applications from database
     *
     * @return list of applications
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public List<Application> getAllApplications() throws IOException, ClassNotFoundException {
        List<Application> applicationList = new ArrayList<>();
        NetworkPackage toServer = new ApplicationListPackage(NetworkType.GET_ALL_APPLICATIONS, applicationList);
        String gsonToServer = gson.toJson(toServer);
        handler.sendToDb(gsonToServer);

        String response = handler.readFromDb();
        ApplicationListPackage applicationPackage = gson.fromJson(response, ApplicationListPackage.class);
        return applicationPackage.getApplicationList();
    }

    /**
     * Crete a network package with application and serialize it
     * Send the gson to data tier in order to store it in database
     *
     * @param application
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void createApplication(Application application) throws IOException, ClassNotFoundException {
        NetworkPackage toServer = new ApplicationPackage(NetworkType.CREATE_APPLICATION, application);
        String gsonToServer = gson.toJson(toServer);
        handler.sendToDb(gsonToServer);
    }

    /**
     * Creates a QueryPackage And serialize it
     * Send the gson to data tier
     * Deserialize the response from data tire
     * Returns an application
     *
     * @param applicationId
     * @return application
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public Application getApplication(String applicationId) throws IOException, ClassNotFoundException {
        QueryPackage toServer = new QueryPackage(NetworkType.GET_APPLICATION, applicationId);
        String gsonToServer = gson.toJson(toServer);
        handler.sendToDb(gsonToServer);

        String response = handler.readFromDb();
        ApplicationPackage applicationPackage = gson.fromJson(response, ApplicationPackage.class);
        return applicationPackage.getApplication();
    }

    /**
     * Creates a ApplicationPackage And serialize it
     * Send the gson to data tier
     *
     * @param application
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void updateApplication(Application application) throws IOException, ClassNotFoundException {
        NetworkPackage toServer = new ApplicationPackage(NetworkType.UPDATE_APPLICATION, application);
        String gsonToServer = gson.toJson(toServer);
        handler.sendToDb(gsonToServer);
    }

    /**
     * Creating a new application
     * Setting the application name
     * Creating a network package of type ApplicationPackage
     * Converts to gson the network package
     * Send the gson to data tier
     * Deserialize the response from data tier
     * Returns an applications from database
     *
     * @param user
     * @return application
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public Application getApplicationMyApplication(String user) throws IOException, ClassNotFoundException {
        Application userApplication = new Application();
        userApplication.setUser(user);

        NetworkPackage toServer = new ApplicationPackage(NetworkType.GET_MY_APPLICATION, userApplication);
        String gsonToServer = gson.toJson(toServer);
        handler.sendToDb(gsonToServer);

        String response = handler.readFromDb();
        ApplicationPackage applicationPackage = gson.fromJson(response, ApplicationPackage.class);
        return applicationPackage.getApplication();
    }
}
