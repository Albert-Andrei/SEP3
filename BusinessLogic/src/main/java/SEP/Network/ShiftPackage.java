package SEP.Network;

import SEP.Models.Shift;
import SEP.Models.User;

public class ShiftPackage extends NetworkPackage{

    private Shift shift;

    /**
     * Constructor
     * @param type
     * @param shift
     */
    public ShiftPackage(NetworkType type, Shift shift) {
        super(type);
        this.shift = shift;
    }

    /**
     * Returns a shift
     * @return shift
     */
    public Shift getShift() {
        return shift;
    }

    /**
     * String value of the all information in the shift and the enum network type
     * @return A string with ingormation
     */
    @Override
    public String toString() {
        return getType() + ": " + shift;
    }
}
