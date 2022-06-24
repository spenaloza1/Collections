package model;

import java.util.Comparator;

public class StatusComparator implements Comparator<Posting> {

    public int compare(Posting posting01, Posting posting02){
        return posting01.getStatus().name().compareTo(posting02.getStatus().name());
    }
}
