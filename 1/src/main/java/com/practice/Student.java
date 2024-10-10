package com.practice;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private int id;
    private String name;
    private int grade;
    private int feesPaid;
    private int feesTotal;

    public Student(int id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.feesPaid = 0;
        this.feesTotal = 30000; // Assume total fees is 30000 for all students
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getFeesPaid() {
        return feesPaid;
    }

    public int getFeesTotal() {
        return feesTotal;
    }

    public int getRemainingFees() {
        return feesTotal - feesPaid;
    }

    public void payFees(int fees) {
        this.feesPaid += fees;
    }

    @Override
    public String toString() {
        return "Student's name: " + name +
               ", Total fees paid so far: $" + feesPaid;
    }
}