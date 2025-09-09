package model.mutations.muts.spells;

import model.geralt.Geralt;
import model.geralt.Mutation;
import model.geralt.Spell;
import model.exceptions.SpellException;
import model.functions.*;
import model.mutations.abstracts.SpellMutation;

public class QuenSpellMutation extends SpellMutation {

    public QuenSpellMutation(Spell s, Geralt g) throws SpellException {
        super(s,g, Mutation.Quen);
        if (s != Spell.Quen){
            throw new SpellException();
        }
    }

    @Override
    public MyConsumer<Geralt> applica(Geralt g) {
        return new AddQuen();
    }

    @Override
    public  MyConsumer<Geralt> rimuovi(Geralt g) {
        return new RemQuen();
    }
}
