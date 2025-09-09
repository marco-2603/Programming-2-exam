package model.mutations.muts.spells;

import model.exceptions.SpellException;
import model.functions.AddIgni;
import model.functions.MyConsumer;
import model.functions.RemIgni;
import model.geralt.Geralt;
import model.geralt.Mutation;
import model.geralt.Spell;
import model.mutations.abstracts.SpellMutation;

public class IgniSpellMutation extends SpellMutation {

    public IgniSpellMutation(Spell s, Geralt g) throws SpellException {
        super(s,g, Mutation.Igni);
        if (s != Spell.Igni){
            throw new SpellException();
        }
    }

    @Override
    public MyConsumer<Geralt> applica(Geralt g){
        return new AddIgni();
    }

    @Override
    public MyConsumer<Geralt> rimuovi(Geralt g){
        return new RemIgni();
    }
}
