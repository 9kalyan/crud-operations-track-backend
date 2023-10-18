package crud.apihandler;
import crud.authentication.login;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import crud.apihandler.Main;
record mai(String status){}
@RestController
public class api_login {
    @RequestMapping("/user")
    public mai k(@RequestParam String username, String password){
        mai n=new mai("Success");
        mai m=new mai("Fail");
        if(login.validateUserName(username,password))
            return n;
        return m;
    }
}
