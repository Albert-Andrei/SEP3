package SEP.Controllers;

import SEP.Models.Application;
import SEP.Services.ApplicationService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/application")
public class ApplicationController {
        @Autowired
        private ApplicationService service;


    @GetMapping("/get/all")
    @ResponseBody
    public List<Application> getApplication() throws IOException, ClassNotFoundException {
        System.out.println(service.getAllApplications().size() + "MESSAGE");
        return service.getAllApplications();
    }


        @PostMapping("/create")
        @ResponseBody
        public Application createApplication(@RequestBody final Application application) throws IOException, ClassNotFoundException {
            service.createApplication(application);
            return application;
        }

        @GetMapping("/get/{applicationId}")
        @ResponseBody
        public Application getApplication(@PathVariable final ObjectId applicationId) throws IOException, ClassNotFoundException {
            service.getApplication(applicationId);
            return getApplication(applicationId);
        }




    ;

    /*    @DeleteMapping("/delete")
        public void remove(@RequestParam int id) {
            service.removeUser(id);
        }

        ;

        @PutMapping("/update")
        public void update(@RequestBody final User user) {
            service.updateUser(user);
        }

        ;*/

}
