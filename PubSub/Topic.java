import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Topic {
    private final String topicName;

    private final List<Subscribe> subscribers = new CopyOnWriteArrayList<>();

    public Topic(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicName() {
        return topicName;
    }
    
    public void addSubscriber(Subscribe subscribe) {
        subscribers.add(subscribe);
    }

    public void removeSubscriber(Subscribe subscribe) {
        subscribers.remove(subscribe);
    }

    public List<Subscribe> getSubscribers() {
        return subscribers;
    }
    
}
