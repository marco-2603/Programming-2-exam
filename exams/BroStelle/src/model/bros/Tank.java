package model.bros;

import javafx.scene.paint.Color;
import model.attacks.Attack;
import model.enums.Speed;

public class Tank extends AbstractBro {

    public Tank (String name, int level, Attack attacco, int baseDamage){
        super(name, level, attacco, 8000, 10500, baseDamage, Speed.lenta, Color.MAGENTA);
    }
}
