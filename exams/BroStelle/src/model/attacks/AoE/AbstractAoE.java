package model.attacks.AoE;

import model.attacks.AbstractAttack;
import model.enums.Portata;
import model.enums.Traj;

public abstract class AbstractAoE extends AbstractAttack {

    public AbstractAoE(String name, Traj traiettoria) {
        super(name, Portata.media, traiettoria);
    }
}
