package SEP.Services;

import SEP.Models.Shift;

import java.io.IOException;
import java.util.List;

public interface ShiftService {
    List<Shift> GetShiftsAsync();
    void AddShiftAsync(Shift shift) throws IOException, ClassNotFoundException;
    void RemoveShiftAsync(int shiftId);
    void UpdateShiftAsync(Shift shift);
}
