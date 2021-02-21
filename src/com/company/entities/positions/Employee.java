package com.company.entities.positions;

import com.company.entities.interfaces.IEmployee;

public class Employee implements IEmployee {
    private int id;
    private String name;
    private String surname;
    private boolean gender;
    private int salary;
    private int experience;
    private int projectID;

    public Employee(){}

    public Employee(String name, String surname, boolean gender, int salary, int experience, int projectID){
        this.setName(name);
        this.setSurname(surname);
        this.setSalary(salary);
        this.setExperience(experience);
        this.setGender(gender);
        this.setProjectID(projectID);
    }

    public Employee(int id, String name, String surname, boolean gender, int salary, int experience, int projectID){
        this.id = id;
        this.setName(name);
        this.setSurname(surname);
        this.setSalary(salary);
        this.setExperience(experience);
        this.setGender(gender);
        this.setProjectID(projectID);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getId() { return id; }

    @Override
    public String toString(){
        return "Hi! My name is " + this.getName() + " " + this.getSurname() +
                "\nI have " + this.getExperience() + " year experience, so my salary is " + this.getSalary() +
                "\n" + this.work();
    }

    @Override
    public String work(){
        return "I'm employee without potion";
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }
}
