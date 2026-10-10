package com.Airtribe.Learning.service;

import com.Airtribe.Learning.entity.Student;
import com.Airtribe.Learning.exception.EntityNotFoundException;
import com.Airtribe.Learning.utility.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private final List<Student> students = new ArrayList<>();

    public Student addStudent(String firstName, String lastName, String email, String batch)
    {
        Student student = new Student(
                IdGenerator.generateid(),
                firstName,
                lastName,
                email,
                batch,
                true
        );

        students.add(student);
        return student;
    }

    public List<Student> getAllStudents()
    {
        return students;
    }

    public Student getStudentById(int id)
    {
        for(Student student : students)
        {
            if(student.getId() == id)
            {
                return student;
            }
        }

        throw new EntityNotFoundException(
                "Student Id Not Found: " + id
        );
    }

    public void updateStudent(int id, String firstName, String lastName, String email, String batch)
    {
        Student student = getStudentById(id);

        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setBatch(batch);
    }

    public void deleteStudent(int id)
    {
        Student student = getStudentById(id);
        students.remove(student);
    }


}
