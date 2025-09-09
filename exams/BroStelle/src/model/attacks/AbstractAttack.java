package model.attacks;

import model.bros.longRange.AbstractLongRange;
import model.enums.Portata;
import model.enums.Traj;

public abstract class AbstractAttack implements Attack {
    String name;
    Portata portata;
    Traj traiettoria;

    public AbstractAttack(String name, Portata portata, Traj traiettoria){
        this.name = name;
        this.portata = portata;
        this.traiettoria = traiettoria;
    }

    @Override
    public String getName(){
        return name;
    }
    @Override
    public Portata getPortata() {
        return portata;
    }
}
