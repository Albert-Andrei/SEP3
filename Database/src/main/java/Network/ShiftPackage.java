package Network;

import Data.Shift;

public class ShiftPackage extends NetworkPackage {

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
