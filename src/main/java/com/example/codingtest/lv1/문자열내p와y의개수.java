package com.example.codingtest.lv1;

// https://school.programmers.co.kr/learn/courses/30/lessons/12916
public class 문자열내p와y의개수 {
    private static boolean solution(String s) {
        boolean answer = false;
        String lowerCase = s.toLowerCase();
        int p = lowerCase.length() - lowerCase.replace("p", "").length();
        int y = lowerCase.length() - lowerCase.replace("y", "").length();

        if( p == y ){
            return true;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println( solution("pPoooyY"));
    }
}
