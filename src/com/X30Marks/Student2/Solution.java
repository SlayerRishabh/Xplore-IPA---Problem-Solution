package com.X30Marks.Student2;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        Student s[] = new Student[4];
        for (int i=0; i<s.length; i++) {
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            char d = sc.next().charAt(0);sc.nextLine();
            String e = sc.nextLine();

            s[i] = new Student(a, b, c, d, e);
        }
        char pGrade = sc.next().charAt(0);sc.nextLine();
        int pMonth = sc.nextInt();
        sc.close();

        Student r[] = findStudentByGradeAndMonth(s, pGrade, pMonth);
        if (r != null) {
            for (int i=0; i<r.length; i++) {
                System.out.println(r[i].getName());
                System.out.println(r[i].getSubject());
            }
            System.out.println(r.length);
        } else
            System.out.println("No student found");


    }

    public static Student[] findStudentByGradeAndMonth(Student s[], char pGrade, int pMonth) {
        Student r[] = new Student[0];
        Student temp = null;

        for (int i=0 ;i<s.length; i++) {
            String month[] = s[i].getDate().split("/");
            if (s[i].getGrade() == pGrade && Integer.parseInt(month[1]) == pMonth){
                //month[1] means [27/03/2023], 27 is at 0th idx and 03 is at 1st idx
                r = Arrays.copyOf(r, r.length+1);
                r[r.length-1] = s[i];
            }
        }

        if (r.length > 0) {
            for (int i=0 ;i<r.length; i++) {
                for (int j=i+1; j<r.length; j++) {
                    if (r[i].getRollNo() > r[j].getRollNo()) {
                        temp = r[i];
                        r[i] = r[j];
                        r[j] = temp;
                    }
                }
            }
        }

        if (r.length > 0)
            return r;
        else return null;
    }
}


class Student {
    private int rollNo;
    private String name;
    private String subject;
    private char grade;
    private String date;

    public Student(int rollNo, String name, String subject, char grade, String date) {
        this.rollNo = rollNo;
        this.name = name;
        this.subject = subject;
        this.grade = grade;
        this.date = date;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public char getGrade() {
        return grade;
    }

    public String getDate() {
        return date;
    }
}
