package com.X30Marks.Team;

import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Team t[] = new Team[3];
        for(int i=0; i<t.length; i++) {
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();sc.nextLine();

            t[i] = new Team(a, b, c, d);
        }

        int pRun = sc.nextInt();sc.nextLine();
        String pCountry = sc.nextLine();

        Team r = findPlayer(t, pRun, pCountry);
        if(r != null) {
            System.out.println(r.getId());
            System.out.println(r.getName());
            System.out.println(r.getCountry());
            System.out.println(r.getRun());
        } else {
            System.out.println("No team is found from the given country and run");
        }

    }

    public static Team findPlayer(Team t[], int pRun, String pCountry) {
        for(int i=0; i<t.length; i++) {
            if(t[i].getCountry().equalsIgnoreCase(pCountry) && t[i].getRun() > pRun) {
                return t[i];
            }
        }

        return null;
    }


}

class Team {
    private int tId;
    private String tName;
    private String tCountry;
    private int tRun;

    public Team(int a, String b, String c, int d) {

        //When we are using same var name in constructor then only we need to use this

        tId = a;
        tName = b;
        tCountry = c;
        tRun = d;
    }

    public int getId() {
        return tId;
    }

    public String getName() {
        return tName;
    }

    public String getCountry() {
        return tCountry;
    }

    public int getRun() {
        return tRun;
    }

}