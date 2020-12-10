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


    @GetMapping("/all")
    public  List<Application>  getApplication() throws IOException, ClassNotFoundException {
        return service.getAllApplications();
    }

    @GetMapping("/get/{applicationId}")
        @ResponseBody
         public Application getApplication(@PathVariable final String applicationId) throws IOException, ClassNotFoundException {
        System.out.println(applicationId);
        return service.getApplication(applicationId);

    }


        @PostMapping("/create")
        @ResponseBody
        public Application createApplication(@RequestBody final Application application) throws IOException, ClassNotFoundException {
            service.createApplication(application);
            return application;
        }


        @PutMapping("/update/{applicationId}")
        @ResponseBody
        public Application updateApplication(@PathVariable("applicationId") String applicationId, @RequestBody final Application application) throws IOException, ClassNotFoundException {
         service.updateApplication(application);
         return application;


        }

}
