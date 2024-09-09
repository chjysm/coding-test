package com.example.codingtest.lv2;

//https://school.programmers.co.kr/learn/courses/30/lessons/12924
public class 숫자의표현 {

    public static int solution(int n) {
        int answer = 1;

        for(int i = 1; i < n; i++){
            int sum = i;
            for(int j = i + 1; j < n; j++){
                sum += j;

                if( sum > n ){
                    break;
                } else if( sum == n ){
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(15));
    }
}
