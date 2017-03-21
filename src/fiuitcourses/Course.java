package fiuitcourses;
/*
 @author Michael Juarez
 @version 1.0 Due date: 7-5-2015
 Description of program:

 This is the Course class.
 1. Create a new class called Course, with attributes such as FIUCourseName, credits, FloridaCourseName, arrayList of preRequisites, and yearLevel.

 */

import java.util.ArrayList;

/**
 *
 * @author mtsguest
 */
public class Course implements Comparable<Course> {

    String FIUCourseName;
    double credits;
    String FLACourseName;
    int yearLevel;
    ArrayList<String> preReqs;

    public Course(String anFIUaCourse, double anyCredits, String aFLACourseName,
            int someYearLevel, ArrayList<String> somePreReqs) {
        FIUCourseName = anFIUaCourse;
        credits = anyCredits;
        FLACourseName = aFLACourseName;
        yearLevel = someYearLevel;
        //preReqs = somePreReqs;
        preReqs = new ArrayList<String>();
        for (int i = 0; i < somePreReqs.size(); i++) {
            preReqs.add(somePreReqs.get(i));
        }

    }

    public int compareTo(Course otherCourse) {
        return FIUCourseName.compareTo(otherCourse.FIUCourseName);
    }

    /*
     toString() method   
     */
    public String toString() {
        return ("FIU Course Name: " + FIUCourseName + "\n"
                + "Florida Course Name: " + FLACourseName + "\n"
                + "Credits: " + credits + "\n"
                + "Year Level: " + yearLevel + "\n"
                + "Prerequesites: \n" + getPrereqs());
    }

    /*
     This is a helper method for toString() Class
     It will create a concatenated string for all the prereqs    
     */
    public String getPrereqs() {
        String preReq = "";

        for (int i = 0; i < preReqs.size(); i++) {
            preReq = preReq + "Prereq " + (i + 1) + ": " + preReqs.get(i) + "\n";
        }

        return preReq;
    }

}
