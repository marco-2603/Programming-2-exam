package model.quests;

import model.Geraldo;
import model.exceptions.LowlvlException;
import model.exceptions.MissedPreException;

public interface QuestInterface {

    void completeQuest(Geraldo g) throws MissedPreException, LowlvlException;

    boolean is_solvable(Geraldo g);
    boolean is_risolta();

}
