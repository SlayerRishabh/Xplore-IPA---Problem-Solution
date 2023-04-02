package com.X15Marks.Last_Character_In_Every_Word;

import java.util.*;
public class Solution  {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        String inStr = sc.nextLine();
        char chara[] = inStr.toCharArray();

        for(int i=0; i<chara.length; i++) {
            if(Character.isWhitespace(chara[i]) && !Character.isDigit(chara[i-1]) && !Character.isWhitespace(chara[i-1]))
                System.out.print(chara[i-1]);
            else if(i == chara.length-1 && !Character.isDigit(chara[i]))
                System.out.println(chara[i]);
        }
    }
}