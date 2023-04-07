package com.X30Marks.Motel;

import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Motel m[] = new Motel[4];
        for (int i=0; i<m.length; i++) {
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();sc.nextLine();
            String e = sc.nextLine();
            double f = sc.nextDouble();sc.nextLine();
            m[i] = new Motel(d ,e);
        }

        String pCab = sc.nextLine();

        int r = totalNoOfRoomsBooked(m, pCab);
        if (r > 0)
            System.out.println(r);
        else
            System.out.println("No such rooms booked");
    }

    public static int totalNoOfRoomsBooked(Motel m[], String pCab) {
        int totRoomBooked = 0;
        for (int i=0; i<m.length; i++) {
            if (m[i].getCabFacility().equalsIgnoreCase(pCab) && m[i].getNoOfRoomsBooked() > 5) {
                totRoomBooked += m[i].getNoOfRoomsBooked();
            }
        }

        if (totRoomBooked > 0)
            return totRoomBooked;
        else
            return 0;
    }
}

class Motel {
    //private int motelId;
    //private String motel;
    //private String dateOfBooking;
    private int noOfRoomsBooked;
    private String cabFacility;
    //private double totalBill;

    /*public Motel(int motelId, String motel, String dateOfBooking, int noOfRoomsBooked, String cabFacility, double totalBill) {
        this.motelId = motelId;
        this.motel = motel;
        this.dateOfBooking = dateOfBooking;
        this.noOfRoomsBooked = noOfRoomsBooked;
        this.cabFacility = cabFacility;
        this.totalBill = totalBill;
    }*/

    public Motel(int noOfRoomsBooked, String cabFacility) {
        this.noOfRoomsBooked = noOfRoomsBooked;
        this.cabFacility = cabFacility;
    }

    public int getNoOfRoomsBooked() {
        return noOfRoomsBooked;
    }
    public String getCabFacility() {
        return cabFacility;
    }
}