package View;

import Model.Gerald.Geraldo;
import Model.Gerald.Mutations;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Right extends VBox {
    protected Right (Geraldo g, MainView mv){
        this.getChildren().removeAll(this.getChildren());
        this.getChildren().add(new Text("Mutations: "));
        Text cm = (new Text(g.getCM().getMut().name())); //colora?
        cm.setFill(mv.getColor(Mutations.Str));
        this.getChildren().add(cm);
        Text sm = (new Text(g.getSM().getMut().name()));
        sm.setFill(mv.getColor(Mutations.Fire));
        this.getChildren().add(sm);
        Text pm = (new Text(g.getPM().getMut().name()));
        pm.setFill(mv.getColor(Mutations.Tol));
        this.getChildren().add(pm);
        Text gm = (new Text(g.getGM().getMut().name()));
        gm.setFill(mv.getColor(g.getGM().getMut()));
        this.getChildren().add(gm);
        this.setTranslateX(-10);
        this.setTranslateY(10);
    }
}
