package Sim_Match_And_Sort;

import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sim sims[] = new Sim[4];
        for(int i=0; i<sims.length; i++) {
//            int a = sc.nextInt();
//            String b = sc.next();
//            int c = sc.nextInt();
//            double d = sc.nextDouble();
//            String e = sc.next();
//            sims [i] = new Sim(a, b, c, d, e);
        sims[i] = new Sim(sc.nextInt(), sc.next(),sc.nextInt(),sc.nextDouble(), sc.next());
        }

        String search_circle = sc.next();
        double search_rate = sc.nextDouble();
        sc.nextLine();
        sc.close();

        Sim res[] = matchAndSort(sims, search_circle, search_rate);
        for(int i=0; i< res.length; i++) {
            System.out.println(res[i].getId());
        }
    }



    public static Sim[] matchAndSort(Sim sims[], String search_circle, double search_rate) {
        Sim r[] = new Sim[0];
        for(int i=0; i<sims.length; i++) {
            if((sims[i].getCircle().equalsIgnoreCase(search_circle)) && (search_rate > sims[i].getRatePerSecond())) {
                r = Arrays.copyOf(r, r.length+1);
                r[r.length-1] = sims[i];
            }
        }

        for(int i=0; i<r.length-1; i++) {
            for(int j=0; j<r.length-i-1; j++) {
                if(r[j].getBalance() < r[j+1].getBalance()) {
                    Sim temp = r[j];
                    r[j] = r[j+1];
                    r[j+1] = temp;
                }
            }
        }

        return r;

    }
}

class Sim {
    private int id;
    private String company;
    private int balance;
    private double ratePerSecond;
    private String circle;

    public Sim(int id, String company, int balance, double ratePerSecond, String circle) {
        this.id = id;
        this.company = company;
        this.balance = balance;
        this.ratePerSecond = ratePerSecond;
        this.circle = circle;
    }
    public String getCircle() {
        return circle;
    }
    public double getRatePerSecond() {
        return ratePerSecond;
    }
    public int getBalance() {
        return balance;
    }
    public int getId() {
        return id;
    }
}