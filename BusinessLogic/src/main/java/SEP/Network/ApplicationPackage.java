package SEP.Network;

import SEP.Models.Application;
import org.bson.types.ObjectId;

import java.util.List;

public class ApplicationPackage extends NetworkPackage {
    private Application application;

    public ApplicationPackage(NetworkType type, Application application) {
        super(type);
        this.application = application;
    }



    public Application getApplication()
    {
        return application;
    }



    public String toString()
    {
        return getType() + ": " + application;
    }
}
