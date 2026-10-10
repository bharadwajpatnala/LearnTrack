package com.Airtribe.Learning.entity;

public class Course {
    private int id;
    private String courseName;
    private String description;
    private int duration;
    private boolean active;

    public Course()
    {

    }

    public Course( int id, String courseName, String description, int duration, boolean active)
    {
        this.id = id;
        this.courseName = courseName;
        this.description = description;
        this.duration = duration;
        this.active = active;
    }

    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }

    public String getCourseName()
    {
        return courseName;
    }

    public void setCourseName(String courseName)
    {
        this.courseName = courseName;
    }

    public String getDescription()
    {
        return description;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getDuration()
    {
        return duration;
    }
    public void setDuration(int duration)
    {
        this.duration = duration;
    }
    public boolean isActive()
    {
        return active;
    }
    public void setActive(boolean active)
    {
        this.active = active;
    }
}
