import entities.Course;
import entities.Student;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Santosh Phaiju", 20, "santoshphaiju@gmail.com", "Male");

        Course java = new Course("crs1", "Java Programming");
        Course javaScript = new Course("crs2", "JavaScript Programming");
        Course python = new Course("crs3", "Python Programming");

        List<Course> courseList = new ArrayList<>();
        // Add courses
        courseList.add(java);
        courseList.add(javaScript);
        courseList.add(python);

        s1.setCourses(courseList);

        // print courses
        System.out.println("After adding courses");
        for (Course course: s1.getCourses()) {
            System.out.println(course.getCourseId() + " " + course.getCourseName());
        }

        // update course
        System.out.println("After updating courses");
        java.setCourseName("Advanced Java Programming");
        s1.getCourses().set(0, java);


        // print courses
        for (Course course: s1.getCourses()) {
            System.out.println(course.getCourseId() + " " + course.getCourseName());
        }

        // remove course
        s1.getCourses().remove(1);
        System.out.println("After removing course");

        // print courses
        for (Course course: s1.getCourses()) {
            System.out.println(course.getCourseId() + " " + course.getCourseName());
        }

    }
}