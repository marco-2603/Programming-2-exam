package Model.Titoli;

import Model.Enums.Colors;
import Model.Enums.Tipo;

public class Film extends AbstractTitle{
    public Colors colore;

    public Film(String nome, int anno, String lingua, int prezzoBase) {
        super(nome, anno, lingua, prezzoBase, Tipo.film);
        this.colore = Colors.cyan;
    }

    @Override
    public String getTipo() {return "Film";}
    @Override
    public Colors getColore(){
        return this.colore;
    }
}
