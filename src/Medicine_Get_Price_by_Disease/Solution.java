package Medicine_Get_Price_by_Disease;

import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Medicine medicines[] = new Medicine[4];
        for(int i=0; i<medicines.length; i++ ) {
            String a = sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt(); sc.nextLine();
            medicines[i] = new Medicine(a, b, c, d);
        }
        String p_disease = sc.nextLine();
        sc.close();

        Integer res[] = getPriceByDisease(medicines, p_disease);
        for(int i=0; i<res.length; i++) {
            System.out.println(res[i]);
        }

    }

    public static Integer[] getPriceByDisease(Medicine medicines[], String p_disease) {
        Integer r[] = new Integer[0];
        for (int i=0; i<medicines.length; i++) {
            if(medicines[i].getDisease().equalsIgnoreCase(p_disease)) {
                r = Arrays.copyOf(r, r.length+1);
                r[r.length-1] = medicines[i].getPrice();
            }
            Arrays.sort(r);
        }

        return r;
    }
}

class Medicine {
    private String MedicineName;
    private String batch;
    private String disease;
    private int price;

    public Medicine (String MedicineName,String batch,String disease,int price) {
        this.MedicineName = MedicineName;
        this.batch = batch;
        this.disease = disease;
        this.price = price;
    }

    public String getDisease() {
        return disease;
    }

    public int getPrice() {
        return price;
    }
}
