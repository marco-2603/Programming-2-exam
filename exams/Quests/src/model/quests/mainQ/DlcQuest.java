package model.quests.mainQ;

import model.enums.Places;
import model.exceptions.MissedPreException;
import model.quests.AbstractQuest;

public class DlcQuest extends AbstractMainQuests {

    public DlcQuest(String name, int level, Places location, AbstractQuest nextQuest) {
        super( nextQuest, level,  location, name);
    }

    @Override
    protected void check_requisites() throws MissedPreException {
        if( ! prevQuest.is_risolta()){
            throw new MissedPreException();
        }
    }

    @Override
    public String getInfo() {
            return (super.getInfo() + "\nREQ: " + prevQuest.getName());
    }
}
