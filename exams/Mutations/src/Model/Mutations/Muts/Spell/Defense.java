package Model.Mutations.Muts.Spell;

import Model.Gerald.Geraldo;
import Model.Gerald.Mutations;
import Model.Gerald.Spell;
import Model.Mutations.Abstracts.AbsSpellMutation;

public class Defense extends AbsSpellMutation {
    public Defense(Geraldo g) {
        super(g, Mutations.Def);
    }

    @Override
    public void aggiungi (Geraldo g){
        g.spelllist.add(Spell.Quen);
    }

    @Override
    public void togli(Geraldo g) {
        g.spelllist.remove(Spell.Quen);
    }
}
