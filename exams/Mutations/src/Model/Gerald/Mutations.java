package Model.Gerald;

public enum Mutations {
    Str,
    Spd,
    Fire,
    Def,
    Tol,
    Empty;

    public boolean isCombat(){
        return(this== Str || this== Spd);
    }
    public boolean isSpell(){
        return(this==Fire || this== Def);
    }
    public boolean isPotion(){
        return(this== Tol);
    }
}
