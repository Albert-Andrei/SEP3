package SEP.Controllers;

import SEP.Models.Application;
import SEP.Services.ApplicationService;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * ApplicationController class make the API connection using Java Spring framework
 */
@RestController
@RequestMapping("/application")
public class ApplicationController {
    @Autowired
    private ApplicationService service;

    /**
     * Returns a list of Applications to client's get request with endpoint all
     * @return An ArrayList of Applications
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @GetMapping("/all")
    public List<Application> getApplication() throws IOException, ClassNotFoundException {
        return service.getAllApplications();
    }

    /**
     * Returns a specific application by it's id from database to client's get request with endpoint get
     * @param applicationId
     * @return Application from Database
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @GetMapping("/get/{applicationId}")
    @ResponseBody
    public Application getApplication(@PathVariable final String applicationId) throws IOException, ClassNotFoundException {
        System.out.println(applicationId);
        return service.getApplication(applicationId);

    }


    /**
     * Receives and send the application to database in order to be stored
     * Returns an application by it's id from database to client's get request with endpoint get
     * @param application
     * @return Created application from database
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @PostMapping("/create")
    @ResponseBody
    public Application createApplication(@RequestBody final Application application) throws IOException, ClassNotFoundException {
        service.createApplication(application);
        return application;
    }


    /**
     * Send the application and the username of application owner
     * received from client data tire order to update it in database
     * @param user
     * The username of application owner
     * @param application
     * @return Created application from database
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @PutMapping("/update/{user}")
    @ResponseBody
    public Application updateApplication(@PathVariable("user") String user, @RequestBody final Application application) throws IOException, ClassNotFoundException {
        service.updateApplication(application);
        return application;
    }

    /**
     * Receives and send the username to database in order to be get a the application of the user
     * Returns an application by username from database to client's get request with endpoint get-by-user
     * @param user
     * The username of application owner
     * @return Application from Database by username
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @GetMapping("/get-by-user/{user}")
    @ResponseBody
    public Application getMyApplication(@PathVariable final String user) throws IOException, ClassNotFoundException {
        return service.getApplicationMyApplication(user);
    }
}
