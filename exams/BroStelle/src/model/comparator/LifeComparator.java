package model.comparator;

import model.bros.Bro;

import java.util.Comparator;

public class LifeComparator implements Comparator<Bro> {

    @Override
    public int compare(Bro o1, Bro o2) {
        if(o1.getHealth()==o2.getHealth()){
            return new NameComparator().compare(o1,o2);
        }else if(o1.getHealth()<o2.getHealth()){
            return 1;
        }else{
            return -1;
        }
    }
}
