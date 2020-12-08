package SEP.Managers;

import SEP.Mediator.ConnectionHandler;
import SEP.Mediator.ConnectionImplementation;
import SEP.Models.Application;
import SEP.Network.ApplicationListPackage;
import SEP.Network.ApplicationPackage;
import SEP.Network.NetworkPackage;
import SEP.Network.NetworkType;
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


    public ApplicationClient() throws IOException {
        this.gson = new Gson();
        this.handler = ConnectionImplementation.getInstance();
    }

    @Override
    public List<Application> getAllApplications() throws IOException, ClassNotFoundException {
        List<Application> applicationList = new ArrayList<>();
        NetworkPackage toServer = new ApplicationListPackage(NetworkType.GET_ALL_APPLICATIONS,applicationList);
        String gsonToServer = gson.toJson(toServer);
        handler.sendToDb(gsonToServer);

        String response = handler.readFromDb();
        ApplicationListPackage applicationPackage = gson.fromJson(response, ApplicationListPackage.class);
        return applicationPackage.getApplicationList();
    }

    @Override
    public void createApplication(Application application) throws IOException, ClassNotFoundException
    {
        NetworkPackage toServer = new ApplicationPackage(NetworkType.CREATE_APPLICATION, application);
        String gsonToServer = gson.toJson(toServer);
        handler.sendToDb(gsonToServer);
    }

    @Override
    public Application getApplication(ObjectId applicationId) throws IOException, ClassNotFoundException {
        Application toCheck = new Application();
        toCheck.setApplicationId(applicationId);

        NetworkPackage toServer = new ApplicationPackage(NetworkType.GET_APPLICATION, toCheck);
        String gsonToServer = gson.toJson(toServer);
        handler.sendToDb(gsonToServer);

        String response = handler.readFromDb();
        ApplicationPackage applicationPackage = gson.fromJson(response, ApplicationPackage.class);
        return applicationPackage.getApplication();

    }
}
