package model.comparator;

import model.bros.Bro;

import java.util.Comparator;

public class NameComparator implements Comparator<Bro> {

    @Override
    public int compare (Bro o1, Bro o2) {
        return o1.getName().compareTo(o2.getName());
    }

}
