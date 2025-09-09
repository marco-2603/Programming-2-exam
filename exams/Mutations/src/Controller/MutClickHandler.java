package Controller;

import Model.Gerald.Geraldo;
import Model.Mutations.Abstracts.AbstractMutation;
import View.MainView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


public class MutClickHandler implements EventHandler<MouseEvent> {
    AbstractMutation m;
    Geraldo g;
    MainView mv;

    public MutClickHandler(AbstractMutation m, Geraldo g, MainView mv) {
        this.m = m;
        this.g = g;
        this.mv = mv;
    }

    public void handle(MouseEvent event) {
        m.clicked(g);
        mv.refresh();
    }
}
