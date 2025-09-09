package model.attacks;

import model.enums.Portata;
import model.enums.Traj;

public class Single extends AbstractAttack{

    public Single(String name) {
        super(name, Portata.m_lunga, Traj.terreno);
    }
}
