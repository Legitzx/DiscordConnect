package org.legitzxdevelopment.discordbot.firebase;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Contributor(s): Luciano K
 * Description:
 */
public class DatabaseConnection {
    private static Firestore db;

    public static void connect() throws Exception {
        InputStream serviceAccount = new FileInputStream("C:\\Users\\Luciano\\Desktop\\Programming\\hackathon\\DiscordConnect\\serviceAccount.json");
        GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(credentials)
                .build();
        FirebaseApp.initializeApp(options);

        db = FirestoreClient.getFirestore();

//        ApiFuture<QuerySnapshot> query = db.collection("users").get();
//
//        QuerySnapshot querySnapshot = query.get();
//        List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
//        for (QueryDocumentSnapshot document : documents) {
//            System.out.println("User: " + document.getId());
//            System.out.println("First: " + document.getString("bio"));
//            System.out.println("Last: " + document.get("interests"));
//        }
    }

    public static Firestore getDatabase() {
        return db;
    }
}
