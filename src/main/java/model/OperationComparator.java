package model;

import java.util.Comparator;

public class OperationComparator implements Comparator<Posting> {

    public int compare(Posting posting01, Posting posting02){
        return posting01.getOperationType().name().compareTo(posting02.getOperationType().name());
    }
}
