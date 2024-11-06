package doAnQuanLyGiaoDichNhaDat.domain;

import java.util.LinkedList;
import java.util.List;

public class Publisher {
    private List<Subscriber> subscribers = new LinkedList<>();

    public void subscriber(Subscriber subscriber1){
        subscribers.add(subscriber1);
    }

    public void unSubscriber(Subscriber subscriber2){
        subscribers.remove(subscriber2);
    }

    public void notifySubscribers(){
        for (Subscriber subscriber3 : subscribers) {
            subscriber3.update();
        }
    }
}
