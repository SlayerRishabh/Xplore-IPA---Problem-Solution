package Data_Transmission;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static int primeCpunt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ipStr = sc.nextLine();
        sc.close();

        ipStr = ipStr.replace(";","");

        String ipStrArray[] = ipStr.split(" ");

        int resultArray[] = new int[0];

        for (int i=0; i<ipStrArray.length; i++) {
            boolean result = checkPrime(Integer.parseInt(ipStrArray[i]));
            if (result) {
                resultArray = Arrays.copyOf(resultArray, resultArray.length+1);
                resultArray[resultArray.length-1] = Integer.parseInt(ipStrArray[i]);
                primeCpunt++;
            }
        }

        Arrays.sort(resultArray);
        System.out.println(resultArray[resultArray.length-2]+primeCpunt);

    }

    static boolean checkPrime(int n) {
        if (n == 2)
            return true;

        for(int i=2; i<Math.sqrt(n); i++) {
            if(n%i == 0) {
                return false;
            }
        }
        return true;
    }
}

