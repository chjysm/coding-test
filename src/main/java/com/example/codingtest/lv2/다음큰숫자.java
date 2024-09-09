package com.example.codingtest.lv2;
// https://school.programmers.co.kr/learn/courses/30/lessons/12911
public class 다음큰숫자 {

    public static int solution(int n) {
        String binaryString = Integer.toBinaryString(n);
        int count = getCount(binaryString);

        int i = n+1;
        while (count != getCount(Integer.toBinaryString(i))) {
            i++;
        }

        return i;
    }

    private static int getCount(String binaryString) {
        int count = 0;
        System.out.println(binaryString);
        for(int i = 0; i < binaryString.length(); i++){
            if(binaryString.charAt(i) == '1' ){
                count++;
            }
        }
        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(78));
    }
}
