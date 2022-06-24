package model;

import java.util.Comparator;

public class DateComparator implements Comparator<Posting> {

    public int compare (Posting posting01, Posting posting02){
        return posting01.getCreationDate().compareTo(posting02.getCreationDate());
    }
}
