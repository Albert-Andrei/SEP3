package SEP.Network;


import SEP.Models.Shift;

import java.util.List;

public class ListPackage extends NetworkPackage{

    private List<Shift> shiftList;

    /**
     * Constructor
     * @param type
     * @param shiftList
     */
    public ListPackage(NetworkType type, List<Shift> shiftList) {
        super(type);
        this.shiftList = shiftList;
    }

    /**
     * Returns a list of shifts
     * @return list of shifts
     */
    public List<Shift> getShiftList() {
        return shiftList;
    }

    /**
     * Gets a string with a network type and list of shifts
     * @return network type and list of shift
     */
    @Override
    public String toString() {
        return getType() + ": " + shiftList;
    }
}
