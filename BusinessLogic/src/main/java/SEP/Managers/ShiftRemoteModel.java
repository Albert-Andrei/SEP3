package SEP.Managers;

import SEP.Models.Shift;

import java.io.IOException;
import java.util.List;

public interface ShiftRemoteModel {
    void createShift(Shift shift) throws IOException, ClassNotFoundException;
    List<Shift> getShiftsForOneUser(String username) throws IOException, ClassNotFoundException;
    List<Shift> getAllShifts() throws IOException, ClassNotFoundException;
    void removeShift(String shiftId) throws IOException, ClassNotFoundException;

}
