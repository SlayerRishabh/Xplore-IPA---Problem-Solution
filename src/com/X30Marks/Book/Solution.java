package com.X30Marks.Book;

import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book b[] = new Book[4];
        for (int i=0; i<b.length; i++) {
            int a = sc.nextInt();sc.nextLine();
            int bb = sc.nextInt();sc.nextLine();
            String c = sc.nextLine();
            String d = sc.nextLine();
            double e = sc.nextDouble();sc.nextLine();

            b[i] = new Book(a, bb, c, d, e);
        }

        String pT = sc.nextLine();

        Book r1[] = findBookWithMaximumPrice(b);
        if (r1 != null) {
            for (int i=0; i<r1.length; i++) {
                System.out.println(r1[i].getId()+" "+r1[i].getTitle());
            }
        } else
            System.out.println("No Book found with mentioned attribute.");


        Book r2 = searchBookByTitle(b, pT);

        if (r2 != null) {
            System.out.println(r2.getId());
            System.out.println(r2.getPages());
        } else
            System.out.println("No Book found with mentioned attribute.");


    }

    public static Book[] findBookWithMaximumPrice(Book b[]) {

        Book r[] = new Book[0];
        double maxP = Double.MIN_VALUE;

        for (int i=0; i<b.length; i++) {
            if (b[i].getPrice() > maxP) {
                maxP = b[i].getPrice();
            }
        }

        for (int i=0; i<b.length; i++) {
            if (b[i].getPrice() == maxP) {
                r = Arrays.copyOf(r, r.length+1);
                r[r.length-1] = b[i];
            }
        }


        if (r.length > 0)
            return r;
        else
            return null;
    }

    public static Book searchBookByTitle(Book b[], String pT) {

        for (int i=0; i<b.length; i++) {
            if (b[i].getTitle().equalsIgnoreCase(pT)) {
                return b[i];
            }
        }

        return null;
    }
}

class Book {
    private int id;
    private int pages;
    private String title;
    private String author;
    private double price;

    public Book(int id, int pages, String title, String author, double price) {
        this.id = id;
        this.pages = pages;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getPages() {
        return pages;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }
}