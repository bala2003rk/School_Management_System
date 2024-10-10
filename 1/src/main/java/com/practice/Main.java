package com.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Teacher> teacherList = new ArrayList<>();
        List<Student> studentList = new ArrayList<>();

   
        School school = new School(teacherList, studentList);

        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;

        while (keepRunning) {
            System.out.println("\nSchool Management System");
            System.out.println("1. Add a teacher");
            System.out.println("2. Add a student");
            System.out.println("3. Pay student fees");
            System.out.println("4. Pay teacher salary");
            System.out.println("5. View school finances");
            System.out.println("6. Print all students");
            System.out.println("7. Print all teachers");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter teacher's ID: ");
                    int teacherId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over
                    System.out.print("Enter teacher's name: ");
                    String teacherName = scanner.nextLine();
                    Teacher teacher = new Teacher(teacherId, teacherName, 0);
                    school.addTeacher(teacher);
                    System.out.println("Teacher added successfully.");
                    break;

                case 2:
                    System.out.print("Enter student's ID: ");
                    int studentId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over
                    System.out.print("Enter student's name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter student's grade (1-12): ");
                    int grade = scanner.nextInt();

                    if (grade < 1 || grade > 12) {
                        System.out.println("Invalid grade! Grade should be between 1 and 12.");
                    } else {
                        Student student = new Student(studentId, studentName, grade);
                        school.addStudent(student);
                        System.out.println("Student added successfully.");
                    }
                    break;

                case 3:
                    System.out.print("Enter student ID to pay fees: ");
                    int sId = scanner.nextInt();
                    Student payingStudent = findStudentById(sId, studentList);
                    if (payingStudent != null) {
                        System.out.print("Enter amount to pay (remaining: " + payingStudent.getRemainingFees() + "): ");
                        int fees = scanner.nextInt();
                        if (fees > payingStudent.getRemainingFees()) {
                            System.out.println("Amount exceeds the remaining fees. Cannot pay more than " + payingStudent.getRemainingFees());
                        } else {
                            payingStudent.payFees(fees);
                            school.updateTotalMoneyEarned(fees);
                            System.out.println("Fees paid successfully.");
                        }
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter teacher ID to pay salary: ");
                    int tId = scanner.nextInt();
                    Teacher payingTeacher = findTeacherById(tId, teacherList);
                    if (payingTeacher != null) {
                        System.out.print("Enter salary amount: ");
                        int salary = scanner.nextInt();
                        payingTeacher.receiveSalary(salary);
                        school.updateTotalMoneySpent(salary);
                        System.out.println("Salary paid successfully.");
                    } else {
                        System.out.println("Teacher not found.");
                    }
                    break;

                case 5:
                    System.out.println(school);
                    break;

                case 6:
                    if (studentList.isEmpty()) {
                        System.out.println("No students added.");
                    } else {
                        System.out.println("List of students:");
                        for (Student student : studentList) {
                            System.out.println(student);
                        }
                    }
                    break;

                case 7:
                    if (teacherList.isEmpty()) {
                        System.out.println("No teachers added.");
                    } else {
                        System.out.println("List of teachers:");
                        for (Teacher teacherObj : teacherList) {
                            System.out.println(teacherObj);
                        }
                    }
                    break;

                case 8:
                   
                    keepRunning = false;
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static Student findStudentById(int id, List<Student> students) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null; 
    }

    private static Teacher findTeacherById(int id, List<Teacher> teachers) {
        for (Teacher teacher : teachers) {
            if (teacher.getId() == id) {
                return teacher;
            }
        }
        return null; 
    }
}
