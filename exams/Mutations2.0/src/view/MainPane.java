package view;

import controller.MutationClickHandler;
import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.exceptions.SpellException;
import model.geralt.Geralt;
import model.geralt.Spell;
import model.mutations.abstracts.*;
import model.mutations.muts.combat.*;
import model.mutations.muts.potions.TolPotionMutation;
import model.mutations.muts.spells.*;

import java.util.ArrayList;

public class MainPane extends BorderPane {

    private Geralt g;
    private ArrayList<AbstractMutation> globalmutations;

    private VBox cb, rb;

    public MainPane(Geralt g){
        this.g = g;
        globalmutations = new ArrayList<>();
        globalmutations.add(new StrCombatMutation(g));
        globalmutations.add(new VelCombatMutation(g));
        globalmutations.add(new TolPotionMutation(g));
        try {
            globalmutations.add(new IgniSpellMutation(Spell.Igni, g));
        } catch (SpellException e) {
            throw new RuntimeException(e);
        }
        try {
            globalmutations.add(new QuenSpellMutation(Spell.Quen, g));
        } catch (SpellException e) {
            throw new RuntimeException(e);
        }

        this.setPadding(new Insets(10));
        // top

        // center
        cb = new VBox();
        refreshCenter();
        this.setCenter(cb);

        // left

        // right
        rb = new VBox();
        refreshRight();
        this.setRight(rb);

        // bottom
        VBox bb = new VBox();
        bb.getChildren().add(new Text("Mutazioni Possibili"));
        HBox bbmp = new HBox();
        for (AbstractMutation a: globalmutations ) {
            MutPane mp = new MutPane(a);
            MutationClickHandler mch = new MutationClickHandler(g,a,this,mp);
            mp.addEventHandler(MouseEvent.MOUSE_CLICKED,mch);
            bbmp.getChildren().add(mp);
        }
        bb.getChildren().add(bbmp);

        this.setBottom(bb);
    }

    // stats + spells
    private void refreshCenter() {
        cb.getChildren().removeAll(cb.getChildren());
        cb.getChildren().add(new Text("Lvl: "+g.level));
        cb.getChildren().add(new Text("Str: "+g.str));
        cb.getChildren().add(new Text("Vel: "+g.vel));
        cb.getChildren().add(new Text(""));
        cb.getChildren().add(new Text("Tol: "+g.tol));
        cb.getChildren().add(new Text(""));
        cb.getChildren().add(new Text("Spells:"));
        for (Spell s : g.spellist) {
            cb.getChildren().add(new Text(s.name()));
        }
    }
    // mutations
    private void refreshRight() {
        rb.getChildren().removeAll(rb.getChildren());
        rb.getChildren().add(new Text("Mutations:"));

        Text ct = new Text(g.getCm().getMutation().name());
        ct.setFill(MutPane.getColorOfMutation(new StrCombatMutation(null)));
        rb.getChildren().add(ct);
        Text st = new Text(g.getSm().getMutation().name());
        try {
            st.setFill(MutPane.getColorOfMutation(new IgniSpellMutation(Spell.Igni,null)));
        } catch (SpellException e) {
            throw new RuntimeException(e);
        }
        rb.getChildren().add(st);
        Text pt = new Text(g.getPm().getMutation().name());
        pt.setFill(MutPane.getColorOfMutation(new TolPotionMutation(null)));
        rb.getChildren().add(pt);
        Text at = new Text(g.getAm().getMutation().name());
        at.setFill(MutPane.getColorOfMutation(g.getAm()));
        rb.getChildren().add(at);
    }
    public void refresh(){
        this.refreshCenter();
        this.refreshRight();
    }

}
