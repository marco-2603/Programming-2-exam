package model.bros;

import javafx.scene.paint.Color;
import model.Enemy;
import model.Exceptions.MaxlvlException;
import model.attacks.Attack;
import model.enums.Speed;

public abstract class AbstractBro implements Bro{
    String name;
    int level;

    int minHealth;
    int curHealth;
    int maxHealth;

    Attack attacco;
    int baseDamage;
    int curDamage;

    Speed velocita;
    Color colore;

    public AbstractBro(String name, int level, Attack attacco, int minHealth, int maxHealth,int baseDamage, Speed velocita, Color colore) {
        this.name = name;
        this.level = level;

        this.minHealth = minHealth;
        this.maxHealth = maxHealth;
        this.curHealth = updateHealth();

        this.attacco = attacco;
        this.baseDamage = baseDamage;
        this.curDamage = updateDamage();

        this.velocita = velocita;
        this.colore = colore;
    }

    protected int updateHealth(){
        int cur=this.minHealth + minHealth* (int)(0.1*this.level);
        if(cur>this.maxHealth){
            cur=this.maxHealth;
        }
        return cur;
    }

    protected int updateDamage(){
        return baseDamage + baseDamage * (int)(0.1*this.level);
    }

    @Override
    public void levelup() throws MaxlvlException {
        if(this.level<11) {
            this.level++;
            curHealth = updateHealth();
            curDamage = updateDamage();
        }else throw new MaxlvlException();
    }

    @Override
    public void attack(Enemy e){
        e.getHit(curDamage);
    }


    @Override
    public String getName() {
        return name;
    }
    @Override
    public int getHealth (){
        return curHealth;
    }
    @Override
    public int getLevel() {
        return level;
    }
    @Override
    public Attack getAttacco() {
        return attacco;
    }
    @Override
    public int getDamage() {
        return curDamage;
    }
    @Override
    public Color getColor() {
        return colore;
    }
}
