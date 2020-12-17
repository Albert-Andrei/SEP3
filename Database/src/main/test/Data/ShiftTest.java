package Data;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ShiftTest {

    Shift s = new Shift(
                null, null, "andrei", "Hopa Prime",
            "Packing", "It's easy work", "No requirements"
                        , 120, null, null, null, new Date(2020,11,15),"Evening (14-22)"
            );
    @BeforeEach
    void setUp() {
        System.out.println("----> setUp()");
    }

    @AfterEach
    void tearDown() {
        System.out.println("---> tearDown()");
    }

    @Test
    void getShiftId() {
        assertEquals(null, s.getShiftId());
    }

    @Test
    void setShiftId() {
        s.setShiftId("123456789");
        assertEquals("123456789", s.getShiftId());
    }

    @Test
    void getJobTitle() {
        assertEquals("Packing",s.getJobTitle());
    }

    @Test
    void setJobTitle() {
        s.setJobTitle("Opaaaa");
        assertEquals("Opaaaa",s.getJobTitle());
    }

    @Test
    void get_id() {
        assertEquals(null,s.get_id());
    }

    @Test
    void set_id() {
        //Not relevant
    }

    @Test
    void getUsername() {
        assertEquals("andrei",s.getUsername());
    }

    @Test
    void setUsername() {
        s.setUsername("Jora");
        assertEquals("Jora",s.getUsername());
    }

    @Test
    void getCompanyName() {
        assertEquals("Hopa Prime", s.getCompanyName());
    }

    @Test
    void setCompanyName() {
        s.setCompanyName("MOPA");
        assertEquals("MOPA", s.getCompanyName());
    }

    @Test
    void getDate() {
        assertEquals(new Date(2020,11,15),s.getDate());
    }

    @Test
    void setDate() {
        s.setDate(new Date(2020,11,17));
        assertEquals(new Date(2020,11,17), s.getDate());
    }

    @Test
    void getPreferableWorkTime() {
        assertEquals("Evening (14-22)",s.getPreferableWorkTime());
    }

    @Test
    void setPreferableWorkTime() {
        s.setPreferableWorkTime("Day (7-15)");
        assertEquals("Day (7-15)",s.getPreferableWorkTime());
    }

    @Test
    void getDescription() {
        assertEquals("It's easy work",s.getDescription());
    }

    @Test
    void setDescription() {
        s.setDescription("It's easy");
        assertEquals("It's easy", s.getDescription());
    }

    @Test
    void getRequirements() {
        assertEquals("No requirements",s.getRequirements());
    }

    @Test
    void setRequirements() {
        s.setRequirements("mda");
        assertEquals("mda", s.getRequirements());
    }

    @Test
    void getHourWage() {
        assertEquals(120, s.getHourWage());
    }

    @Test
    void setHourWage() {
        s.setHourWage(123);
        assertEquals(123, s.getHourWage());
    }
}