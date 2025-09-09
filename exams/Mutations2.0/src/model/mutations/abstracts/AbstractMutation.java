package model.mutations.abstracts;

import model.exceptions.AggiuntaException;
import model.geralt.Geralt;
import model.geralt.Mutation;
import model.mutations.MutationInterface;

public abstract class AbstractMutation implements MutationInterface {

    protected Geralt g;
    private Mutation m;
    private boolean isequipped = false;

    public AbstractMutation(Geralt g, Mutation m){
        super();
        this.g=g;
        this.m=m;
    }

    public void clicked(Geralt g){
        System.out.println(g);
        if (this.isequipped) {
            g.removeMutation(this);
            g.applyModifier(this.rimuovi(g));
        } else {
            try {
                if (this instanceof CombatMutation) {
                    g.addCombatMutation((CombatMutation) this);
                } else if (this instanceof SpellMutation) {
                    g.addSpellMutation((SpellMutation) this);
                } else if (this instanceof PotionMutation) {
                    g.addPotionMutation((PotionMutation) this);
                }
            } catch (AggiuntaException e) {
                throw new RuntimeException();
            }
            g.applyModifier(this.applica(g));
        }
        this.isequipped = !this.isequipped;
        System.out.println(g);
    }

    public boolean isEmpty(){
        return this.m == Mutation.Empty;
    }

    public boolean isIsequipped(){
        return this.isequipped;
    }

    public Mutation getMutation(){
        return m;
    }
}
