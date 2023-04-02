package com.X30Marks.Movie_Get_Movie_By_Genre;

import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Movie movies[] = new Movie[4];
        for(int i=0; i<movies.length; i++) {
            String a = sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt(); sc.nextLine();
            movies[i] = new Movie(a, b, c, d);
        }
        String searchGenre = sc.nextLine();
        sc.close();

        Movie res[] = getMovieByGenre(movies, searchGenre);
        for(int i=0; i<res.length; i++) {
            if(res[i].getBudget() > 80000000)
                System.out.println("High Budget Movie");
            else
                System.out.println("Low Budget Movie");
        }
    }
    public static Movie[] getMovieByGenre(Movie movies[], String searchGenre) {
        Movie r[] = new Movie[0];
        for(int i=0; i<movies.length; i++) {
            if(movies[i].getGenre().equalsIgnoreCase(searchGenre)) {
                r = Arrays.copyOf(r, r.length+1);
                r[r.length-1] = movies[i];
            }
        }
        return r;
    }
}

class Movie {
    private String movieName;
    private String company;
    private String genre;
    private int budget;

    public Movie(String movieName, String company, String genre, int budget){
        this.movieName = movieName;
        this.company = company;
        this.genre = genre;
        this.budget = budget;
    }

    public String getGenre() {
        return genre;
    }
    public int getBudget() {
        return budget;
    }
}