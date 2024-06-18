/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm;

/**
 *
 * @author FPTSHOP
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentManager {
    private ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(String studentId, String name, double marks) {
        Student student = new Student(studentId, name, marks);
        students.add(student);
    }

    public boolean editStudent(String studentId, String name, Double marks) {
        Student student = searchStudentById(studentId);
        if (student != null) {
            if (name != null) {
                student.setName(name);
            }
            if (marks != null) {
                student.setMarks(marks);
            }
            return true;
        }
        return false;
    }

    public boolean deleteStudent(String studentId) {
        Student student = searchStudentById(studentId);
        if (student != null) {
            students.remove(student);
            return true;
        }
        return false;
    }

    public void sortStudents() {
        Collections.sort(students, Comparator.comparingDouble(Student::getMarks).reversed());
    }

    public Student searchStudentById(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    public ArrayList<Student> searchStudentByName(String name) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                result.add(student);
            }
        }
        return result;
    }

    public void displayStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
