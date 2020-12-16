package SEP.Network;

import SEP.Models.Application;
import org.bson.types.ObjectId;

import java.util.List;

public class ApplicationPackage extends NetworkPackage {
    private Application application;

    /**
     * Constructor
     *
     * @param type
     * @param application
     */
    public ApplicationPackage(NetworkType type, Application application) {
        super(type);
        this.application = application;
    }

    /**
     * Returns an application
     *
     * @return application
     */
    public Application getApplication() {
        return application;
    }

    /**
     * Gets a string with a network type and application
     *
     * @return network type and application
     */
    public String toString() {
        return getType() + ": " + application;
    }
}
