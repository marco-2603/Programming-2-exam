package Model.Titoli;

import Model.Enums.Colors;
import Model.Enums.Tipo;

public class SerieTV extends AbstractTitle{
    public int stagioni;
    public Colors colore;
    public int stagioniAcqu;

    public SerieTV(String nome, int anno, String lingua, int stagioni, int prezzoBase) {
        super(nome, anno, lingua, prezzoBase, Tipo.serieTV);
        this.stagioni = stagioni;
        this.colore = Colors.magenta;
    }

    @Override
    public String getTipo() {return "Serie TV";}
    @Override
    public int getPrezzoEff() { //c'è un modo per semplificare?  decisamente si
        if (anno < 2015 && stagioniAcqu > 1 && stagioniAcqu < stagioni) {
            return prezzoEff = prezzoBase - (int)(prezzoBase * 0.1) + prezzoBase - (int)(prezzoBase * 0.25);
        } else if (anno < 2015 && stagioniAcqu == stagioni) {
            return prezzoEff = prezzoBase - (int)(prezzoBase * 0.1) + prezzoBase - (int)(prezzoBase * 0.5);
        } else if (anno < 2015) {
            return prezzoEff = prezzoBase - (int)(prezzoBase * 0.1);
        } else if (stagioniAcqu > 1 && stagioniAcqu < stagioni) {
            return prezzoEff = prezzoBase - (int)(prezzoBase * 0.25);
        } else if (stagioniAcqu == stagioni) {
            return prezzoEff = prezzoBase - (int)(prezzoBase * 0.5);
        } else return prezzoBase;
    }
    @Override
    public Colors getColore(){
        return this.colore;
    }
}
