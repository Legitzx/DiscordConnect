package org.legitzxdevelopment.discordbot.firebase;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import org.legitzxdevelopment.discordbot.modules.connect.converters.UserConverter;
import org.legitzxdevelopment.discordbot.modules.connect.user.User;

import java.util.Collections;
import java.util.List;

/**
 * Contributor(s): Luciano K
 * Description: Provides methods that interact with the database
 */
public class DatabaseApi {
    // Database
    private Firestore db = DatabaseConnection.getDatabase();

    // Converters
    private UserConverter userConverter = new UserConverter();

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

    public void createUserProfile(User user) {
        DocumentReference docRef = db.collection("users").document(user.getId());

        docRef.set(userConverter.serialize(user));
    }

    public void updateUserProfile(User user) {
        String id = user.getId();

        if(!doesUserExist(id)) {
            createUserProfile(new User(id, "", "", "", Collections.emptyList(), Collections.emptyList()));
        }

        DocumentReference docRef = db.collection("users").document(id);
        docRef.update(userConverter.serialize(user));
    }

    /**
     * Attempts to get a user profile
     * @param id
     * @return
     */
    public User getUserProfile(String id) {
        User user = null;

        if(!doesUserExist(id)) {
            createUserProfile(new User(id, "", "", "", Collections.emptyList(), Collections.emptyList()));
        }

        ApiFuture<QuerySnapshot> query = db.collection("users").get();
        try {
            QuerySnapshot querySnapshot = query.get();
            List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
            for(QueryDocumentSnapshot document : documents) {
                if(document.getId().equalsIgnoreCase(id)) {
                    user = userConverter.deserialize(document);
                }
            }
        } catch (Exception ignored) { }

        return user;
    }
}
