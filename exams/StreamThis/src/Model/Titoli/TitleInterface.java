package Model.Titoli;

import Model.Enums.Colors;

public interface TitleInterface {
    public String getTipo();
    public String getNome();
    public int getPrezzoBase();
    public int getPrezzoEff();
    public String getLingua();
    public int getAnno();
    public Colors getColore();
}
