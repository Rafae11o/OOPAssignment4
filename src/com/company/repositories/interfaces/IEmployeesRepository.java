package com.company.repositories.interfaces;

import com.company.entities.positions.Employee;

import java.util.List;

public interface IEmployeesRepository {
    boolean addEmployee(Employee employee, String position, IProjectRepository projectRepository);
    Employee getEmployeeByID(int id);
    List<Employee> getAllEmployees();
    boolean deleteEmployeeByID(int id);
}
