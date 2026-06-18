package RateLimiter;

public class TokenBucket {
    private final int capacity;
    private final double refillRatePerSec;

    private double token;
    private long lastRefillTime;

    TokenBucket(int capacity, double refillRatePerSec) {
        this.capacity = capacity;
        this.refillRatePerSec = refillRatePerSec;
        this.token = capacity;
        this.lastRefillTime = System.currentTimeMillis();
    }

    boolean isAllowed(String userId) {
        refill();
        if (token > 0) {
            token--;
            return true;
        }
        return false;
    }

    private void refill() {
        long now = System.currentTimeMillis();
        long elapsedTime = (now - lastRefillTime) / 1_000L;
        token = Math.min(capacity , token + elapsedTime * refillRatePerSec);
        lastRefillTime = now;
    }
}
