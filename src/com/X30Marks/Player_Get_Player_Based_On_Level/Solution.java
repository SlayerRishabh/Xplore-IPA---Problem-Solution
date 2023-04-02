package com.X30Marks.Player_Get_Player_Based_On_Level;

import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Player players[] = new Player[4];
        for(int i=0; i<players.length; i++) {
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt(); sc.nextLine();
            players[i] = new Player(a, b, c ,d);
        }

        String pskill = sc.nextLine();
        String plevel = sc.nextLine();

        int res1 = findPointsForGivenSkill(players, pskill);
        if(res1 > 0)
            System.out.println(res1);
        else
            System.out.println("The given Skill is not available");


        Player res2 = getPlayerBasedOnLevel(players, plevel, pskill);
        if(res2 == null)
            System.out.println("No player is available with specified level, skill and eligibility points");
        else
            System.out.println(res2.getPlayerId());

    }

    public static int findPointsForGivenSkill(Player players[] ,String pskill) {
        int sum = 0;
        for(int i=0; i<players.length; i++) {
            if(players[i].getSkill().equalsIgnoreCase(pskill)) {
                sum += players[i].getPoints();
            }
        }
        return sum;
    }

    public static Player getPlayerBasedOnLevel(Player players[], String plevel, String pskill) {
        for(int i=0; i<players.length; i++) {
            if(players[i].getLevel().equalsIgnoreCase(plevel) && players[i].getSkill().equalsIgnoreCase(pskill) && players[i].getPoints() >= 20) {
                return players[i];
            }
        }
        return null;
    }
}

class Player {
    private int playerId;
    private String skill;
    private String level;
    private int points;

    public Player(int playerId, String skill, String level, int points) {
        this.playerId = playerId;
        this.skill = skill;
        this.level = level;
        this.points = points;
    }

    public String getSkill() {
        return skill;
    }

    public int getPoints() {
        return points;
    }

    public String getLevel() {
        return level;
    }

    public int getPlayerId() {
        return playerId;
    }
}