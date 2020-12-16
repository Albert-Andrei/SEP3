package SEP.Controllers;

import SEP.Models.User;
import SEP.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * UserController class make the API connection using Java Spring framework
 */
@RestController
@RequestMapping("/users")
public class UserController {

    /**
     * Injecting UserService
     */
    @Autowired
    private UserService service;

    /**
     * Receives and send the User in order to check if the user exist in the system and the password is right
     * @param user
     * @return The username and the Hash of password to client
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @PostMapping("/post")
    @ResponseBody
    public User list(@RequestBody final User user) throws IOException, ClassNotFoundException {
//        System.out.println("Opa this is request for log in((((( Privet b");
        return service.validateUser(user.getUsername(), user.getPassword());
    }


    /**
     * Receives and send the shift to Data tire in order to be stored in database
     * Returns the User if user is stored in database and null if the user is not created
     * @param user
     * @return User if user is sored in database
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @PostMapping("/create")
    @ResponseBody
    public User createUser(@RequestBody final User user) throws IOException, ClassNotFoundException {
        try {
            service.createUser(user);
            return user;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Controller for delete request ,calls the removeUser method from User Service
     * @param id
     */
    @DeleteMapping("/delete")
    public void remove(@RequestParam int id) {
        service.removeUser(id);
    }

    /**
     * Controller for update request, calls the updateUser method from User Service
     * @param user
     */
    @PutMapping("/update")
    public void update(@RequestBody final User user) {
        service.updateUser(user);
    }
}
