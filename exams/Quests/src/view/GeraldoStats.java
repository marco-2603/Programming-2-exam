package view;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import model.Geraldo;

public class GeraldoStats extends StackPane {
    private Text txt;

    public GeraldoStats(Geraldo g) {
        txt = new Text("Geraldo. LV:" +g.getLevel()+" GP:"+g.getMoney() );
        this.getChildren().add(txt);
        this.setAlignment(Pos.CENTER_LEFT);

    }

    public void redraw(Geraldo g) {
        txt.setText("Geraldo. LV:" +g.getLevel()+" GP:"+g.getMoney() );
    }
}
