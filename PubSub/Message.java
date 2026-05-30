import java.util.UUID;

public class Message {
    private final String id;
    private final String message;
    private final long timestemp;

    Message(String message){
        this.id = UUID.randomUUID().toString();
        this.message = message;
        this.timestemp = System.currentTimeMillis();
        
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public long getTimestemp() {
        return timestemp;
    }

    @Override
    public String toString() {
        return "Message [id=" + id + ", message=" + message + ", timestemp=" + timestemp + "]";
    }
    
}
