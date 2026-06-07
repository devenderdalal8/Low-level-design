public class PubSub {

    public static void main(String[] args) {
        Broker broker = new Broker();
        broker.createTopic("topic1");
        Subscribe emailSubscriber1 = new EmailSubscriber("email1");
        Subscribe emailSubscriber2 = new EmailSubscriber("email2");
        broker.subscribe("topic1", emailSubscriber1);
        broker.subscribe("topic1", emailSubscriber2);
        Message message = new Message("Hello, World!");
        broker.publish("topic1", message);
    }
}