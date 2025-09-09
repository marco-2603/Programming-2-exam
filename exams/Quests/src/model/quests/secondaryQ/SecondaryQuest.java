package model.quests.secondaryQ;

import model.Geraldo;
import model.enums.NPCs;
import model.exceptions.MissedPreException;
import model.quests.AbstractQuest;
import model.quests.QuestInterface;
import model.quests.contractQ.AbstracContractQuest;

public class SecondaryQuest extends AbstractQuest {

    NPCs npcs;

    public SecondaryQuest(String name, int level, int reward, NPCs npcs) {
        super(name, level, reward);
        this.npcs = npcs;
    }


    @Override
    protected void addLevel(Geraldo g) {
        g.LevelUp();
        g.LevelUp();
    }

    @Override
    public String getInfo() {
        return (super.getInfo() + "\nNPC: " + npcs.toString());
    }

}
