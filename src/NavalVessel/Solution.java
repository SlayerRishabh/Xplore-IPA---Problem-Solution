package NavalVessel;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NavalVessel arr[] = new NavalVessel[4];

        for (int i=0; i< arr.length; i++) {
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();sc.nextLine();
            int d = sc.nextInt();sc.nextLine();
            String e = sc.nextLine();
            arr[i] = new NavalVessel(a, b, c, d, e);
        }

        int percentage = sc.nextInt();
        String searchPurposeValue = sc.nextLine();
        sc.close();

        //For findAvgVoyagesByPct()
        int avgOfVoyagesCompleted = findAvgVoyagesByPct(arr, percentage);

        if(avgOfVoyagesCompleted == 0) {
            System.out.println("No such possible combination");
        } else {
            System.out.println(avgOfVoyagesCompleted);
        }

        //For findVesselByGrade()

        NavalVessel navalvesselAvgGrade  = findVesselByGrade(arr, searchPurposeValue);
        if(navalvesselAvgGrade == null)
            System.out.println("No Naval Vessel is available with the specified purpose");
        else
            System.out.println(navalvesselAvgGrade.getVesselName() +"%" +navalvesselAvgGrade.getClassification());
    }


    static int findAvgVoyagesByPct(NavalVessel arr[], int para_percentage) {
        int avg = 0;
        int count = 0;

        for(int i=0; i< arr.length; i++) {
            int percentage = arr[i].getNoOfVoyagesCompleted()*100/arr[i].getNoOfVoyagesPlanned();

            if(percentage >= para_percentage) {
                count++;
                avg+=arr[i].getNoOfVoyagesCompleted();

            }
        }

        if(avg == 0) {
            return 0;
        } else {
            return avg/count;
        }
    }

    static NavalVessel findVesselByGrade(NavalVessel arr[], String searchPurposeValue) {
        for(int i=0; i<arr.length; i++) {
            if(searchPurposeValue.equalsIgnoreCase(arr[i].getPurpose())) {
                int percentage = arr[i].getNoOfVoyagesCompleted()*100/arr[i].getNoOfVoyagesPlanned();
                if(percentage == 100)
                    arr[i].setClassification("Star");
                else if (percentage >= 80 && percentage <= 90)
                    arr[i].setClassification("Leader");
                else if (percentage >= 55 && percentage <= 79)
                    arr[i].setClassification("Inspirer");
                else
                    arr[i].setClassification("Striver");
                return arr[i];
            }
        }
        return null;
    }
}

class NavalVessel{
    private int vesselId, noOfVoyagesPlanned, noOfVoyagesCompleted;
    private String vesselName, purpose, classification;

    public NavalVessel(int vesselId, String vesselName, int noOfVoyagesPlanned, int noOfVoyagesCompleted, String purpose) {
        this.vesselId = vesselId;
        this.vesselName = vesselName;
        this.noOfVoyagesPlanned = noOfVoyagesPlanned;
        this.noOfVoyagesCompleted = noOfVoyagesCompleted;
        this.purpose = purpose;
    }

    public int getVesselId() {
        return vesselId;
    }

    public void setVesselId(int vesselId) {
        this.vesselId = vesselId;
    }

    public String getVesselName() {
        return vesselName;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    public int getNoOfVoyagesPlanned() {
        return noOfVoyagesPlanned;
    }

    public void setNoOfVoyagesPlanned(int noOfVoyagesPlanned) {
        this.noOfVoyagesPlanned = noOfVoyagesPlanned;
    }

    public int getNoOfVoyagesCompleted() {
        return noOfVoyagesCompleted;
    }

    public void setNoOfVoyagesCompleted(int noOfVoyagesCompleted) {
        this.noOfVoyagesCompleted = noOfVoyagesCompleted;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }
}