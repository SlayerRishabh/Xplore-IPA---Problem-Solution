package com.X30Marks.Newspaper;

import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Newspaper n[] = new Newspaper[4];
        for(int i=0; i<n.length; i++) {
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();sc.nextLine();
            int d = sc.nextInt();sc.nextLine();
            n[i] = new Newspaper(a, b, c, d);
        }

        int pPublicationYear = sc.nextInt();sc.nextLine();
        String pName = sc.nextLine();
        sc.close();

        int r1 = findTotalPriceByPublicationYear(n, pPublicationYear);
        if(r1 > 0)
            System.out.println(r1);
        else
            System.out.println("No Newspaper found with the mentioned attribute");

        Newspaper r2 = searchNewspaperByName(n, pName);
        if(r2 != null) {
            System.out.println("regNo-"+r2.getRegNo());
            System.out.println("name-"+r2.getName());
            System.out.println("publicationYear-"+r2.getPublicationYear());
            System.out.println("price-"+r2.getPrice());
        } else
            System.out.println("No Newspaper found with the given name.");
    }

    public static int findTotalPriceByPublicationYear(Newspaper n[], int pPublicationYear) {
        int tp = 0;
        for(int i=0; i<n.length; i++) {
            if(n[i].getPublicationYear() == pPublicationYear) {
                tp += n[i].getPrice();
            }
        }

        if(tp > 0)
            return tp;

        else
            return 0;
    }

    public static Newspaper searchNewspaperByName(Newspaper n[], String pName) {
        for(int i=0; i<n.length; i++) {
            if(n[i].getName().equalsIgnoreCase(pName)) {
                return n[i];
            }
        }

        return null;
    }

}

class Newspaper {
    private int regNo;
    private String name;
    private int publicationYear;
    private int price;

    public Newspaper(int a, String b, int c, int d) {
        regNo = a;
        name = b;
        publicationYear= c;
        price = d;
    }

    public int getRegNo() {
        return regNo;
    }

    public String getName() {
        return name;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public int getPrice() {
        return price;
    }

}
