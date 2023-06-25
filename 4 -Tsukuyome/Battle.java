import java.util.Date;

public class Battle {
    private Date dateTime;
    private Skill skill;

    public Battle(Date dateTime, Skill skill) {
        this.dateTime = dateTime;
        this.skill = skill;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}