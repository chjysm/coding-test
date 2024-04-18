package com.example.codingtest.lv0;

// https://school.programmers.co.kr/learn/courses/30/lessons/120875
public class 평행 {
    public static void main(String[] args) {
//        int[][] arr = {
//                {1, 4},
//                {9, 2},
//                {3, 8},
//                {11, 6}
//        };

        int[][] arr = {
                {10, 1},
                {9, 3},
                {2, 2},
                {4 ,4}
        };

        System.out.println(solution(arr));
    }
    public static int solution(int[][] dots) {
        for( int i = 0; i < dots.length; i++ ){

            int[] dot1 = dots[i];
            int[] dot2 = dots[(i + 1) % 4];
            int[] dot3 = dots[(i + 2) % 4];
            int[] dot4 = dots[(i + 3) % 4];

            double slope1 = (double) (dot1[0]-dot2[0]) / (double) (dot1[1]-dot2[1]);
            double slope2 = (double) (dot3[0]-dot4[0]) / (double) (dot3[1]-dot4[1]);

            if(slope1 == slope2){
                return 1;
            }
        }

        return 0;
    }
}
