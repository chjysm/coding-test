package com.example.codingtest.lv1;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/12932
public class 자연수뒤집어배열로만들기 {
    public static int[] solution(long n) {
        int[] answer = new int[String.valueOf(n).length()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = (int) (n % 10);
            n = n/10;
        }
        return answer;
    }

    public static void main(String[] args) {
        Arrays.stream(solution(10000000000L)).forEach(System.out::println);
    }
}
