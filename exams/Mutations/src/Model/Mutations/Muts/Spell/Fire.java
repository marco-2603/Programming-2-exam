package Model.Mutations.Muts.Spell;

import Model.Gerald.Geraldo;
import Model.Gerald.Mutations;
import Model.Gerald.Spell;
import Model.Mutations.Abstracts.AbsSpellMutation;

public class Fire extends AbsSpellMutation {
    public Fire(Geraldo g) {
        super(g, Mutations.Fire);
    }

    @Override
    public void aggiungi (Geraldo g){
        g.spelllist.add(Spell.Igni);
    }

    @Override
    public void togli(Geraldo g) {
        g.spelllist.remove(Spell.Igni);
    }
}
