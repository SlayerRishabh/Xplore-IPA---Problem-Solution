package com.X30Marks.Employee3;

import java.util.Arrays;
import java.util.Scanner;

public class MyClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee e[] = new Employee[4];
        for (int i=0 ;i<e.length; i++) {
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            double d = sc.nextDouble();sc.nextLine();
            boolean ee = sc.nextBoolean();sc.nextLine();

            e[i] = new Employee(a, b, c, d, ee);
        }

        String pCt = sc.nextLine();

        int r1 = findCountOfEmployeesUsingCompTransport(e, pCt);
        if (r1 > 0)
            System.out.println(r1);
        else
            System.out.println("No such Employees");

        Employee r2 = findEmployeeWithSecondHighestRating(e);
        if (r2 != null) {
            System.out.println(r2.getEmployeeId());
            System.out.println(r2.getName());
        } else
            System.out.println("All Employees using company transport");
    }

    public static int findCountOfEmployeesUsingCompTransport(Employee e[], String pCt) {
        int count = 0;
        for (int i=0; i<e.length; i++) {
            if (e[i].isCompanyTransport() == true && e[i].getBranch().equalsIgnoreCase(pCt)) {
                count++;
            }
        }

        if (count > 0)
            return count;
        else return 0;
    }

    public static Employee findEmployeeWithSecondHighestRating(Employee e[]) {
        Employee temp = null;

        Employee r[] = new Employee[0];

        for (int i=0 ;i<e.length; i++) {
            if (e[i].isCompanyTransport() == false) {
                r = Arrays.copyOf(r, r.length+1);
                r[r.length-1] = e[i];
            }
        }


        //Sorting Array of employee who are not using company transport
        if (r != null) {
            for (int i=0; i<r.length; i++) {
                for (int j=i+1; j<r.length; j++) {
                    if (r[i].getRating() < r[j].getRating()) {
                        temp = r[i];
                        r[i] = r[j];
                        r[j] = temp;
                    }
                }
            }
        }

        if (r.length > 0)
            return r[1];
        else return null;
    }
}

class Employee {
    private int employeeId;
    private String name;
    private String branch;
    private double rating;
    private boolean companyTransport;

    public Employee(int employeeId, String name, String branch, double rating, boolean companyTransport) {
        this.employeeId = employeeId;
        this.name = name;
        this.branch = branch;
        this.rating = rating;
        this.companyTransport = companyTransport;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getBranch() {
        return branch;
    }

    public double getRating() {
        return rating;
    }

    public boolean isCompanyTransport() {
        return companyTransport;
    }
}