package AutonomousCar;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        AutonomousCar autonomousCars[] = new AutonomousCar[4];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < autonomousCars.length; i++) {
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();sc.nextLine();
            int d = sc.nextInt();sc.nextLine();
            String e = sc.nextLine();
            autonomousCars[i] = new AutonomousCar(a, b, c, d, e);
        }

        String paraEnvironment = sc.nextLine();
        String paraBrand = sc.nextLine();

//        for findTestPassedByEnv()
        int testPassed = findTestPassedByEnv(autonomousCars, paraEnvironment);
        if(testPassed == 0)
            System.out.println("There are no tests passed in this particular environment");
        else
            System.out.println(testPassed);

//        for updateCarGrade()
        AutonomousCar updatedCar = updateCarGrade(paraBrand, autonomousCars);
        if(updatedCar == null)
            System.out.println("No Car is available with the specified brand");
        else
            System.out.println(updatedCar.getBrand()+"::"+updatedCar.getGrade());

    }

    static int findTestPassedByEnv(AutonomousCar autonomousCars[], String paraEnvironment ) {
        int sumOfNoOfTestsPassed = 0;
        for (int i = 0; i < autonomousCars.length; i++) {
            if (autonomousCars[i].getEnvironment().equalsIgnoreCase(paraEnvironment)) {
                sumOfNoOfTestsPassed += autonomousCars[i].getNoOfTestsPassed();
            }
        }
        return sumOfNoOfTestsPassed;
    }

    static AutonomousCar updateCarGrade(String paraBrand, AutonomousCar autonomousCars[]) {
        int rating;
        for (int i = 0; i < autonomousCars.length; i++) {
            if(autonomousCars[i].getBrand().equalsIgnoreCase(paraBrand)) {
                rating = ((autonomousCars[i].getNoOfTestsPassed()*100)/autonomousCars[i].getNoOfTestsConducted());
                if(rating >= 80) autonomousCars[i].setGrade("A1");
                else autonomousCars[i].setGrade("B2");
                return autonomousCars[i];
            }
        }
        return null;
    }
}

class AutonomousCar {
    int carld;
    String brand;
    int noOfTestsConducted;
    int noOfTestsPassed;
    String environment;
    String grade;

    public AutonomousCar(int carld, String brand, int noOfTestsConducted, int noOfTestsPassed, String environment) {
        this.carld = carld;
        this.brand = brand;
        this.noOfTestsConducted = noOfTestsConducted;
        this.noOfTestsPassed = noOfTestsPassed;
        this.environment = environment;
    }

    public int getCarld() {
        return carld;
    }

    public void setCarld(int carld) {
        this.carld = carld;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getNoOfTestsConducted() {
        return noOfTestsConducted;
    }

    public void setNoOfTestsConducted(int noOfTestsConducted) {
        this.noOfTestsConducted = noOfTestsConducted;
    }

    public int getNoOfTestsPassed() {
        return noOfTestsPassed;
    }

    public void setNoOfTestsPassed(int noOfTestsPassed) {
        this.noOfTestsPassed = noOfTestsPassed;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
