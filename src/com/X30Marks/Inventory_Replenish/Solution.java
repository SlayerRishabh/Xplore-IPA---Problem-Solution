package com.X30Marks.Inventory_Replenish;

import java.util.*;
public class Solution{
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory inventorys[] = new Inventory[4];
        for(int i=0; i<inventorys.length; i++) {
            String a = sc.nextLine();
            int b = sc.nextInt();sc.nextLine();
            int c = sc.nextInt();sc.nextLine();
            int d = sc.nextInt();sc.nextLine();
            inventorys[i] = new Inventory(a, b, c, d);
        }

        int p_limit = sc.nextInt();
        sc.close();
        
        Inventory res[] = replenish(inventorys, p_limit);

        for(int j = 0; j<res.length; j++) {
            if(res[j].getThreshold() > 75)
                System.out.println(res[j].getInventoryId() + " Critical Filling");
            else if(res[j].getThreshold() > 50 && res[j].getThreshold() < 75)
                System.out.println(res[j].getInventoryId() + " Moderate Filling");
            else
                System.out.println(res[j].getInventoryId() + " Non-Critical Filling");
            }
}

public static Inventory[] replenish(Inventory inventorys[], int p_limit) {
        Inventory r[] = new Inventory[0];
            for(int i=0; i<inventorys.length; i++) {
                if(inventorys[i].getThreshold() <= p_limit) {
                    r = Arrays.copyOf(r, r.length+1);
                    r[r.length-1] = inventorys[i];
                }
            }
            return r;
        }
}

class Inventory {
    private String inventoryId;
    private int maximumQuantity;
    private int currentQuantity;
    private int threshold;

    public Inventory(String inventoryId, int maximumQuantity, int currentQuantity, int threshold) {
        this.inventoryId = inventoryId;
        this.maximumQuantity =maximumQuantity;
        this.currentQuantity =currentQuantity;
        this.threshold = threshold;
    }

    public int getThreshold() {
        return threshold;
    }

    public String getInventoryId() {
        return inventoryId;
    }
}