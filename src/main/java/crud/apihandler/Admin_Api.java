package crud.apihandler;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import crud.firebaseconnect.init;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class Admin_Api {
    @RequestMapping("/admin")
    public List AdminApi() {
        try {
            Firestore firestore = init.fd;
            ApiFuture<QuerySnapshot> future = firestore.
                    collection("username")
                    .get();
            List<QueryDocumentSnapshot> docfuture =
                    future.get().getDocuments();
            List k = new LinkedList();
            for (QueryDocumentSnapshot document : docfuture) {
                k.add(document.getId());
            }
            return k;
        } catch (Exception e) {

        }
        return new LinkedList();
    }
    @RequestMapping("/userinfo")
    public static
    List
    UserInfo(@RequestParam String name,
             @RequestParam String operation){
        try{
            Firestore firestore = init.fd;
            ApiFuture<QuerySnapshot> future = firestore.
                    collection("track").document(name).
                    collection(operation)
                    .get();
            List<QueryDocumentSnapshot> docfuture =
                    future.get().getDocuments();
            List k = new LinkedList();
            for (QueryDocumentSnapshot document : docfuture) {
                k.add(document.getId());
            }
            return k;
        }
        catch(Exception e){

        }
        return null;
    }
}
