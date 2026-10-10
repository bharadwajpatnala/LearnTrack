package com.Airtribe.Learning.service;

import com.Airtribe.Learning.entity.Course;
import com.Airtribe.Learning.exception.EntityNotFoundException;
import com.Airtribe.Learning.utility.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class CourseService {
    private final List<Course> courses = new ArrayList<>();

    public Course addCourse(String courseName, String description, int duration)
    {
        Course course = new Course(
                IdGenerator.generateid(),
                courseName,
                description,
                duration,
                true
        );

        courses.add(course);
        return course;
    }

    public List<Course> getAllCourse()
    {
        return courses;
    }

    public Course getCourseById(int id)
    {
        for(Course course : courses)
        {
            if(course.getId() == id)
            {
                return course;
            }
        }

        throw new EntityNotFoundException(
                "Course Not Found: " + id
        );
    }

    public void updateCourse(int id,
                             String courseName,
                             String description,
                             int duration,
                             boolean active)
    {
        Course course = getCourseById(id);
        course.setCourseName(courseName);
        course.setDescription(description);
        course.setDuration(duration);
        course.isActive();
    }

    public void deleteCourse(int id)
    {
        Course course = getCourseById(id);
        courses.remove(course);
    }
}
