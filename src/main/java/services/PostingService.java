package services;

import model.*;
import utils.PostingUtils;

import java.util.*;
import java.util.stream.Collectors;

public class PostingService{

    private List<Posting> getPostingListFilteredByPublisher (Integer idPublisher){
        List<Posting> filteredList = new ArrayList<>();
        for (Posting post : PostingUtils.getListPostings()){
            if (idPublisher.equals(post.getPublisher().getPublisherId())){
                filteredList.add(post);
            }
        }
        return filteredList;
    }

    private Set<Publisher> getPublisherList(){
        Set<Publisher> publisherSet = new HashSet<>();
        for (Posting post : PostingUtils.getListPostings()){
            publisherSet.add(post.getPublisher());
        }
        return publisherSet;
    }

    protected Map<Publisher, List<Posting>> initialize(){
        Map<Publisher, List<Posting>> map = new HashMap<>();
        for (Publisher publisher : getPublisherList()){
            map.put(publisher, getPostingListFilteredByPublisher(publisher.getPublisherId()));
        }
        return map;
    }

    //Item 3 - Métodos de ordenamiento para listados según Publisher.


    //Item 3 - Métodos de ordenamiento para la lista completa.
    public void arrangePostingByMostRecent(List<Posting> postingList){
        List<Posting> arrangedList = postingList;
        Collections.sort(arrangedList, new DateComparator());
        Collections.reverse(arrangedList);
        arrangedList.forEach(System.out::println);
    }

    public void arrangePostingByStatus(List<Posting> postingList, boolean reverse){
        List<Posting> arrangedList = postingList;
        Collections.sort(arrangedList, new StatusComparator());
        if (reverse){
            Collections.reverse(arrangedList);
        }
        arrangedList.forEach(System.out::println);
    }

    public void arrangePostingByOperation(List<Posting> postingList, boolean reverse){
        List<Posting> arrangedList = postingList;
        Collections.sort(arrangedList, new OperationComparator());
        if (reverse){
            Collections.reverse(arrangedList);
        }
        arrangedList.forEach(System.out::println);
    }

    public void arrangePostingsByRealEstate(List<Posting> postingList, boolean reverse){
        List<Posting> arrangedList = postingList;
        Collections.sort(arrangedList, new RealEstateComparator());
        if (reverse){
            Collections.reverse(arrangedList);
        }
        arrangedList.forEach(System.out::println);
    }

    public void arrangePostingsByPrice(List<Posting> postingList, boolean reverse){
        List<Posting> arrangedList = postingList;
        Collections.sort(arrangedList, new PriceComparator());
        if (reverse){
            Collections.reverse(arrangedList);
        }
        arrangedList.forEach(System.out::println);
    }
    //Fin de métodos de ordenamiento para listas completas.


    private List<Posting> filterPostingsByRealEstate(List<Posting> postingList, RealestateTypeEnum realestateType){
        Set<Posting> filteredSet = new HashSet<>();
        for (Posting post : postingList){
            if (realestateType.equals(post.getRealestateType()))
            filteredSet.add(post);
        }
        List<Posting> filteredList = new ArrayList<>();
        filteredList.addAll(filteredSet);
        return filteredList;
    }

    private List<Posting> filterPostingsByOperationType(List<Posting> postingList, OperationTypeEnum operationType){
        Set<Posting> filteredSet = new HashSet<>();
        for (Posting post : postingList){
            if (operationType.equals(post.getOperationType()))
                filteredSet.add(post);
        }
        List<Posting> filteredList = new ArrayList<>();
        filteredList.addAll(filteredSet);
        return filteredList;
    }

    private List<Posting> filterPostingsByStatus(List<Posting> postingList, StatusEnum status){
        Set<Posting> filteredSet = new HashSet<>();
        for (Posting post : postingList){
            if (status.equals(post.getStatus()))
                filteredSet.add(post);
        }
        List<Posting> filteredList = new ArrayList<>();
        filteredList.addAll(filteredSet);
        return filteredList;
    }

    public void filterPostingByEnum(List<Posting> postingList, Filter filter){
        List<Posting> postingTemp = new ArrayList<>();
        if (filter.getOperationTypeExist()){
            postingTemp.addAll(filterPostingsByOperationType(postingList, filter.getOperationTypeEnum()));
        }
        else {
            postingTemp.addAll(postingList);
        }
        if (filter.getRealestateTypeExist()){
            postingTemp.addAll(filterPostingsByRealEstate(postingTemp, filter.getRealestateTypeEnum()));
        }
        if (filter.getStatusExist()){
            postingTemp.addAll(filterPostingsByStatus(postingTemp, filter.getStatusEnum()));
        }

        Set<Posting> filteredSet = new HashSet<>();
        filteredSet.addAll(postingTemp);
        filteredSet.forEach(System.out::println);
    }
    public void filterPostingByEnumMethod3(List<Posting> postingList, Filter filter) {
        List<Posting> filteredList = postingList.stream()

                .filter(p -> p.getRealestateType().equals(filter.getRealestateTypeEnum()))
                .filter(p -> p.getOperationType().equals(filter.getOperationTypeEnum()))
                .filter(p -> p.getStatus().equals(filter.getStatusEnum()))
                .collect(Collectors.toList());

        filteredList.forEach(System.out::println);
    }
}
