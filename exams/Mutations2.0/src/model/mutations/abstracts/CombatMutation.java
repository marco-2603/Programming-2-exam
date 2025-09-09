package model.mutations.abstracts;

import model.geralt.Geralt;
import model.geralt.Mutation;

public abstract class CombatMutation extends AbstractMutation{

    protected CombatMutation(Geralt g, Mutation m){
        super(g,m);
    }

}
