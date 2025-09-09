package controller;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import model.Geraldo;
import model.exceptions.LowlvlException;
import model.exceptions.MissedPreException;
import model.quests.AbstractQuest;
import view.GeraldoStats;
import view.QuestPane;

public class QuestController {

    private QuestPane qp;
    private GeraldoController g;
    private AbstractQuest qq;

    public QuestController(AbstractQuest q, GeraldoController g) {
        this. qq = q;
        this.g = g;
        //inizializzo la singola quest
        this.qp = new QuestPane(q, this , g);
    }

    public void solveQuest() {
        try{
            Geraldo geraldo = g.getG();
            qq.completeQuest(geraldo);
            GeraldoStats gs = g.getGS();
            gs.redraw(geraldo);
            qp.redraw(qq);

        }catch (LowlvlException e) {
            Alert a= new Alert(Alert.AlertType.ERROR);
            a.setContentText("Level too low");
            a.show();
        }catch (MissedPreException e) {
            Alert a= new Alert(Alert.AlertType.ERROR);
            a.setContentText("Previous quest not completed");
            a.show();
        }
    }

    public QuestPane getQuestPane() {
        return qp;
    }
}
