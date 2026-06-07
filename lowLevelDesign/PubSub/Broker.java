import java.util.HashMap;
import java.util.Map;

public class Broker {
    Map<String, Topic> topics = new HashMap<>();
    
    public void createTopic(String topicName) {
        if (topics.containsKey(topicName)) {
            throw new IllegalArgumentException("Topic already exists");
        }
        topics.put(topicName, new Topic(topicName));
    }

    public void subscribe(String topicName, Subscribe subscribe) {
        if (!topics.containsKey(topicName)) {
            throw new IllegalArgumentException("Topic does not exist");
        }
        topics.get(topicName).addSubscriber(subscribe);
    }

    public void unsubscribe(String topicName, Subscribe subscribe) {
        if (!topics.containsKey(topicName)) {
            throw new IllegalArgumentException("Topic does not exist");
        }
        topics.get(topicName).removeSubscriber(subscribe);
    }

    public void publish(String topicName, Message message) {
        if (!topics.containsKey(topicName)) {
            throw new IllegalArgumentException("Topic does not exist");
        }
        for (Subscribe subscribe : topics.get(topicName).getSubscribers()) {
            subscribe.consume(message);
        }
    }
}
