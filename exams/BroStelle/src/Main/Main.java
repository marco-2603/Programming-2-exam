package Main;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Enemy;
import model.attacks.*;
import model.attacks.AoE.*;
import model.bros.*;
import model.bros.longRange.Artilliery;
import model.bros.longRange.Sniper;
import view.MainView;

import java.util.ArrayList;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //inizializzo i bro
        Bro Franco = new Tank("Franco", 2, new Blast("SBAM"), 1000);
        Bro Dinamichele = new Artilliery("Dinamichele", 8, new Lobber("Bomba"), 2000);
        Bro Ape = new Sniper("Ape", 11, new Single("Bzz"), 2000);
        Bro Edoardo = new Tank("Edoardo", 1, new Single("Sciarpa"), 500);
        Bro Salice = new Sniper("Salice", 1, new Lobber("Tentacolo"), 1200);
        //li metto nella lista
        ArrayList<Bro> bros = new ArrayList<>();
        bros.add(Franco);
        bros.add(Dinamichele);
        bros.add(Ape);
        bros.add(Edoardo);
        bros.add(Salice);
        //inizializzo enemy
        Enemy mob = new Enemy();
        //fine model


        BorderPane root = new MainView(bros, mob);

        primaryStage.setTitle("Bro-stelle");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
