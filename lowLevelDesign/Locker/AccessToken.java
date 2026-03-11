package Locker;

public class AccessToken {
    private String code;
    private long expirationTime;
    private Container container;

    AccessToken(String code, long expirationTime, Container container){
        this.code = code;
        this.expirationTime = expirationTime;
        this.container = container;
    }

    public String getCode() {
        return code;
    }

    public long getExpirationTime() {
        return expirationTime;
    }

    public Container getContainer() {
        return container;
    }

    public boolean isExpire(){
        return System.currentTimeMillis() > expirationTime;
    }

}
