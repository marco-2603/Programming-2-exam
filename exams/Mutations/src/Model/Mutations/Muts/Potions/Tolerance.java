package Model.Mutations.Muts.Potions;

import Model.Gerald.Geraldo;
import Model.Gerald.Mutations;
import Model.Mutations.Abstracts.AbsPotionMutation;

public class Tolerance extends AbsPotionMutation {
    public Tolerance(Geraldo g) {
        super(g, Mutations.Tol);
    }

    @Override
    public void aggiungi (Geraldo g){
        g.tol +=2;
    }

    @Override
    public void togli(Geraldo g) {
        g.tol -=2;
    }
}
