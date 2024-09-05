package com.example.codingtest.lv2;

public class JadenCase문자열만들기 {
    public static String solution(String s) {
        String[] sArray = s.split(" ");
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for(String s1: sArray){
            i++;
            String lowerCase = s1.toLowerCase();
            if(lowerCase.isEmpty()){
                sb.append(" ");
                continue;
            }
            String substring = lowerCase.substring(0, 1);
            String upperCase = substring.toUpperCase();
            sb.append(upperCase).append(lowerCase.substring(1));
            if( i != sArray.length ){
                sb.append( " " );
            }
        }
        if(s.charAt(s.length()-1) == ' '){
            sb.append( " " );
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        try {

        System.out.println(solution(" 3people Unfollowed Me u u u uu 3uu a s w3 "));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
