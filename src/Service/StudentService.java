package Service;

import entities.Student;

import java.util.List;

public interface StudentService {
    public void addStudent(Student student);

    public Student removeStudent(int index);

    public Student updateStudent(int index, Student student);

    public void printAllStudents();

    public List<Student> getStudentList();

    public Student getStudent(int index);


}
