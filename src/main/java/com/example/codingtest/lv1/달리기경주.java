package com.example.codingtest.lv1;

import java.util.HashMap;

// https://school.programmers.co.kr/learn/courses/30/lessons/178871?language=java
public class 달리기경주 {
    private static final String[] players = {"mumu", "soe", "poe", "kai", "mine"};
    private static final String[] callings = {"kai", "kai", "mine", "mine"};

    public static void main(String[] args) {

        String[] answer = new String[players.length];
        HashMap<String, Integer> map = new HashMap<>();
        int i =0;
        for(String s:players){
            map.put(s, i++);
        }


        for(String s : callings){
            Integer index = map.get(s);
            String s1 = players[index - 1];
            players[index-1] = s;
            players[index] = s1;

            map.put(s, index-1);
            map.put(s1,index);
        }

        map.forEach( (k,v) -> {
            answer[v] = k;
        });

    }
}
