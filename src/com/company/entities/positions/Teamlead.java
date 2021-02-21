package com.company.entities.positions;

import com.company.entities.interfaces.ITeamlead;

public class Teamlead extends Employee implements ITeamlead {

    public Teamlead(){
        super();
    }

    public Teamlead(String name, String surname, boolean gender, int salary, int experience, int projectID){
        super(name, surname, gender, salary, experience, projectID);
    }

    public Teamlead(int id, String name, String surname, boolean gender, int salary, int experience, int projectID){
        super(id, name, surname, gender, salary, experience, projectID);
    }

    public String helpToJunior(JuniorBackendDeveloper junior){
        if(junior.getGender()) return "I'm helping to " + junior.getName()+", because he is junior";
        else return "I'm helping to +" + junior.getName() + ", because she is junior";
    }

    @Override
    public String leadTeam(){
        return "I'm managing a team";
    }

    @Override
    public String work(){
        return this.leadTeam();
    }
}
