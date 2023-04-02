package com.X30Marks.Hotel;
import java.util.Arrays;
import java.util.Scanner;

public class SolutionHotel {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Hotel[] arr = new Hotel[4];

        for(int i=0; i< arr.length; i++) {
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();sc.nextLine();
            String e = sc.nextLine();
            double f = sc.nextDouble();sc.nextLine();
            arr[i] = new Hotel(a, b, c ,d, e, f);
        }

        String month = sc.nextLine();
        String wifi = sc.nextLine();

        //Testing 1st method
//        int res = noOfRoomsBookedInGivenMonth(arr, month);
//        if(res > 0) {
//            System.out.println(res);
//        } else {
//            System.out.println("No rooms booked in the given month");
//        }

        //Testing 2nd method
        Hotel obj = searchHotelByWifiOption(arr, wifi);
        if (obj == null) {
            System.out.println("No such option available");
        } else {
            System.out.println(obj.getHotelId());
        }

    }


    //this method will return total no of room booked for the given month(String parameter passed)
    static int noOfRoomsBookedInGivenMonth(Hotel[] arr, String month) {
        int totalNum = 0;

        for(Hotel h : arr) {
            String strDate = h.getDateOfBooking(); //Ex- 17-feb-2023
            String strMonth = strDate.substring(3,6); //feb
            if (strMonth.equalsIgnoreCase(month)) {
                totalNum += h.getNoOfRoomBooked();
            }
        }

        return totalNum;
    }



    //this method will return hotel object with second-highest bill

    static Hotel searchHotelByWifiOption(Hotel [] arr, String wifi) {
        Hotel[] refined  = new Hotel[0];

        for(int i=0; i< arr.length; i++) {
            if(arr[i].getWifiFacility().equalsIgnoreCase(wifi)) {
                refined = Arrays.copyOf(refined, refined.length+1);
                refined[refined.length-1] = arr[i];
            }
        }

        for (int i=0; i< refined.length-1; i++) {
            for (int j=0; j<refined.length-1-i; j++) {
                if (refined[j].getTotalBill() < refined[j+1].getTotalBill()) {
                    Hotel temp = refined[j];
                    refined[j] = refined[j+1];
                    refined[j+1] = temp;
                }
            }
        }
        if(refined.length <= 1) {
            return null;
        } else {
            return refined[1]; //cause at 0 there will be the highest value and at 1 second-highest value/
        }
    }

}



class Hotel {
    private int hotelId;
    private String hotelName;
    private String dateOfBooking;
    private int noOfRoomBooked;
    private String wifiFacility;
    double totalBill;

    //Constructors

    public Hotel(int hotelId, String hotelName, String dateOfBooking, int noOfRoomBooked, String wifiFacility, double totalBill) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.dateOfBooking = dateOfBooking;
        this.noOfRoomBooked = noOfRoomBooked;
        this.wifiFacility = wifiFacility;
        this.totalBill = totalBill;
    }

    //Getters and Setters
    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getDateOfBooking() {
        return dateOfBooking;
    }

    public void setDateOfBooking(String dateOfBooking) {
        this.dateOfBooking = dateOfBooking;
    }

    public int getNoOfRoomBooked() {
        return noOfRoomBooked;
    }

    public void setNoOfRoomBooked(int noOfRoomBooked) {
        this.noOfRoomBooked = noOfRoomBooked;
    }

    public String getWifiFacility() {
        return wifiFacility;
    }

    public void setWifiFacility(String wifiFacility) {
        this.wifiFacility = wifiFacility;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }
}



        /*101
        Best stay
        01-Jan-2022
        10
        Yes
        20000
        102
        Apple
        12-Feb-2022
        3
        Yes
        4000
        103
        Accrod
        11-May-2022
        5
        Yes
        15000
        104
        Royal
        22-Dec-2022
        7
        Yes
        12000
        May
        Yes*/