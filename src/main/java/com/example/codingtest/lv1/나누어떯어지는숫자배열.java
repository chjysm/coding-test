package com.example.codingtest.lv1;

import java.util.Arrays;

public class 나누어떯어지는숫자배열 {
    public static int[] solution(int[] arr, int divisor) {
        int[] array = Arrays.stream(arr).filter(i -> i % divisor == 0).sorted().toArray();
        if(array == null || array.length == 0 ){
            return new int[]{-1};
        }
        return array;
    }

    public static void main(String[] args) {
        try {
            System.out.println(Arrays.toString(solution(new int[]{5, 9, 7, 10}, 5)));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
