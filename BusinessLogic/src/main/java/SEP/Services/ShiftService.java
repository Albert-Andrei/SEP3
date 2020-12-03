package SEP.Services;

import SEP.Models.Shift;
import java.util.List;

public interface ShiftService {
    List<Shift> GetShiftsAsync();
    void AddShiftAsync(Shift shift);
    void RemoveShiftAsync(int shiftId);
    void UpdateShiftAsync(Shift shift);
}
