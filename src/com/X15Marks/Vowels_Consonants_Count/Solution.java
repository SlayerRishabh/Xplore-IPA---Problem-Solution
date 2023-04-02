package com.X15Marks.Vowels_Consonants_Count;

import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();

        int c=0, v=0;

        str = str.toLowerCase();

//        char ch[] = str.toCharArray();

        for(int i=0; i<str.length(); i++) {
//            if(!Character.isDigit(ch[i])) {
//                if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
//                    v++;
//                } else
//                    c++;
//            }

            if(str.charAt(i)>='a' && str.charAt(i)<='z') {
                if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
                    v++;
                } else
                    c++;
            }
        }

        System.out.println("Vowels count : "+v);
        System.out.println("Vowels count : "+c);

    }
}