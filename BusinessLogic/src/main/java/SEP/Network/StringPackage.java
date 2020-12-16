package SEP.Network;

import SEP.Models.Shift;

public class StringPackage extends NetworkPackage {
    private String string;

    /**
     * Constructor
     * @param type
     * @param string
     */
    public StringPackage(NetworkType type, String string) {
        super(type);
        this.string = string;
    }

    /**
     * One argumetn constructor
     * @param type
     */
    public StringPackage(NetworkType type) {
        super(type);
    }

    /**
     * Returns the string vlue
     * @return string
     */
    public String getString() {
        return string;
    }

    /**
     * String value and the enum network type
     * @return a string
     */
    @Override
    public String toString() {
        return getType() + ": " + string;
    }
}
