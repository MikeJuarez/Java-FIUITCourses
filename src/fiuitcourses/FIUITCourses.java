package fiuitcourses;
/*
 @author Michael Juarez
 @version 1.0 Due date: 7-5-2015
 Description of program:

 This is the driver class. 

 1. Create a new driver class that will process an arrayList of Course objects.  The driver will prompt the user to enter the core courses required for the IT major, and will ask for all the information required to populate all the attributes of the Course object.
 2. Once the arrayList of Courses is created, the driver will display a menu to the user, to select which order to print the Course arrayList :
 by FIUCourseName, or by yearLevel.  The driver will use Collections.sort  to sort the arrayList, using the Comparable interface for sorting by FIUCourseName, and the Comparator object for sorting by yearLevel.     

 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FIUITCourses {

    /**
     * @param args
     */
    @SuppressWarnings("empty-statement")

    //Driver Class
    public static void main(String[] args) {

        ArrayList<Course> courseList = new ArrayList();

        String courseFin = "Y";

        int courseCount = 1;
        Scanner keyboard = new Scanner(System.in);

        //Introduction            
        System.out.println("Hello, welcome to the FIUITCourses program.");

        //Start taking input from user:
        while (courseFin.equalsIgnoreCase("Y")) {

            //Variables needed for Loop
            String FIUCourseName = null;
            double credits = 0;
            String FLACourseName = null;
            int yearLevel = 0;
            String preReqAns = null;
            String preReqFin = "Y";

            //Introduction
            System.out.println("Ready to process Course number " + courseCount + ".");

            //Input for Course Name
            try {
                System.out.print("Please enter the FIU Course Name: ");
                FIUCourseName = keyboard.nextLine();
            } catch (Exception e) {
                System.out.println("Error!");
                e.printStackTrace();
            }

            //Input for Florida Course Name
            try {
                System.out.print("Please enter the Florida Course Name: ");
                FLACourseName = keyboard.nextLine();
            } catch (Exception e) {
                System.out.println("Error!");
                e.printStackTrace();
            }

            //Input for Credits
            try {
                System.out.print("Please enter the Credits: ");
                credits = keyboard.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Next time enter a number, not a letter!");
            } catch (Exception e) {
                System.out.println("Error!");
                e.printStackTrace();
            }
            keyboard.nextLine();

            //Input for Year Level
            try {
                System.out.print("Please enter the Year Level: ");
                yearLevel = keyboard.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Next time enter a number, not a letter!");
            } catch (Exception e) {
                System.out.println("Error!");
                e.printStackTrace();
            }
            keyboard.nextLine();

            //Variables needed for preReq loop
            ArrayList<String> preReqs = new ArrayList();
            int count = 1;

            //While loop made to capture all prereq's.  
            while (preReqFin.equalsIgnoreCase("Y")) {
                try {
                    System.out.print("Please enter prerequisite number " + count + ": ");
                    preReqAns = keyboard.nextLine();
                } catch (Exception e) {
                    System.out.println("Error!");
                    e.printStackTrace();
                }

                preReqs.add(preReqAns);
                count++;

                try {
                    System.out.print("Type 'Y' or 'y' to add another prerequisite, or type any other key to stop: ");
                    preReqFin = keyboard.nextLine();
                } catch (Exception e) {
                    System.out.println("Error!");
                    e.printStackTrace();
                }
            }
            System.out.println();

            System.out.println("Thank you for your input!");
            System.out.println("Now saving your entry to the course list...");
            System.out.println();

            //Initialize course variable after we got the answers
            Course course = new Course(FIUCourseName, credits, FLACourseName, yearLevel, preReqs);

            //Add to courseList ArrayList
            courseList.add(course);

            //Increment courseCount (display purposes only)
            courseCount++;

            //Print out the course objects in courseList
            System.out.println("Displaying your unsorted Course list: ");
            getCourseList(courseList);

            System.out.println();

            //Ask if user wants to add another course
            try {
                System.out.print("Type 'Y' if you'd like to adding another course, or type any other key to stop: ");
                courseFin = keyboard.nextLine();
            } catch (Exception e) {
                System.out.println("Error!");
                e.printStackTrace();
            }
            System.out.println();
            System.out.println();
        }

        //Used for sorting
        int sortAns = 0;

        //Ask user if they want to sort by course name or credits
        while (!(sortAns == 1 || sortAns == 2)) {
            System.out.println("Now it is time to choose how we should sort, then display your list.");
            System.out.println("How should we sort your list?");
            System.out.println("Type '1' to sort your list by Course Name");
            System.out.println("Type '2' to sort your list by Credits");

            try {
                System.out.print("Please type 1 or 2 for your selection: ");
                sortAns = keyboard.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Next time enter a number, not a letter!");
            }

            keyboard.nextLine();
            System.out.println();
            System.out.println();

            //Course name Sort
            if (sortAns == 1) {
                Collections.sort(courseList, new CourseByFLANameComparator());
                System.out.println("Here is your sorted list by Course Name: ");

                //Year Level Sort
            } else if (sortAns == 2) {
                Collections.sort(courseList, new CourseByLevelComparator());
                System.out.println("Here is your sorted list by Year Level: ");

                //Fix if wrong answer    
            } else {
                System.out.println("Not a valid option, please try again. ");
            }

        }

        //Print out sorted list
        getCourseList(courseList);
        System.out.println();
        System.out.println();
    }

//Helper method to print out all objects in courseList array
    public static void getCourseList(ArrayList<Course> courseList) {
        for (int i = 0; i < courseList.size(); i++) {
            System.out.println("Course number " + (i + 1) + ": ");
            System.out.println(courseList.get(i));
            System.out.println("----------------------------");
            System.out.println();
        }

    }
}
