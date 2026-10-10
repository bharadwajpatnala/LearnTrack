package com.Airtribe.Learning.entity;

import java.time.LocalDate;

public class Enrollment {
    private int id;
    private Student student;
    private Course course;
    private LocalDate enrollmentDate;
    private String status;

    public Enrollment()
    {

    }

    public Enrollment(int id, Student student, Course course, LocalDate enrollmentDate, String status)
    {
        this.id = id;
        this.student = student;
        this.course = course;
        this.enrollmentDate =  enrollmentDate;
        this.status = status;
    }

    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }

    public Student getStudentId()
    {
        return student;
    }
    public void setStudentId(Student studentId)
    {
        this.student = student;
    }

    public Course getCourseId()
    {
        return course;
    }
    public void setCourseId(Course course)
    {
        this.course = course;
    }

    public LocalDate getEnrollmentDate()
    {
        return enrollmentDate;
    }
    public void setEnrollmentDate(LocalDate enrollmentDate)
    {
        this.enrollmentDate = enrollmentDate;
    }

    public String getStatus()
    {
        return status;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }
}
