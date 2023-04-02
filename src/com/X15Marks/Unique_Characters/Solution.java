package com.X15Marks.Unique_Characters;

import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        str = str.toLowerCase();
        String temp = "";

        for(int i=0; i<str.length(); i++) {
            if(!temp.contains(Character.toString(str.charAt(i)))) {
                temp += str.charAt(i);
            }
        }

        System.out.println(temp);
    }
}