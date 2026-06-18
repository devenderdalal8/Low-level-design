package RateLimiter;

import java.util.concurrent.ConcurrentHashMap;

public class FixedWindowRateLimiter {
    class Windows{
        long startTime;
        int  count;
        Windows(long startTime){
            this.startTime = startTime;
            this.count = 1;
        }
    }

    private final int MAX_LIMIT;
    private final long windowsSizeMs;

    ConcurrentHashMap<String , Windows> map = new ConcurrentHashMap<>();

    public FixedWindowRateLimiter(int limit , long windowsSizeMs){
        this.MAX_LIMIT = limit;
        this.windowsSizeMs = windowsSizeMs;
    }

    boolean isAllowed(String userId){
        long currentTime = System.currentTimeMillis();
        Windows curr = map.get(userId);
        if(curr == null || currentTime - curr.startTime >= windowsSizeMs){
            map.put(userId, new Windows(currentTime));
            return true;
        }
        if(curr.count < MAX_LIMIT){
           curr.count += 1;
           return true; 
        }
        return false;
    }
}
