package fiuitcourses;

import java.util.Comparator;
/*
 @author Michael Juarez
 @version 1.0 Due date: 7-5-2015
 Description of program:

 This is the Course by FLA Name comparator
 
 This comparator object will compare the course object by it's FLAname attribute
 */
public class CourseByFLANameComparator implements Comparator {

    public int compare(Object obj1, Object obj2)
    {
        Course course1 = (Course) obj1;
        Course course2 = (Course) obj2;
        
        return course1.FLACourseName.compareTo(course2.FLACourseName);
    }
}
