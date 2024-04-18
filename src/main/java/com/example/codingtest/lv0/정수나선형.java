package com.example.codingtest.lv0;

// https://school.programmers.co.kr/learn/courses/30/lessons/181832
public class 정수나선형 {
    private static int[][] target;
    private static int currentNum;
    private static int input;

    public static void main(String[] args) {
        solution(4);

        for(int i = 0; i<input; i++){
            for(int j=0;j<input;j++){
                System.out.println(target[i][j]);
            }
        }
    }

    public static int[][] solution(int n) {
        currentNum = 0;
        target = new int[n][n];
        input = n;
        
        xAxis(0,0,true);
        return target;
    }

    private static void xAxis(int yIndex, int xIndex, boolean isIncrement ){
        int lastIndex = 0;
        if( isIncrement ){
            for( int i = xIndex; ; i++ ){
                if( i > input - 1
                        ||target[yIndex][i] != 0){
                    lastIndex = i-1;
                    break;
                }
                target[yIndex][i] = ++currentNum;
            }

            if(currentNum >= input * input ){
                return;
            }

            yAxis( yIndex + 1, lastIndex, true);
        } else {
            for( int i = xIndex; ; i-- ){
                if( i < 0
                        || target[yIndex][i] != 0){
                    lastIndex = i+1;
                    break;
                }
                target[yIndex][i] = ++currentNum;
            }
            if(currentNum >= input * input ){
                return;
            }

            yAxis( yIndex - 1, lastIndex, false);
        }
    }
    private static void yAxis(int yIndex, int xIndex, boolean isIncrement ){
        int lastIndex = 0;
        if( isIncrement ){
            for(int i = yIndex; ; i++ ){
                if( i > input - 1
                        || target[i][xIndex] != 0){
                    lastIndex = i-1;
                    break;
                }

                target[i][xIndex] = ++currentNum;
            }
            if(currentNum >= input * input ){
                return;
            }
            xAxis( lastIndex, xIndex - 1, false);
        } else {
            for(int i = yIndex; ; i-- ){
                if( i < 0
                        || target[i][xIndex] != 0){
                    lastIndex = i+1;
                    break;
                }
                target[i][xIndex] = ++currentNum;
            }
            if(currentNum >= input * input ){
                return;
            }
            xAxis( lastIndex, xIndex + 1, true);
        }
    }
}
