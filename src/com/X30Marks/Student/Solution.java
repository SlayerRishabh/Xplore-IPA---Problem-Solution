package com.X30Marks.Student;

import javax.sound.midi.Soundbank;
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student s[] = new Student[4];
        for (int i=0; i<s.length; i++) {
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            double d = sc.nextDouble();
            boolean e = sc.nextBoolean();
            s[i] = new Student(a, b, c, d, e);
        }

        int r1 = findCountOfDayscholarStudents(s);
        if (r1 > 0)
            System.out.println(r1);
        else
            System.out.println("There are no such dayscholar students");

        Student r2 = findStudentwithSecondHighestScore(s);
        if (r2 != null) {
            System.out.println(r2.getRollNo()+"#"+r2.getName()+"#"+r2.getScore());
        }
    }

    public static int  findCountOfDayscholarStudents(Student s[]) {
        int count = 0;
        for (int i=0; i<s.length; i++) {
            if ((s[i].isDayScholar() == true) && (s[i].getScore() > 80)) {
                count++;
            }
        }

        if (count > 0)
            return count;
        else
            return 0;
    }

    public static Student findStudentwithSecondHighestScore(Student s[]) {
        Student temp = null;
        Student r[] = new Student[0];

        for (int i=0; i<s.length; i++) {
            if (s[i].isDayScholar() == false) {
                r = Arrays.copyOf(r, r.length+1);
                r[r.length-1] = s[i];
            }
        }

        if (r.length > 0) {
            for (int i=0; i<r.length; i++) {
                for (int j=i+1; j<r.length; j++) {
                    if (r[i].getScore() < r[j].getScore()) {
                        temp = r[i];
                        r[i] = r[j];
                        r[j] = temp;
                    }
                }
            }
        }

        if (r.length > 0)
            return r[1];
        else
            return null;
    }
}

class Student {
    private int rollNo;
    private String name;
    private String branch;
    private double score;
    private boolean dayScholar;

    public Student (int rollNo, String name, String branch, double score, boolean dayScholar) {
        this.rollNo = rollNo;
        this.name = name;
        this.branch = branch;
        this.score = score;
        this.dayScholar = dayScholar;
    }

    public boolean isDayScholar() {
        return dayScholar;
    }

    public double getScore() {
        return score;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }
}