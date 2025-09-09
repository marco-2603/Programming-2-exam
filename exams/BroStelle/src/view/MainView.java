package view;

import control.BrosController;
import control.EnemyController;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import model.Enemy;
import model.Exceptions.MaxlvlException;
import model.bros.Bro;
import model.comparator.LifeComparator;
import model.comparator.NameComparator;
import model.enums.Portata;

import java.util.ArrayList;

public class MainView extends BorderPane {
    private ArrayList<Bro> bros;
    private Enemy mob;
    private Rectangle background;


    public MainView (ArrayList<Bro> bros, Enemy mob){
        this.bros = bros;
        this.mob = mob;


        background = new Rectangle(300,300);
        background.setFill(Color.BLACK);
        StackPane mp = new StackPane();
        mp.getChildren().add(background);
        this.setCenter(mp);


        EnemyController enemyController = new EnemyController(mob);
        EnemyPane ep = enemyController.getEnemyPane();
        this.setBottom(ep);


        this.refreshTop(enemyController);

        //bottoni order
        VBox orderButtons = new VBox();
        Button vitaB = new Button("Ordina per Vita");
        vitaB.setOnAction(e -> {
            LifeComparator lifeComparator = new LifeComparator();
            this.bros.sort(lifeComparator);
            refreshTop(enemyController);
        });

        Button nomeB= new Button("Ordina per Nome");
        nomeB.setOnAction(e -> {
            NameComparator nameComparator = new NameComparator();
            this.bros.sort(nameComparator);
            refreshTop(enemyController);
        });

        orderButtons.getChildren().addAll(vitaB,nomeB);
        orderButtons.setSpacing(20);
        this.setLeft(orderButtons);

    }

    public void setMap(Bro b, EnemyController ec){
        //creo il pane della mappa
        StackPane mp = new StackPane();

        //creo l'area verde
        Circle area = new Circle(this.getArea(b.getAttacco().getPortata()));
        area.setFill(Color.GREEN);
        mp.setOnMouseClicked(event -> {
            //qua è il controller che decide come fare
            ec.getHit(b);
        });

        //creo i dati del bro
        Rectangle myBro = new Rectangle(130, 90);
        myBro.setFill(b.getColor());
        Text stats = new Text(b.getName() + " " + b.getLevel() + "\n" + b.getHealth() + " " + b.getAttacco().getPortata() + "\n" + b.getAttacco().getName() + ", " + b.getDamage() + " dmg");
        StackPane broStats = new StackPane();
        broStats.getChildren().addAll(myBro,stats);

        //bottone per lvlup
        HBox brawler = new HBox();
        Button addLVL = new Button("+");
        addLVL.setOnAction(e -> {
            try {
                b.levelup();
                setMap(b, ec);
            }catch(MaxlvlException err){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Max level limit reached");
                alert.showAndWait();
            }

        });
        brawler.getChildren().addAll(broStats, addLVL);
        //aggiungo tutto e impagino
        mp.getChildren().addAll(background,area,brawler);
        this.setCenter(mp);
    }

    protected int getArea(Portata area) {
        if(area == Portata.m_lunga){
            return 150;
        }else if(area == Portata.media){
            return 100;
        }else System.out.println("huh?");
        return 500;
    }

    public void refreshTop (EnemyController ec){

        HBox top = new HBox();
        top.setSpacing(10);

        for(int i = 0; i < bros.size(); i++){
            BrosController bc = new BrosController(bros.get(i),this, ec);
            BroPane bp = new BroPane(bros.get(i), bc);
            top.getChildren().add(bp);
        }

        this.setTop(top);
    }
}
