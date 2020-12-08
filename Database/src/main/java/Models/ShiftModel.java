package Models;

import Data.Shift;

import java.text.ParseException;
import java.util.List;

public interface ShiftModel {
    void CreateShift(Shift shift);
    List<Shift> GetAllShiftsForOneUser(String username) throws ParseException;
}
