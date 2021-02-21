package com.company;

import com.company.controller.CompanyController;
import com.company.entities.Project;
import com.company.entities.positions.Employee;
import com.company.repositories.interfaces.IEmployeesRepository;
import com.company.repositories.interfaces.IProjectRepository;

import java.util.Scanner;

public class Application {
    private final CompanyController controller;
    private final Scanner scanner;

    public Application(IEmployeesRepository employeesRepository, IProjectRepository projectRepository){
        this.controller = new CompanyController(employeesRepository, projectRepository);
        scanner = new Scanner(System.in);
    }

    public void start(){
        boolean exit = false;
        while(!exit){
            System.out.println("****************************************************");
            System.out.println("*   Select option:                                 *");
            System.out.println("*       1. Create new project                      *");
            System.out.println("*       2. Delete project                          *");
            System.out.println("*       3. Get total cost of all projects          *");
            System.out.println("*       4. Get total cost of project               *");
            System.out.println("*       5. Get project information                 *");
            System.out.println("*       6. Get information about all projects      *");
            System.out.println("*       7. Add new employee                        *");
            System.out.println("*       8. Fire employee                           *");
            System.out.println("*       9. Get employee by id                      *");
            System.out.println("*      10. Display all work employees              *");
            System.out.println("*      11. Get employees table                     *");
            System.out.println("*       0. Exit                                    *");
            System.out.println("****************************************************");
            System.out.print("Enter option (0-11): ");
            switch (scanner.nextInt()) {
                case 1 -> createNewProject();
                case 2 -> deleteProject();
                case 3 -> getTotalCostOfAllProjects();
                case 4 -> getTotalCostOfProject();
                case 5 -> getProjectInformation();
                case 6 -> getInformationOfAllProjects();
                case 7 -> addNewEmployee();
                case 8 -> fireEmployee();
                case 9 -> getEmployeeByID();
                case 10 -> displayAllEmployeesWork();
                case 11 -> getEmployeesTable();
                case 0 -> exit = true;
                default -> System.out.println("Invalid input!");
            }
            System.out.println("****************************************************");
        }
    }

    private void getInformationOfAllProjects() {
        System.out.println("********************Our projects********************");
        for(Project project : controller.getAllProjects()){
            System.out.println(project);
        }
    }

    private void getProjectInformation() {
        System.out.print("Enter project id: ");
        int id = scanner.nextInt();
        System.out.println(controller.getProjectByID(id));
    }


    private void deleteProject() {
        System.out.print("Enter project id: ");
        int id = scanner.nextInt();
        System.out.println(controller.deleteProjectByID(id));
    }

    private void createNewProject() {
        System.out.print("Enter project name: ");
        String projectName = scanner.next();
        System.out.println(controller.createNewProject(projectName));
    }

    private void getTotalCostOfProject() {
        System.out.print("Enter project id: ");
        int id = scanner.nextInt();
        System.out.println(controller.getTotalCostById(id));
    }

    private void getTotalCostOfAllProjects() {
        System.out.println(controller.getTotalCostOfAllProjects());
    }


    private void getEmployeesTable() {
        System.out.println("****************************************************");
        System.out.println("*****************Employees table*******************");
        for(Employee employee : controller.getAllEmployees()){
            String position = employee.getClass().toString();
            position = position.split("\\.")[position.split("\\.").length-1];
            System.out.printf("%d\t%s\t%s\t%d\t%d\t%s\n", employee.getId(), employee.getName(), employee.getSurname(),
                    employee.getSalary(), employee.getExperience(), position);
        }
    }

    private void displayAllEmployeesWork(){
        System.out.println("****************************************************");
        System.out.println("*******************Our employees*******************");
        for(Employee employee : controller.getAllEmployees()){
            System.out.println("****************************************************");
            System.out.println(employee);
        }
    }

    private void getEmployeeByID(){
        System.out.print("Please enter employee id: ");
        int id = scanner.nextInt();
        System.out.println(controller.getEmployeeByID(id));
    }

    private void addNewEmployee(){
        Employee newEmployee = new Employee();
        System.out.print("Name: ");
        newEmployee.setName(scanner.next());
        System.out.print("Surname: ");
        newEmployee.setSurname(scanner.next());
        System.out.print("Gender: ");
        newEmployee.setGender(scanner.next().toLowerCase().matches("male"));
        System.out.print("Salary: ");
        newEmployee.setSalary(scanner.nextInt());
        System.out.print("Experience: ");
        newEmployee.setExperience(scanner.nextInt());
        System.out.print("Project ID: ");
        newEmployee.setProjectID(scanner.nextInt());
        String position = "";
        while(position.matches("")){
            System.out.print("Position: ");
            position = scanner.nextLine();
        }
        System.out.println(controller.addNewEmployee(newEmployee, position));
    }

    private void fireEmployee() {
        System.out.print("Please enter employee id: ");
        int id = scanner.nextInt();
        System.out.println(controller.fireEmployee(id));
    }
}
