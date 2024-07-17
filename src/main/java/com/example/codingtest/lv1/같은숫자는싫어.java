package com.example.codingtest.lv1;

import java.util.ArrayList;
import java.util.List;

public class 같은숫자는싫어 {

    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1};
        List<Integer> result = new ArrayList<>();
        result.add(0, arr[0]);
        int index = 0;
        for(int i = 1; i < arr.length; i++) {
            if(result.get(index) != arr[i]){
                result.add(++index, arr[i]);
            }
        }
        Integer[] array = result.toArray(new Integer[0]);
    }
}
