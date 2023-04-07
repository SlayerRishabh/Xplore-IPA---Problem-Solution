package com.X30Marks.Employee;

import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee[] e = new Employee[4];
        for(int i=0; i<e.length; i++) {
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();sc.nextLine();
            char d = sc.next().charAt(0);sc.nextLine();
            double ee = sc.nextDouble();
            e[i] = new Employee(a, b, c, d, ee);
        }

        int pAge = sc.nextInt();sc.nextLine();
        sc.close();

        Employee r1 = getEmployeeWithSecondLowestSalary(e);
        if(r1 != null) {
            System.out.println(r1.getEmployeeId()+"#"+r1.getEmployeeName());
        } else {
            System.out.println("Null");
        }


        int r2 = countEmployeesBasedOnAge(e, pAge);
        if(r2 > 0) {
            System.out.println(r2);
        } else {
            System.out.println("No employee found for the given age");
        }
    }

    public static Employee getEmployeeWithSecondLowestSalary (Employee e[]) {
        Employee temp = null;
        int noOFEmp = e.length;

        for(int i=0; i<e.length; i++) {
            for(int j=i; j<e.length; j++) {
                if(e[i].getSalary() > e[j].getSalary()) {
                    temp = e[i];
                    e[i] = e[j];
                    e[j] = temp;
                }
            }
        }

        if(noOFEmp < 2) {
            return null;
        } else {
            return e[1];
        }
    }

    public static int countEmployeesBasedOnAge (Employee e[], int pAge) {
        int count  = 0;
        for(int i=0; i<e.length; i++) {
            if(e[i].getAge() == pAge) {
                count++;
            }
        }

        if(count > 0) {
            return count;
        }else {
            return 0;
        }
    }
}

class Employee {
    private int employeeId;
    private String employeeName;
    private int age;
    private char gender;
    private double salary;

    public Employee (int employeeId, String employeeName, int age, char gender, double salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }
}