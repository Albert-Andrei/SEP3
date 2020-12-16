package SEP.Services;

import SEP.Managers.ShiftClient;
import SEP.Managers.ShiftRemoteModel;
import SEP.Models.Shift;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ShiftServiceImplementation implements ShiftService {

    private ShiftRemoteModel remoteModel;

    /**
     * Constructor, initialize the variables
     *
     * @throws IOException
     */
    public ShiftServiceImplementation() throws IOException {
        this.remoteModel = new ShiftClient();
    }

    /**
     * Calls the getShiftsForOneUser from ShiftRemoteModel class
     *
     * @param username
     * @return A list of all Shifts that are stored in database
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public List<Shift> GetShiftsAsyncForOne(String username) throws IOException, ClassNotFoundException {
        return remoteModel.getShiftsForOneUser(username);
    }

    /**
     * Calls the getAllShifts from ShiftRemoteModel class
     *
     * @return A list of Shifts for a specific user
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public List<Shift> GetAllShifts() throws IOException, ClassNotFoundException {
        return remoteModel.getAllShifts();
    }

    /**
     * Calls the GetShiftById method from ShiftRemoteModel class
     *
     * @param shiftId
     * @return A shift
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public Shift GetShiftById(String shiftId) throws IOException, ClassNotFoundException {
        return remoteModel.GetShiftById(shiftId);
    }

    /**
     * Calls the method CreateShift from remote model
     *
     * @param shift
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void AddShiftAsync(Shift shift) throws IOException, ClassNotFoundException {
        remoteModel.createShift(shift);
    }

    /**
     * Calls the method removeShift method from remote model in order to remove a shift from database
     *
     * @param shiftId
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void RemoveShiftAsync(String shiftId) throws IOException, ClassNotFoundException {
        remoteModel.removeShift(shiftId);

    }

    /**
     * Calls the method applyToShift method from ShiftRemoteMode class in order to update a shift from database
     *
     * @param shiftId
     * @param username
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void ApplyToShiftAsync(String shiftId, String username) throws IOException, ClassNotFoundException {
        remoteModel.applyToShift(shiftId, username);
    }

    /**
     * Calls the method Approve method from ShiftRemoteMode class in order to update a shift from database
     *
     * @param shiftId
     * @param username
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void ApproveAsync(String shiftId, String username) throws IOException, ClassNotFoundException {
        remoteModel.Approve(shiftId, username);
    }

    /**
     * Calls the method Reject method from ShiftRemoteMode class in order to update a shift from database
     *
     * @param shiftId
     * @param username
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void RejectAsync(String shiftId, String username) throws IOException, ClassNotFoundException {
        remoteModel.Reject(shiftId, username);
    }
}
