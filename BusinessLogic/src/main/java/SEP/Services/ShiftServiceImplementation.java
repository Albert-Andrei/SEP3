package SEP.Services;

import SEP.Managers.UserRemoteModel;
import SEP.Models.Shift;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiftServiceImplementation implements ShiftService {
//    private ShiftRemoteModel remoteModel;

    @Override
    public List<Shift> GetShiftsAsync() {
        return null;
    }

    @Override
    public void AddShiftAsync(Shift shift) {
        System.out.println("Privet");
    }

    @Override
    public void RemoveShiftAsync(int shiftId) {

    }

    @Override
    public void UpdateShiftAsync(Shift shift) {

    }
}
