package com.example.codingtest.lv1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

// https://school.programmers.co.kr/learn/courses/30/lessons/68644
public class 두개뽑아서더하기 {
    public static int[] solution(int[] numbers) {
        Set<Integer> integers = new HashSet<>();

        for(int i = 0; i < numbers.length-1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                integers.add(numbers[i]+numbers[j]);
            }
        }

        return integers.stream().sorted(Comparator.naturalOrder()).mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{2, 1, 3, 4, 1})));
    }
}