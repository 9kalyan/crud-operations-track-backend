package crud.firebaseconnect;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.WriteResult;

import java.util.HashMap;
import java.util.Map;

public class Firebase_write {
    public static void main(String username) {
        try{
            System.out.println("kallllllllllllllllllllcccaleed");
        FirestoreOptions firestoreOptions =
                FirestoreOptions.getDefaultInstance().toBuilder()
                        .setProjectId("872557705682")
                        .setCredentials(GoogleCredentials.getApplicationDefault())
                        .build();
            System.out.println("123333333333");
        Firestore db = firestoreOptions.getService();
            DocumentReference docRef = db.collection("track")
                    .document("reva");
            Map<String, Object> data = new HashMap<>();
            data.put("first", "Alan");
            ApiFuture<WriteResult> result = docRef.set(data);
            System.out.println("Update time : " + result.get().getUpdateTime());

        }
    catch (Exception e){

    }
    }
}
