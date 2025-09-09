package Model.Mutations.Muts.Combat;

import Model.Gerald.Geraldo;
import Model.Gerald.Mutations;
import Model.Mutations.Abstracts.AbsCombatMutation;

public class Strenght extends AbsCombatMutation {

    public Strenght(Geraldo g) {
        super(g,Mutations.Str);
    }

    @Override
    public void aggiungi (Geraldo g){
        g.str +=2;
    }

    @Override
    public void togli(Geraldo g) {
        g.str -=2;
    }

    //qua devo fare un metodo applica che mi aggiunge uno agli slot combatmut
}
