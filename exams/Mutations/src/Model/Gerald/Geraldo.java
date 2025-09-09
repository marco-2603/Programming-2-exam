package Model.Gerald;

import Model.Exeptions.AddException;
import Model.Mutations.Abstracts.AbsCombatMutation;
import Model.Mutations.Abstracts.AbsPotionMutation;
import Model.Mutations.Abstracts.AbsSpellMutation;
import Model.Mutations.Abstracts.AbstractMutation;
import Model.Mutations.Muts.EmptyMutations;

import java.util.ArrayList;

public class Geraldo {
    public int lvl = 0;
    public int str = 10;
    public int vel = 10;
    public int tol = 2;

    public ArrayList<Spell> spelllist = new ArrayList<Spell>();

    //possibili contenitori delle mutazioni
    private AbstractMutation cm = new EmptyMutations() {};
    private AbstractMutation sm = new EmptyMutations() {};
    private AbstractMutation pm = new EmptyMutations() {};
    private AbstractMutation gm = new EmptyMutations() {};

    //costruttore
    public Geraldo() {}

    //applica modificatore
    public void applyModifier(AbstractMutation m) {
        if (m.isOn()){
            m.togli(this);
        }else{
            m.aggiungi(this);
        }
    }

    //tostring (stampa le stats, nel terminale, non nella giu)


    public void addCombatMut(AbsCombatMutation m){
        if(cm.isEmpty()){
            cm = m;
        }else if(gm.isEmpty()){
            gm = m;
        }else{
            throw new AddException();
        }
    }

    public void addSpellMut(AbsSpellMutation m){
        if(sm.isEmpty()){
            sm = m;
        }else if(gm.isEmpty()){
            gm = m;
        }else{
            throw new AddException();
        }
    }

    public void addPotionMut(AbsPotionMutation m){
        if(pm.isEmpty()){
            pm = m;
        }else if(gm.isEmpty()){
            gm = m;
        }else{
            throw new AddException();
        }
    }

    public void toggleMut(AbstractMutation m){
        if(cm == m){
            cm = new EmptyMutations() {};
        }else if(sm == m){
            sm = new EmptyMutations() {};
        }else if(pm == m){
            pm = new EmptyMutations() {};
        }else if(gm == m){
            gm = new EmptyMutations() {};
        }else{
            System.out.println("ERRORE TOGGLE MUT");
        }
    }


    public AbstractMutation getCM (){
        return cm;
    }
    public AbstractMutation getSM (){
        return sm;
    }
    public AbstractMutation getPM (){
        return pm;
    }
    public AbstractMutation getGM (){
        return gm;
    }
}
