package com.company.entities.positions;

import com.company.entities.interfaces.ISystemAdministrator;

public class SystemAdministrator extends Employee implements ISystemAdministrator {

    public SystemAdministrator(){
        super();
    }

    public SystemAdministrator(String name, String surname, boolean gender, int salary, int experience, int projectID){
        super(name, surname, gender, salary, experience, projectID);
    }

    public SystemAdministrator(int id, String name, String surname, boolean gender, int salary, int experience, int projectID){
        super(id, name, surname, gender, salary, experience, projectID);
    }

    @Override
    public String administrateSystem(){
        return "I'm dropping server and administrating system... ";
    }

    @Override
    public String work(){
        return this.administrateSystem();
    }
}
