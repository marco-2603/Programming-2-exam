package model.attacks.AoE;

import model.enums.Traj;

public class Lobber extends AbstractAoE{

    public Lobber(String name) {
        super(name, Traj.terreno);
    }
}
