package com.X15Marks.Reverse_String;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        str = str.toLowerCase();
        char strArr[] = str.toCharArray();
        for(int i = strArr.length-1; i>=0; i--)
            System.out.print(strArr[i]);
    }
}
