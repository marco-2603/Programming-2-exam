package model.attacks.AoE;

import model.attacks.Single;
import model.enums.Traj;

public class Blast extends AbstractAoE {

    public Blast(String name) {
        super(name, Traj.aerea);
    }
}
