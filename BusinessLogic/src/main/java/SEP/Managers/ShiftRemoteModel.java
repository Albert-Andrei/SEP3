package SEP.Managers;

import SEP.Models.Shift;

import java.io.IOException;

public interface ShiftRemoteModel {
    void createShift(Shift shift) throws IOException, ClassNotFoundException;
}
