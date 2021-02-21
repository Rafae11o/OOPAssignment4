package com.company;

import com.company.database.PostgresDB;
import com.company.database.interfaces.IDB;
import com.company.repositories.EmployeesRepository;
import com.company.repositories.ProjectRepository;
import com.company.repositories.interfaces.IEmployeesRepository;
import com.company.repositories.interfaces.IProjectRepository;

public class Main {

    public static void main(String[] args) {
        IDB db = new PostgresDB("EmployeesDB");
        IEmployeesRepository employeesRepository = new EmployeesRepository(db);
        IProjectRepository projectRepository = new ProjectRepository(db);
        Application app = new Application(employeesRepository, projectRepository);
        app.start();
    }
}
