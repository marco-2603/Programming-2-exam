package model.bros;

import javafx.scene.paint.Color;
import model.Enemy;
import model.attacks.Attack;

public interface Bro {

    //metodo levelup
    public void levelup();

    //metodo attack (getDamage)
    public void attack(Enemy e);

    //metodo getName
    public String getName();
    public int getHealth();
    public int getLevel();
    public int getDamage();
    public Attack getAttacco();
    public Color getColor();


    //metodo get?
}
