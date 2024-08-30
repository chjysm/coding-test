package com.example.codingtest.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/172928
public class 공원산책 {

    private static final String[] park = {"XSX", "XXX", "XXX"};
    private static final String[] routes = {"E 1", "N 1", "W 1", "W 5"};

    public static int[] solution(String[] park, String[] routes) {
        int[] answer = {};

        int x = 0;
        int y = 0;
        int index = 0;
        List<String> blockList = new ArrayList<>();
        for(String s : park){
            if( s.contains("S") ){
                x = s.indexOf("S");
                y = index;
            }

            if( s.contains("X") ){
                int i = 0;
                while (true){
                    int i1 = s.indexOf("X", i);
                    if(i1 < 0){
                        break;
                    }
                    blockList.add(i1+ " " + index);
                    i = i1+1;
                }
            }

            index++;
        }

        for(String route : routes){
            String direction = route.split(" ")[0];
            int count = Integer.parseInt(route.split(" ")[1]);

            int goX = x;
            int goY = y;
            switch (direction){
                case "E":
                    goX = x + count;
                    break;
                case "W":
                    goX = x - count;
                    break;
                case "S":
                    goY = y + count;
                    break;
                case "N":
                    goY = y - count;
                    break;
            }

            if(!validate( park, blockList, x, y, goX, goY)){
                continue;
            }

            x = goX;
            y = goY;
        }
        System.out.println(x);
        System.out.println(y);
        return new int[]{y,x};
    }

    private static boolean validate(
            String[] park,
            List<String> blockList,
            int x, int y,
            int goX, int goY
    ){
        // 1. 공원 넘어가는지 확인
        if( park[0].length() < goX + 1
                || park.length < goY + 1
                || goX < 0
                || goY < 0
        ){
            return false;
        }

        // 2. 장애물 만나는지 확인
        if( x != goX ){
            int start = Math.min(x, goX);
            int end = Math.max(x, goX);

            for(int i = start; i <= end ;i++){
                if( blockList.contains(i + " " + y) ){
                    return false;
                }
            }
        } else {
            int start = Math.min(y, goY);
            int end = Math.max(y, goY);

            for(int i = start; i <= end ;i++){
                if( blockList.contains(x + " " + i) ){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(park, routes)));
    }
}
