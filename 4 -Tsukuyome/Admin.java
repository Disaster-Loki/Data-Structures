package ao.tsukuyomi;

import java.io.Serializable;
import java.util.List;

class Admin implements Serializable {
    private String username;
    private String password;
    private List<String> activities;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void addActivity(String activity) {
        activities.add(activity);
    }

    public List<String> getActivities() {
        return activities;
    }
}