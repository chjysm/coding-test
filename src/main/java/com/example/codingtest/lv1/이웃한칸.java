package com.example.codingtest.lv1;

// https://school.programmers.co.kr/learn/courses/30/lessons/250125
public class 이웃한칸 {
    public static int solution(String[][] board, int h, int w) {
        String color = board[h][w];
        int count = 0;

        // up
        if( h - 1 >= 0 ){
            if( color.equals( board[h-1][w] ) ){
                count++;
            }
        }
        // down
        if( h + 1 <= board.length - 1 ){
            if( color.equals( board[h + 1][w] ) ){
                count++;
            }
        }
        // left
        if( w - 1 >= 0 ){
            if( color.equals( board[h][w - 1] ) ){
                count++;
            }
        }
        // right
        if( w + 1 <= board[0].length - 1 ){
            if( color.equals( board[h][w + 1] ) ){
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        try {
            System.out.println(solution( new String[][]{ {"blue", "red", "orange", "red"}, {"red", "red", "blue", "orange"}, {"blue", "orange", "red", "red"}, {"orange", "orange", "red", "blue"}}, 1,1 ) );
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
