package SEP.Managers;

import SEP.Mediator.ConnectionHandler;
import SEP.Mediator.ConnectionImplementation;
import SEP.Models.Shift;
import SEP.Network.NetworkPackage;
import SEP.Network.NetworkType;
import SEP.Network.ShiftPackage;
import SEP.Network.UserPackage;
import com.google.gson.Gson;

import java.io.IOException;

public class ShiftClient implements ShiftRemoteModel{
    private Gson gson;
    ConnectionHandler handler;

    public ShiftClient() throws IOException {
        this.gson = new Gson();
        this.handler = ConnectionImplementation.getInstance();
    }

    @Override
    public void createShift(Shift shift) throws IOException, ClassNotFoundException {
        NetworkPackage toServer = new ShiftPackage(NetworkType.CREATE_SHIFT, shift);
        String gsonToServer = gson.toJson(toServer);
        handler.sendToDb(gsonToServer);
    }
}
