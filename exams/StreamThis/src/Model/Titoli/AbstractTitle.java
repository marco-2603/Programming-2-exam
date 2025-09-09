package Model.Titoli;

import Model.Enums.Tipo;

public abstract class AbstractTitle implements TitleInterface {
    public String nome;
    public Tipo tipo;
    public int anno;
    public String lingua;
    public int prezzoBase;
    public int prezzoEff;

    public AbstractTitle(String nome, int anno, String lingua, int prezzoBase, Tipo tipo) {
        this.nome = nome;
        this.anno = anno;
        this.lingua = lingua;
        this.prezzoBase = prezzoBase;
        this.tipo = tipo;
    }

    @Override
    public String getTipo() {return tipo.toString();}
    @Override
    public String getNome() {return nome;}
    @Override
    public int getAnno() {return anno;}
    @Override
    public int getPrezzoBase() {return prezzoBase;}
    @Override
    public int getPrezzoEff() {
        if (anno < 2015) return prezzoEff = prezzoBase - (int)(prezzoBase * 0.1);
        return prezzoBase;
    }
    @Override
    public String getLingua() {return lingua;}
}
