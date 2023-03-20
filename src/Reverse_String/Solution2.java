package Reverse_String;

import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        str = str.toLowerCase();
        StringBuffer sb = new StringBuffer(str);
//        sb.append(str);  do like this or pass string as argument in StringBuffer(str)
        System.out.println(sb.reverse());
    }
}
