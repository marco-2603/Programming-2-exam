package model.quests.mainQ;

import model.enums.Places;
import model.exceptions.MissedPreException;
import model.quests.AbstractQuest;
import model.quests.QuestInterface;

public class MainQuest extends AbstractMainQuests {

    public MainQuest(String name, int level, AbstractQuest prevQuest, Places location) {
        super( prevQuest, level,  location, name);
    }


    @Override
    protected void check_requisites() throws MissedPreException {
        if(prevQuest==null){
            return;
        }
        if( ! prevQuest.is_risolta()){
            throw new MissedPreException();
        }
    }

    @Override
    public String getInfo() {
        if(prevQuest == null){
            return (super.getInfo() + "\nREQ: null");
        }else{
            return (super.getInfo() + "\nREQ: " + prevQuest.getName() +"\nLuogo: " + location.toString());
        }

    }

}
