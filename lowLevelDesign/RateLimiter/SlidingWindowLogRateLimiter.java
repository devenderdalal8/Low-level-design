package RateLimiter;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SlidingWindowLogRateLimiter {
    
    private final int limit;
    private long windowSizeMs;

    private final Map<String , Deque<Long>> map = new ConcurrentHashMap<>();

    public SlidingWindowLogRateLimiter(int limit , long windowSizeMs){
        this.limit = limit;
        this.windowSizeMs = windowSizeMs;
    }

    public boolean isAllowed(String userId){
        long now = System.currentTimeMillis();
        map.putIfAbsent(userId, new LinkedList<>());
        Deque<Long> deque = map.get(userId);
        while(!deque.isEmpty() && now - deque.peekFirst() >= windowSizeMs){
            deque.removeFirst();
        }
        if(deque.size() < limit){
            deque.addLast(now);
            return true;
        }
        return false;
    }
}
