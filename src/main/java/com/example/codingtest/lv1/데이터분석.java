package com.example.codingtest.lv1;

import java.util.Arrays;
import java.util.Comparator;

public class 데이터분석 {
    public static int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int extIndex = getColumnNameToIndex(ext);
        int sortIndex = getColumnNameToIndex(sort_by);

        return Arrays.stream(data)
                .filter( a -> a[extIndex] < val_ext )
                .sorted(Comparator.comparingInt( a -> a[sortIndex]))
                .toArray(int[][]::new);
    }
    public static int getColumnNameToIndex(String columnName){
        switch (columnName){
            case "code":
                return 0;
            case "date":
                return 1;
            case "maximum":
                return 2;
            case "remain":
                return 3;
            default:
                return 999999;
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println(Arrays.toString(solution(new int[][]{{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 99}}, "date", 20300501, "remain")));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
