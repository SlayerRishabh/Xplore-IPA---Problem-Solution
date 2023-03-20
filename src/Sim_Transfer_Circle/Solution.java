package Sim_Transfer_Circle;

import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sim sims[] = new Sim[5];
        for(int i=0; i<sims.length; i++) {
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            double c = sc.nextDouble();
            double d = sc.nextDouble();sc.nextLine();
            String e = sc.nextLine();
            sims[i] = new Sim(a, b, c, d, e);
        }
        String p_circle1 = sc.nextLine();
        String p_circle2 = sc.nextLine();

        Sim res[] = transferCircle(sims, p_circle1, p_circle2);

        for(int i=0; i<res.length; i++) {
            System.out.println(res[i].getSimId()+" "+res[i].getCustomerName()+" "+res[i].getCircle()+" "+res[i].getRatePerSecond());
        }
    }

    public static Sim[] transferCircle(Sim sims[], String p_circle1, String p_circle2) {
        Sim r[] = new Sim[0];
        for(int i=0; i<sims.length; i++) {
            if(sims[i].getCircle().equalsIgnoreCase(p_circle1)) {
                r = Arrays.copyOf(r, r.length+1);
                r[r.length-1] = sims[i];
                r[r.length-1].setCircle(p_circle2);
            }
        }

        //sorting
        for(int i=0; i<r.length-1; i++) {
            for(int j=0; j<r.length-i-1; j++) {
                if(r[j].getRatePerSecond() < r[j+1].getRatePerSecond()) {
                    Sim temp = r[j];
                    r[j] = r[j+1];
                    r[j+1] = temp;
                }
            }
        }

        return r;

    }
}

class Sim{
    private int simId;
    private String customerName;
    private double balance;
    private double ratePerSecond;
    private String circle;

    public Sim(int simId, String customerName, double balance, double ratePerSecond, String circle) {
        this.simId = simId;
        this.customerName = customerName;
        this.balance = balance;
        this.ratePerSecond = ratePerSecond;
        this.circle = circle;
    }

    public int getSimId() {
        return simId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getBalance() {
        return balance;
    }

    public String getCircle() {
        return circle;
    }

    public void setCircle(String circle) {
        this.circle = circle;
    }

    public double getRatePerSecond() {
        return ratePerSecond;
    }
}