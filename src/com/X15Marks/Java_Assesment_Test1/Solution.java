package com.X15Marks.Java_Assesment_Test1;

import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[5];
        for(int i=0; i<arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int l1 = sc.nextInt();
        int l2 = sc.nextInt();

        int count = 0;
        int sum = 0;
        for(int j = 0; j<arr.length; j++) {
            if(arr[j]>l1 && arr[j] <l2) {
                sum += arr[j];
                count++;
            }
        }

        int avg = sum/count;

        System.out.println(avg);
    }
}

