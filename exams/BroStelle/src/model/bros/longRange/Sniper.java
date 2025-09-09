package model.bros.longRange;

import javafx.scene.paint.Color;
import model.attacks.Attack;
import model.bros.AbstractBro;

public class Sniper extends AbstractLongRange {

    public Sniper(String name, int level, Attack attacco, int baseDamage){
        super(name, level, attacco, 3000, 5500, baseDamage, Color.OLIVE);
    }
}
