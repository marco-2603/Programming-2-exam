package Model.Titoli;

import Model.Enums.Colors;
import Model.Enums.Tipo;

public class Anime extends AbstractTitle{
    public String sottotitoli;
    public Colors colore;

    public Anime(String nome, int anno, String lingua, String sottotitoli, int prezzoBase) {
        super(nome, anno, lingua, prezzoBase, Tipo.anime);
        this.sottotitoli = sottotitoli;
        this.colore = Colors.salmon;
    }

    @Override
    public String getTipo() {return "Anime";}
    @Override
    public Colors getColore(){
        return this.colore;
    }
}
