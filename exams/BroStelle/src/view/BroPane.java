package view;

import control.BrosController;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import model.bros.Bro;

public class BroPane extends StackPane {

    private Bro b;

    public BroPane(Bro b, BrosController bc) {
        Rectangle r = new Rectangle(70,70);
        r.setFill(b.getColor());
        Text t = new Text(b.getName());
        this.getChildren().addAll(r, t);

        this.setEventHandler(MouseEvent.MOUSE_CLICKED, bc);
    }

    public Bro getBro() {
        return b;
    }

}
