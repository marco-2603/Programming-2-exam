package model.quests.contractQ;

import model.Geraldo;
import model.enums.Monsters;
import model.exceptions.LowlvlException;
import model.exceptions.MissedPreException;
import model.quests.AbstractQuest;
import model.quests.QuestInterface;

import java.util.ArrayList;

public abstract class AbstracContractQuest extends AbstractQuest {
    ArrayList<Monsters> mostri = new ArrayList<>();

    public AbstracContractQuest(String name, int level, int reward, ArrayList<Monsters> mostri) {
        super(name, level, reward);
        this.mostri = mostri;
    }

    @Override
    protected void addMoney(Geraldo g) {
        g.earnMoney((int)(reward*1.2));
    }

    @Override
    public String getInfo() {
        return (super.getInfo() + "\nMostri: [" + mostri.toString()+"]" );
    }

}
