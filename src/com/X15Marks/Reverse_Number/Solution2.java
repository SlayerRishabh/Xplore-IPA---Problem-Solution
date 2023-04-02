package com.X15Marks.Reverse_Number;

import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        StringBuffer sb = new StringBuffer();
        sb = sb.append(a);
        System.out.println(sb.reverse());
    }
}
