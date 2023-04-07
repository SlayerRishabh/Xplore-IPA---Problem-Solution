package com.X30Marks.Antenna;

import java.util.*;
public class MyClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Antenna a[] = new Antenna[4];
        for(int i=0; i<a.length; i++) {
            int aa = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            double d = sc.nextDouble();sc.nextLine();

            a[i] = new Antenna(aa, b, c, d);
        }

        String aN = sc.nextLine();
        double pVSWR = sc.nextDouble();sc.nextLine();

        int r1 = searchAntennaByName(a, aN);
        if(r1 > 0) {
            System.out.println(r1);
        } else {
            System.out.println("There is no antenna with the given parameter");
        }

        Antenna r2[] = sortAntennaByVSWR(a, pVSWR);
        if(r2 != null) {
            for(int i=0; i<r2.length; i++) {
                System.out.println(r2[i].getProjectLead());
            }
        } else {
            System.out.println("No Antenna found");
        }

    }

    public static int searchAntennaByName(Antenna a[], String aN) {
        for(int i=0; i<a.length; i++) {
            if(a[i].getAntennaName().equalsIgnoreCase(aN)) {
                return a[i].getAntennaid();
            }
        }

        return 0;
    }

    public static Antenna[] sortAntennaByVSWR(Antenna a[], double pVSWR) {
        Antenna temp = null;

        Antenna r[] = new Antenna[0];

        for(int i=0; i<a.length; i++) {
            if(a[i].getAntennaVSWR() < pVSWR) {
                r = Arrays.copyOf(r, r.length+1);
                r[r.length-1] = a[i];
            }
        }

        //Sorting

        if(r.length > 0) {
            for(int i=0 ;i<r.length; i++) {
                for(int j=i+1; j<r.length; j++) {
                    if(r[i].getAntennaVSWR() > r[j].getAntennaVSWR()) {
                        temp = r[i];
                        r[i] = r[j];
                        r[j] = temp;
                    }
                }
            }
        }

        if(r.length > 0) {
            return r;
        } else {
            return null;
        }
    }
}

class Antenna {
    private int antennaid;
    private String antennaName;
    private String projectLead;
    private double antennaVSWR;

    public Antenna(int antennaid, String antennaName, String projectLead, double antennaVSWR) {
        this.antennaid = antennaid;
        this.antennaName = antennaName;
        this.projectLead = projectLead;
        this.antennaVSWR = antennaVSWR;
    }

    public String getAntennaName() {
        return antennaName;
    }

    public int getAntennaid() {
        return antennaid;
    }

    public double getAntennaVSWR() {
        return antennaVSWR;
    }

    public String getProjectLead() {
        return projectLead;
    }
}
