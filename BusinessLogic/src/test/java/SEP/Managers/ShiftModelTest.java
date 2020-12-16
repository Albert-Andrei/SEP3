package SEP.Managers;

import SEP.Models.Shift;
import SEP.Services.ShiftService;
import SEP.Services.ShiftServiceImplementation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShiftModelTest {

    ShiftService shiftModel = new ShiftServiceImplementation();
    List<Shift> listAll;
    List<Shift> oneUser;

    ShiftModelTest() throws IOException, ClassNotFoundException {
        this.listAll = shiftModel.GetAllShifts();
        this.oneUser = shiftModel.GetShiftsAsyncForOne("andrei");
    }

    @BeforeEach
    void setUp() throws IOException, ClassNotFoundException {
        System.out.println("----> setUp()");
    }

    @AfterEach
    void tearDown() {
        System.out.println("---> tearDown()");
    }

    @Test
    void createShiftZero() throws IOException, ClassNotFoundException {
        // Not relevant
    }

    @Test
    void createShiftOne() throws IOException, ClassNotFoundException {
        Shift shift = new Shift(
                null, null, "andrei", "Hopa Prime", "Packing", "It's easy work", "No requirements"
                , 120, null, null, null, null,"Evening (14-22)"
        );
//        shiftModel.AddShiftAsync(shift);
        assertEquals(shift, shiftModel.GetShiftById("5fda6a7647a8c6672a81761d"));
    }

    @Test
    void createShiftMany() throws IOException, ClassNotFoundException {
        Shift shift = new Shift(
                null, null, "andrei", "Hopa Prime", "Picking", "It's easy work", "No requirements"
                , 120, null, null, null, null,"Evening (14-22)"
        );

        Shift shift2 = new Shift(
                null, null, "andrei", "Hopa Prime", "Packing", "It's easy work", "No requirements"
                , 130, null, null, null, null,"Day (06-14:00)"
        );

        shiftModel.AddShiftAsync(shift);
        shiftModel.AddShiftAsync(shift2);

        assertEquals(shift, shiftModel.GetShiftById(""));
    }

    @Test
    void getShiftsForOneUser() throws IOException, ClassNotFoundException {
        assertEquals(oneUser, shiftModel.GetShiftsAsyncForOne("andrei"));
    }

    @Test
    void getShiftById() throws IOException, ClassNotFoundException {
        Shift shift = new Shift(
                null, null, "andrei", "Hopa Prime", "Packing", "It's easy work", "No requirements"
                , 120, null, null, null, null,"Evening (14-22)"
        );
        assertEquals(shift, shiftModel.GetShiftById("5fda6a7647a8c6672a81761d"));
    }

    @Test
    void getAllShifts() throws IOException, ClassNotFoundException {
        assertEquals(listAll, shiftModel.GetAllShifts());
    }


    @Test
    void applyToShiftZero() throws IOException, ClassNotFoundException {
       // Not relevant
    }

    @Test
    void applyToShiftOne() throws IOException, ClassNotFoundException {
        shiftModel.ApplyToShiftAsync("", "fiodor");
        assertEquals("fiodor", shiftModel.GetShiftById("").getPendingList().get(0));
    }

    @Test
    void applyToShiftMany() throws IOException, ClassNotFoundException {
        shiftModel.ApplyToShiftAsync("", "fedea");
        shiftModel.ApplyToShiftAsync("", "jora");

        Shift s = shiftModel.GetShiftById("");

        for ( String so : s.getPendingList()) {
            if (so.equals("fedea"))
            {
                assertEquals("fedea", so);
            } else if (so.equals("jora")) {
                assertEquals("jora", so);
            }
        }
    }

    @Test
    void approveZero() throws IOException, ClassNotFoundException {
        // Not relevant
    }

    @Test
    void approveOne() throws IOException, ClassNotFoundException {
        shiftModel.ApproveAsync("","fiodor");
        assertEquals("fiodor", shiftModel.GetShiftById("").getApprovedList().get(0));
    }

    @Test
    void approveMany() throws IOException, ClassNotFoundException {
        shiftModel.ApproveAsync("","fedea");
        shiftModel.ApproveAsync("","jora");

        Shift s = shiftModel.GetShiftById("");

        assertEquals("fedea jora",
                shiftModel.GetShiftById("").getApprovedList().get(1) + " " +
                shiftModel.GetShiftById("").getApprovedList().get(2));
    }

    @Test
    void rejectZero() {
        //Not relevant
    }

    @Test
    void rejectOne() throws IOException, ClassNotFoundException {
        shiftModel.RejectAsync("", "fiodor");
        assertEquals("fiodor", shiftModel.GetShiftById("").getRejectedList().get(0));
    }

    @Test
    void rejectMany() throws IOException, ClassNotFoundException {
        shiftModel.RejectAsync("","fedea");
        shiftModel.RejectAsync("","jora");

        Shift s = shiftModel.GetShiftById("");

        assertEquals("fedea jora",
                shiftModel.GetShiftById("").getRejectedList().get(1) + " " +
                        shiftModel.GetShiftById("").getRejectedList().get(2));
    }

    @Test
    void removeShift() throws IOException, ClassNotFoundException {
        shiftModel.RemoveShiftAsync("");
        assertEquals(null,shiftModel.GetShiftById(""));
    }
}
