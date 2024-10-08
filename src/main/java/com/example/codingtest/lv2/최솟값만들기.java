package com.example.codingtest.lv2;

import java.util.Arrays;

public class 최솟값만들기 {
    public static int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[A.length - 1 - i];
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println( solution(new int[]{1,2},new int[]{3,4}));
    }
}
