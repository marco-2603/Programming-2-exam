package model.mutations.abstracts;

import model.geralt.Geralt;
import model.geralt.Mutation;
import model.geralt.Spell;

public abstract class SpellMutation extends AbstractMutation{
    Spell s;

    protected SpellMutation(Spell s, Geralt g, Mutation m){
        super(g,m);
        this.s=s;
    }

}
