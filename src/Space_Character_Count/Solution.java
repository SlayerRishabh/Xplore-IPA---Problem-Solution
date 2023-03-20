package Space_Character_Count;

import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        int char_count = 0,space = 0;
        char ch[] = str.toCharArray();

        for(int i=0; i<str.length(); i++) {
            if(Character.isWhitespace(ch[i])) {
                space++;
                continue;
            } else if (!Character.isDigit(ch[i])) {
                char_count++;
            }
        }

        System.out.println("No of Spaces : "+space+" and characters : "+char_count);
    }
}
