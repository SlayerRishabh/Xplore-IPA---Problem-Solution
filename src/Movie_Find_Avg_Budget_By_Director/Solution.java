package Movie_Find_Avg_Budget_By_Director;

import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Movie movies[] = new Movie[4];
        for(int i=0; i<movies.length; i++) {
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt(); sc.nextLine();
            int d = sc.nextInt(); sc.nextLine();
            movies[i] = new Movie(a, b, c, d);
        }

        String p_director = sc.nextLine();
        int p_rating = sc.nextInt();sc.nextLine();
        int p_budget = sc.nextInt();

        int resB = findAvgBudgetByDirector(movies, p_director);
        if(resB > 0) {
            System.out.println(resB);
        } else
            System.out.println("Sorry - The given director has not yet directed any movie");

        Movie resR = getMovieByRatingBudget(movies, p_rating, p_budget);
        if(resR == null)
            System.out.println("Sorry - No movie is available with the specified rating and budget requirement");
        else
            System.out.println(resR.getMovieId());
    }

    public static int findAvgBudgetByDirector(Movie movies[], String p_director) {
        int c = 0;
        int b = 0;
        for(int i=0; i<movies.length; i++) {
            if(movies[i].getDirector().equalsIgnoreCase(p_director)) {
                b += movies[i].getBudget();
                c++;
            }
        }

        if(c > 0) {
            int avg = b/c;
            return avg;
        }else
            return 0;


    }

    public static Movie getMovieByRatingBudget(Movie movies[], int p_rating, int p_budget) {
        for(int i=0; i<movies.length; i++) {
            if(movies[i].getRating() == p_rating && movies[i].getBudget() == p_budget) {
                if(movies[i].getRating() / movies[i].getBudget() == 0) {
                    return movies[i];
                }
            }
        }
        return null;
    }
}

class Movie {
    private int movieId;
    private String director;
    private int rating;
    private int budget;

    public Movie(int movieId, String director, int rating, int budget) {
        this.movieId = movieId;
        this.director = director;
        this.rating = rating;
        this.budget = budget;
    }

    public String getDirector() {
        return director;
    }

    public int getBudget() {
        return budget;
    }

    public int getRating() {
        return rating;
    }

    public int getMovieId() {
        return movieId;
    }


}