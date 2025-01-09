package com.example.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2798
public class 블랙잭 {

    public static int solution(String s){
        String[] row1 = s.split("\n");
        String[] row2 = row1[1].split(" ");
        int M = Integer.parseInt(row1[0].split(" ")[1]);

        int max = 0;
        for(int i =0; i< row2.length; i++){
            for(int j =i+1; j< row2.length; j++){
                for(int h =j+1; h< row2.length; h++){
                    int sum = Integer.parseInt(row2[i]) + Integer.parseInt(row2[j]) + Integer.parseInt(row2[h]);
                    if( sum <= M ){
                        max = Math.max(max, sum);
                    }
                }
            }
        }


        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        String tmp = "";
        while((tmp = br.readLine())!= null){
            str += tmp + "\n";
        }

        System.out.println( solution(str));
    }
}
