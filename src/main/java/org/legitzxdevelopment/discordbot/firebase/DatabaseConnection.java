package org.legitzxdevelopment.discordbot.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Contributor(s): Luciano K
 * Description: Connects to the database
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
    }

    public static Firestore getDatabase() {
        return db;
    }
}
