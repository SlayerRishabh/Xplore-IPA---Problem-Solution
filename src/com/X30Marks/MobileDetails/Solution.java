package com.X30Marks.MobileDetails;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MobileDetails m[] = new MobileDetails[5];
        for (int i=0; i<m.length; i++) {
            int a = sc.nextInt();sc.nextLine();
            int b = sc.nextInt();sc.nextLine();
            String c = sc.nextLine();
            boolean d = sc.nextBoolean();sc.nextLine();
            m[i] = new MobileDetails(a, b, c ,d);
        }
        String pB = sc.nextLine();

        int r1 = getTotalPrice(m, pB);
        if(r1 > 0) {
            System.out.println(r1);
        } else
            System.out.println("There are no mobile with given brand");

        MobileDetails r2[] = getSecondMin(m);
        if(r2 != null) {
//            System.out.println(r2.getBrand()+":"+r2.getPrice());
            for (int i=0; i<r2.length; i++) {
                System.out.println(r2[i].getBrand()+":"+r2[i].getPrice());
            }
        }
        else
            System.out.println("no proce avilable");
    }

    public static int getTotalPrice(MobileDetails m[], String pB) {
        int tp = 0;
        for (int i=0; i<m.length; i++) {
            if (m[i].getBrand().equalsIgnoreCase(pB)) {
                tp += m[i].getPrice();
            }
        }

        if(tp > 0)
            return tp;
        else
            return 0;
    }

    public static MobileDetails[] getSecondMin(MobileDetails m[]) {

        //Possibly this solution may not pass all the test cases
        MobileDetails temp = null;
        MobileDetails arr[] = new MobileDetails[0];

        //sorting m array
        for (int i=0; i<m.length-1; i++) {
            for (int j=i+1; j<m.length; j++) {
                if(m[i].getPrice() > m[j].getPrice()) {
                    temp = m[i];
                    m[i] = m[j];
                    m[j] = temp;
                }
            }
        }

        //Adding sec min obj in arr[]
        for (int i=0; i<m.length; i++) {
            if (m[0].getPrice() < m[i].getPrice()) {
                arr = Arrays.copyOf(arr, arr.length+1);
                arr[arr.length-1] = m[i];
                break;
            }
        }

        //Checking if there are other element who have same price, then sec min ele price which is stored in arr[0], if yes then add to arr[1], arr[2] ...
        //where ar arr[0] sec min ele is
        for (int j=0; j<m.length; j++) {
            if (arr[0].getPrice() == m[j].getPrice() && arr[0].getMobileId() != m[j].getMobileId()) {
                arr = Arrays.copyOf(arr, arr.length+1);
                arr[arr.length-1] = m[j];
            }
        }

        if(arr.length != 0)
            return arr;
        else
            return null;
    }
}

class MobileDetails {
    private int MobileId;
    private int Price;
    private String Brand;
    private boolean isFlagShip;

    public MobileDetails(int a, int b, String c, boolean d) {
        MobileId = a;
        Price = b;
        Brand = c;
        isFlagShip = d;
    }

    public String getBrand() {
        return Brand;
    }

    public int getPrice() {
        return Price;
    }

    public int getMobileId() {
        return MobileId;
    }

}