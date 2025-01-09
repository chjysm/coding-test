package com.example.codingtest.lv1;
// https://school.programmers.co.kr/learn/courses/30/lessons/12948?language=java
public class 핸드폰번호가리기 {
    public static String solution(String phone_number) {
        int length = phone_number.length();
        String substring = phone_number.substring(length - 4, length);
        String s = phone_number.substring(0, length - 4).replaceAll("[0-9]", "*");
        return s + substring;
    }

    public static void main(String[] args) {
        try {
            System.out.println(solution("01012341234"));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
