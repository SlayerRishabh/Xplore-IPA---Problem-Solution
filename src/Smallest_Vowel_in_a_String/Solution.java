package Smallest_Vowel_in_a_String;

import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str =     sc.nextLine();

        String vowel[] = {"a", "e", "i", "o", "u"};

        for(int i=0; i<vowel.length; i++) {
            if(str.contains(vowel[i])) {
                System.out.println(vowel[i]);
                break;
            }
        }
    }
}