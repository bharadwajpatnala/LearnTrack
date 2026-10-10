package com.Airtribe.Learning.ui;

import com.Airtribe.Learning.entity.Course;
import com.Airtribe.Learning.entity.Enrollment;
import com.Airtribe.Learning.entity.Student;
import com.Airtribe.Learning.service.CourseService;
import com.Airtribe.Learning.service.EnrollmentService;
import com.Airtribe.Learning.service.StudentService;

import java.util.Scanner;

public class Main {

    public static final Scanner scanner = new Scanner(System.in);

    public static final StudentService studentService = new StudentService();

    public static final CourseService courseService = new CourseService();

    public static final EnrollmentService enrollmentService = new EnrollmentService(studentService, courseService);

    public static void main(String[] args)
    {
        boolean running = true;

        while(running) {
            showMenu();

            int choice = readInt("Enter your choice");

            try {
                switch(choice) {
                    case 1: addStudent();
                    break;

                    case 2: viewStudents();
                    break;

                    case 3: updateStudent();
                    break;

                    case 4: deleteStudent();
                    break;

                    case 5: addCourse();
                    break;

                    case 6: viewCourse();
                    break;

                    case 7: updateCourse();
                    break;

                    case 8: deleteCourse();
                    break;

                    case 9: enrollStudent();
                    break;

                    case 10: viewEnrollment();
                    break;

                    case 11: cancelEnrollment();
                    break;

                    case 0:
                        running = false;
                        System.out.println("Exiting LMS");
                        break;

                    default:
                        System.out.println("Invalid choice");
                }
            } catch (Exception ex)
            {
                System.out.println("Error: " + ex.getMessage());
            }
        }
        scanner.close();
    }

    public static void showMenu() {
        System.out.println("\n----Learning Management System----");

        System.out.println("1. Add New Student");
        System.out.println("2. View Student");
        System.out.println("3. Update Student");
        System.out.println("4. Remove Student");

        System.out.println("5. Add New Course");
        System.out.println("6. View Course");
        System.out.println("7. Update Course");
        System.out.println("8. Remove Course");

        System.out.println("9. New Enrollment");
        System.out.println("10. View Enrollment");
        System.out.println("11. Cancel Enrollment");

        System.out.println("0. Exit");
    }

    //Student section
    public static void addStudent()
    {
        System.out.println("\n----Add Student----");
        String firstName = readString("First Name: ");
        String lastName = readString("Last Name: ");
        String email = readString("Email: ");
        String batch = readString("Batch: ");

        Student student = studentService.addStudent(
                firstName,
                lastName,
                email,
                batch
        );

        System.out.println(
                "Student Created Successfully. Id: " + student.getId()
        );
    }

    public static void viewStudents()
    {
        System.out.println("\n----Students----");

        if(studentService.getAllStudents().isEmpty())
        {
            System.out.println("No Students found");
            return;
        }

        for(Student student : studentService.getAllStudents())
        {
            System.out.println(
                    "Id: " + student.getId()
                    + " | Name: " + student.getDisplayName()
                    + " | Email: " + student.getEmail()
                    + " | Batch: " + student.getBatch()
                    + " | Active: " + student.isActive()
            );
        }
    }

    public static void updateStudent()
    {
        int id = readInt("Student Id: ");

        String firstName = readString("First Name: ");
        String lastName = readString("Last Name: ");
        String email = readString("Email: ");
        String batch = readString("Batch: ");

        studentService.updateStudent(
                id,
                firstName,
                lastName,
                email,
                batch
        );

        System.out.println("Student updated Successfully");
    }

    public static void deleteStudent()
    {
        int id = readInt("Student Id: ");

        studentService.deleteStudent(id);

        System.out.println("Student deleted successfully");
    }

    //Course Section
    public static void addCourse()
    {
        System.out.println("\n----Add Course----");

        String courseName = readString("Course Name: ");
        String description = readString("Description: ");
        int duration = readInt("Duration: ");


        Course course = courseService.addCourse(
                courseName,
                description,
                duration
        );
        System.out.println(
                "Course created successfully.Id: " + course.getId()
        );

    }

    public static void viewCourse()
    {
        System.out.println("\n----Courses----");

        if(courseService.getAllCourse().isEmpty())
        {
            System.out.println("No Courses found");
        }

        for(Course course : courseService.getAllCourse())
        {
            System.out.println(
                    "Id: " + course.getId()
                    + " | Course Name: " + course.getCourseName()
                    + " | Course Description: " + course.getDescription()
                    + " | Duration: " + course.getDuration()
                    + " | Active: " + course.isActive()
            );
        }
    }

    public static void updateCourse()
    {
        int id = readInt("Id: ");

        String courseName = readString("Name: ");
        String description = readString("Description: ");
        int duration = readInt("Duration: ");
        boolean active = readBoolean("Active: ");

        courseService.updateCourse(
                id,
                courseName,
                description,
                duration,
                active
        );

    }

    public static void deleteCourse()
    {
        int id = readInt("Id: ");

        courseService.deleteCourse(id);

        System.out.println("Course deleted successfully.");

    }

    //Enrollment section
    public static void enrollStudent()
    {
        int studentId = readInt("Student Id: ");
        int courseId = readInt("Course Id: ");

        Enrollment enrollment = enrollmentService.enrollStudent(
                studentId,
                courseId
        );

        System.out.println("Enrollment successful. Enrollment Id: " + enrollment.getId());
    }

    public static void viewEnrollment()
    {
        System.out.println("\n----Enrollments----");

        if(EnrollmentService.getAllEnrollments().isEmpty())
        {
            System.out.println("No enrollments found");
        }

        for(Enrollment enrollment : EnrollmentService.getAllEnrollments())
        {
            System.out.println(
                 "Enrollment Id: " + enrollment.getId()
                 + " | Student: " + enrollment.getStudentId().getDisplayName()
                 + " | Course: " + enrollment.getCourseId().getCourseName()
                 + " | Date: " + enrollment.getEnrollmentDate()
                 + " | Active: " + enrollment.getStatus()
            );
        }
    }

    public static void cancelEnrollment()
    {
        int id = readInt("Id: ");

        enrollmentService.cancelEnrollment(id);
        System.out.println("Enrollment Cancelled Successfully.");
    }

    private static boolean readBoolean(String message) {
        System.out.println(message);
        return scanner.nextBoolean();
    }

    private static String readString(String message) {

        System.out.print(message);

        return scanner.nextLine();
    }

    private static int readInt(String message) {

        while (true) {

            try {

                System.out.print(message);

                return Integer.parseInt(
                        scanner.nextLine()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number."
                );
            }
        }
    }

    private static double readDouble(String message) {

        while (true) {

            try {

                System.out.print(message);

                return Double.parseDouble(
                        scanner.nextLine()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid amount."
                );
            }
        }
    }
}
