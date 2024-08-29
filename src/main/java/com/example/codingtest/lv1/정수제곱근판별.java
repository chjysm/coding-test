package com.example.codingtest.lv1;

public class 정수제곱근판별 {
    public static long solution(long n) {
        long answer = -1;

        int index = 1;
        while (true){

            if( n == Math.pow(index,2) ){
                return (long) Math.pow(index+1,2);
            }

            if(index > (n / 2) ){
                break;
            }

            index++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(3));
    }
}
