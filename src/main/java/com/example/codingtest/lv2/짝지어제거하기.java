package com.example.codingtest.lv2;

import java.util.Stack;

// https://school.programmers.co.kr/learn/courses/30/lessons/12973
public class 짝지어제거하기 {
    public static int solution(String s)
    {
        char[] charArray = s.toCharArray();
        Stack<Character> characters = new Stack<>();
        for(char a : charArray){
            if( characters.isEmpty()
                    || characters.lastElement() != a
            ){
                characters.push(a);
            } else {
                characters.pop();
            }
        }

        if(characters.isEmpty()){
            return 1;
        }else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution("cdcddcdcccccccccccccccccccccc"));
    }
}
