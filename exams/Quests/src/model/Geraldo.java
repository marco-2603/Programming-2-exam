package model;


public class Geraldo {
    private int level = 2;
    private int money = 0;

    public Geraldo() {
    }


    public int getLevel() {
        return level;
    }
    public void LevelUp() {
        this.level += 1;
    }
    public void earnMoney(int reward) {
        money += reward;
    }
    public int getMoney() {return money;}
}
