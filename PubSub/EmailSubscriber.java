public class EmailSubscriber implements Subscribe {

    private final String id;
     public EmailSubscriber(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
       return id;
    }

    @Override
    public void consume(Message message) {
        // TODO Auto-generated method stub
        System.out.println("EmailSubscriber " + id + " received message: " + message);
    }
    
}
