package com.X30Marks.Flowers;

import java.util.*;
public class MyClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Flowers f[] = new Flowers[4];
        for(int i=0; i<f.length; i++) {
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();sc.nextLine();
            int d = sc.nextInt();sc.nextLine();
            String e = sc.nextLine();

            f[i] = new Flowers(a, b, c, d, e);
        }

        String pType = sc.nextLine();

        Flowers r = findMinPriceByType(f, pType);
        if(r != null) {
            System.out.println(r.getFlowerId());
        } else {
            System.out.println("There is no flower with given type");
        }

    }

    public static Flowers findMinPriceByType(Flowers f[], String pType) {
        Flowers temp = null;

        Flowers r[] = new Flowers[0];
        for (int i=0 ;i<f.length; i++) {
            if(f[i].getType().equalsIgnoreCase(pType) && f[i].getRating() > 3) {
                r = Arrays.copyOf(r, r.length+1);
                r[r.length-1] = f[i];
            }
        }

        if(r.length > 0) {
            for(int i=0; i<r.length; i++) {
                for(int j=i+1; j<r.length; j++) {
                    if(r[i].getPrice() > r[j].getPrice()) {
                        temp = r[i];
                        r[i] = r[j];
                        r[j] = temp;
                    }
                }
            }
        }

        if(r.length > 0) {
            return r[0];
        } else {
            return null;
        }
    }


}

class Flowers {
    private int flowerId;
    private String flowerName;
    private int price;
    private int rating;
    private String type;

    public Flowers(int flowerId, String flowerName, int price, int rating, String type) {
        this.flowerId = flowerId;
        this.flowerName = flowerName;
        this.price = price;
        this.rating = rating;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public int getRating() {
        return rating;
    }

    public int getFlowerId() {
        return flowerId;
    }


}