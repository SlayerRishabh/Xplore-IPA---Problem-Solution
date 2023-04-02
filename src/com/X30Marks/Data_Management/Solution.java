package com.X30Marks.Data_Management;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Phone phones[] = new Phone[4];

        for (int i = 0; i < phones.length; i++) {
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();sc.nextLine();

            phones[i] = new Phone(a, b, c, d);
        }

        String para_brand = sc.nextLine();
        String para_os = sc.nextLine();
        sc.close();

//        for findPriceForGivenBrand()
        int priceResult = findPriceForGivenBrand(phones, para_brand);
        if(priceResult > 0)
            System.out.println(priceResult);
        else
            System.out.println("The given Brand is not available");

//        for getPhoneIdBasedOnOs()
        Phone resultPhoneId = getPhoneIdBasedOnOs(phones, para_os);
        if (resultPhoneId == null)
            System.out.println("No phones are available with specified os and price range");
        else
            System.out.println(resultPhoneId.getPhoneId());

    }

    static int findPriceForGivenBrand(Phone phones[], String para_brand) {
        int sumOfPrice = 0;
        for (int i = 0; i < phones.length; i++) {
            if(phones[i].getBrand().equalsIgnoreCase(para_brand)) {
                sumOfPrice += phones[i].getPrice();
            }
        }
        return sumOfPrice;
        //No need to check condition because if condition is false then sumOfPrice will be automatically 0 hence 0 will be returned
//        if (sumOfPrice > 0)
//            return sumOfPrice;
//        else
//            return 0;
    }

    static Phone getPhoneIdBasedOnOs(Phone phones[], String para_os) {
        //Phone temp = null;
        for (int i = 0; i < phones.length; i++) {
            if(phones[i].getOs().equalsIgnoreCase(para_os) && (phones[i].getPrice() >= 50000)) {
                return phones[i];
            }
        }
        return null;
    }
}

class Phone {
    int phoneId;
    String os;
    String brand;
    int price;

    public Phone(int phoneId, String os, String brand, int price) {
        this.phoneId = phoneId;
        this.os = os;
        this.brand = brand;
        this.price = price;
    }

    public int getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}