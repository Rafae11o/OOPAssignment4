package com.company.entities.positions;

import com.company.entities.interfaces.IDesigner;

public class Designer extends Employee implements IDesigner {

    public Designer(){
        super();
    }

    public Designer(String name, String surname, boolean gender, int salary, int experience, int projectID){
        super(name, surname, gender, salary, experience, projectID);
    }

    public Designer(int id, String name, String surname, boolean gender, int salary, int experience, int projectID){
        super(id, name, surname, gender, salary, experience, projectID);
    }

    public String adjustUX(){ return "I'm adjusting user experience";}
    public String createDesign(){
        return "I'm creating design of project";
    }

    @Override
    public String work(){
        return this.createDesign() + ". Also " + this.adjustUX();
    }
}
