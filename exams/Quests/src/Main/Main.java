package Main;


import controller.GeraldoController;
import controller.OrderController;
import controller.QuestController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Geraldo;
import model.enums.Monsters;
import model.enums.NPCs;
import model.enums.Places;
import model.quests.AbstractQuest;
import model.quests.contractQ.ContractQuest;
import model.quests.contractQ.TreasureHuntQuest;
import model.quests.mainQ.DlcQuest;
import model.quests.mainQ.MainQuest;
import model.quests.secondaryQ.SecondaryQuest;
import view.GeraldoStats;
import view.QuestListPane;

import java.util.ArrayList;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //mainquests
        MainQuest pon = new MainQuest("Pyres of Novigrad", 5, null, Places.Novigrad);
        MainQuest tnc = new MainQuest("The Nilfgaardian Connection", 3, pon, Places.Velen);
        MainQuest lag = new MainQuest("Lilac and Gooseberries", 2, tnc, Places.White_Orchard);
        //secondary quests
        SecondaryQuest affaf = new SecondaryQuest("A Favor for a Friend", 2, 10, NPCs.Keira_Metz);
        SecondaryQuest tlw = new SecondaryQuest("The Last Wish", 6, 30, NPCs.Bloody_Baron);
        //contract e contract-treasure quests
        ArrayList<Monsters> stm = new ArrayList<>();
        stm.add(Monsters.Drowners); stm.add(Monsters.Foglet);
        ContractQuest st = new ContractQuest("Swamp Thing", 12, 40, stm);
        ArrayList<Monsters> cowm = new ArrayList<>();
        cowm.add(Monsters.Drowners);
        TreasureHuntQuest cow = new TreasureHuntQuest("Coast of Wrecks", 4, 50, cowm, Places.Novigrad);
        ArrayList<Monsters> dfm = new ArrayList<>();
        dfm.add(Monsters.Wolves); dfm.add(Monsters.Drowners);
        TreasureHuntQuest df = new TreasureHuntQuest("Dirty Funds", 1, 20, dfm, Places.Velen);
        //DLC quests
        DlcQuest ew = new DlcQuest("Envoys, Wineboys", 8, Places.Velen, tnc);
        DlcQuest ctc = new DlcQuest("Capture the Castle", 9, Places.Toussaint, tnc);

        //inizzializzo il geraldo
        Geraldo geraldo = new Geraldo();

        //creo le liste per i 4 tipi
        ArrayList<AbstractQuest> q1 = new ArrayList<>();
        q1.add(lag); q1.add(tnc); q1.add(pon);
        ArrayList<AbstractQuest> q2 = new ArrayList<>();
        q2.add(affaf); q2.add(tlw);
        ArrayList<AbstractQuest> q3 = new ArrayList<>();
        q3.add(st); q3.add(cow); q3.add(df);
        ArrayList<AbstractQuest> q4 = new ArrayList<>();
        q4.add(ew); q4.add(ctc);
        //fine model

        GeraldoController gc = new GeraldoController(geraldo);

        OrderController a1 = new OrderController(q1, gc);
        OrderController a2 = new OrderController(q2, gc);
        OrderController a3 = new OrderController(q3, gc);
        OrderController a4 = new OrderController(q4, gc);
        //fine controller

        //stampa le stats
        GeraldoStats gs = gc.getGS();

        //creo i 4 pane delel quest dandogli gli array di quest
        QuestListPane qp1 = a1.getQLP();
        QuestListPane qp2 = a2.getQLP();
        QuestListPane qp3 = a3.getQLP();
        QuestListPane qp4 = a4.getQLP();

        HBox hb = new HBox();
        hb.getChildren().addAll(qp1, qp2, qp3, qp4);
        hb.setSpacing(10);

        //impagino
        VBox vb = new VBox();
        vb.getChildren().add(gs);
        vb.getChildren().add(hb);
        vb.setSpacing(10);


        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(vb));
        primaryStage.show();
    }
}
