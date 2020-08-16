package org.legitzxdevelopment.discordbot.modules.connect.converters;

import com.google.cloud.firestore.QueryDocumentSnapshot;
import org.legitzxdevelopment.discordbot.modules.connect.user.User;
import org.legitzxdevelopment.discordbot.utils.Converter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Contributor(s): Luciano K
 * Description:
 */
public class UserConverter implements Converter<User> {
    @Override
    public User deserialize(QueryDocumentSnapshot doc) {
        String id = doc.getId();
        String name = doc.getString("name");
        String bio = doc.getString("bio");
        String location = doc.getString("location");
        List<String> interests = (List<String>) doc.get("interests");
        List<String> connections = (List<String>) doc.get("connections");

        return new User(id, name, bio, location, interests, connections);
    }

    @Override
    public Map<String, Object> serialize(User user) {
        Map<String, Object> data = new HashMap<>();

        data.put("name", user.getName());
        data.put("bio", user.getBio());
        data.put("location", user.getLocation());
        data.put("interests", user.getInterests());
        data.put("connections", user.getConnections());

        return data;
    }
}