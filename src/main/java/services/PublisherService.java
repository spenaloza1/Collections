package services;

import model.Posting;
import model.Publisher;
import model.StatusEnum;

import java.util.*;

public class PublisherService {

    PostingService postingService = new PostingService();

    public List<Posting> getPostingListOfPublisher(Integer idPublisher){
        List<Posting> filteredList = new ArrayList<>();
        Map<Publisher, List<Posting>> map = postingService.initialize();//initialize(idPublisher) para ir a buscarlo por el id
        Set<Map.Entry<Publisher, List<Posting>>> setMap = map.entrySet();
        Iterator<Map.Entry<Publisher, List<Posting>>> itOnMap = setMap.iterator();
        Publisher publisherMatch = itOnMap.next().getKey();
        //boolean found = false;
        while (itOnMap.hasNext()){
            Publisher publisherTemp = itOnMap.next().getKey();
            if (idPublisher.equals(publisherTemp.getPublisherId())){
                publisherMatch = publisherTemp;
                //found = true;
                break;
            }
        }
        filteredList.addAll(map.get(publisherMatch));
        return filteredList;
    }

    public void showPostingListFilteredByPublisher(List<Posting> postingList){
        postingList.forEach(System.out::println);
    }

    public void showPostingById(List<Posting> postingList, Integer idPosting){
        boolean found = false;
        Posting postToShow = new Posting();
        for (Posting post : postingList){
            if (idPosting.equals(post.getPostingId())){
                found = true;
                postToShow = post;
                break;
            }
        }
        System.out.println(postToShow.getPostingId() + "\n" + postToShow.getTitle());
    }

    public void getPostingAmountByStatus(List<Posting> postingList){
        Integer contDraft=0;
        Integer contONLINE=0;
        Integer contOFFLINE=0;

        //Collection<Posting> postingListFiltered = getPostingListByPublisher(id);
        for(Posting po: postingList){
            if(StatusEnum.DRAFT.equals(po.getStatus())){
                contDraft++;
            }else if(StatusEnum.OFFLINE.equals(po.getStatus())){
                contOFFLINE++;
            } else{
                contONLINE++;
            }
        }
        System.out.println("DRAFT: " + contDraft + "\n ONLINE: " + contONLINE + "\n OFFLINE: " + contOFFLINE);
    }

    public void addNewOrUpdatePosting(List<Posting> postingList, Posting post){
        if (postingList.contains(post)){
            postingList.set(postingList.indexOf(post), post);
        }
        else{
            postingList.add(post);
        }
    }

    public void addNewOrUpdatePostingMethod2(List<Posting> postingList, Posting posting){
        boolean found = false;
        int index = 0;
        for (Posting post : postingList){
            if (posting.getPostingId().equals(post.getPostingId())){
                found = true;
                index = postingList.indexOf(post);
                break;
            }
        }
        if (found){
            postingList.set(index, posting);
        }
        else{
            postingList.add(posting);
        }
        postingList.forEach(System.out::println);
    }

    public void addPriceToPostingTitle(List<Posting> postingList){
        Iterator<Posting> itOnPostingList = postingList.iterator();
        while (itOnPostingList.hasNext()){
            Posting postPointer = itOnPostingList.next();
            postPointer.setTitle(postPointer.getTitle() + " por " + postPointer.getPrice().getAmount() + " " + postPointer.getPrice().getCurrency());
        }
        postingList.forEach(System.out::println);
    }

}
