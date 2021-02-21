package com.company.controller;

import com.company.entities.Project;
import com.company.entities.positions.Employee;
import com.company.repositories.interfaces.IEmployeesRepository;
import com.company.repositories.interfaces.IProjectRepository;

import java.util.List;

public class CompanyController {
    private final IEmployeesRepository employeesRepository;
    private final IProjectRepository projectRepository;

    public CompanyController(IEmployeesRepository employeesRepository, IProjectRepository projectRepository){
        this.employeesRepository = employeesRepository;
        this.projectRepository = projectRepository;
    }

    public String getTotalCostOfAllProjects(){
        return "Total cost of all projects: " + projectRepository.getTotalCostOfAllProjects();
    }

    public String getTotalCostById(int id){
        return "Total cost of project with id " + id + " is " + projectRepository.getTotalCostOfProjectById(id);
    }

    public String createNewProject(String projectName){
        boolean created = projectRepository.createNewProject(projectName);
        return (created ? "Something went wrong!" : "New project was created");
    }

    public String deleteProjectByID(int id){
        return projectRepository.deleteProjectByID(id) ? "Something went wrong" : "Project was deleted";
    }

    public String getProjectByID(int id){
        return projectRepository.getProjectByID(id).toString();
    }

    public List<Project> getAllProjects(){
        return projectRepository.getAllProjects();
    }

    public String addNewEmployee(Employee newEmployee, String position){
        boolean created =  employeesRepository.addEmployee(newEmployee, position, projectRepository);
        return (created ? "Something went wrong!" : "New employee was hired");
    }

    public String getEmployeeByID(int id){
        Employee employee = employeesRepository.getEmployeeByID(id);
        return (employee == null ? "Employee with this id was not found" : employee.toString());
    }

    public List<Employee> getAllEmployees(){
        return employeesRepository.getAllEmployees();
    }

    public String fireEmployee(int id) {
        return (employeesRepository.deleteEmployeeByID(id) ? "Something went wrong": "Employee was fired");
    }
}
