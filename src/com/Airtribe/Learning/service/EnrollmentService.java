package com.Airtribe.Learning.service;

import com.Airtribe.Learning.entity.Course;
import com.Airtribe.Learning.entity.Enrollment;
import com.Airtribe.Learning.entity.Student;
import com.Airtribe.Learning.exception.EntityNotFoundException;
import com.Airtribe.Learning.utility.IdGenerator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentService {
    private static final List<Enrollment> enrollments = new ArrayList<>();

    private final StudentService studentService;
    private final CourseService courseService;

    public EnrollmentService(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    public Enrollment enrollStudent(int studentId, int courseId)
    {
        Student student = studentService.getStudentById(studentId);
        Course course = courseService.getCourseById(courseId);

        for(Enrollment enrollment : enrollments)
        {
            if(enrollment.getStudentId().getId() == studentId
                && enrollment.getCourseId().getId() == courseId
                && enrollment.getStatus() == "Active")
            {
                throw new IllegalArgumentException("Student is already enrolled in this course");
            }
        }

        Enrollment enrollment = new Enrollment(
                IdGenerator.generateid(),
                student,
                course,
                LocalDate.now(),
                "Active"
        );

        enrollments.add(enrollment);
        return enrollment;
    }

    public static List<Enrollment> getAllEnrollments()
    {
        return enrollments;
    }

    public void cancelEnrollment(int enrollmentId)
    {
        for(Enrollment enrollment : enrollments)
        {
            if(enrollment.getId() == enrollmentId)
            {
                enrollment.setStatus("Active");
            }
        }

        throw new EntityNotFoundException("Enrollment not found for id: " + enrollmentId);
    }
}
