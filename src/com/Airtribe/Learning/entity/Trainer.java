package com.Airtribe.Learning.entity;

public class Trainer extends Person {
    private String specialization;

    public Trainer()
    {
        super();
    }

    public Trainer(int id, String firstName, String lastName, String email)
    {
        super(id, firstName, lastName, email);
        this.specialization = specialization;
    }

    public String getSpecialization()
    {
        return specialization;
    }

    public void setSpecialization(String specialization)
    {
        this.specialization = specialization;
    }

    @Override
    public String ToString()
    {
        return "Trainer:" + super.getDisplayName();
    }
}
