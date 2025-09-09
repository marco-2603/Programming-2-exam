package view;

import controller.GeraldoController;
import controller.OrderController;
import controller.QuestController;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import model.Geraldo;
import model.quests.AbstractQuest;

import java.util.ArrayList;

public class QuestListPane extends VBox {

    private VBox vb;
    private Button ordername;
    private Button orderreward;
    private GeraldoController gc;

    public QuestListPane(GeraldoController gc, OrderController oc) {
        this.gc = gc;
        vb = new VBox();
        //creo i bottoni
        ordername = new Button("Ordina per Nome");
        ordername.setOnAction(e -> {
            oc.sortByName();
        });

        orderreward = new Button("Ordina per Ricompensa");
        orderreward.setOnAction(e -> {
            oc.sortByReward();
        });

        //Non mi serve creare la vb nel costruttore perchè

        this.getChildren().addAll(vb,ordername,orderreward);
        this.setSpacing(10);
    }

    public void clear(){
        this.getChildren().clear();
        vb = new VBox();
        this.getChildren().add(vb);
        this.getChildren().add(ordername);
        this.getChildren().add(orderreward);
    }

    public void refresh(ArrayList<AbstractQuest> quests){
        for(int i=0; i<quests.size(); i++){ // per ogni quest della lista creo un nuovo questcontroller e aggiungo il questPane alla vbox
            AbstractQuest quest = quests.get(i);
            QuestController qc = new QuestController(quest, gc );
            this.vb.getChildren().add(qc.getQuestPane());
        }
    }
}
