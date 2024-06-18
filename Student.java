/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm;

/**
 *
 * @author FPTSHOP
 */
public class Student {
    private String studentId;
    private String name;
    private double marks;
    private String rank;

    public Student(String studentId, String name, double marks) {
        this.studentId = studentId;
        this.name = name;
        this.marks = marks;
        this.rank = calculateRank();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public String getRank() {
        return rank;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(double marks) {
        this.marks = marks;
        this.rank = calculateRank();
    }

    private String calculateRank() {
        if (0 <= marks && marks < 5.0) {
            return "Fail";
        } else if (5.0 <= marks && marks < 6.5) {
            return "Medium";
        } else if (6.5 <= marks && marks < 7.5) {
            return "Good";
        } else if (7.5 <= marks && marks < 9.0) {
            return "Very Good";
        } else if (9.0 <= marks && marks <= 10.0) {
            return "Excellent";
        } else {
            return "Invalid Marks";
        }
    }

    @Override
    public String toString() {
        return "ID: " + studentId + ", Name: " + name + ", Marks: " + marks + ", Rank: " + rank;
    }
}
