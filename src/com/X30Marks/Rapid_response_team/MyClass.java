package com.X30Marks.Rapid_response_team;

import java.util.*;
public class MyClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RRT r[] = new RRT[4];
        for (int i=0; i<r.length; i++) {
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();sc.nextLine();
            String e = sc.nextLine();

            r[i] = new RRT(a, b, c, d, e);
        }

        String pProject = sc.nextLine();

        RRT r1 = getHighestPriorityTicket(r, pProject);
        if (r1 != null) {
            System.out.println(r1.getTicketNo());
            System.out.println(r1.getRaisedBy());
            System.out.println(r1.getAssignedTo());
        } else {
            System.out.println("No such Ticket");
        }
    }

    public static RRT getHighestPriorityTicket(RRT r[], String pProject) {
        int hP = Integer.MAX_VALUE;
        int idx = 0;
        for (int i=0 ;i<r.length; i++) {
            if (r[i].getPriority() < hP && r[i].getProject().equalsIgnoreCase(pProject)) {
                hP = r[i].getPriority();
                idx = i;
            }
        }

        if (hP == Integer.MAX_VALUE)
            return null;
        else
            return r[idx];
    }
}

class RRT {
    private int ticketNo;
    private String raisedBy;
    private String assignedTo;
    private int priority;
    private String project;

    public RRT(int ticketNo, String raisedBy, String assignedTo, int priority, String project) {
        this.ticketNo = ticketNo;
        this.raisedBy = raisedBy;
        this.assignedTo = assignedTo;
        this.priority = priority;
        this.project = project;
    }

    public int getTicketNo() {
        return ticketNo;
    }

    public String getRaisedBy() {
        return raisedBy;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public int getPriority() {
        return priority;
    }

    public String getProject() {
        return project;
    }

}
