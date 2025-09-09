package View;

import Model.Gerald.Geraldo;
import Model.Gerald.Spell;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Left extends VBox {
    protected Left (Geraldo g){
        this.getChildren().removeAll(this.getChildren());
        this.getChildren().add(new Text("Lvl: "+g.lvl));
        this.getChildren().add(new Text("Str: "+g.str));
        this.getChildren().add(new Text("Vel: "+g.vel));
        this.getChildren().add(new Text(""));
        this.getChildren().add(new Text("Tol: "+g.tol));
        this.getChildren().add(new Text(""));
        this.getChildren().add(new Text("Spells: "));
        for(Spell s:g.spelllist){
            this.getChildren().add(new Text(s.name()));
        }
        this.setTranslateX(10);
        this.setTranslateY(10);
    }
}
