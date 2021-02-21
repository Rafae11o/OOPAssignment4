package com.company.entities.positions;

public class JuniorBackendDeveloper extends BackendDeveloper {

    public JuniorBackendDeveloper(){
        super();
    }

    public JuniorBackendDeveloper(String name, String surname, boolean gender, int salary, int experience, int projectID){
        super(name, surname, gender, salary, experience, projectID);
    }

    public JuniorBackendDeveloper(int id, String name, String surname, boolean gender, int salary, int experience, int projectID){
        super(id, name, surname, gender, salary, experience, projectID);
    }

    @Override
    public String writeBackendCode(){
        return "I'm writing bad backend";
    }

}
