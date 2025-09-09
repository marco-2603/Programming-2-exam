package View;

import Controller.MutClickHandler;
import Model.Gerald.Geraldo;
import Model.Mutations.Abstracts.AbstractMutation;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class Bottom extends VBox {
    protected Bottom (Geraldo g, MainView mv, ArrayList<AbstractMutation> mutList){
        this.getChildren().removeAll(this.getChildren());
        this.getChildren().add(new Text("Mutazioni possibili: "));
        HBox muts = new HBox();
        for (AbstractMutation m : mutList) {
            //creo lo stackpane
            StackPane sp = new StackPane();
            //creo il rettangolo sotto
            Rectangle r = new Rectangle(50,50);
            r.setStroke(Color.BLACK);
            r.setFill(mv.getColor(m.getMut()));
            //creo il testo
            String prefix = "+";
            if(m.isOn()){
                prefix = "-";
            }
            String text = prefix + " " + m.getMut().name();
            Text t = new Text(text);
            //refresho e metto tutto
            sp.getChildren().removeAll(sp.getChildren());
            sp.getChildren().add(r);
            sp.getChildren().add(t);
            //creo l'handler
            MutClickHandler mh = new MutClickHandler(m,g,mv);
            //faccio il m.addEventHandler
            sp.addEventHandler(MouseEvent.MOUSE_CLICKED, mh);
            muts.getChildren().add(sp);
        }
        this.getChildren().add(muts);
        //sposto un po
        this.setTranslateX(10);
        this.setTranslateY(-10);
    }
}
