package com.company.entities.positions;

import com.company.entities.interfaces.IDesignerAndFrontendDeveloper;

public class DesignerAndFrontendDeveloper extends Employee implements IDesignerAndFrontendDeveloper {
    public DesignerAndFrontendDeveloper(){
        super();
    }

    public DesignerAndFrontendDeveloper(String name, String surname, boolean gender, int salary, int experience, int projectID){
        super(name, surname, gender, salary, experience, projectID);
    }

    public DesignerAndFrontendDeveloper(int id, String name, String surname, boolean gender, int salary, int experience, int projectID){
        super(id, name, surname, gender, salary, experience, projectID);
    }

    @Override
    public String adjustUX(){ return "I'm adjusting user experience";}

    @Override
    public String createDesign(){
        return "I'm creating design of project";
    }

    @Override
    public String createFrontend(){
        return "I'm creating frontend";
    }

    @Override
    public String work(){
        return this.createFrontend() + ". Also " + this.adjustUX() + ". In addition " +this.createDesign();
    }

}
