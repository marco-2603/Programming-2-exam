package model.quests.contractQ;

import model.Geraldo;
import model.enums.Monsters;
import model.enums.Places;
import model.exceptions.MissedPreException;
import model.quests.QuestInterface;

import java.util.ArrayList;

public class ContractQuest extends AbstracContractQuest {

    public ContractQuest(String name, int level, int reward, ArrayList<Monsters> mostri ) {
        super(name, level, reward, mostri);
    }

}
