package com.company.entities.positions;

import com.company.entities.interfaces.IBackendDeveloper;

abstract public class BackendDeveloper extends Employee implements IBackendDeveloper {

    public BackendDeveloper(){
        super();
    }

    public BackendDeveloper(String name, String surname, boolean gender, int salary, int experience, int projectID){
        super(name, surname, gender, salary, experience, projectID);
    }

    public BackendDeveloper(int id, String name, String surname, boolean gender, int salary, int experience, int projectID){
        super(id, name, surname, gender, salary, experience, projectID);
    }

    @Override
    public String work(){
        return this.writeBackendCode();
    }
}
