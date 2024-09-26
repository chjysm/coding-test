package com.example.codingtest.lv1;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/161990
public class 바탕화면정리 {
    public static int[] solution(String[] wallpaper) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = 0;
        int maxY = 0;

        for(int x = 0; x < wallpaper.length; x++){
            for(int y = 0; y < wallpaper[x].length(); y++){
                if(wallpaper[x].charAt(y) == '#'){
                    minX = Math.min(minX, x);
                    maxX = Math.max(maxX, x+1);
                    minY = Math.min(minY, y);
                    maxY = Math.max(maxY, y+1);
                }
            }
        }

        return new int[]{ minX, minY, maxX, maxY };
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{ "..........", ".....#....", "......##..", "...##.....", "....#....." })));
    }
}
