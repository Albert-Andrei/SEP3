package SEP.Managers;

import SEP.Models.Shift;

import java.io.IOException;
import java.util.List;

public interface ShiftRemoteModel {
    void createShift(Shift shift) throws IOException, ClassNotFoundException;
    List<Shift> getShiftsForOneUser(String username) throws IOException, ClassNotFoundException;
    Shift GetShiftById(String ShiftId) throws IOException, ClassNotFoundException;
    List<Shift> getAllShifts() throws IOException, ClassNotFoundException;
    void removeShift(String shiftId) throws IOException, ClassNotFoundException;
    void applyToShift(String shiftId, String username) throws IOException, ClassNotFoundException;
    void Approve(String shiftId, String username) throws IOException, ClassNotFoundException;
    void Reject(String shiftId, String username) throws IOException, ClassNotFoundException;
}
