package com.example.codingtest.lv1;

// https://school.programmers.co.kr/learn/courses/30/lessons/87389
public class 나머지가1이되는수찾기 {

    public static int solution(int n) {
        int answer = 1000000;

        for(int i = 2; i < n ; i++){
            if(n % i == 1){
                if( answer > i ) {
                    answer = i;
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        System.out.println( solution(10 ) );
    }
}
