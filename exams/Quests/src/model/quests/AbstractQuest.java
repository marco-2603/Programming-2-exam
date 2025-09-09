package model.quests;

import model.Geraldo;
import model.exceptions.LowlvlException;
import model.exceptions.MissedPreException;

public abstract class AbstractQuest implements QuestInterface {
    protected String name;
    protected int level;
    protected AbstractQuest type;
    protected int reward;
    protected boolean risolta = false;

    public AbstractQuest(String name, int level,int reward) {
        this.name = name;
        this.level = level;
        this.reward = reward;
    }

    public String getName() {
        return name;
    }
    public int getLevel() {
        return level;
    }
    public int getReward() {
        return reward;
    }

    public boolean is_solvable(Geraldo g) {return g.getLevel()>=level;}
    public boolean is_risolta() {return risolta;}

    protected void addLevel(Geraldo g) {
        g.LevelUp();
    }
    protected void addMoney(Geraldo g) {
        g.earnMoney(reward);
    }
    protected void check_requisites() throws MissedPreException {}

    public String getInfo() {
        return ( name + " ("+reward+") " );
    }

    public void completeQuest(Geraldo g) throws MissedPreException, LowlvlException {
        if( ! is_solvable(g)) {
            throw new LowlvlException();
        }
        this.check_requisites();

        addLevel(g);
        addMoney(g);
        this.risolta = true;
    }
}
