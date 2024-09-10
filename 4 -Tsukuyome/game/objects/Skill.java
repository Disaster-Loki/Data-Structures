package ao.tsukuyomi.game.objects;

import java.io.Serializable;

public class Skill implements Serializable {
    private String name;
    private String description;
    private int level;

    public Skill(String name, String description, int level) {
        this.name = name;
        this.description = description;
        this.level = level;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString(){
        var sb = new StringBuilder();
        sb.append("Name: " + this.name + "\n");
        sb.append("Description: " + this.description + "\n");
        sb.append("Level: " + this.level + "\n");
        return sb.toString();
    }

}