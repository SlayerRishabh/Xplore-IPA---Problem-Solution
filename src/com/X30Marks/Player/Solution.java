package com.X30Marks.Player;

import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Player p[] = new Player[5];
        for(int i=0; i<p.length; i++) {
            int a;
            a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();sc.nextLine();
            int e = sc.nextInt();sc.nextLine();
            p[i] = new Player(a, b, c, d, e);
        }

        String pC = sc.nextLine();
        int pRun = sc.nextInt();sc.nextLine();

        Player r[] = findPlayerName(p, pC, pRun);
        if(r != null) {
            for (int i=0; i<r.length; i++) {
                System.out.println(r[i].getId()+":"+r[i].getName());
            }
        } else
            System.out.println("No player found");
    }

    public static Player[] findPlayerName(Player p[],String pC,int pRun) {
        Player r[] = new Player[0];
        for (int i=0; i<p.length; i++) {
            if (p[i].getCountry().equalsIgnoreCase(pC) && p[i].getRunsScored() > pRun) {
                r = Arrays.copyOf(r, r.length+1);
                r[r.length-1] = p[i];
            }
        }

        if(r.length !=0)
            return r;
        else
            return null;
    }
}

class Player {
    private int id;
    private String name;
    private String country;
    private int matchesPlayed;
    private int runsScored;

    public Player(int a, String b, String c, int d, int e) {
        id = a;
        name = b;
        country= c;
        matchesPlayed = d;
        runsScored = e;
    }

    public String getCountry() {
        return country;
    }

    public int getRunsScored() {
        return runsScored;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}