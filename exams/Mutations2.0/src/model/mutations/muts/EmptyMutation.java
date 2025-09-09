package model.mutations.muts;

import model.functions.MyConsumer;
import model.geralt.Geralt;
import model.geralt.Mutation;
import model.mutations.abstracts.AbstractMutation;

public class EmptyMutation extends AbstractMutation {

    public EmptyMutation(){
        super(null, Mutation.Empty);
    }

    public MyConsumer<Geralt> applica(Geralt g) {
        return null;
    }
    public  MyConsumer<Geralt> rimuovi(Geralt g) {
        return null;
    }

}
