package model.quests.contractQ;

import model.enums.Monsters;
import model.enums.Places;
import model.exceptions.MissedPreException;
import model.quests.QuestInterface;

import java.util.ArrayList;

public class TreasureHuntQuest extends AbstracContractQuest {
    Places location;

    public TreasureHuntQuest(String name, int level, int reward, ArrayList<Monsters> mostri, Places location ) {
        super(name, level, reward, mostri);
        this.location = location;
    }

    @Override
    public String getInfo() {
        return (super.getInfo() + "\nLocation: " + location.toString());
    }

}
