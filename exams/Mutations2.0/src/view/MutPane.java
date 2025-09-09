package view;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import model.mutations.abstracts.AbstractMutation;
import model.mutations.abstracts.CombatMutation;
import model.mutations.abstracts.PotionMutation;
import model.mutations.abstracts.SpellMutation;
import model.mutations.muts.EmptyMutation;

public class MutPane extends StackPane {

    public static final int DIM = 50;

    private AbstractMutation m;

    private Rectangle r;
    private Text t;

    public MutPane(AbstractMutation m){
        this.m = m;
        refresh();
    }

    public void refresh(){
        r = new Rectangle(DIM, DIM);
        r.setStroke(Color.BLACK);
        r.setFill(MutPane.getColorOfMutation(this.m));

        String prefix = "+";
        if (m.isIsequipped()){
            prefix = "-";
        }
        String text = prefix+" "+this.m.getMutation().name();
        t = new Text(text);

        this.getChildren().removeAll(this.getChildren());
        this.getChildren().add(r);
        this.getChildren().add(t);
    }

    public static Color getColorOfMutation(AbstractMutation m){
        if (m instanceof EmptyMutation){
            return Color.GRAY;
        }
        if (m instanceof CombatMutation){
            return Color.CRIMSON;
        }
        if (m instanceof SpellMutation){
            return Color.CADETBLUE;
        }
        if (m instanceof PotionMutation){
            return Color.GREENYELLOW;
        }
        return Color.BLACK;
//        switch (m.getMutation()){
//            case Empty -> {
//                return Color.GRAY;
//            }
//            case Str, Vel ->{
//                return Color.CRIMSON;
//            }
//            case Tol -> {
//                return Color.GREENYELLOW;
//            }
//            case Igni, Quen -> {
//                return Color.AZURE;
//            }
//        }
    }
}
