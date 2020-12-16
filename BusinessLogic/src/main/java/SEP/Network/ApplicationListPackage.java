package SEP.Network;

import SEP.Models.Application;

import java.util.List;

public class ApplicationListPackage extends NetworkPackage {

    private List<Application> applicationList;

    /**
     * Constructor
     * @param type
     * @param applicationList
     */
    public ApplicationListPackage(NetworkType type, List<Application> applicationList) {
        super(type);
        this.applicationList = applicationList;
    }

    /**
     * Returns the applicationList
     * @return applicationList
     */
    public List<Application> getApplicationList()
    {
        return applicationList;
    }

    /**
     * Gets a string with a network type and applicationList
     * @return network type and applicationList
     */
    public String toString()
    {
        return getType() + ": " + applicationList;
    }
}
