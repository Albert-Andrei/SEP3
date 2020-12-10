package SEP.Managers;

import SEP.Mediator.ConnectionHandler;
import SEP.Mediator.ConnectionImplementation;
import SEP.Models.Shift;
import SEP.Models.User;
import SEP.Network.*;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShiftClient implements ShiftRemoteModel{

    private Gson gson;
    ConnectionHandler handler;

    public ShiftClient() throws IOException {
        this.gson = new Gson();
        this.handler = ConnectionImplementation.getInstance();
    }

    /**
     * Serialize the Shift object into gson and sending it to Database, T3
     * @param shift
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void createShift(Shift shift) throws IOException, ClassNotFoundException {
        NetworkPackage toServer = new ShiftPackage(NetworkType.CREATE_SHIFT, shift);
        String gsonToServer = gson.toJson(toServer);
        handler.sendToDb(gsonToServer);
    }


    @Override
    public List<Shift> getShiftsForOneUser(String username) throws IOException, ClassNotFoundException {

        NetworkPackage toServer = new StringPackage(NetworkType.SEND_USERNAME, username);
        String gsonToServer = gson.toJson(toServer);
        handler.sendToDb(gsonToServer);

        String respose = handler.readFromDb();
        ListPackage list = gson.fromJson(respose, ListPackage.class);
        return list.getShiftList();
    }

    @Override
    public List<Shift> getAllShifts() throws IOException, ClassNotFoundException {
        NetworkPackage toServer = new StringPackage(NetworkType.GET_ALL_SHIFTS);
        String gsonToServer = gson.toJson(toServer);
        handler.sendToDb(gsonToServer);

        String respose = handler.readFromDb();
        ListPackage list = gson.fromJson(respose, ListPackage.class);
        return list.getShiftList();
    }


}
