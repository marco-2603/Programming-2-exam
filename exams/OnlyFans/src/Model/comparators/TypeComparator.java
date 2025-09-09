package Model.comparators;

import Model.Ventilatori.FanInterface;

import java.util.Comparator;

public class TypeComparator implements Comparator<FanInterface> {
    @Override
    public int compare(FanInterface o1, FanInterface o2) {
        int val = o1.fanToint() - o2.fanToint();
        if(val == 0){
            int costC =  new CostComparator().compare(o1, o2);
            if(costC == 0){
                return 0;
            }else return costC;
        }else return val;
    }
}
