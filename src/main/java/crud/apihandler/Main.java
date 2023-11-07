package crud.apihandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import crud.firebaseconnect.init;

import java.io.IOException;
import crud.firebaseconnect.Firebase_write;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(Main.class,args);
        init.connectToFirebase();
        Firebase_write.main("reva");
    }

}
