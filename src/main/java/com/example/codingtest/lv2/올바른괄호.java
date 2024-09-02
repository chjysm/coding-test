package com.example.codingtest.lv2;

import java.util.Stack;

// https://school.programmers.co.kr/learn/courses/30/lessons/12909
public class 올바른괄호 {
    static boolean solution(String s) {
        char[] charArray = s.toCharArray();
        int index = 0;
        Stack<Integer> a = new Stack<>();
        Stack<Integer> b = new Stack<>();
        for (char c : charArray){
            if(c == '('){
                a.push(index);
            } else {
                if(a.isEmpty()){
                    return false;
                }
                a.pop();
                if(a.isEmpty()){
                    b.clear();
                } else {
                    b.push(index);
                }


            }
            index++;
        }

        return a.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(solution("((()()))"));
    }
}
