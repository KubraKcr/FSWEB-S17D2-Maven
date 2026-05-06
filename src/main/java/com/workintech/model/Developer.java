package com.workintech.model;

public class Developer {


    private long id;
    private String  name;
    private  double salary;
    Experience experience;

    public Developer(long id, String name, Experience experience, double salary) {
        this.id = id;
        this.name = name;
        this.experience = experience;
        this.salary = salary;
    }

    public int getId() {
        return (int) id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Experience getExperience() {
        return experience;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }
}
