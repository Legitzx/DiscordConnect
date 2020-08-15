package org.legitzxdevelopment.discordbot.firebase;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

import java.util.List;

/**
 * Contributor(s): Luciano K
 * Description: Provides methods that interact with the database
 */
public class DatabaseApi {
    private Firestore db = DatabaseConnection.getDatabase();

    /**
     * Checks if a user exists in the database
     * @param id        Discord ID of user
     * @return          true if user exists
     */
    public boolean doesUserExist(String id) {
        ApiFuture<QuerySnapshot> query = db.collection("users").get();
        try {
            QuerySnapshot querySnapshot = query.get();
            List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
            for(QueryDocumentSnapshot document : documents) {
                if(document.getId().equalsIgnoreCase(id)) {
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }

        return false;
    }
}
