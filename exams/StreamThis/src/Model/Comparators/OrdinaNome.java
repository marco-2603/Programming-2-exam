package Model.Comparators;

import Model.Titoli.TitleInterface;

import java.util.Comparator;

public class OrdinaNome implements Comparator<TitleInterface> {
    @Override
    public int compare(TitleInterface o1, TitleInterface o2) {
        return o1.getNome().compareTo(o2.getNome());
    }
}
