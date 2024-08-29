package com.example.codingtest.lv1;

// https://school.programmers.co.kr/learn/courses/30/lessons/12947
public class 하샤드수 {
    public static boolean solution(int x) {
        int imsi = x;
        int sum = 0;
        while (true){
            if(imsi == 0){
                break;
            }

            sum += imsi % 10;
            imsi = imsi/10;
        }

        if( x % sum == 0 ){
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(10));
        System.out.println(solution(12));
        System.out.println(solution(11));
        System.out.println(solution(13));
    }
}
