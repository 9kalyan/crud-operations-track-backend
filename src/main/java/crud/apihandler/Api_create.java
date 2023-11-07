package crud.apihandler;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import crud.firebaseconnect.init;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
@RestController
public class Api_create {
    @PostMapping("/create")
    public static void createapi(@RequestBody Map<String,String> id,
                                 @RequestParam String username){
        System.out.println(id.get("Value"));
        System.out.println(username);
    }
    @GetMapping("/checkbeforecreate")
    public static void main(@RequestParam String document) {
        Firestore firestore=init.fd;
        ApiFuture<QuerySnapshot> collection=
                firestore.collection("storage")
                .document(document)
                        .collection("mystore")
                        .get();

    }
}
