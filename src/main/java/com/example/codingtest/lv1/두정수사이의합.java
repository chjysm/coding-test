package com.example.codingtest.lv1;

// https://school.programmers.co.kr/learn/courses/30/lessons/12912
public class 두정수사이의합 {
    public static long solution(int a, int b) {
        boolean isBiggerThenB = a > b;
        boolean isNegativeA = a < 0;
        boolean isNegativeB = b < 0;

        if( a == b ){
            return a;
        }

        int start = isBiggerThenB ? b : a;
        int end = isBiggerThenB ? a : b;
        if( (isNegativeA && !isNegativeB)
            || (!isNegativeA && isNegativeB) ){

            if( start + end > 0 ){
                start = Math.abs(start) + 1;
            } else if ( start + end < 0 ) {
                end = Math.abs(end) * - 1 - 1;
            } else {
                return 0;
            }

            return getSum(start, end);
        } else {
            return getSum(start, end);
        }
    }

    public static long getSum(int start, int end){
        long sum = 0;
        for(int i = start; i <= end; i++){
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(solution(-4,1));
    }
}
