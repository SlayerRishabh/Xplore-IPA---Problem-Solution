package com.X30Marks.Engine;

import java.util.*;
public class MyClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Engine e[] = new Engine[4];
        for(int i=0; i<e.length; i++) {
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            double d = sc.nextDouble();sc.nextLine();

            e[i] = new Engine(a, b, c, d);
        }

        String pType = sc.nextLine();
        String pName = sc.nextLine();

        double r1 = findAvgEnginePriceByType(e, pType);
        if(r1 > 0) {
            System.out.println(r1);
        } else {
            System.out.println("There are no engine with given type");
        }

        Engine r2[] = searchEngineByName(e, pName);
        if(r2 != null) {
            for(int i=0; i<r2.length; i++) {
                System.out.println(r2[i].getEngineld());
            }
        } else {
            System.out.println("There are no engine with the given name");
        }


    }

    public static double findAvgEnginePriceByType(Engine e[], String pType) {
        double count = 0;
        double price = 0;
        for(int i=0 ;i<e.length; i++) {
            if(e[i].getType().equalsIgnoreCase(pType)) {
                price = e[i].getEnginePrice();
                count++;
            }
        }

        if(count > 0) {
            double avg = price / count;
            return avg;
        } else {
            return 0;
        }

    }

    public static Engine[] searchEngineByName(Engine e[], String pName) {
        Engine temp = null;
        Engine r[] = new Engine[0];

        for(int i=0 ;i<e.length; i++) {
            if(e[i].getEngineName().equalsIgnoreCase(pName)) {
                r = Arrays.copyOf(r, r.length+1);
                r[r.length-1] = e[i];
            }
        }

        if(r.length > 0) {
            for(int i=0; i<r.length; i++) {
                for(int j=i+1; j<r.length; j++) {
                    if(r[i].getEngineld() > r[j].getEngineld()) {
                        temp = r[i];
                        r[i] = r[j];
                        r[j] = temp;
                    }
                }
            }
        }

        if(r.length > 0) {
            return r;
        } else {
            return null;
        }
    }


}

class Engine {
    private int engineld;
    private String engineName;
    private String engineType;
    private double enginePrice;

    public Engine(int engineld, String engineName, String engineType, double enginePrice) {
        this.engineld = engineld;
        this.engineName = engineName;
        this.engineType = engineType;
        this.enginePrice = enginePrice;
    }

    public String getType() {
        return engineType;
    }

    public double getEnginePrice() {
        return enginePrice;
    }

    public int getEngineld() {
        return engineld;
    }

    public String getEngineName() {
        return engineName;
    }

}