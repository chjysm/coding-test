package com.example.codingtest.lv1;

// https://school.programmers.co.kr/learn/courses/30/lessons/12919
public class 서울에서김서방찾기 {

    public static String solution(String[] seoul) {
        String answer = "";

        int i = 0;
        for(String s : seoul){
            if(s.equals("Kim")){
                return "김서방은 "+i+"에 있다";
            }
            i++;
        }
        return answer;
    }


    public static void main(String[] args) {
        System.out.println(solution(new String[]{"Jane", "Kim"}));

    }
}
