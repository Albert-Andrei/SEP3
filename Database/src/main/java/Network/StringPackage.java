package Network;

public class StringPackage extends NetworkPackage {
    private String string;

    public StringPackage(NetworkType type, String string) {
        super(type);
        this.string = string;
    }

    public String getString() {
        return string;
    }

    @Override
    public String toString() {
        return getType() + ": " + string;
    }
}
