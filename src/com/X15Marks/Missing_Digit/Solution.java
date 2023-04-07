package com.X15Marks.Missing_Digit;

import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[8];
        for(int i=0; i<arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        /*int num;
        for (int i=0; i<arr.length-1; i++) {
            num = arr[i];
            while (num+1 != arr[i+1]) {
                System.out.println(num+1+" ");
                num++;
            }
        }*/

        //Using new Array
        // (Same concept but different is we are making new arrays and storing missing values' int it and printing it)

        int ans[] = new int[0];

        for (int i=0; i< arr.length-1; i++) {
            int num = arr[i];
            while (num+1 != arr[i+1]) {
                ans = Arrays.copyOf(ans, ans.length+1);
                ans[ans.length-1] = num+1;
                num++;
            }
        }

        for (int i=0; i< ans.length; i++) {
            System.out.println(ans[i]);
        }



    }
}
