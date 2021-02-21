package com.company.entities.positions;

public class SeniorBackendDeveloper extends BackendDeveloper{

    public SeniorBackendDeveloper(){
        super();
    }

    public SeniorBackendDeveloper(String name, String surname, boolean gender, int salary, int experience, int projectID){
        super(name, surname, gender, salary, experience, projectID);
    }

    public SeniorBackendDeveloper(int id, String name, String surname, boolean gender, int salary, int experience, int projectID){
        super(id, name, surname, gender, salary, experience, projectID);
    }

    public String helpToJunior(JuniorBackendDeveloper junior){
        if(junior.getGender()) return "I'm helping to " + junior.getName()+", because he is junior";
        else return "I'm helping to +" + junior.getName() + ", because she is junior";
    }

    @Override
    public String writeBackendCode() {
        return "I'm writing cool backend";
    }
}
