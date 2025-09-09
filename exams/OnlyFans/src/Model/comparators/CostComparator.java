package Model.comparators;

import Model.Ventilatori.FanInterface;

import java.util.Comparator;

public class CostComparator implements Comparator<FanInterface> {

    @Override
    public int compare(FanInterface o1, FanInterface o2) {
        int cost = o1.getCosto() - o2.getCosto();
        if(cost == 0){
            return new TypeComparator().compare(o1, o2);
        }else return cost;
    }
}
