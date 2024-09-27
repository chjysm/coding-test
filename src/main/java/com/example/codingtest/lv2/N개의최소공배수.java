package com.example.codingtest.lv2;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/12953
public class N개의최소공배수 {
    public static int solution(int[] arr) {
        int answer = Arrays.stream(arr).max().getAsInt();
        while (true){
            boolean good = true;
            for(int i : arr){
                if( answer % i != 0 ){
                    good = false;
                    break;
                }
            }

            if(good){
                return answer;
            }

            answer++;
        }
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,6,8,14}));
    }
}
