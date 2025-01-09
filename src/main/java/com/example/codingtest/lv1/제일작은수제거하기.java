package com.example.codingtest.lv1;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/12935
public class 제일작은수제거하기 {
    public static int[] solution(int[] arr) {
        int min = Arrays.stream(arr).min().getAsInt();
        int[] array = Arrays.stream(arr).filter(i -> i > min).toArray();
        if(array == null || array.length == 0 ){
            return new int[]{-1};
        }
        return array;
    }

    public static void main(String[] args) {
        try {
            System.out.println(Arrays.toString(solution(new int[]{4,3,2,1,1,1,1})));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
