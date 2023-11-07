package crud.apihandler;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import crud.authentication.Signup;
@RestController
public class Api_signup {
    @PostMapping("/signup")
    public void k(@RequestBody Map<String,String> object){
        Signup.Signup(object.get("UserName"),object.get("Password"),
                object.get("PhoneNumber"),object
                        .get("EmailId")
                );
    }
}

