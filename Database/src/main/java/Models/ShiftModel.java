package Models;

import Data.Application;
import Data.Shift;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface ShiftModel {
    void CreateShift(Shift shift);
    List<Shift> GetAllShiftsForOneUser(String username) throws ParseException;
    List<Shift> GetAllShifts() throws ParseException;
    Shift GetShiftById(String shiftId) throws ParseException;
    void removeShift(String stringId) throws IOException, ClassNotFoundException;
    void applyToShift(String shiftId, String username) throws IOException, ClassNotFoundException;
    void Approve(String shiftId, String username) throws IOException, ClassNotFoundException;
    void Reject(String shiftId, String username) throws IOException, ClassNotFoundException;
}
