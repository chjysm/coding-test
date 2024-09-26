package com.example.codingtest.lv1;

public class 음양더하기 {
    public static int solution(int[] absolutes, boolean[] signs) {
        int sum = 0;
        int i =0;
        for(boolean sign:signs){
            if(sign){
                sum += absolutes[i++];
            } else {
                sum -= absolutes[i++];
            }
        }

        return sum;
    }
    public static void main(String[] args) {
        System.out.println( solution( new int[]{4,7,12}, new boolean[]{ true, false, true } ) );
    }
}
