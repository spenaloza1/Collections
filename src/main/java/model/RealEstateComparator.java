package model;

import java.util.Comparator;

public class RealEstateComparator implements Comparator<Posting> {

    public int compare(Posting posting01, Posting posting02){
        return posting01.getRealestateType().name().compareTo(posting02.getRealestateType().name());
    }
}
