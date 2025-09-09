package model.comparator;

import model.quests.AbstractQuest;

import java.util.Comparator;

public class PrizeComparator implements Comparator<AbstractQuest> {
    @Override
    public int compare(AbstractQuest q1, AbstractQuest q2) {
        if( q1.getReward() == q2.getReward() ){
            return new NameComparator().compare(q1,q2);
        }else if( q1.getReward() < q2.getReward() ){
            return 1;
        }else{
            return -1;
        }
    }
}
