package com.example.codingtest.lv2;

import java.util.*;

public class 전력망을둘로나누기 {

    private static final Map<Integer,Integer> nodeCountMap = new HashMap<>();
    private static final Map<Integer, Set<Integer>> nodeLinkMap = new HashMap<>();

    public static void main(String[] args) {
        int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};

        System.out.println(solution(n,wires));
    }
    public static int solution(int n, int[][] wires) {
        int answer = -1;

        for( int i = 1; i <= n; i++ ){
            int count = 0;
            for( int[] wire : wires ){
                int node1 = wire[0];
                int node2 = wire[1];

                if(i == node1 || i == node2){
                    nodeLinkMap.computeIfAbsent(i, k -> new HashSet<>());
                    if(i == node1){
                        nodeLinkMap.get(i).add(node2);
                    } else {
                        nodeLinkMap.get(i).add(node1);
                    }
                    count++;
                }
            }
            nodeCountMap.put(i,count);
        }

        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++ ){
            for(int linkNode : nodeLinkMap.get(i)){
                Set<Integer> topHis = new HashSet<>();
                Set<Integer> linkHis = new HashSet<>();
                topHis.add(i);
                topHis.add(linkNode);
                linkHis.add(i);
                linkHis.add(linkNode);
                int topCount = getCount(topHis,i, 1);
                int linkCount = getCount(linkHis,linkNode,1);

                int abs = Math.abs(topCount - linkCount);
                if(min > abs){
                    min = abs;
                }
            }
        }

        return min;
    }

    private static int getCount(Set<Integer> his, int node, Integer count ){

        for ( int linkNode : nodeLinkMap.get(node) ){
            if(his.contains(linkNode)){
                continue;
            }
            his.add(linkNode);
            count = getCount(his,linkNode,++count);
        }
        return count;
    }
}
