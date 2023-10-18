package crud.authentication;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreFactory;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import crud.firebaseconnect.init;
import  crud.firebaseconnect.init;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class login {
    public static boolean loginok;
    public static boolean validateUserName(String username,String password) {
        try {
            Firestore firestore = init.fd;
            ApiFuture<QuerySnapshot>
                    future = firestore.collection("username").get();
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();
            for (QueryDocumentSnapshot document : documents) {
                Map<String, Object> data = document.getData();
                if (document.getId().equals(username) && data.get("password").equals(password)) {
                    return true;
                }

            }

        } catch (Exception e) {

        }
        return false;
    }
}
