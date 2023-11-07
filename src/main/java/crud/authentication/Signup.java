package crud.authentication;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import crud.firebaseconnect.init;
import java.time.LocalTime;
import java.util.*;

public class Signup {
    public static void Signup(String username,String password,
                              String phonenumber, String emailid){
        try {
            boolean usernameExist = false;
            Firestore firestore = init.fd;
            ApiFuture<QuerySnapshot> future = firestore.collection("username").get();
            List<QueryDocumentSnapshot> list = future.get().getDocuments();
            for(QueryDocumentSnapshot document:list){
                if(username.equals(document.getId().toString())){
                    usernameExist=true;
                    System.out.println(document.getId());
                }
            }
            if(!usernameExist){
                DocumentReference docref=
                        firestore.collection("username")
                                .document(username);
                Map<String,String> map=new HashMap<>();
                map.put("password",password);
                map.put("phonenumber",phonenumber);
                map.put("email",emailid);
                docref.set(map);
                DocumentReference docref2=
                        firestore.collection("storage")
                                .document(username)
                                .collection("mystore")
                                .document("kalyan");
                Map<String,String> ex=new HashMap<>();
                ex.put("time","po[".toString());
                docref2.set(ex);
                DocumentReference collref=
                        firestore.collection("track")
                                .document(username).
                                collection("create").
                                document("1");
                collref.set(ex);
                DocumentReference collref2=
                        firestore.collection("track")
                                .document(username)
                                .collection("read").document();
                collref2.set(ex);
                DocumentReference docsign=
                        firestore.collection("track")
                                .document(username)
                                .collection
                                        ("signup").document("time");
                DocumentReference collref3=
                        firestore.collection("track")
                                .document(username)
                                .collection("update").document();
                collref3.set(ex);
                DocumentReference collref4=
                        firestore.collection("track")
                                .document(username).collection("delete").document();
                collref4.set(ex);
                DocumentReference collref5=
                        firestore.collection("track")
                                .document(username).collection("login").document();
                collref5.set(ex);
                DocumentReference collref6=
                        firestore.collection("track")
                                .document(username).collection("logout").document();
                collref6.set(ex);
                Date time= new Date();
                Map<String,String> signupmap=new HashMap<>();
                signupmap.put("time",time.toString());
                docsign.set(signupmap);
            }
        }
        catch (Exception e){

        }
    }
}
