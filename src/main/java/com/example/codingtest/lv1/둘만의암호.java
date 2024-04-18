package com.example.codingtest.lv1;

import java.util.List;
// https://school.programmers.co.kr/learn/courses/30/lessons/155652
public  class 둘만의암호 {
    public static void main(String[] args) {
        System.out.println(solution("aukks", "wbqd",5));
        System.out.println(solution("bcdefghijklmnopqrstuvwxyz", "a",1));
    }
    public static String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        String alphabat = "abcdefghijklmnopqrstuvwxyz";
        alphabat = alphabat.replaceAll("["+skip+"]","");
        List<String> alphabatList  = List.of(alphabat.split(""));
        List <String> skipList = List.of(skip.split(""));
        String[] sArray = s.split("");

        for (String tempS : sArray) {
            int i = ( alphabatList.indexOf(tempS) + index ) % alphabatList.size();
            tempS = alphabatList.get( i );
            answer.append(tempS);
        }

        return answer.toString();
    }
}
