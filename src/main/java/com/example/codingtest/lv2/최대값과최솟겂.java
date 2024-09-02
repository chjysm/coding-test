package com.example.codingtest.lv2;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/12939
public class 최대값과최솟겂 {
    public static String solution(String s) {
        String answer = "";
        String[] s1 = s.split(" ");
        int[] array = Arrays.stream(s1).mapToInt(Integer::valueOf).sorted().toArray();
        return array[0] + " " + array[s1.length - 1];
    }

    public static void main(String[] args) {
        String s = "1 2 3 4";
        System.out.println(solution(s));
    }
}
