package com.company.entities;

import com.company.entities.positions.*;

public class Distributor {
    // Mr.Abulkhair could you please tell me how to avoid this
    public static Employee definePosition(Employee employeeInfo, String position){
        try{
            if(position.matches("designer"))
                return new Designer(employeeInfo.getId(),
                        employeeInfo.getName(),
                        employeeInfo.getSurname(),
                        employeeInfo.getGender(),
                        employeeInfo.getSalary(),
                        employeeInfo.getExperience(),
                        employeeInfo.getProjectID());
            if(position.matches("designer and frontenddeveloper"))
                return new DesignerAndFrontendDeveloper(employeeInfo.getId(),
                        employeeInfo.getName(),
                        employeeInfo.getSurname(),
                        employeeInfo.getGender(),
                        employeeInfo.getSalary(),
                        employeeInfo.getExperience(),
                        employeeInfo.getProjectID());
            if(position.matches("frontend developer"))
                return new FrontendDeveloper(employeeInfo.getId(),
                        employeeInfo.getName(),
                        employeeInfo.getSurname(),
                        employeeInfo.getGender(),
                        employeeInfo.getSalary(),
                        employeeInfo.getExperience(),
                        employeeInfo.getProjectID());
            if(position.matches("hr"))
                return new HumanResource(employeeInfo.getId(),
                        employeeInfo.getName(),
                        employeeInfo.getSurname(),
                        employeeInfo.getGender(),
                        employeeInfo.getSalary(),
                        employeeInfo.getExperience(),
                        employeeInfo.getProjectID());
            if(position.matches("junior backend developer"))
                return new JuniorBackendDeveloper(employeeInfo.getId(),
                        employeeInfo.getName(),
                        employeeInfo.getSurname(),
                        employeeInfo.getGender(),
                        employeeInfo.getSalary(),
                        employeeInfo.getExperience(),
                        employeeInfo.getProjectID());
            if(position.matches("project manager"))
                return new ProjectManager(employeeInfo.getId(),
                        employeeInfo.getName(),
                        employeeInfo.getSurname(),
                        employeeInfo.getGender(),
                        employeeInfo.getSalary(),
                        employeeInfo.getExperience(),
                        employeeInfo.getProjectID());
            if(position.matches("qa"))
                return new QualityAssurance(employeeInfo.getId(),
                        employeeInfo.getName(),
                        employeeInfo.getSurname(),
                        employeeInfo.getGender(),
                        employeeInfo.getSalary(),
                        employeeInfo.getExperience(),
                        employeeInfo.getProjectID());
            if(position.matches("senior backend developer"))
                return new SeniorBackendDeveloper(employeeInfo.getId(),
                        employeeInfo.getName(),
                        employeeInfo.getSurname(),
                        employeeInfo.getGender(),
                        employeeInfo.getSalary(),
                        employeeInfo.getExperience(),
                        employeeInfo.getProjectID());
            if(position.matches("system administrator"))
                return new SystemAdministrator(employeeInfo.getId(),
                        employeeInfo.getName(),
                        employeeInfo.getSurname(),
                        employeeInfo.getGender(),
                        employeeInfo.getSalary(),
                        employeeInfo.getExperience(),
                        employeeInfo.getProjectID());
            if(position.matches("teamlead"))
                return new Teamlead(employeeInfo.getId(),
                        employeeInfo.getName(),
                        employeeInfo.getSurname(),
                        employeeInfo.getGender(),
                        employeeInfo.getSalary(),
                        employeeInfo.getExperience(),
                        employeeInfo.getProjectID());
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
