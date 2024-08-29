package com.example.codingtest.lv1;

// https://school.programmers.co.kr/learn/courses/30/lessons/12931
public class 자릿수더하기 {
    public static int solution(int n) {
        int answer = 0;

        while (true){
            if( n == 0 ){
                break;
            }
            answer += n % 10;
            n = n / 10;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution( 123));
    }
}
