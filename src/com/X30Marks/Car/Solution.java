package com.X30Marks.Car;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Car c[] = new Car[5];
        for (int i=0; i<c.length; i++) {
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            String cc = sc.nextLine();
            c[i] = new Car(a, b, cc);
        }

        int pId = sc.nextInt();sc.nextLine();
        sc.close();

        Car r[] = RemoveAndRearrange(c, pId);
        if(r != null) {
            for (int i=0; i<r.length; i++) {
                System.out.println(r[i].getCarId()+":"+r[i].getCarName());
            }
        } else {
            System.out.println("There are no car with given id");
        }
    }

    public static Car[] RemoveAndRearrange(Car c[], int pId) {
        Car r[] = new Car[0];
        for (int i=0; i<c.length; i++) {
            if (c[i].getCarId() != pId) {
                r = Arrays.copyOf(r, r.length+1);
                r[r.length-1] = c[i];
            }
        }

        if(r.length != 0)
            return r;
        else
            return null;
    }
}

class Car {
    private int carId;
    private String carName;
    private String fuelType;

    public Car(int a, String b, String c) {
        carId = a;
        carName = b;
        fuelType = c;
    }

    public int getCarId() {
        return carId;
    }
    public String getCarName() {
        return carName;
    }
}
