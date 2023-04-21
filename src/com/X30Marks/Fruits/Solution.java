package com.X30Marks.Fruits;

import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Fruits f[] = new Fruits[4];
        for(int i=0; i<f.length; i++) {
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();sc.nextLine();
            int d = sc.nextInt();sc.nextLine();

            f[i] = new Fruits(a, b, c, d);
        }

        int pR = sc.nextInt();sc.nextLine();

        Fruits r = findMaximumPriceByRating (f, pR);
        if(r != null) {
            System.out.println(r.getFruitId());
        } else {
            System.out.println("No such Fruit");
        }


    }

    public static Fruits findMaximumPriceByRating (Fruits f[], int pR) {
        int max = Integer.MIN_VALUE;
        int count = 0;
        for(int i=0; i<f.length; i++) {
            if(f[i].getRating() > pR) {
                if(f[i].getPrice() > max) {
                    max = f[i].getPrice();
                    count = i;
                }
            }
        }

        if(max == Integer.MIN_VALUE) {
            return null;
        } else {
            return f[count];
        }
    }

}

class Fruits {
    private int fruitId;
    private String fruitName;
    private int price;
    private int rating;

    public Fruits(int fruitId, String fruitName, int price, int rating) {
        this.fruitId = fruitId;
        this.fruitName = fruitName;
        this.price = price;
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public int getPrice() {
        return price;
    }

    public int getFruitId() {
        return fruitId;
    }
}