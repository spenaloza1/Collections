import model.*;
import services.PostingService;
import services.PublisherService;

import java.util.Date;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        PublisherService publisherService = new PublisherService();
        Integer MAX_VALUE_TEST = Integer.MAX_VALUE;
        List<Posting> filteredList = publisherService.getPostingListOfPublisher(MAX_VALUE_TEST); //original: 10024
        publisherService.showPostingListFilteredByPublisher(filteredList);

        publisherService.getPostingAmountByStatus(filteredList);
        System.out.println("");

        PostingService postingService = new PostingService();
        postingService.arrangePostingByMostRecent(filteredList);

        System.out.println("");

        postingService.arrangePostingByStatus(filteredList, false);
        System.out.println("");
        postingService.arrangePostingByStatus(filteredList, true);
        System.out.println("");


        postingService.arrangePostingByOperation(filteredList, false);
        System.out.println("");
        postingService.arrangePostingByOperation(filteredList, true);
        System.out.println("");

        postingService.arrangePostingsByRealEstate(filteredList, false);
        System.out.println("");
        postingService.arrangePostingsByRealEstate(filteredList, true);
        System.out.println("");

        postingService.arrangePostingsByPrice(filteredList, false);
        System.out.println("");
        postingService.arrangePostingsByPrice(filteredList, true);
        System.out.println("");

        /*METODO FILTRADO CON BOOLEANO*/
        Filter filter01 = new Filter(true, OperationTypeEnum.SELL, true, RealestateTypeEnum.HOUSE, true, StatusEnum.OFFLINE);
        postingService.filterPostingByEnum(filteredList, filter01);
        System.out.println("");
        Filter filter02 = new Filter();
        try{
            filter02 = new Filter(true, OperationTypeEnum.RENT, true, RealestateTypeEnum.COMERCIAL, true, StatusEnum.ONLINE);
        }
        finally {
            postingService.filterPostingByEnum(filteredList, filter02);
            System.out.println("");
        }
        publisherService.showPostingById(filteredList, 10410117);


        System.out.println("");
        //postingId=10410021, title='Casa en venta', price=Price{amount=24911, currency=SOLES}, realestateType=HOUSE, operationType=SELL, postingType=PROPERTY, quality=0.51, status=OFFLINE, creationDate=Wed Jun 07 00:00:00 ART 3922, updateDate=null}
        Posting postingToUpdate = new Posting(10411121, "Casa en Venta nueva", new Price(25000, CurrencyEnum.SOLES), RealestateTypeEnum.HOUSE, OperationTypeEnum.SELL, PostingType.PROPERTY, 0.51, StatusEnum.OFFLINE, new Date(2022,06,07)); // original: 10410021
        publisherService.addNewOrUpdatePostingMethod2(filteredList, postingToUpdate);

        System.out.println("");
        Posting postingToAdd =  new Posting(10410022, "Casa en Venta nuevita", new Price(27000, CurrencyEnum.SOLES), RealestateTypeEnum.HOUSE, OperationTypeEnum.SELL, PostingType.PROPERTY, 0.51, StatusEnum.OFFLINE, new Date(2022,06,07));
        publisherService.addNewOrUpdatePostingMethod2(filteredList, postingToAdd);
        System.out.println("");

        publisherService.addPriceToPostingTitle(filteredList);

        System.out.println("");
        publisherService.getPostingAmountByStatus(filteredList);
        System.out.println("");

    }

}
