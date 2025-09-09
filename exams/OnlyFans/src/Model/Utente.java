package Model;

import Model.Exceptions.NoMoneyExceptions;

public class Utente {
    private int capitale;
    private int spesaM;
    private int mese;

    public Utente() {
        this.capitale = 100;
        this.spesaM = 0;
        this.mese = 0;
    }

    public void addMoney() {
        this.capitale+= 100;
    }
    public void addFan( int costo){
        this.spesaM += costo;
    }
    public void removeFan( int costo){
        this.spesaM -= costo;
    }

    public void nextMese() throws NoMoneyExceptions {
        int cur=this.capitale;
        capitale-=spesaM;
        if(capitale<=0){
            capitale=cur;
            throw new NoMoneyExceptions();
        }else{
            mese++;
        }
    }

    public int getCapitale() {
        return capitale;
    }
    public int getSpesaM() {
        return spesaM;
    }
    public int getMese() {
        return mese;
    }

}
