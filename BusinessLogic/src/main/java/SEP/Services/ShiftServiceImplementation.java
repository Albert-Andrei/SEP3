package SEP.Services;

import SEP.Managers.ShiftClient;
import SEP.Managers.ShiftRemoteModel;
import SEP.Managers.UserClient;
import SEP.Managers.UserRemoteModel;
import SEP.Models.Shift;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ShiftServiceImplementation implements ShiftService {

    private ShiftRemoteModel remoteModel;

    /**
     * Constructor, initialize the variables
     * @throws IOException
     */
    public ShiftServiceImplementation() throws IOException {
        this.remoteModel = new ShiftClient();
    }

    /**
     *
     * @param username
     * @return A list of Shifts for a specific user
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public List<Shift> GetShiftsAsyncForOne(String username) throws IOException, ClassNotFoundException {
        return remoteModel.getShiftsForOneUser(username);
    }

    @Override
    public List<Shift> GetAllShifts() throws IOException, ClassNotFoundException {
        return remoteModel.getAllShifts();
    }

    @Override
    public Shift GetShiftById(String shiftId) throws IOException, ClassNotFoundException {
        return remoteModel.GetShiftById(shiftId);
    }

    /**
     * Calls the method CreateShift from remote model
     * @param shift
     * @throws IOException
     * @throws ClassNotFoundException
     */

    @Override
    public void AddShiftAsync(Shift shift) throws IOException, ClassNotFoundException {
        remoteModel.createShift(shift);
    }

    @Override
    public void RemoveShiftAsync(String shiftId) throws IOException, ClassNotFoundException {
        remoteModel.removeShift(shiftId);

    }

    @Override
    public void ApplyToShiftAsync(String shiftId, String username) throws IOException, ClassNotFoundException {
        remoteModel.applyToShift(shiftId, username);
    }

    @Override
    public void ApproveAsync(String shiftId, String username) throws IOException, ClassNotFoundException {
        remoteModel.Approve(shiftId, username);
    }

    @Override
    public void RejectAsync(String shiftId, String username) throws IOException, ClassNotFoundException {
        remoteModel.Reject(shiftId, username);
    }
}
