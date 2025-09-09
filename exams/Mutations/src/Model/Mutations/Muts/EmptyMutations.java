package Model.Mutations.Muts;

import Model.Gerald.Geraldo;
import Model.Gerald.Mutations;
import Model.Gerald.Spell;
import Model.Mutations.Abstracts.AbstractMutation;

public class EmptyMutations extends AbstractMutation {

    public EmptyMutations() {
        super(null , Mutations.Empty);
    }

    @Override
    public void aggiungi (Geraldo g){
    }

    @Override
    public void togli(Geraldo g) {
    }

    // qui è da mettere i metodi applica e togli
}
