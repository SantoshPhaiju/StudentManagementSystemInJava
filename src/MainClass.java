import Service.StudentService;
import Service.StudentServiceImpl;
import entities.Course;
import entities.Student;

import java.util.List;
import java.util.*;


public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentService studentService = new StudentServiceImpl();
        boolean runProgram = true;


        while (runProgram) {
            int choice;
            System.out.println("Enter \n 1 to add \n 2 to remove \n 3 update \n 4 fetch students \n 5 to exit program \n 6 to add course");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // take new date from user and add
                    Student student = new Student();

                    System.out.println("Enter student name: ");
                    String name = scanner.nextLine();

                    System.out.println("Enter student age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter student email: ");
                    String email = scanner.nextLine();

                    System.out.println("Enter student gender: ");
                    String gender = scanner.nextLine();


                    student.setName(name);
                    student.setAge(age);
                    student.setEmail(email);
                    student.setGender(gender);

                    studentService.addStudent(student);
                    System.out.println("Student added successfully !!!");
                    break;
                case 2:
                    System.out.println("Enter the student index to remove: ");
                    int index = scanner.nextInt();
                    Student removedStudent = studentService.removeStudent(index);
                    System.out.println(removedStudent.getName() + " is removed successfully !!!");
                    break;

                case 3:
                    // update students...
                    // ask user index
                    System.out.println("Enter the index of student to update (starting from 0):");
                    int indexToUpdate = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter new student name:");
                    String updatedName = scanner.nextLine();

                    System.out.println("Enter new student age:");
                    Integer updatedAge = scanner.nextInt();
                    scanner.nextLine();


                    System.out.println("Enter new student email:");
                    String updatedEmail = scanner.nextLine();

                    System.out.println("Enter new student gender:");
                    String updatedGender = scanner.nextLine();

                    Student updatedStudent = new Student();
                    updatedStudent.setName(updatedName);
                    updatedStudent.setAge(updatedAge);
                    updatedStudent.setEmail(updatedEmail);
                    updatedStudent.setGender(updatedGender);

                    studentService.updateStudent(indexToUpdate, updatedStudent);
                    break;
                case 4:
                    // get all students
                    // display all students
                    List<Student> students = studentService.getStudentList();
                    System.out.println("-----Displaying all students in the list----");
                    for (Student stdData : students) {
                        System.out.println(stdData.getName() + " " + stdData.getAge() + " " + stdData.getEmail() + " " + stdData.getGender());

                        if (stdData.getCourses() != null) {
                            for (Course course : stdData.getCourses()) {
                                System.out.println(course.getCourseId() + " " + course.getCourseName());
                            }
                        }
                    }
                    break;
                case 5:
                    runProgram = false;
                    break;

                case 6:
                    // take student name from user and find index
                    System.out.println("Enter the student name:- ");
                    String stdName = scanner.nextLine();
                    Student newStd = new Student();

                    for (Student stdData : studentService.getStudentList()) {
                        if (stdData.getName().equals(stdName)) {
                            newStd = stdData;
                        }
                    }

                    // take course data from the user
                    System.out.println("Enter the course to add:- ");
                    System.out.println("Enter course name: ");
                    String courseName = scanner.nextLine();
                    System.out.println("Enter course id to add: ");
                    String courseId = scanner.nextLine();
                    Course newCourse = new Course(courseId, courseName);
                    newStd.getCourses().add(newCourse);
                    System.out.println(courseName + " added successfully !!!");
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        }
    }

}