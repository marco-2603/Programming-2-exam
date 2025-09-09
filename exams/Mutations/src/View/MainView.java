package View;

import Model.Gerald.Geraldo;
import Model.Gerald.Mutations;
import Model.Mutations.Abstracts.AbstractMutation;
import Model.Mutations.Muts.Combat.Speed;
import Model.Mutations.Muts.Combat.Strenght;
import Model.Mutations.Muts.Potions.Tolerance;
import Model.Mutations.Muts.Spell.Defense;
import Model.Mutations.Muts.Spell.Fire;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class MainView extends BorderPane {
    private Geraldo g;

    protected VBox stats;
    protected VBox slots;
    protected VBox mutations;

    protected ArrayList<AbstractMutation> mutList;


    public MainView(Geraldo g) {
        this.g = g;
        mutList = new ArrayList<>();
        mutList.add(new Strenght(g));
        mutList.add(new Speed(g));
        mutList.add(new Tolerance(g));
        mutList.add(new Fire(g));
        mutList.add(new Defense(g));
        setup();
    }

    protected Color getColor(Mutations m){
        if (m == Mutations.Empty){
            return Color.GREY;
        }else if(m.isCombat()){
            return Color.RED;
        }else if(m.isSpell()){
            return Color.CADETBLUE;
        }else if(m.isPotion()){
            return Color.GREENYELLOW;
        }else{
            return Color.BLACK;
        }
    }

    private void setup(){
        stats = new Left(g);
        slots = new Right(g, this);
        mutations = new Bottom(g, this, mutList);

        this.setCenter(stats);
        this.setRight(slots);
        this.setBottom(mutations);
    }

    public void refresh(){
        setup();
    }
}
