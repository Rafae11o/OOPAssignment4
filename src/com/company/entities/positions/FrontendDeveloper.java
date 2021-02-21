package com.company.entities.positions;

import com.company.entities.interfaces.IFrontendDeveloper;

public class FrontendDeveloper extends Employee implements IFrontendDeveloper {

    public FrontendDeveloper(){
        super();
    }

    public FrontendDeveloper(String name, String surname, boolean gender, int salary, int experience, int projectID){
        super(name, surname, gender, salary, experience, projectID);
    }

    public FrontendDeveloper(int id, String name, String surname, boolean gender, int salary, int experience, int projectID){
        super(id, name, surname, gender, salary, experience, projectID);
    }

    @Override
    public String createFrontend(){
        return "I'm creating frontend";
    }

    @Override
    public String work(){
        return this.createFrontend();
    }
}