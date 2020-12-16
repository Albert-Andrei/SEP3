package SEP.Network;

public class QueryPackage extends NetworkPackage {
    private Object object;

    /**
     * Constructor
     * @param type
     * @param object
     */
    public QueryPackage(NetworkType type, Object object) {
        super(type);
        this.object = object;
    }

    /**
     * Returns the object
     * @return object
     */
    public Object getObject() {
        return object;
    }

    /**
     * Returns a string with a network type and the object
     * @return network type and the object
     */
    @Override
    public String toString() {
        return "QueryPackage{" +
                "object=" + object +
                '}';
    }
}
