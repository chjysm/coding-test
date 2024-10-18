package com.example.codingtest.lv1;

// https://school.programmers.co.kr/learn/courses/30/lessons/250137?language=java
public class 붕대감기 {

    public static int solution(int[] bandage, int health, int[][] attacks) {
        int attackIndex = 0;
        int countBandage = 0;
        final int MAX_HEALTH = health;
        for(int t =0; t<=attacks[attacks.length-1][0]; t++){

            // 공격 받음
            if( t == attacks[attackIndex][0] ){
                health -= attacks[attackIndex][1];
                attackIndex++;
                countBandage = 0;
            } else {
                if(countBandage == bandage[0]){
                    health += bandage[1]+bandage[2];
                    countBandage = 0;
                } else {
                    health += bandage[1];
                }
            }

            if(health > MAX_HEALTH){
                health = MAX_HEALTH;
            }

            if(health <= 0){
                return -1;
            }

            countBandage++;
        }

        return health;
    }

    public static void main(String[] args) {
        System.out.println( solution( new int[]{3, 2, 7}, 20, new int[][]{{1, 15}, {5, 16}, {8, 6}} ) );
    }
}
