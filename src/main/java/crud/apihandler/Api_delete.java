package crud.apihandler;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import crud.firebaseconnect.init;

import java.util.LinkedList;
import java.util.List;

@RestController
public class Api_delete {
    @RequestMapping("/delete")
    public static String main(@RequestParam String name,@RequestParam String doc) {
        Firestore firestore=init.fd;
        CollectionReference coll = firestore.collection("storage")
                .document(name)
                .collection("mystore");
        coll.document(doc).delete();
        return "Deleted";
    }
    @RequestMapping("/getdocs")
    public static List mai(@RequestParam String name) {
        try {
            Firestore firestore=init.fd;
            ApiFuture<QuerySnapshot> future = firestore.collection("storage")
                    .document(name)
                    .collection("mystore").get();
            List<QueryDocumentSnapshot> list = future.get().getDocuments();
            List k = new LinkedList();
            for (QueryDocumentSnapshot document :list) {
                k.add(document.getId());
            }
            return k;
        }
        catch(Exception e){

        }
        return new LinkedList();
    }
}
