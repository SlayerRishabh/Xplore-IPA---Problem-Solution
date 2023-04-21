package com.X30Marks.Music;

import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Music m[] = new Music[4];
        for(int i=0; i<m.length; i++) {
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();sc.nextLine();
            double d = sc.nextDouble();sc.nextLine();
            m[i] = new Music(a, b, c, d);
        }

        int pCount = sc.nextInt();sc.nextLine();
        int pDur = sc.nextInt();


        int r1 = findAvgOfCount(m, pCount);
        if(r1 > 0) {
            System.out.println(r1);
        } else {
            System.out.println("No playlist found.");
        }

        Music r2[] = sortTypeByDuration(m, pDur);
        if(r2 != null) {
            for(int i=0; i<r2.length; i++) {
                System.out.println(r2[i].getType());
            }
        } else {
            System.out.println("No playlist found with mentioned attribute.");
        }

    }

    public static int findAvgOfCount(Music m[], int pCount) {
        int n = 0;
        int cc = 0;
        for(int i=0; i<m.length; i++) {
            if(m[i].getCount() > pCount) {
                cc += m[i].getCount();
                n++;
            }
        }

        if(n > 0) {
            int avg = cc/n;
            return avg;
        } else {
            return 0;
        }
    }

    public static Music[] sortTypeByDuration(Music m[], int pDur) {
        Music temp = null;
        Music r[] = new Music[0];
        for(int i=0; i<m.length; i++) {
            if(m[i].getDuration() > pDur) {
                r = Arrays.copyOf(r, r.length+1);
                r[r.length-1] = m[i];
            }
        }

        if(r.length != 0) {
            for(int i=0; i<r.length; i++) {
                for(int j=i+1; j<r.length; j++) {
                    if(r[i].getDuration() > r[j].getDuration()) {
                        temp = r[i];
                        r[i] = r[j];
                        r[j] = temp;
                    }
                }
            }
        }

        if(r.length != 0) {
            return r;
        } else {
            return null;
        }
    }
}

class Music {
    private int playListNo;
    private String type;
    private int count;
    private double duration;

    public Music(int a, String b, int c, double d) {
        playListNo = a;
        type = b;
        count= c;
        duration = d;
    }

    public int getCount() {
        return count;
    }

    public double getDuration() {
        return duration;
    }

    public String getType() {
        return type;
    }

}