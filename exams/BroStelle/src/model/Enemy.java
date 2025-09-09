package model;

import model.Exceptions.EnemyKilledException;

public class Enemy {
    private int Health = 10000;

    public Enemy (){

    }

    public int getHealth() {
        return Health;
    }

    public void getHit(int damage) throws EnemyKilledException {
        this.Health -= damage;
        if(this.Health <= 0){
            throw new EnemyKilledException();
        }
    }
}
