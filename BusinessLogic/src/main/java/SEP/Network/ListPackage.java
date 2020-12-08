package SEP.Network;


import SEP.Models.Shift;

import java.util.List;

public class ListPackage extends NetworkPackage{

    private List<Shift> shiftList;

    public ListPackage(NetworkType type, List<Shift> shiftList) {
        super(type);
        this.shiftList = shiftList;
    }

    public List<Shift> getShiftList() {
        return shiftList;
    }

    @Override
    public String toString() {
        return getType() + ": " + shiftList;
    }
}
