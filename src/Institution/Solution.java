package Institution;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Institution institutions[] = new Institution[4];

        for (int i = 0; i<institutions.length; i++) {
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();sc.nextLine();
            String e = sc.nextLine();

            institutions[i] = new Institution(a, b, c, d, e);
        }

        String para_location = sc.nextLine();
        String para_institutionName = sc.nextLine();

//        for findNumClearancedByLoc()
        int resnoOfClearance = findNumClearancedByLoc(institutions, para_location);
        if (resnoOfClearance > 0)
            System.out.println(resnoOfClearance);
        else
            System.out.println("There are no cleared students in this particular location");

//        for updateInstitutionGrade()

        Institution res = updateInstitutionGrade(institutions, para_institutionName);
        if (res != null)
            System.out.println(res.institutionName+"::"+res.getGrade());
        else
            System.out.println("No Institute is available with the specified name");
    }

    static int findNumClearancedByLoc(Institution institutions[], String para_location) {
        int sum = 0;
        for (int i = 0; i < institutions.length; i++) {
            if (institutions[i].getLocation().equalsIgnoreCase(para_location)) {
                sum += institutions[i].getNoOfStudentsCleared();
            }
        }
        return sum;
    }

    static Institution updateInstitutionGrade(Institution institutions[], String para_institutionName) {
        for (int i = 0; i < institutions.length; i++) {
            if(institutions[i].getInstitutionName().equalsIgnoreCase(para_institutionName)) {
                int rating = (Integer.parseInt(institutions[i].getNoOfStudentsPlaced())*100) / institutions[i].getNoOfStudentsCleared();
                if(rating >= 80)
                    institutions[i].setGrade("A");
                else
                    institutions[i].setGrade("B");
                return institutions[i];
            }
        }
        return null;
    }
}

class Institution {
    int institutionId;
    String institutionName;
    String noOfStudentsPlaced;
    int noOfStudentsCleared;
    String location;
    String grade;

    public Institution(int institutionId, String institutionName, String noOfStudentsPlaced, int noOfStudentsCleared, String location) {
        this.institutionId = institutionId;
        this.institutionName = institutionName;
        this.noOfStudentsPlaced = noOfStudentsPlaced;
        this.noOfStudentsCleared = noOfStudentsCleared;
        this.location = location;
    }

    public int getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(int institutionId) {
        this.institutionId = institutionId;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getNoOfStudentsPlaced() {
        return noOfStudentsPlaced;
    }

    public void setNoOfStudentsPlaced(String noOfStudentsPlaced) {
        this.noOfStudentsPlaced = noOfStudentsPlaced;
    }

    public int getNoOfStudentsCleared() {
        return noOfStudentsCleared;
    }

    public void setNoOfStudentsCleared(int noOfStudentsCleared) {
        this.noOfStudentsCleared = noOfStudentsCleared;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}