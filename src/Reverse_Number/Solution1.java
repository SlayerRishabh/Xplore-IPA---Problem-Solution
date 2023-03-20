package Reverse_Number;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        sc.close();

        if(a == 0)
            System.out.println(0);
        else {
            while (a != 0) {
                System.out.print(a%10);
                a /= 10;
            }
        }
    }
}
