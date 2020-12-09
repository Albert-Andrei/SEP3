package SEP.Network;

public class QueryPackage extends NetworkPackage {
    private Object object;

    public QueryPackage(NetworkType type, Object object) {
        super(type);
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    @Override
    public String toString() {
        return "QueryPackage{" +
                "object=" + object +
                '}';
    }
}
