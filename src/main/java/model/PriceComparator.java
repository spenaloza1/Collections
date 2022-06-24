package model;

import java.util.Comparator;

public class PriceComparator implements Comparator<Posting> {

    public int compare(Posting posting01, Posting posting02){
        int amountDifference = Long.compare(posting01.getPrice().getAmount(), posting02.getPrice().getAmount());
        int currencyDifference = posting01.getPrice().getCurrency().name().compareTo(posting02.getPrice().getCurrency().name());
        if (currencyDifference==0){
            return amountDifference;
        }
        else {
            return currencyDifference;
        }
    }
}
