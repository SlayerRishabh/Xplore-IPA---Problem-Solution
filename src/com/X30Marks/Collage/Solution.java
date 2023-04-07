package com.X30Marks.Collage;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Collage c[] = new Collage[4];
        for (int i=0; i<c.length; i++) {
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            int cc = sc.nextInt();sc.nextLine();
            String d = sc.nextLine();
            int e = sc.nextInt();sc.nextLine();

            c[i] = new Collage(a, b, cc, d, e);
        }

        String pAdd = sc.nextLine();

        Collage r1 = findCollegeWithMaximumPincode(c);
        if (r1 != null) {
            System.out.println("id-"+r1.getId());
            System.out.println("name-"+r1.getName());
            System.out.println("contactNo-"+r1.getContactNo());
            System.out.println("addrss-"+r1.getAddress());
            System.out.println("pincode-"+r1.getPincode());
        } else {
            System.out.println("No college found with mentioned attribute");
        }

        Collage r2 = searchCollegeByAddress(c, pAdd);
        if (r2 != null) {
            System.out.println("id-"+r2.getId());
            System.out.println("name-"+r2.getName());
            System.out.println("contactNo-"+r2.getContactNo());
            System.out.println("addrss-"+r2.getAddress());
            System.out.println("pincode-"+r2.getPincode());
        } else {
            System.out.println("No college found with mentioned attribute");
        }
    }

    public static Collage findCollegeWithMaximumPincode (Collage c[]) {
        int objId = 0;
        int max = Integer.MIN_VALUE;
        for (int i=0; i<c.length; i++) {
            if (c[i].getPincode() > max) {
                max = c[i].getPincode();
                objId = i;
            }
        }

        if (objId > Integer.MIN_VALUE) {
            return c[objId];
        } else {
            return null;
        }

    }


    public static Collage searchCollegeByAddress(Collage c[], String pAdd) {
        for (int i=0; i< c.length; i++) {
            if (c[i].getAddress().equalsIgnoreCase(pAdd)) {
                return c[i];
            }
        }
        return null;
    }
}

class Collage {
    private int id;
    private String name;
    private int contactNo;
    private String address;
    private int pincode;

    public Collage(int id, String name, int contactNo, String address, int pincode) {
        this.id = id;
        this.name = name;
        this.contactNo = contactNo;
        this.address = address;
        this.pincode = pincode;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getContactNo() {
        return contactNo;
    }

    public String getAddress() {
        return address;
    }

    public int getPincode() {
        return pincode;
    }
}
