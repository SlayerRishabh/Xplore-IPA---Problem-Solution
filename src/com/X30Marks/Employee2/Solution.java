package com.X30Marks.Employee2;

import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Company name: ");
        String cn = sc.nextLine();

        System.out.println("Enter number of employees: ");
        int num = sc.nextInt();sc.nextLine();

        Employee[] employees = new Employee[num];

        System.out.println("Enter Employee details: ");
        for(int i=0; i<employees.length; i++) {
            System.out.println("Employee "+(i+1)+":");

            System.out.println("Enter id: ");
            int a = sc.nextInt();sc.nextLine();

            System.out.print("Enter name: ");
            String b = sc.nextLine();

            System.out.print("Enter designation: ");
            String c = sc.nextLine();

            System.out.print("Enter salary: ");
            double d = sc.nextDouble();sc.nextLine();

            employees[i] = new Employee(a, b, c, d);
        }

        Company c = new Company (cn, employees, num);

        System.out.println("Average Salary : "+c.getAverageSalary(employees));
        System.out.println("Max Salary : "+c.getMaxSalary(employees));

        System.out.print("Employee with Designation: ");
        String designation  = sc.nextLine();
        Employee[] r = c.getEmployeesByDesignation(employees,designation);
        if (r != null) {
            for (int i=0; i<r.length; i++) {
                System.out.println("ID: "+r[i].getId()+", Name: "+r[i].getName()+", Designation: "+r[i].getDesignation()+", Salary: "+r[i].getSalary());
            }
        }


    }

}

class Employee {
    private int id;
    private String name;
    private String designation;
    private double salary;

    public Employee(int id, String name, String designation, double salary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public double getSalary() {
        return salary;
    }

    public String getDesignation() {
        return designation;
    }
}

class Company {
    private String companyName;
    private Employee[] employees;
    private int numEmployees;

    public Company (String companyName, Employee[] employees, int numEmployees) {
        this.companyName = companyName;
        this.employees = employees;
        this.numEmployees = numEmployees;
    }

    public static double getAverageSalary(Employee[] employees) {
        int totSalary = 0;
        int count = 0;

        for(int i=0; i<employees.length; i++) {
            totSalary += employees[i].getSalary();
            count++;
        }

        if(totSalary > 0) {
            double avg = totSalary/count;
            return avg;
        } else {
            return 0;
        }
    }

    public static double getMaxSalary(Employee[] employees) {
        double maxSalary = Double.MIN_VALUE;

        for(int i=0; i<employees.length; i++) {
            if(maxSalary < employees[i].getSalary()) {
                maxSalary = employees[i].getSalary();
            }
        }

        if(maxSalary == Double.MIN_VALUE) {
            return 0;
        } else {
            return maxSalary;
        }
    }

    public static Employee[] getEmployeesByDesignation(Employee[] employees, String designation) {
        Employee r[] = new Employee[0];

        for(int i=0; i<employees.length; i++) {
            if(employees[i].getDesignation().equalsIgnoreCase(designation)) {
                r = Arrays.copyOf(r, r.length+1);
                r[r.length-1] = employees[i];
            }
        }

        if (r.length != 0) {
            return r;
        } else
            return null;
    }
}