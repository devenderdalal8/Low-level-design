package RateLimiter;

import RateLimiter.*;

public class RateLimiter {

   public static void main(String[] args) {
      // FixedWindowRateLimiter
      FixedWindowRateLimiter fixedWindowRateLimiter = new FixedWindowRateLimiter(2, 10000L);
      System.out.println("FixedWindowRateLimiter : 2 requests in 10 seconds");
      System.out.println(fixedWindowRateLimiter.isAllowed("abc123"));
      System.out.println(fixedWindowRateLimiter.isAllowed("abc123"));
      System.out.println(fixedWindowRateLimiter.isAllowed("abc123"));

      // SlidingWindowLogRateLimiter
      SlidingWindowLogRateLimiter slidingWindowLogRateLimiter = new SlidingWindowLogRateLimiter(2, 10000L);
      System.out.println("SlidingWindowLogRateLimiter : 2 requests in 10 seconds");
      System.out.println(slidingWindowLogRateLimiter.isAllowed("abc123"));
      System.out.println(slidingWindowLogRateLimiter.isAllowed("abc123"));
      System.out.println(slidingWindowLogRateLimiter.isAllowed("abc123"));

      // TokenBucket
      TokenBucket tokenBucket = new TokenBucket(2, 1);
      System.out.println("TokenBucket : 2 requests in 1 second");
      System.out.println(tokenBucket.isAllowed("abc123"));
      System.out.println(tokenBucket.isAllowed("abc123"));
      System.out.println(tokenBucket.isAllowed("abc123"));
   
   }     


}