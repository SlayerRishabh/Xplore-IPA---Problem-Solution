package com.X30Marks.Footwear;

import java.util.*;
public class footwearProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Footwear f[] = new Footwear[5];
        for(int i=0; i<f.length; i++) {
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();sc.nextLine();
            f[i] = new Footwear(a, b, c, d);
        }

        String pFt = sc.nextLine();
        String pFn = sc.nextLine();

        int r1 = getCountByType(f, pFt);
        if(r1 > 0) {
            System.out.println(r1);
        } else {
            System.out.println("Footwear not available");
        }

        Footwear r2 = getSecondHighestPriceByBrand(f, pFn);
        if(r2 != null) {
            System.out.println(r2.getPrice());
        } else {
            System.out.println("Brand not available");
        }
    }

    public static int getCountByType(Footwear f[], String pFt) {
        int count = 0;
        for(int i=0; i<f.length; i++) {
            if(f[i].getFootwearType().equalsIgnoreCase(pFt)) {
                count++;
            }
        }

        if(count > 0) {
            return count;
        } else {
            return 0;
        }
    }

    public static Footwear getSecondHighestPriceByBrand(Footwear f[], String pFn) {
        Footwear temp = null;

        Footwear r[] = new Footwear[0];
        for(int i=0; i<f.length; i++) {
            if(f[i].getFootwearName().equalsIgnoreCase(pFn)) {
                r = Arrays.copyOf(r, r.length+1);
                r[r.length-1] = f[i];
            }
        }

        //Sorting

        for(int i=0; i<r.length; i++) {
            for(int j=i+1; j<r.length; j++) {
                if(r[i].getPrice() < r[j].getPrice()) {
                    temp = r[i];
                    r[i] = r[j];
                    r[j] = temp;
                }
            }
        }

        if(r.length != 0) {
            return r[1];
        } else {
            return null;
        }
    }
}

class Footwear {
    private int footwearId;
    private String footwearName;
    private String footwearType;
    private int price;

    public Footwear (int footwearId, String footwearName, String footwearType, int price) {
        this.footwearId = footwearId;
        this.footwearName = footwearName;
        this.footwearType = footwearType;
        this.price = price;
    }

    public String getFootwearType() {
        return footwearType;
    }

    public String getFootwearName() {
        return footwearName;
    }

    public int getPrice() {
        return price;
    }
}
