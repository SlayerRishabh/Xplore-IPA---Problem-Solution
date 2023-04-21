package com.X30Marks.Vegetable;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vegetable v[] = new Vegetable[4];
        for (int i=0; i<v.length; i++) {
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();sc.nextLine();
            int d = sc.nextInt();sc.nextLine();

            v[i] = new Vegetable(a, b, c, d);
        }

        int pR = sc.nextInt();sc.nextLine();

        Vegetable r = findMinimumPriceByRating(v, pR);
        if (r != null) {
            System.out.println(r.getVegetableId());
        } else
            System.out.println("No such Vegetables");
    }

    public static Vegetable findMinimumPriceByRating(Vegetable v[], int pR) {
        int min = Integer.MAX_VALUE;
        int minID = 0;

        for (int i=0; i<v.length; i++) {
            if (v[i].getRating() > pR) {
                if (v[i].getPrice() < min) {
                    min = v[i].getPrice();
                    minID = i;
                }
            }
        }

        if (min != Integer.MAX_VALUE) {
            return v[minID];
        } else
            return null;
    }
}

class Vegetable {
    private int VegetableId;
    private String VegetableName;
    private int Price;
    private int Rating;

    public Vegetable(int vegetableId, String vegetableName, int price, int rating) {
        VegetableId = vegetableId;
        VegetableName = vegetableName;
        Price = price;
        Rating = rating;
    }

    public int getVegetableId() {
        return VegetableId;
    }

    public String getVegetableName() {
        return VegetableName;
    }

    public int getPrice() {
        return Price;
    }

    public int getRating() {
        return Rating;
    }
}