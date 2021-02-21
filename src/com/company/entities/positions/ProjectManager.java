package com.company.entities.positions;

import com.company.entities.interfaces.IProjectManager;

public class ProjectManager extends Employee implements IProjectManager {

    public ProjectManager(){
        super();
    }

    public ProjectManager(String name, String surname, boolean gender, int salary, int experience, int projectID){
        super(name, surname, gender, salary, experience, projectID);
    }

    public ProjectManager(int id, String name, String surname, boolean gender, int salary, int experience, int projectID){
        super(id, name, surname, gender, salary, experience, projectID);
    }

    @Override
    public String doProjectManagerWork(){
       return "I'm do nothing..."; //PMs please don't kill me, I'm just kidding
    }

    @Override
    public String work(){
        return doProjectManagerWork();
    }
}
