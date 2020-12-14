package SEP.Controllers;


import SEP.Models.Shift;
import SEP.Models.User;
import SEP.Services.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/shifts")

public class ShiftController {

    /**
     * Injecting ShiftService
     */
    @Autowired
    private ShiftService service;


    /**
     *
     * @param shift
     * @return HttpStatus.CREATED and shift is everithing went ok and HttpStatus.EXPECTATION_FAILED
     * if something went wrong
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @PostMapping
    @ResponseBody
    public ResponseEntity CreateShift(@RequestBody final Shift shift) throws IOException, ClassNotFoundException {
        try {
            System.out.println("Esti Contact, Shift to create> " + shift.toString());
            service.AddShiftAsync(shift);
            return new ResponseEntity(shift, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     *
     * Controller for get request calls the GetShiftsAsyncForOne method from Shift Service
     * @param username
     * @return List of Shifts
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @GetMapping
    public List<Shift> get(@RequestParam final String username) throws IOException, ClassNotFoundException {
        return service.GetShiftsAsyncForOne(username);
    }

    /**
     *
     * @return A list of all shifts
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @GetMapping("/all")
    public List<Shift> getAll() throws IOException, ClassNotFoundException {
        return service.GetAllShifts();
    }

    @GetMapping("/one/{shiftId}")
    public Shift getShiftById(@PathVariable("shiftId") String shiftId) throws IOException, ClassNotFoundException {
        return service.GetShiftById(shiftId);
    }

    @DeleteMapping("{shiftId}")
    @ResponseBody
    public void remove(@PathVariable("shiftId") String shiftId) throws IOException, ClassNotFoundException {
         service.RemoveShiftAsync(shiftId);
    }

    ;

    @PutMapping("apply/{shiftId}/{username}")
    public void update(@PathVariable("shiftId") String shiftId, @PathVariable("username") String username) throws IOException, ClassNotFoundException {
        System.out.println(shiftId + ", "+ username);
        service.ApplyToShiftAsync(shiftId, username);
    }

    @PutMapping("approve/{shiftId}/{username}")
    public void approve(@PathVariable("shiftId") String shiftId, @PathVariable("username") String username) throws IOException, ClassNotFoundException {
        System.out.println("approve" + shiftId + ", "+ username);
        service.ApproveAsync(shiftId, username);
    }

    @PutMapping("reject/{shiftId}/{username}")
    public void reject(@PathVariable("shiftId") String shiftId, @PathVariable("username") String username) throws IOException, ClassNotFoundException {
        System.out.println("reject" + shiftId + ", "+ username);
        service.RejectAsync(shiftId, username);
    }

    ;

}
