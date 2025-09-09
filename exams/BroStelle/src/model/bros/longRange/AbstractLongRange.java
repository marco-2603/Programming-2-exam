package model.bros.longRange;

import javafx.scene.paint.Color;
import model.attacks.Attack;
import model.bros.AbstractBro;
import model.enums.Speed;

public abstract class AbstractLongRange extends AbstractBro {

    public AbstractLongRange(String name, int level, Attack attacco, int minHealth, int maxHealth, int baseDamage, Color colore ) {
        super(name, level, attacco, minHealth, maxHealth, baseDamage,  Speed.normale, colore);
    }
}
