package com.example.codingtest.lv1;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/42748
public class K번째수 {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int i = 0;
        for(int [] command : commands){
            int[] subArray = Arrays.stream(Arrays.copyOfRange(array, command[0]-1, command[1])).sorted().toArray();
            answer[i++] = subArray[command[2]-1];
        }
        return answer;
    }

    public static void main(String[] args) {
        try {
            System.out.println(Arrays.toString(solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1},{1, 7, 3}})));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
