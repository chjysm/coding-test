package com.example.codingtest.lv2;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/70129
public class 이진변환반복하기 {
    public static int[] solution(String s) {
        int[] answer = new int[2];

        int i1 = 0;
        int i2 = 0;
        while (!s.equals("1")){
            i1++;
            String s1 = s.replaceAll("0", "");
            i2 += s.length() - s1.length();

            int a = s1.length();
            if(a == 1){
                break;
            }
            s = Integer.toBinaryString(a);
        }

        answer[0] = i1;
        answer[1] = i2;
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("110010101001")));
    }
}
