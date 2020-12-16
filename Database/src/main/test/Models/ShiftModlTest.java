package Models;

import Data.Shift;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShiftModlTest {

    MongoClient mongoClient = MongoClients.create(
            "mongodb+srv://shared:12345@cluster0.anhd1.mongodb.net/Cluster0?retryWrites=true&w=majority"
    );
    MongoDatabase database = mongoClient.getDatabase("SEP");

    private ShiftModel model = new ShiftModelImplementation(database);
    private List<Shift> all;

    public ShiftModlTest() throws ParseException {
        this.all = model.GetAllShifts();
    }

    @BeforeEach
    void setUp() {
        System.out.println("----> setUp()");
    }

    @AfterEach
    void tearDown() {
        System.out.println("---> tearDown()");
    }

    @Test
    void createShiftZero() {
        model.CreateShift(new Shift(
                null, null, "andrei", "Hopa Prime", "Packing", "It's easy work", "No requirements"
                , 120, null, null, null, new Date(2020,11,15),"Evening (14-22)"
        ));
    }

    @Test
    void getAllShiftsForOneUser() throws ParseException {
        List<Shift> opa = new ArrayList<>();
        for (Shift s: all) {
            if (s.getUsername().equals("andrei")){
                opa.add(s);
            }
        }
        assertEquals(opa,model.GetAllShiftsForOneUser("andrei"));
    }

    @Test
    void getAllShifts() throws ParseException {
        assertEquals(all, model.GetAllShifts());
    }

    @Test
    void getShiftById() {
    }

    @Test
    void removeShift() {
    }

    @Test
    void applyToShift() {
    }

    @Test
    void approve() {
    }

    @Test
    void reject() {
    }
}