package com.example.codingtest.lv2;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/42842
public class 카펫 {

    public static int[] solution(int brown, int yellow) {
        int[] answer = {};

        for(int i = 1; i <= yellow; i++){
            int height = i;
            if( yellow % height != 0 ){
                continue;
            }

            int width = yellow/height;
            if( width < height ){
                break;
            }

            if( (((width-1)+(height-1)) * 2 + 8) == brown){
                answer = new int[]{width + 2, height + 2};
                break;
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(24, 24)));
    }
}
