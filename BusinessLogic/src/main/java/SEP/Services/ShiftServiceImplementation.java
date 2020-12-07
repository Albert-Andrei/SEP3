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

    public ShiftServiceImplementation() throws IOException {
        this.remoteModel = new ShiftClient();
    }

    @Override
    public List<Shift> GetShiftsAsync() {
        return null;
    }

    @Override
    public void AddShiftAsync(Shift shift) throws IOException, ClassNotFoundException {
        remoteModel.createShift(shift);
    }

    @Override
    public void RemoveShiftAsync(int shiftId) {

    }

    @Override
    public void UpdateShiftAsync(Shift shift) {

    }
}
