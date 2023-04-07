package com.X30Marks.CourseProgram;

import java.util.*;
public class CourseProgram {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                Course c[] = new Course[4];
                for (int i=0; i<c.length; i++) {
                        int a = sc.nextInt();sc.nextLine();
                        String b = sc.nextLine();
                        String cc = sc.nextLine();
                        int d = sc.nextInt();sc.nextLine();
                        int e = sc.nextInt();sc.nextLine();
                        c[i] = new Course(a, b, cc, d, e);
                }

                String pCAdmin = sc.nextLine();
                int pHandson = sc.nextInt();sc.nextLine();
                sc.close();

                int r1 = findAvgOfQuizByAdmin(c, pCAdmin);
                if (r1 != 0) {
                        System.out.println(r1);
                } else {
                        System.out.println("No Course found.");
                }

                Course r2[] = sortCourseByHandsOn(c, pHandson);
                if (r2 != null) {
                        for (int i=0; i< r2.length; i++) {
                                System.out.println(r2[i].getCourseName());
                        }
                } else {
                        System.out.println("No Course found with mentioned attribute.");
                }

        }

        public static int findAvgOfQuizByAdmin(Course c[], String pCAdmin) {
                int noOfQuizQuestion = 0;
                int count = 0;
                for (int i=0; i<c.length; i++) {
                        if (c[i].getCourseAdmin().equalsIgnoreCase(pCAdmin)) {
                                noOfQuizQuestion += c[i].getQuiz();
                                count++;
                        }
                }

                if (count > 0) {
                        int avg = noOfQuizQuestion / count;
                        return avg;
                } else {
                        return 0;
                }
        }

        public static Course[] sortCourseByHandsOn(Course c[], int pHandson) {
                Course temp = null;
                Course r[] = new Course[0];

                for (int i=0; i<c.length; i++) {
                        if (c[i].getHandson() < pHandson) {
                                r = Arrays.copyOf(r, r.length+1);
                                r[r.length-1] = c[i];
                        }
                }

                //Sorting
                for (int i=0; i<r.length; i++) {
                        for (int j=i+1; j<r.length; j++) {
                                if (r[i].getHandson() > r[j].getHandson()) {
                                        temp = r[i];
                                        r[i] = r[j];
                                        r[j] = temp;
                                }
                        }
                }

                if (r.length != 0) {
                        return r;
                } else {
                        return null;
                }
        }

}

class Course {
        private int courseId;
        private String courseName;
        private String courseAdmin;
        private int quiz;
        private int handson;

        public Course (int courseId, String courseName, String courseAdmin, int quiz, int handson) {
                this.courseId = courseId;
                this.courseName = courseName;
                this.courseAdmin = courseAdmin;
                this.quiz = quiz;
                this.handson = handson;
        }

        public String getCourseAdmin() {
                return courseAdmin;
        }

        public int getQuiz() {
                return quiz;
        }

        public int getHandson() {
                return handson;
        }

        public String getCourseName() {
                return courseName;
        }
}
