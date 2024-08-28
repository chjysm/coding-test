package com.example.codingtest.lv3;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/43105
public class 정수삼각형 {

    private static final int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

    // 내 오답... 속도가 안나온다
    public static int solution() {
        int answer = 0;

        int num = triangle[0][0];
        int row = 1;
        int beforeIndex = 0;

        answer = sum(num, row, beforeIndex);

        return answer;
    }

    private static int sum(int sum, int row, int beforeIndex) {
        System.out.println(sum+ " : " + row +" : "  +  beforeIndex );
        if( row > triangle.length - 1 ){
            return sum;
        }

        int left = beforeIndex;
        int right = beforeIndex + 1;

        int leftSum = sum(sum + triangle[row][left], row + 1, left);
        int rightSum = sum(sum + triangle[row][right], row + 1, right );

        return Math.max(leftSum, rightSum);
    }

    public static void main(String[] args) {
        System.out.println(solution());
    }

    // 이게 정답.....
    // 동적으로 경우의 수를 압축한다.
    public int solution(int[][] triangle) {
        for (int i = 1; i < triangle.length; i++) {
            triangle[i][0] += triangle[i-1][0];
            triangle[i][i] += triangle[i-1][i-1];
            for (int j = 1; j < i; j++)
                triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
        }

        return Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
    }
}
