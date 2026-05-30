public interface Subscribe {
    String getId();
    void consume(Message message);
}
