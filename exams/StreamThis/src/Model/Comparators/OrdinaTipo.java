package Model.Comparators;

import Model.Titoli.TitleInterface;

import java.util.Comparator;
import java.util.Objects;

public class OrdinaTipo implements Comparator<TitleInterface> {
    @Override
    public int compare(TitleInterface o1, TitleInterface o2) {
        if (Objects.equals(o1.getTipo(), o2.getTipo())) {
            return new OrdinaNome().compare(o1,o2);
        } else return o1.getTipo().compareTo(o2.getTipo());
    }
}
