package com.X30Marks.Document;

import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Document d[] = new Document[4];
        for(int i=0; i<d.length; i++) {
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int dd = sc.nextInt();sc.nextLine();
            d[i] = new Document(a, b, c, dd);
        }

        Document r[] = docsWithOddPages(d);
        if(r != null) {
            for(int i=0; i<r.length; i++) {
                System.out.println(r[i].getId()+" "+r[i].getTitle()+" "+r[i].getFolderName()+" "+r[i].getPages());
            }
        }
    }

    public static Document[] docsWithOddPages(Document d[]) {
        Document r[] = new Document[0];

        for(int i=0; i<d.length; i++) {
            int p = d[i].getPages();
            if((p % 2) != 0) {
                r = Arrays.copyOf(r, r.length+1);
                r[r.length-1] = d[i];
            }
        }

        if(r.length != 0) {
            return r;
        } else {
            return null;
        }
    }
}

class Document {
    private int id;
    private String title;
    private String folderName;
    private int pages;

    public Document(int a, String b, String c, int d) {
        id = a;
        title = b;
        folderName= c;
        pages = d;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getFolderName() {
        return folderName;
    }

    public int getPages() {
        return pages;
    }

}