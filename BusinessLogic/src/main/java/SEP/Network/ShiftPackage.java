package SEP.Network;

import SEP.Models.Shift;
import SEP.Models.User;

public class ShiftPackage extends NetworkPackage{

    private Shift shift;

    public ShiftPackage(NetworkType type, Shift shift) {
        super(type);
        this.shift = shift;
    }

    public Shift getShift() {
        return shift;
    }

    @Override
    public String toString() {
        return getType() + ": " + shift;
    }
}
