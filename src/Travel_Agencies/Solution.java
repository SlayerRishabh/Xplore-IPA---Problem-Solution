package Travel_Agencies;

import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TravelAgencies travelAgencies[] = new TravelAgencies[4];
        for(int i=0; i<travelAgencies.length; i++) {
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();sc.nextLine();
            boolean e = sc.nextBoolean();sc.nextLine();
            travelAgencies[i] = new TravelAgencies(a, b, c, d, e);
        }

        int p_regNo = sc.nextInt();sc.nextLine();
        String p_packageType = sc.nextLine();

        int r1 = findAgencyWithHighestPackagePrice(travelAgencies);
        System.out.println(r1);

        TravelAgencies r2 = agencyDetailsForGivenldAndType(travelAgencies, p_regNo, p_packageType);
        if(r2 == null)
            System.out.println("A string value should be printed here!");
        else
            System.out.println(r2.getAgencyName()+":"+r2.getPrice());
    }

    public static int findAgencyWithHighestPackagePrice(TravelAgencies travelAgencies[]) {
        int highestPackagePrice = Integer.MIN_VALUE;
        for(int i=0; i<travelAgencies.length; i++) {
            if(travelAgencies[i].getPrice() > highestPackagePrice) {
                highestPackagePrice = travelAgencies[i].getPrice();
            }
        }
        return highestPackagePrice;
    }

    public static TravelAgencies agencyDetailsForGivenldAndType(TravelAgencies travelAgencies[], int p_regNo, String p_packageType) {
        for(int i=0; i<travelAgencies.length; i++) {
            if(travelAgencies[i].getFlightFacility()) {
                if(travelAgencies[i].getRegNo() == p_regNo && travelAgencies[i].getPackageType().equalsIgnoreCase(p_packageType)) {
                    return travelAgencies[i];
                }
            }
        }

        return null;
    }
}

class TravelAgencies {
    private int regNo;
    private String agencyName;
    private String packageType;
    private int price;
    private boolean flightFacility;

    public TravelAgencies(int regNo, String agencyName, String packageType, int price, boolean flightFacility){
        this.regNo = regNo;
        this.agencyName = agencyName;
        this.packageType = packageType;
        this.price = price;
        this.flightFacility = flightFacility;
    }

    public int getRegNo() {
        return regNo;
    }

    public String getPackageType() {
        return packageType;
    }

    public int getPrice() {
        return price;
    }

    public boolean getFlightFacility() {
        return flightFacility;
    }

    public String getAgencyName() {
        return agencyName;
    }
}