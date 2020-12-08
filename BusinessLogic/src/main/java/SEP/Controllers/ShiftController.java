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
    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity CreateShift(@RequestBody final Shift shift) throws IOException, ClassNotFoundException {
        System.out.println("Esti Contact > " + shift);
        try {
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
    @GetMapping("/get")
    public List<Shift> get(@RequestParam final String username) throws IOException, ClassNotFoundException {
        return service.GetShiftsAsyncForOne(username);
    }

    @DeleteMapping("/delete")
    public void remove(@RequestParam int id) {

    }

    ;

    @PutMapping("/update")
    public void update(@RequestBody final User user) {

    }

    ;

}
