package com.example.codingtest.lv1;

// https://school.programmers.co.kr/learn/courses/30/lessons/131128
// 실패...
public class 숫자짝궁 {
    public static String solution(String X, String Y) {
        int[] x_cnt = new int[10];
        int[] y_cnt = new int[10];

        for (int i = 0; i<X.length(); i++) {
            x_cnt[X.charAt(i)-'0']++;
        }

        for (int i = 0; i<Y.length(); i++) {
            y_cnt[Y.charAt(i)-'0']++;
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 9; i>=0; i--) {
            if (x_cnt[i] == 0 || y_cnt[i] == 0) {
                continue;
            }
            int min = 0;
            if (y_cnt[i] < x_cnt[i]) {
                min = y_cnt[i];
            }
            else {
                min = x_cnt[i];
            }
            for (int j = 0; j<min; j++) {
                answer.append(i);
            }
        }
        if ((answer.toString()).equals("")) {
            return "-1";
        }

        if ((answer.toString()).charAt(0) == '0') {
            return "0";
        }

        return (answer.toString());



//        StringBuilder sb = new StringBuilder();
//                .forEach(o -> {
//                    if(i == 0 && o.equals("0")){
//                    }
//                })
//        ;
//
//
//        for(int i = 0; i < list.size(); i++){
//            if(i == 0 && list.get(i).equals("0")){
//                return "0";
//            }
//            sb.append(list.get(i));
//        }
//
//        return sb.toString();
    }

    public static void main(String[] args) {
        try {
            System.out.println(solution("12345678912345678912345789","123456"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
