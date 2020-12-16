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

/**
 * ShiftClient class implements ShiftRemoteModel interface
 */
public class ShiftClient implements ShiftRemoteModel{

    private Gson gson;
    ConnectionHandler handler;

    /**
     * Constructor
     * @throws IOException
     */
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

    /**
     * Creating a network package with StringPackage type
     * Converts to gson the network package
     * Send the gson to data tire
     * Deserialize the response from data tire
     * Returns a list with shifts from database
     *
     * @param username
     * @return a list of shifts
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public List<Shift> getShiftsForOneUser(String username) throws IOException, ClassNotFoundException {

        NetworkPackage toServer = new StringPackage(NetworkType.SEND_USERNAME, username);
        String gsonToServer = gson.toJson(toServer);
        handler.sendToDb(gsonToServer);

        String respose = handler.readFromDb();
        ListPackage list = gson.fromJson(respose, ListPackage.class);
        return list.getShiftList();
    }

    /**
     * Creating a network package with StringPackage type and String shiftId in order
     * to get the specific shift from database
     * Converts to gson the network package
     * Send the gson to data tire
     * Deserialize the response from data tire
     * Returns a shifts from database
     *
     * @param shiftId
     * @ a shift
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public Shift GetShiftById(String shiftId) throws IOException, ClassNotFoundException {
        NetworkPackage toServer = new StringPackage(NetworkType.GET_SHIFT_ID, shiftId);
        String gsonToServer = gson.toJson(toServer);
        handler.sendToDb(gsonToServer);

        String respose = handler.readFromDb();
        ShiftPackage shift = gson.fromJson(respose, ShiftPackage.class);
        return shift.getShift();
    }

    /**
     * Creating a network package with StringPackage type
     * Converts to gson the network package
     * Send the gson to data tire
     * Deserialize the response from data tire
     * Returns a list with shifts from database
     *
     * @return a list of shifts
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public List<Shift> getAllShifts() throws IOException, ClassNotFoundException {
        NetworkPackage toServer = new StringPackage(NetworkType.GET_ALL_SHIFTS);
        String gsonToServer = gson.toJson(toServer);

        handler.sendToDb(gsonToServer);

        String respose = handler.readFromDb();
        ListPackage list = gson.fromJson(respose, ListPackage.class);
        return list.getShiftList();
    }

    /**
     *
     * Creating a network package with StringPackage type
     * Converts to gson the network package
     * Send the gson to data tire
     *
     * @param shiftId
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void removeShift(String shiftId) throws IOException, ClassNotFoundException {
        NetworkPackage toServer = new StringPackage(NetworkType.DELETE_SHIFT, shiftId);
        String gsonToServer = gson.toJson(toServer);
        handler.sendToDb(gsonToServer);
    }

    /**
     * Creating a network package with StringPackage type with shiftId
     * Converts to gson the network package
     * Send the gson to data tire
     *
     * Creating a network package with StringPackage type with username
     * Converts to gson the network package
     * Send the gson to data tire
     *
     * @param shiftId
     * @param username
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void applyToShift(String shiftId, String username) throws IOException, ClassNotFoundException {
        StringPackage toServer = new StringPackage(NetworkType.APPLY_TO_SHIFT, shiftId);
        String gsonToServer = gson.toJson(toServer);
        handler.sendToDb(gsonToServer);

        StringPackage toServer2 = new StringPackage(NetworkType.APPLY_TO_SHIFT, username);
        String gsonToServer2 = gson.toJson(toServer2);
        handler.sendToDb(gsonToServer2);
    }

    /**
     * Creating a network package with StringPackage type with shift ID and username
     * Converts to gson the network package
     * Send the gson to data tire
     *
     * @param shiftId
     * @param username
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void Approve(String shiftId, String username) throws IOException, ClassNotFoundException {
        StringPackage toServer = new StringPackage(NetworkType.APPROVE, shiftId);
        String gsonToServer = gson.toJson(toServer);
        handler.sendToDb(gsonToServer);

        StringPackage toServer2 = new StringPackage(NetworkType.APPROVE, username);
        String gsonToServer2 = gson.toJson(toServer2);
        handler.sendToDb(gsonToServer2);
    }

    /**
     * Creating a network package with StringPackage type with shift ID and username
     * Converts to gson the network package
     * Send the gson to data tire
     *
     * @param shiftId
     * @param username
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void Reject(String shiftId, String username) throws IOException, ClassNotFoundException {
        StringPackage toServer = new StringPackage(NetworkType.REJECT, shiftId);
        String gsonToServer = gson.toJson(toServer);
        handler.sendToDb(gsonToServer);

        StringPackage toServer2 = new StringPackage(NetworkType.REJECT, username);
        String gsonToServer2 = gson.toJson(toServer2);
        handler.sendToDb(gsonToServer2);
    }
}
