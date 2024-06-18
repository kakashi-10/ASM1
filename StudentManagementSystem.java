/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package asm;

/**
 *
 * @author FPTSHOP
 */
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Sort Students");
            System.out.println("5. Search Student by ID");
            System.out.println("6. Search Student by Name");
            System.out.println("7. Display All Students");
            System.out.println("8. Exit");

            System.out.print("Function you want to use: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter Student ID: ");
                    String studentId = scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Student Marks: ");
                    double marks = scanner.nextDouble();
                    scanner.nextLine();  // Consume the newline
                    manager.addStudent(studentId, name, marks);
                    break;
                case "2":
                    System.out.print("Enter Student ID to edit: ");
                    String editId = scanner.nextLine();
                    System.out.print("Enter new name (leave blank to keep unchanged): ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new marks (leave blank to keep unchanged): ");
                    String newMarksStr = scanner.nextLine();
                    Double newMarks = newMarksStr.isEmpty() ? null : Double.parseDouble(newMarksStr);
                    if (manager.editStudent(editId, newName.isEmpty() ? null : newName, newMarks)) {
                        System.out.println("Student information has been successfully updated.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case "3":
                    System.out.print("Student ID wants to delete: ");
                    String deleteId = scanner.nextLine();
                    if (manager.deleteStudent(deleteId)) {
                        System.out.println("Student deleted successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case "4":
                    manager.sortStudents();
                    System.out.println("Students sorted by marks.");
                    break;
                case "5":
                    System.out.print("Student ID you want to find: ");
                    String searchId = scanner.nextLine();
                    Student student = manager.searchStudentById(searchId);
                    if (student != null) {
                        System.out.println(student);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case "6":
                    System.out.print("Name of the student you want to search for: ");
                    String searchName = scanner.nextLine();
                    ArrayList<Student> students = manager.searchStudentByName(searchName);
                    if (!students.isEmpty()) {
                        for (Student s : students) {
                            System.out.println(s);
                        }
                    } else {
                        System.out.println("No students found with that name.");
                    }
                    break;
                case "7":
                    manager.displayStudents();
                    break;
                case "8":
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

