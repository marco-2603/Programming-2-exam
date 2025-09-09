package Model.Mutations.Abstracts;

import Model.Exeptions.AddException;
import Model.Gerald.Geraldo;
import Model.Gerald.Mutations;
import Model.Mutations.MutationInterface;

public abstract class AbstractMutation implements MutationInterface {
    protected Mutations mut;
    protected Geraldo g;
    protected boolean isOn = false;

    protected AbstractMutation(Geraldo g, Mutations mut) {
        this.g = g;
        this.mut = mut;
    }

    public void clicked(Geraldo g) {
        if(isOn){
            g.toggleMut(this);
            g.applyModifier(this);
            isOn = !isOn;
        }else {
            try {
                if (this instanceof AbsCombatMutation) {
                    g.addCombatMut((AbsCombatMutation) this);
                } else if (this instanceof AbsSpellMutation) {
                    g.addSpellMut((AbsSpellMutation) this);
                }else if(this instanceof AbsPotionMutation){
                    g.addPotionMut((AbsPotionMutation) this);
                }
            }catch (AddException e){
                throw new RuntimeException();
            }
            g.applyModifier(this);
            isOn = !isOn;
        }
    }

    public boolean isEmpty() {
        return !isOn;
    }
    public boolean isOn() {
        return isOn;
    }
    public Mutations getMut() {
        return this.mut;
    }


    //non mi serve un .equals perchè non devo comparare nulla
}
