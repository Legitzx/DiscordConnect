package org.legitzxdevelopment.discordbot.modules.connect.user;

import java.util.List;

/**
 * Contributor(s): Luciano K
 * Description:
 */
public class User {
    private String id;
    private String name;
    private String bio;
    private String location;
    private List<String> interests;
    private List<String> connections;

    public User(String id, String name, String bio, String location, List<String> interests, List<String> connections) {
        this.id = id;
        this.name = name;
        this.bio = bio;
        this.location = location;
        this.interests = interests;
        this.connections = connections;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public List<String> getConnections() {
        return connections;
    }

    public void setConnections(List<String> connections) {
        this.connections = connections;
    }
}
