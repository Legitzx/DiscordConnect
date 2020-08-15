package org.legitzxdevelopment.discordbot.utils;

import com.google.cloud.firestore.QueryDocumentSnapshot;

import java.util.Map;

public interface Converter<T> {
    T deserialize(QueryDocumentSnapshot doc);

    Map<String, Object> serialize(T object);
}
