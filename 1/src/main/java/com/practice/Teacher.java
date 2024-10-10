
package com.practice;

public class Teacher {
    private int id;
    private String name;
    private int salaryEarned;

    public Teacher(int id, String name, int salaryEarned) {
        this.id = id;
        this.name = name;
        this.salaryEarned = salaryEarned;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSalaryEarned() {
        return salaryEarned;
    }

    public void receiveSalary(int salary) {
        salaryEarned += salary;
    }

    @Override
    public String toString() {
        return "Teacher's name: " + name +
               ", Salary earned: $" + salaryEarned;
    }
}