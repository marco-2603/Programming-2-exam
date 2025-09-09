package model.bros.longRange;

import javafx.scene.paint.Color;
import model.attacks.Attack;
import model.bros.AbstractBro;
import model.enums.Speed;

public class Artilliery extends AbstractLongRange {

    public Artilliery(String name, int level, Attack attacco, int baseDamage){
        super(name, level, attacco, 2000, 3500, baseDamage, Color.CYAN);
    }
}
