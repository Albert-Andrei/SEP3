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


/**
 * ShiftController class make the API connection using Java Spring framework
 */


@RestController
@RequestMapping("/shifts")
public class ShiftController {

    /**
     * Injecting ShiftService
     */
    @Autowired
    private ShiftService service;


    /**
     * Receives and send the shift to Data tire in order to be stored in database
     * Returns an HttpStatus to client's post request
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
     * Controller for get request calls the GetShiftsAsyncForOne method from Shift Service
     * @param username
     * Username of shift owner
     * @return List of Shifts
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @GetMapping
    public List<Shift> get(@RequestParam final String username) throws IOException, ClassNotFoundException {
        return service.GetShiftsAsyncForOne(username);
    }

    /**
     * Controller for get request calls the GetAllShifts method from Shift Service
     * @return A list of all shifts
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @GetMapping("/all")
    public List<Shift> getAll() throws IOException, ClassNotFoundException {
        return service.GetAllShifts();
    }

    /**
     * Controller for get request calls the GetShiftById method from Shift Service
     * @param shiftId
     * @return A shift by it's id
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @GetMapping("/one/{shiftId}")
    public Shift getShiftById(@PathVariable("shiftId") String shiftId) throws IOException, ClassNotFoundException {
        return service.GetShiftById(shiftId);
    }

    /**
     * Controller for delete request calls the RemoveShiftAsync method from Shift Service
     * @param shiftId
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @DeleteMapping("{shiftId}")
    @ResponseBody
    public void remove(@PathVariable("shiftId") String shiftId) throws IOException, ClassNotFoundException {
         service.RemoveShiftAsync(shiftId);
    }

    /**
     * Controller for put request calls the ApplyToShiftAsync method from Shift Service
     * @param shiftId
     * @param username
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @PutMapping("apply/{shiftId}/{username}")
    public void update(@PathVariable("shiftId") String shiftId, @PathVariable("username") String username) throws IOException, ClassNotFoundException {
        service.ApplyToShiftAsync(shiftId, username);
    }

    /**
     * Controller for put request calls the Controller for put request calls the ApproveAsync
     * method from Shift Service
     * @param shiftId
     * Id of the shift
     * @param username
     * The username of shift owner
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @PutMapping("approve/{shiftId}/{username}")
    public void approve(@PathVariable("shiftId") String shiftId, @PathVariable("username") String username) throws IOException, ClassNotFoundException {
        service.ApproveAsync(shiftId, username);
    }

    /**
     * Controller for put request calls the RejectAsync for put request calls the RejectAsync
     * method from Shift Service
     * This method send the shiftId to find shift in database and username that have to be rejected
     * @param shiftId
     * Id of the shift to update
     * @param username
     * Username of an employee that have to be rejected for this shift
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @PutMapping("reject/{shiftId}/{username}")
    public void reject(@PathVariable("shiftId") String shiftId, @PathVariable("username") String username) throws IOException, ClassNotFoundException {
        service.RejectAsync(shiftId, username);
    }
}
