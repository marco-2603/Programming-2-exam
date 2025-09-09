package View;

import Model.Comparators.OrdinaAnno;
import Model.Comparators.OrdinaNome;
import Model.Comparators.OrdinaTipo;
import Model.Enums.Colors;
import Model.Titoli.TitleInterface;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class MainView extends BorderPane {
    ArrayList<TitleInterface> titoli;

    public MainView(ArrayList<TitleInterface> titoli) {
        this.titoli = titoli;
        inizializzaTop();

        //creo i button per l'ordinamento ma non funzionano
        VBox orders = new VBox(10);
        Text textArea = new Text("Ordina per: ");
        Button orderN = new Button("Nome");
        orderN.setOnAction(e -> {
            titoli.sort(new OrdinaNome());
        });
        Button orderA = new Button("Anno");
        orderA.setOnAction(e -> {
            titoli.sort(new OrdinaAnno());
        });
        Button orderT = new Button("Tipo");
        orderT.setOnAction(e -> {
            titoli.sort(new OrdinaTipo());
        });
        orders.getChildren().addAll(textArea, orderN, orderA, orderT);
        this.setRight(orders);

        //creo il button che resetta tutto ma non so come farlo funzionare(?)
        Button clear = new Button("Clear");
        this.setLeft(clear);
    }

    //creo i button che scorrono la lista di titoli e non so come far funzionare neanche questi lol
    public void inizializzaTop(){
        BorderPane topContainer = new BorderPane();
        Button sx = new Button("<");
        topContainer.setLeft(sx);

        Button dx = new Button(">");
        topContainer.setRight(dx);

        //creo la lista di titoli
        HBox top = new HBox();
        top.setPadding(new Insets(10));
        top.setAlignment(Pos.CENTER);

        for (int i = 0; i < 3 && i < titoli.size(); i++) {
            TitleInterface titolo = titoli.get(i);
                Rectangle r = new Rectangle(130, 40);
                if (titolo.getColore() == Colors.cyan) {
                    r.setFill(Color.CYAN);
                } else if (titolo.getColore() == Colors.salmon) {
                    r.setFill(Color.SALMON);
                } else if (titolo.getColore() == Colors.magenta) {
                    r.setFill(Color.MAGENTA);
                } else {
                    r.setFill(null);
                }
                Label l = new Label(titolo.getNome() + " " + "(" +titolo.getAnno()+")");//il testo chiedeva le ultime due cifre dell'anno ma non avendo la più pallida idea di come si faccesse ho messo l'anno intero
                StackPane stackPane = new StackPane(r, l);
                top.getChildren().add(stackPane);
                topContainer.setCenter(top);
            this.setTop(topContainer);
        }
    }
}
//1) il testo dice che quando clicchi su un titolo ti appaiono tutte le info, ma quindi il titolo deve essere un button?
//2) "Nel caso delle serie, viene altresì riportata una sequenza di pulsanti, uno per stagione, la cui pressione
//seleziona la serie corrispondente per l’acquisto e disabilita il bottone stesso." come si fa?