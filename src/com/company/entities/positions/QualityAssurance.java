package com.company.entities.positions;

import com.company.entities.interfaces.IQualityAssurance;

public class QualityAssurance extends Employee implements IQualityAssurance {

    public QualityAssurance(){
        super();
    }

    public QualityAssurance(String name, String surname, boolean gender, int salary, int experience, int projectID){
        super(name, surname, gender, salary, experience, projectID);
    }

    public QualityAssurance(int id, String name, String surname, boolean gender, int salary, int experience, int projectID){
        super(id, name, surname, gender, salary, experience, projectID);
    }

    @Override
    public String testApplication(){
        return "I'm testing application";
    }

    @Override
    public String work(){
        return this.testApplication();
    }
}
