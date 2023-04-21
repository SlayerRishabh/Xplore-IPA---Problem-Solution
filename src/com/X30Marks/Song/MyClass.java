package com.X30Marks.Song;

import java.util.Arrays;
import java.util.Scanner;

public class MyClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Song s[] = new Song[5];
        for (int i=0; i<s.length; i++) {
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            double d = sc.nextDouble();sc.nextLine();
            s[i] = new Song(a, b, c ,d);
        }

        String pA = sc.nextLine();
        String pA2 = sc.nextLine();

        double r1 = findSongDurationForArtist(s, pA);
        if (r1 > 0)
            System.out.println(r1);
        else
            System.out.println("There are no songs with given artist");

        Song r2[] = getSongsInAscendingOrder(s,pA2);
        if (r2 != null) {
            for (int i=0; i<r2.length; i++) {
                System.out.println(r2[i].getSongId());
                System.out.println(r2[i].getTitle());
            }
        } else
            System.out.println("There are no songs with given artist");
    }

    public static double findSongDurationForArtist(Song s[], String pA) {
        double t = 0;
        for (int i=0; i<s.length; i++) {
            if (s[i].getArtist().equalsIgnoreCase(pA)) {
                t += s[i].getDuration();
            }
        }

        if (t > 0)
            return t;
        else
            return 0;
    }

    public static Song[] getSongsInAscendingOrder(Song s[], String pA2) {
        Song temp = null;
        Song r[] = new Song[0];

        for (int i=0; i<s.length; i++) {
            if (s[i].getArtist().equalsIgnoreCase(pA2)) {
                r = Arrays.copyOf(r, r.length+1);
                r[r.length-1] = s[i];
            }
        }

        //Sorting in ascending order

        for (int i=0 ;i<r.length; i++) {
            for (int j=i+1; j<r.length; j++) {
                if (r[i].getDuration() > r[j].getDuration()) {
                    temp = r[i];
                    r[i] = r[j];
                    r[j] = temp;
                }
             }
        }

        if (r.length != 0)
            return r;
        else return null;
    }
}

class Song {
    private int songId;
    private String title;
    private String artist;
    private double duration;

    public Song (int a, String b, String c, double d) {
        songId = a;
        title = b;
        artist = c;
        duration = d;
    }

    public String getArtist() {
        return artist;
    }

    public double getDuration() {
        return duration;
    }

    public int getSongId() {
        return songId;
    }

    public String getTitle() {
        return title;
    }
}

