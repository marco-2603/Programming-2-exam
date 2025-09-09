package controller;

import model.comparator.NameComparator;
import model.comparator.PrizeComparator;
import model.quests.AbstractQuest;
import view.QuestListPane;

import java.util.ArrayList;

public class OrderController {

    private QuestListPane qlp;
    private ArrayList<AbstractQuest> quests;

    public OrderController(ArrayList<AbstractQuest> quests, GeraldoController gc) {
        this.quests = quests;
        //creo il Pane della lista di quest e lo inizializzo
        this.qlp = new QuestListPane(gc, this);
        qlp.refresh(quests);
    }

    public QuestListPane getQLP() {
        return qlp;
    }

    public void sortByName() {
        quests.sort(new NameComparator());
        qlp.clear();
        qlp.refresh(quests);
    }

    public void sortByReward() {
        quests.sort(new PrizeComparator());
        qlp.clear();
        qlp.refresh(quests);
    }

}
