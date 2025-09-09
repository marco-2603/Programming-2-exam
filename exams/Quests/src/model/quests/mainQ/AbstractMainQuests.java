package model.quests.mainQ;

import model.enums.Places;
import model.quests.AbstractQuest;

public abstract class AbstractMainQuests extends AbstractQuest {
    AbstractQuest prevQuest;
    Places location;

    public AbstractMainQuests(AbstractQuest prevQuest,int level, Places location,String name) {
        super(name, level, 10);
        this.prevQuest = prevQuest;
        this.location=location;
    }

}
