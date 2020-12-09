package SEP.Network;

import SEP.Models.Application;

import java.util.List;

public class ApplicationListPackage extends NetworkPackage {
    private List<Application> applicationList;

    public ApplicationListPackage(NetworkType type, List<Application> applicationList) {
        super(type);
        this.applicationList = applicationList;
    }

    public List<Application> getApplicationList()
    {
        return applicationList;
    }


    public String toString()
    {
        return getType() + ": " + applicationList;
    }
}
