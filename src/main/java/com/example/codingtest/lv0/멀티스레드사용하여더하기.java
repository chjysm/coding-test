package com.example.codingtest.lv0;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class 멀티스레드사용하여더하기 {
    private static AtomicInteger sum = new AtomicInteger(0);

    public static void addSum(int sum) {
        멀티스레드사용하여더하기.sum.addAndGet(sum);
    }



    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        final int n = 999999;
        final int threadNum = 100;
        int maxCnt = n / threadNum;

        ExecutorService executorService = Executors.newFixedThreadPool(threadNum);
        for(int i = 0; i < threadNum; i++) {
            int startNum = i * maxCnt  + 1 ;
            int endNum = (i+1 == threadNum) ? n : startNum + maxCnt - 1;
            executorService.submit( ( ) -> {
                int sum = 0;
                int start = startNum;

                while ( start <= endNum){
                    sum += start++;
                }

                멀티스레드사용하여더하기.addSum(sum);
            } );
        }

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        long endTime = System.currentTimeMillis();
        System.out.println(멀티스레드사용하여더하기.sum.get());
        System.out.println(endTime - startTime);
    }
}
