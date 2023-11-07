package crud.apihandler;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import crud.authentication.login;

import crud.firebaseconnect.init;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

record Status(String status){}
@RestController
public class Api_login {
    Integer a=0;
    @RequestMapping("/user")
    public Status k(@RequestParam String username, String password){
        Status n=new Status("Success");
        Status m=new Status("Fail");
        if(login.validateUserName(username,password)) {
            try{
                a+=1;
            Firestore firestore = init.fd;
           DocumentReference future =
                   firestore.
                           collection("track").
                           document(username).
                           collection("login")
                   .document(a.toString());
                Date localTime = new Date();
                Map<String, Object> data = new HashMap<>();
                data.put("time",localTime);
                ApiFuture<WriteResult> result = future.set(data);
            }
            catch(Exception e){

            }
            return n;
        }
        return m;
    }
}
