package crud.firebaseconnect;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.IOException;

public class init{
    public static Firestore fd;
    public static void connectToFirebase() throws IOException {
        //step 1
        FileInputStream ins=new FileInputStream("./fireb.json");
        //step 2
        FirebaseOptions options=FirebaseOptions.builder(
        ).setCredentials(GoogleCredentials.fromStream(ins)).build();
        FirebaseApp.initializeApp(options);
        fd= FirestoreClient.getFirestore();
    }
}

