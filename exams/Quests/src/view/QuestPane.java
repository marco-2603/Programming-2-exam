package view;

import controller.GeraldoController;
import controller.QuestController;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import model.Geraldo;
import model.quests.AbstractQuest;

public class QuestPane extends VBox {
    private StackPane sp;
    private Rectangle r;
    private Text testo;
    private Button completa;
    private QuestController qc;
    private GeraldoController gc;

    public QuestPane(AbstractQuest q, QuestController qc, GeraldoController gc) {
        sp = new StackPane();
        this.qc = qc;
        this.gc = gc;

        r = new Rectangle(240,60);


        testo =  new Text(q.getInfo());

        sp.getChildren().addAll(r, testo);

        completa = new Button("Completa");
        completa.setOnAction(e -> {
            qc.solveQuest();
        } );

        getChildren().addAll(sp, completa);
        redraw(q);
        this.setSpacing(10);
    }

    public void redraw(AbstractQuest q){
        if(q.is_risolta()) {
            completa.setDisable(true);
            r.setFill(Color.LIGHTGREEN);
        }else{
            r.setFill(Color.LIGHTPINK);
        }
    }


}
