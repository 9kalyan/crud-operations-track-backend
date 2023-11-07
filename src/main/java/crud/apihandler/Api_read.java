package crud.apihandler;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import crud.firebaseconnect.init;

import java.util.ArrayList;
import java.util.List;
@RestController
public class Api_read {
    @RequestMapping("/read")
    public static List read(@RequestParam String name) {

        try {
            Firestore firestore = init.fd;
            ApiFuture<QuerySnapshot>
                    future = firestore.collection("storage")
                    .document(name.toString()).collection("mystore")
                    .get();
            List<QueryDocumentSnapshot>
                    documents = future.get().getDocuments();
            if (documents.size() != 0) {
                System.out.println(documents);
                List list = new ArrayList<>();
                for (QueryDocumentSnapshot document : documents)
                    list.add(document.getData());
            return list;
            }

        }
        catch(Exception e) {

        }
        return new ArrayList();
    }
}
