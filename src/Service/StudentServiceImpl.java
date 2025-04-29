package Service;

import entities.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    List<Student> studentList = new ArrayList<>();

    @Override
    public void addStudent(Student student) {
        this.studentList.add(student);
    }

    @Override
    public Student removeStudent(int index) {
        Student removedStudent = studentList.get(index);
        this.studentList.remove(removedStudent);
        return removedStudent;
    }

    @Override
    public Student updateStudent(int index, Student student) {
        studentList.set(index, student);
        return student;
    }

    @Override
    public void printAllStudents() {
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Override
    public Student getStudent(int index) {
        return studentList.get(index);
    }

    @Override
    public List<Student> getStudentList() {
        return studentList;
    }
}