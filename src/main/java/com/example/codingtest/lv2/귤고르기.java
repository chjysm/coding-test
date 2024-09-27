package com.example.codingtest.lv2;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/138476
public class 귤고르기 {
    public static int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a :tangerine){
            Integer i = map.get(a);
            if(i == null){
                map.put(a,1);
            } else {
                map.put(a, map.get(a)+1);
            }
        }

        List<Integer> integers = new ArrayList<>();
        map.forEach((key,vel) -> integers.add(vel));
        integers.sort(Comparator.reverseOrder());

        int sum = 0;
        int count = 0;
        for(int i:integers){
            sum += i;
            count++;
            if( sum >= k ){
                return count;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(solution(6,new int []{1,3,2,5,4,5,2,3}));
    }
}
