package com.example.codingtest.lv1;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/12954
public class x만큼간격이있는n개의숫자 {
    public static long[] solution(int x, int n) {
        long[] answer = new long[n];

        for(int i = 1; i <= n; i++){
            answer[i-1] = (long) i *x;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(2, 5)));
    }
}
