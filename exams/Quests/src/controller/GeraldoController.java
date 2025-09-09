package controller;

import model.Geraldo;
import view.GeraldoStats;

public class GeraldoController {
    Geraldo g;
    GeraldoStats gs;

    public GeraldoController(Geraldo g) {
        this.g = g;
        this.gs = new GeraldoStats(g);
    }

    public Geraldo getG() {
        return g;
    }
    public GeraldoStats getGS() {
        return gs;
    }

}
