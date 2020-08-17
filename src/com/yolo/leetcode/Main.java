package com.yolo.leetcode;


public class Main {

    public static void main(String[] args) {
        //String s =  "2147483648";
        //int answer = LeetCode8.myAtoi(s);
        //test();
        int[] tes = {1,-2,234,543,-654,2,4,35,4,65,12,0};
        int[] result = LeetCode12.countSort(tes);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+ "    ");
        }

    }


}
