package Character_At_Odd_Position;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ipStr = sc.nextLine();
        sc.close();

        char result[] = ipStr.toCharArray();

        for (int i = 1; i < result.length; i=i+2) {
            System.out.print(result[i]);
        }
    }
}
