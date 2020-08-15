package org.legitzxdevelopment.discordbot.modules.connect.converters;

import com.google.cloud.firestore.QueryDocumentSnapshot;
import org.legitzxdevelopment.discordbot.modules.connect.user.User;
import org.legitzxdevelopment.discordbot.utils.Converter;

import java.util.Map;

/**
 * Contributor(s): Luciano K
 * Description:
 */
public class UserConverter implements Converter<User> {
    @Override
    public User deserialize(QueryDocumentSnapshot doc) {
        return null;
    }

    @Override
    public Map<String, Object> serialize(User object) {
        return null;
    }
}
