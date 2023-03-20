package Player_Get_Average_of_Runs;

import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Player players[] = new Player[4];
        for(int i=0; i<players.length; i++) {
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt(); sc.nextLine();
            int d = sc.nextInt(); sc.nextLine();
            int e = sc.nextInt(); sc.nextLine();
            players[i] = new Player(a, b, c, d, e);
        }

        int ptarget = sc.nextInt();
        sc.close();

        double res[] = findAverageOfRuns(players, ptarget);
        for(int i=0; i<res.length; i++) {
            if(res[i] >= 80 && res[i] <= 100)
                System.out.println("Grade A");
            else if(res[i] >= 50 && res[i] <= 79)
                System.out.println("Grade B");
            else
                System.out.println("Grade C");
        }

    }

    public static double[] findAverageOfRuns(Player players[], int ptarget) {
        double r[] = new double[0];
        for(int i=0; i<players.length; i++) {
            if(ptarget <= players[i].getMatchesPlayed()) {
                r = Arrays.copyOf(r, r.length+1);
                r[r.length-1] = (double)(players[i].getRunsScored() / players[i].getMatchesPlayed());
            }
        }
        return r;
    }
}

class Player{
    private int id;
    private String name;
    private int iccRank;
    private int matchesPlayed;
    private int runsScored;

    public Player(int id, String name, int iccRank, int matchesPlayed, int runsScored) {
        this.id = id;
        this.name = name;
        this.iccRank = iccRank;
        this.matchesPlayed = matchesPlayed;
        this.runsScored = runsScored;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }
    public int getRunsScored() {
        return runsScored;
    }
}