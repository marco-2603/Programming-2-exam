package control;

import Main.Main;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.bros.Bro;
import view.BroPane;
import view.BrosListPane;
import view.MainView;

import java.util.ArrayList;
import java.util.Comparator;

public class BrosController implements EventHandler<MouseEvent> {
    private MainView mainView;
    private EnemyController ec;
    private Bro b;

    public BrosController(Bro b, MainView mainView, EnemyController ec) {
        this.mainView = mainView;
        this.ec = ec;
        this.b = b;
    }

    @Override
    public void handle(MouseEvent event){
        mainView.setMap(b,ec);
    }


}
