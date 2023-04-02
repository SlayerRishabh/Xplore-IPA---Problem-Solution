package com.X30Marks.Java_Assessment_Test1;

import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Player players[] = new Player[4];
        for(int i=0; i<players.length; i++) {
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();sc.nextLine();
            String d = sc.nextLine();
            String e = sc.nextLine();
            players[i] = new Player(a, b, c, d, e);
        }

        String p_pType = sc.nextLine();
        String p_MatchType = sc.nextLine();
        sc.close();

        int r1 = findPlayerWithLowestRuns(players, p_pType);
        if(r1 > 0)
            System.out.println(r1);
        else
            System.out.println("No such player");


        Player r2[] = findPlayerByMatchType(players, p_MatchType);
        if (r2 != null) {
            for (int i=0; i<r2.length; i++) {
                System.out.println(r2[i].getPlayerId());
            }
        }  else {
            System.out.println("No Player with given matchType");
        }


    }

    public static int findPlayerWithLowestRuns(Player players[], String p_pType) {
        int leastRun = Integer.MAX_VALUE;
        for(int i=0; i<players.length; i++) {
            if(players[i].getPlayerType().equalsIgnoreCase(p_pType)) {
                if(players[i].getRuns() < leastRun) {
                    leastRun = players[i].getRuns();
                }
            }
        }
        if(leastRun == Integer.MAX_VALUE)
            return 0;
        else
            return leastRun;
    }

    public static Player[] findPlayerByMatchType(Player players[], String p_MatchType) {
        Player temp = null;

        Player r[] = new Player[0];

        for(int i=0; i<players.length; i++) {
            if(players[i].getMatchType().equalsIgnoreCase(p_MatchType)) {
                r = Arrays.copyOf(r, r.length+1);
                r[r.length-1] = players[i];
            }
        }

        //Sorting
        for (int i=0; i<r.length; i++) {
            for (int j=i; j<r.length; j++) {
                if (r[i].getPlayerId() < r[j].getPlayerId()) {
                    temp = r[i];
                    r[i] = r[j];
                    r[j] = temp;
                }
            }
        }

        if (r.length != 0) {
            return r;
        } else {
            return null;
        }
    }
}

class Player {
    private int playerId;
    private String playerName;
    private int runs;
    private String playerType;
    private String matchType;

    public Player(int playerId, String playerName, int runs, String playerType, String matchType) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.runs = runs;
        this.playerType = playerType;
        this.matchType = matchType;
    }

    public String getPlayerType() {
        return playerType;
    }

    public int getRuns() {
        return runs;
    }

    public int getPlayerId() {
        return playerId;
    }

    public String getMatchType() {
        return matchType;
    }

    //implementing comparable interface method
//    public int compareTo(Player p) {
//        return p.playerId - this.playerId; //for descending order
//        //return this.playerId - p.playerId; //for ascending order
//    }
}


