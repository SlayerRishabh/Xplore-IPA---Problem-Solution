package com.X30Marks.Account;

import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int ab = sc.nextInt();sc.nextLine();
        double b = sc.nextDouble();sc.nextLine();
        double c = sc.nextDouble();sc.nextLine();

        Account a = new Account(ab, b, c);

        int time = sc.nextInt();

        double interest = calculateInterest(a, time);

        System.out.format("%.3f", interest);

    }

    public static double calculateInterest(Account a, int time) {
        double percentage = (a.getInterestRate() * 100)/time;
        percentage = a.getInterestRate()+percentage;
        return percentage;
    }
}

class Account {
    private int id;
    private double balance;
    private double interestRate;

    public Account(int a, double b, double c) {
        id = a;
        balance = b;
        interestRate = c;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

}