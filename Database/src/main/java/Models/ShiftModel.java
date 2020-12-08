package Models;

import Data.Shift;

import java.util.List;

public interface ShiftModel {
    void CreateShift(Shift shift);
    List<Shift> GetAllShiftsForOneUser(String username);
}
