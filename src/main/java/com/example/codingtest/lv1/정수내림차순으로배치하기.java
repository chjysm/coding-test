package com.example.codingtest.lv1;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/12933
public class 정수내림차순으로배치하기 {

    public static long solution(long n) {
        long answer = 0;
        char[] charArray = String.valueOf(n).toCharArray();
        Arrays.sort(charArray);
        StringBuilder stringBuilder = new StringBuilder();

        for( int i = charArray.length-1; i >= 0; i--){
            stringBuilder.append(charArray[i]);
        }

        return Long.parseLong(stringBuilder.toString());
    }

    public static void main(String[] args) {
        System.out.println(solution(118372));
    }
}
