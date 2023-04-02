package com.X15Marks.Perfect_Square;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        double r = Math.sqrt(a);
        if((int) r == r)
            System.out.println("TRUE");
        else
            System.out.println("FALSE");
    }
}
