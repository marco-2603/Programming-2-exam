package Model.Mutations.Muts.Combat;

import Model.Gerald.Geraldo;
import Model.Gerald.Mutations;
import Model.Mutations.Abstracts.AbsCombatMutation;

public class Speed extends AbsCombatMutation {
    public Speed(Geraldo g) {
        super(g, Mutations.Spd);
    }

    @Override
    public void aggiungi (Geraldo g){
        g.vel +=2;
    }

    @Override
    public void togli(Geraldo g) {
        g.vel -=2;
    }
}
