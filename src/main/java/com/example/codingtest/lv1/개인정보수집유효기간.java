package com.example.codingtest.lv1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/150370
public class 개인정보수집유효기간 {

    public static int[] solution(String today, String[] terms, String[] privacies) {

        LocalDate todayDate = LocalDate.parse(today, DateTimeFormatter.ofPattern("yyyy.MM.dd"));

        Map<String, Integer> termsMap = new HashMap<>();
        for(String term:terms){
            String[] s = term.split(" ");
            termsMap.put(s[0], Integer.parseInt(s[1]));
        }

        int i = 1;
        List<Integer> result = new ArrayList<>();
        for( String privacie: privacies){
            String[] s = privacie.split(" ");
            LocalDate date = LocalDate.parse(s[0], DateTimeFormatter.ofPattern("yyyy.MM.dd"));
            int term = termsMap.get(s[1]);

            if( date.plusMonths(term).isEqual(todayDate)
                || date.plusMonths(term).isBefore(todayDate) ){
                result.add(i);
            }

            i++;
        }

        return result.stream().mapToInt(io->io).toArray();
    }

    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        System.out.println(Arrays.toString(solution(today, terms, privacies)));
    }
}
