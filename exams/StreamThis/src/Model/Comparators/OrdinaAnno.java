package Model.Comparators;

import Model.Titoli.TitleInterface;

import java.util.Comparator;

public class OrdinaAnno implements Comparator<TitleInterface> {
    @Override
    public int compare(TitleInterface o1, TitleInterface o2) {
        int anno = o1.getAnno() - o2.getAnno();
        if (anno == 0) {
            return new OrdinaNome().compare(o1,o2);
        } else return anno;
    }
}
