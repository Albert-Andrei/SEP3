package SEP.Mediator;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface ConnectionHandler {
    void disconnect() throws IOException;
    String readFromDb()  throws IOException;
    void sendToDb(String toServer) throws IOException;
}
