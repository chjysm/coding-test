package com.example.codingtest.lv1;


// https://school.programmers.co.kr/learn/courses/30/lessons/70128
public class 내적 {
    public static int solution(int[] a, int[] b) {
        int n = 0;

        for(int i = 0; i< a.length; i++) {
            n += a[i]*b[i];
        }

        return n;
    }

    public static void main(String[] args) {
        try {
            System.out.println(solution(new int[]{1,2,3,4}, new int[]{-3,-1,0,2}));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
