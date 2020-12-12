package org.ajeet.algorithms.concurrency;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

class Solution {
    private static int K;
    private static long maxAllowed = 100;

    private static AtomicLong startTime = new AtomicLong(0);  //10 s
    private static AtomicInteger counter = new AtomicInteger(0);
//    private static Map<String, Integer> sizeLimit = ;
    private static Map<String, Long> cache = new ConcurrentHashMap<>();

    public static boolean shouldPrintMessage(long timestamp, String message) {
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
            System.out.println(message);
            return true;
        } else if(messageDuration > K){
            cache.remove(message);
        }
        return false;
    }

    public static void main(String[] args) {
        startTime = new AtomicLong(System.currentTimeMillis());
        K = 10;
        shouldPrintMessage(System.currentTimeMillis() - 8, "Some message 1");
        shouldPrintMessage(System.currentTimeMillis() - 18, "Some message 3");
        shouldPrintMessage(System.currentTimeMillis() - 1, "Some message 4");
        shouldPrintMessage(System.currentTimeMillis(), "Some message 5");
        shouldPrintMessage(System.currentTimeMillis() - 7, "Some message 6");
        shouldPrintMessage(System.currentTimeMillis() - 18, "Some message 7");
        shouldPrintMessage(System.currentTimeMillis() - 200, "Some message 8");
        shouldPrintMessage(System.currentTimeMillis() - 18, "Some message 9");
    }
}