package SEP.Services;

import SEP.Models.Shift;

import java.io.IOException;
import java.util.List;

public interface ShiftService {
    List<Shift> GetShiftsAsyncForOne(String username) throws IOException, ClassNotFoundException;
    List<Shift> GetAllShifts() throws IOException, ClassNotFoundException;
    Shift GetShiftById(String ShiftId) throws IOException, ClassNotFoundException;
    void AddShiftAsync(Shift shift) throws IOException, ClassNotFoundException;
    void RemoveShiftAsync(String shiftId) throws IOException, ClassNotFoundException;
    void ApplyToShiftAsync(String shiftId, String username) throws IOException, ClassNotFoundException;
    void ApproveAsync(String shiftId, String username) throws IOException, ClassNotFoundException;
    void RejectAsync(String shiftId, String username) throws IOException, ClassNotFoundException;
}
