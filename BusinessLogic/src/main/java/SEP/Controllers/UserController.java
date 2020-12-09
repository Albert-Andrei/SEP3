package SEP.Controllers;

import SEP.Models.User;
import SEP.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/post")
    @ResponseBody
    public User list(@RequestBody final User user) throws IOException, ClassNotFoundException {
        System.out.println("Opa this is request for log in((((( Privet b");
        return service.validateUser(user.getUsername(), user.getPassword());
    }



    @PostMapping("/create")
    @ResponseBody
    public User createUser(@RequestBody final User user) throws IOException, ClassNotFoundException {
        System.out.println("Esti Contact, User to create> " + user);
        try {
            service.createUser(user);
            return user;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


//    @GetMapping("/get")
//    public void get() throws IOException, ClassNotFoundException {
//        service.createUser(null);
//    }
//
//    ;

    @DeleteMapping("/delete")
    public void remove(@RequestParam int id) {
        service.removeUser(id);
    }

    ;

    @PutMapping("/update")
    public void update(@RequestBody final User user) {
        service.updateUser(user);
    }

    ;
}
