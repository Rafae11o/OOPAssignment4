package com.company.entities.positions;

import com.company.entities.interfaces.IHumanResource;

public class HumanResource extends Employee implements IHumanResource {

    public HumanResource(){
        super();
    }

    public HumanResource(String name, String surname, boolean gender, int salary, int experience, int projectID){
        super(name, surname, gender, salary, experience, projectID);
    }

    public HumanResource(int id, String name, String surname, boolean gender, int salary, int experience, int projectID){
        super(id, name, surname, gender, salary, experience, projectID);
    }

    @Override
    public String hireEmployees(){
        return "I'm hiring employees";
    }

    @Override
    public String work(){
        return this.hireEmployees();
    }
}
