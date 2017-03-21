package fiuitcourses;
/*
 @author Michael Juarez
 @version 1.0 Due date: 7-5-2015
 Description of program:

 This is the Course by year level comparator
 
 This comparator object will compare the course object by year level attribute
 */
import java.util.Comparator;

public class CourseByLevelComparator implements Comparator {
    
    public int compare(Object obj1, Object obj2)
    {
        Course course1 = (Course) obj1;
        Course course2 = (Course) obj2;
        if (course1.yearLevel > course2.yearLevel)
            return 1;
        else if (course1.yearLevel < course2.yearLevel)
            return -1;
        else
            return 0;
    }
    
    
    
}
