package model.comparator;

import model.quests.AbstractQuest;

import java.util.Comparator;

public class NameComparator implements Comparator<AbstractQuest> {
    @Override
    public int compare(AbstractQuest q1, AbstractQuest q2) {
        return q1.getName().compareTo(q2.getName());
    }
}
