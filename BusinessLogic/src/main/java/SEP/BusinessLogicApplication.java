package SEP;

import SEP.Controllers.ApplicationController;
import org.bson.types.ObjectId;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class BusinessLogicApplication {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SpringApplication.run(BusinessLogicApplication.class, args);
    }

}
