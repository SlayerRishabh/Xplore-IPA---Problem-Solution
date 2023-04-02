package com.X30Marks.Associate_For_Given_Technology;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Associate associates[] = new Associate[5];
        Scanner sc = new Scanner(System.in);

        for (int i=0; i<associates.length; i++) {
            associates[i] = new Associate(sc.nextInt(), sc.next(), sc.next(), sc.nextInt());
        }
        String searchTechnology = sc.next();
        sc.close();

        Associate[] result= associatesForGivenTechnology(associates,searchTechnology);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i].getId());
        }



    }

    static Associate[] associatesForGivenTechnology(Associate associate[], String searchTechnology) {
        Associate arr[] = new Associate[0];
        for (int i = 0; i < associate.length; i++) {
            boolean check = associate[i].getTechnology().equalsIgnoreCase(searchTechnology) && (associate[i].getExperienceInYears()%5)==0;
            if(check) {
                arr = Arrays.copyOf(arr, arr.length+1);
                arr[arr.length-1] = associate[i];
            }
        }
        return arr;
    }
}

class Associate{
    int id;
    String name;
    String technology;
    int experienceInYears;

    Associate(int id, String name, String technology, int experienceInYears) {
        this.id = id;
        this.experienceInYears = experienceInYears;
        this.name = name;
        this.technology = technology;
    }

    public int getId() {
        return id;
    }

    public int getExperienceInYears() {
        return experienceInYears;
    }

    public String getName() {
        return name;
    }

    public String getTechnology() {
        return technology;
    }

}
