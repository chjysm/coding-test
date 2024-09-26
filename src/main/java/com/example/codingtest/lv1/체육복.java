package com.example.codingtest.lv1;

import java.util.HashSet;
import java.util.Set;

// https://school.programmers.co.kr/learn/courses/30/lessons/42862
public class 체육복 {
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();

        for (int a :lost){
            lostSet.add(a);
        }

        for (int a :reserve){
            reserveSet.add(a);
        }
        Set<Integer> lostSet2 = new HashSet<>();
        for(int a:lost){
            if(reserveSet.contains(a)){
                reserveSet.remove(a);
                lostSet2.add(a);
                answer++;
            }
        }
        lostSet.removeAll(lostSet2);

        for(int a:lostSet){
            int left = a - 1;
            int right = a + 1;
            boolean isLeftExist = false;
            boolean isRightExist = false;
            if(reserveSet.contains(left)){
                isLeftExist = true;
            }
            if(reserveSet.contains(right)){
                isRightExist = true;
            }

            if( isLeftExist && isRightExist ){
                boolean isLeftExist2 = false;
                boolean isRightExist2 = false;

                if(lostSet.contains(a -  2)){
                    isLeftExist2 = true;
                }
                if(lostSet.contains(a +  2)){
                    isRightExist2 = true;
                }

                if(isLeftExist2 && isRightExist2){
                    reserveSet.remove(right);
                    answer++;
                }else if (isLeftExist2){
                    reserveSet.remove(right);
                    answer++;
                }else if (isRightExist2){
                    reserveSet.remove(left);
                    answer++;
                }else {
                    reserveSet.remove(left);
                    answer++;
                }
            } else if (isLeftExist){
                reserveSet.remove(left);
                answer++;
            } else if (isRightExist){
                reserveSet.remove(right);
                answer++;
            }
        }

        return answer ;
    }

    public static void main(String[] args) {
        System.out.println( solution(5, new int[]{1,2}, new int[]{2,3})); // 4
    }
}
