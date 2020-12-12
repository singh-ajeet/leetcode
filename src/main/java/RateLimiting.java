import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class RateLimiting {

    private static class QuotaValidator {
        private final int K;
        private final long maxAllowed;
        private AtomicLong startTime = new AtomicLong(0);  //10 s
        private AtomicInteger counter = new AtomicInteger(0);
        //    private static Map<String, Integer> sizeLimit = ;
        private Map<String, Long> cache = new ConcurrentHashMap<>();

        public QuotaValidator(int k, long maxAllowed) {
            K = k;
            this.maxAllowed = maxAllowed;
        }

        boolean hasQuota(long timestamp, String message){
            long currentTimeStamp = System.currentTimeMillis();
            long diff = currentTimeStamp - startTime.get();

            if(diff >= K){
                //   cache.clear();
                long expected = startTime.get();
                startTime.compareAndSet(expected, currentTimeStamp);
            }

            long messageDuration  = currentTimeStamp - timestamp;
            if(messageDuration <= K && !cache.containsValue(message)){
                cache.put(message, timestamp);
                return true;
            } else if(messageDuration > K){
                cache.remove(message);
            }
            return false;
        }
    }

    private static class Service{
        private final QuotaValidator quotaValidator;

        public Service(int timeWindow, int masAllowedMessages) {
            this.quotaValidator = new QuotaValidator(timeWindow, masAllowedMessages);
        }

        public void shouldPrintMessage(long timestamp, String message) {
            if( quotaValidator.hasQuota(timestamp, message)){
                System.out.println(message);
            } else {
                System.out.println("==== 503 ====");
            }
        }
    }


    public static void main(String[] args) {
/*
        startTime = System.currentTimeMillis();
        K = 10;
        shouldPrintMessage(System.currentTimeMillis() - 8, "Some message 1");
        shouldPrintMessage(System.currentTimeMillis() - 18, "Some message 3");
        shouldPrintMessage(System.currentTimeMillis() - 1, "Some message 4");
        shouldPrintMessage(System.currentTimeMillis(), "Some message 5");
        shouldPrintMessage(System.currentTimeMillis() - 7, "Some message 6");
        shouldPrintMessage(System.currentTimeMillis() - 18, "Some message 7");
        shouldPrintMessage(System.currentTimeMillis() - 200, "Some message 8");
        shouldPrintMessage(System.currentTimeMillis() - 18, "Some message 9");
*/
    }
}