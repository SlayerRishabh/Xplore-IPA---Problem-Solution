package com.X30Marks.HeadSets;

import java.util.*;
public class Solution {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		HeadSets[] h = new HeadSets[4];
		for(int i=0; i<h.length; i++) {
			String a = sc.nextLine();
			String b = sc.nextLine();
			int c = sc.nextInt();
			boolean d = sc.nextBoolean();sc.nextLine();
			h[i] = new HeadSets(a, b, c, d);
		}
		String pBrand = sc.nextLine();

		int r1 = findTotalPriceForGivenBrand(h, pBrand);
		if(r1 > 0)
			System.out.println(r1);
		else
			System.out.println("No Headsets available with the given brand");


		HeadSets r2 = findAvailableHeadsetWithSecondMinPrice(h);
		if (r2 != null) {
			System.out.println(r2.getName());
			System.out.println(r2.getPrice());
		} else
			System.out.println("No Headsets available");
		
	}

	public static int findTotalPriceForGivenBrand(HeadSets[] h, String pBrand) {
		int tp = 0;
		for(int i=0; i<h.length; i++) {
			if(h[i].getBrand().equalsIgnoreCase(pBrand)) {
				tp += h[i].getPrice();
			}
		}
		
		return tp;
	}
	
	public static HeadSets findAvailableHeadsetWithSecondMinPrice(HeadSets[] h) {
		HeadSets temp = null; //for sorting

		//-------------------Approach 1-----------------------
		HeadSets[] newH = new HeadSets[0];
		for(int i=0; i<h.length; i++) {
			if(h[i].isAvailable()) {
				newH = Arrays.copyOf(newH, newH.length+1);
				newH[newH.length-1] = h[i];
			}
		}

		for (int i=0; i< newH.length; i++) {
			for (int j=i+1; j< newH.length; j++) {
				if (newH[i].getPrice() > newH[j].getPrice()) {
					temp = newH[i];
					newH[i] = newH[j];
					newH[j] = temp;
				}
			}
		}

		if (newH.length != 0) {
			return newH[1];
		} else
			return null;

		/*

		//-------------------Approach 2-----------------------

		//Check karte hai ki kitne headset available hai, naye headset obj banane ke liye
		int count = 0;
		for(int i=0; i<h.length; i++) {
			if(h[i].isAvailable()) {
				count++;
			}
		}

		//Making new headset Array with length count(number of available headset)
		com.X30Marks.HeadSets[] newH = new com.X30Marks.HeadSets[count]; //is array me available headset obj ko rakhenge
		int k = 0; //for indexing newH array

		//Available headset obj ko newH array me store kar rahe hai
		for(int i=0 ;i<h.length; i++) {
			if (h[i].isAvailable()) { //if headset is available
				newH[k] = h[i]; //naye headset ke 0th idx par us headset obj ko place  kar do
				k++; //updating idx
			}
		}

		//sorting newH array int ascending order
		for(int i=0; i<newH.length; i++) {  //ye pahle idx ko point karega
			for(int j=i+1; j< newH.length; j++) {  //ye idx+1 yani dusre idx ko
				if (newH[i].getPrice() > newH[j].getPrice()) {
					temp = newH[i];
					newH[i] = newH[j];
					newH[j] = temp;
				}
			}
		}

		if (count > 0)
			return newH[1];
		else
			return null;

		*/
	}
}

class HeadSets {
	private String headsetName;
	private String brand;
	private int price;
	private boolean available;

	public HeadSets(String headsetName, String brand, int price, boolean available) {
		this.headsetName = headsetName;
		this.brand = brand;
		this.price = price;
		this.available = available;
	}

	public String getBrand() {
		return brand;
	}
	
	public boolean isAvailable() {
		return available;
	}

	public int getPrice() {
		return price;
	}

	public String getName() {
		return headsetName;
	}
}
