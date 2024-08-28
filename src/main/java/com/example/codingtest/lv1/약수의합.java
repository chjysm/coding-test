package com.example.codingtest.lv1;
// https://school.programmers.co.kr/learn/courses/30/lessons/12928
public class 약수의합 {

    public static int solution(int n) {
        if(n == 0){
            return 0;
        }

        int answer = 0;
        int i = 1;

        int beforeNum = 0;
        while(true){

            if( n % i == 0 ){
                int m = n / i;
                if( beforeNum == i ){
                    break;
                }

                if( m == i ){
                    answer += i;
                    break;
                } else {
                    answer += i;
                    answer += m;
                }
                beforeNum = m;
            }


            i++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(4));
//        System.out.println(solution(4));
//        System.out.println(solution(5));
//        System.out.println(solution(6));
//        System.out.println(solution(7));
//        System.out.println(solution(8));
//        System.out.println(solution(9));
//        System.out.println(solution(10));

    }
}
