package com.example.codingtest.lv1;

// https://school.programmers.co.kr/learn/courses/30/lessons/340199
public class 지폐접기 {
    public static int solution(int[] wallet, int[] bill) {
        int i = 0;

        int walletX = wallet[0];
        int walletY = wallet[1];
        int bigger = bill[0];
        int smaller = bill[1];
        while (true){
            if( bigger < smaller ){
                int imsi = bigger;
                bigger = smaller;
                smaller = imsi;
            }

            if( bigger <= walletX || bigger <= walletY ){
                if( ( bigger <= walletX && smaller <= walletY )
                    || ( bigger <= walletY && smaller <= walletX )
                ){
                    return i;
                }
            }

            bigger = bigger/2;

            i++;
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println(solution(new int[]{50,50}, new int[]{100,241}));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
