package com.company.repositories;

import com.company.database.interfaces.IDB;
import com.company.entities.*;
import com.company.entities.positions.Employee;
import com.company.repositories.interfaces.IEmployeesRepository;
import com.company.repositories.interfaces.IProjectRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeesRepository implements IEmployeesRepository {
    private final IDB db;

    public EmployeesRepository(IDB db){ this.db = db; }

    public boolean addEmployee(Employee employee, String position, IProjectRepository projectRepository){
        Connection con = null;
        try{
            con = db.getConnection();
            String sqlQuery = "INSERT INTO employees (name,surname,gender,salary,experience,position,projectid) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement statement = con.prepareStatement(sqlQuery);
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getSurname());
            statement.setBoolean(3, employee.getGender());
            statement.setInt(4, employee.getSalary());
            statement.setInt(5, employee.getExperience());
            statement.setString(6, position);
            statement.setInt(7, employee.getProjectID());
            boolean executedInsertion = statement.execute();
            int newTotalCost = projectRepository.getTotalCostOfProjectById(employee.getProjectID()) + employee.getSalary();
            boolean executedUpdate = projectRepository.updateTotalCostOfProjectByID(employee.getProjectID(), newTotalCost);
            return executedUpdate && executedInsertion;
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            try{
                if (con != null) {
                    con.close();
                }
            } catch (SQLException sqlException ){
                System.out.println(sqlException.getMessage());
            }
        }
        return true;
    }

    @Override
    public Employee getEmployeeByID(int id){
        Connection con = null;
        try{
            con = db.getConnection();
            String sqlQuery = "SELECT id,name,surname,gender,salary,experience,position,projectid FROM employees WHERE id=?";
            PreparedStatement statement = con.prepareStatement(sqlQuery);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                Employee employee = new Employee(result.getInt("id"),
                        result.getString("name"),
                        result.getString("surname"),
                        result.getBoolean("gender"),
                        result.getInt("salary"),
                        result.getInt("experience"),
                        result.getInt("projectid"));
                String position = result.getString("position").toLowerCase();
                return Distributor.definePosition(employee, position);
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        } finally {
            try{
                if (con != null) {
                    con.close();
                }
            } catch (SQLException sqlException){
                System.out.println(sqlException.getMessage());
            }
        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployees(){
        Connection con = null;
        try{
            con = db.getConnection();
            String sqlQuery = "SELECT id,name,surname,gender,salary,experience,position,projectid FROM employees";
            PreparedStatement statement = con.prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery();
            List<Employee> allEmployees = new ArrayList<>();
            while(resultSet.next()){
                Employee employee = new Employee(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getBoolean("gender"),
                        resultSet.getInt("salary"),
                        resultSet.getInt("experience"),
                        resultSet.getInt("projectid"));
                String position = resultSet.getString("position").toLowerCase();
                allEmployees.add(Distributor.definePosition(employee, position));
            }
            return allEmployees;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            try{
                if (con != null) {
                    con.close();
                }
            }catch (SQLException sqlException){
                System.out.println(sqlException.getMessage());
            }
        }
        return null;
    }

    @Override
    public boolean deleteEmployeeByID(int id){
        Connection con = null;
        try{
            con = db.getConnection();
            String sqlQuery = "DELETE FROM employees WHERE id=?";
            PreparedStatement statement = con.prepareStatement(sqlQuery);
            statement.setInt(1, id);
            return statement.execute();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        } finally {
            try{
                if (con != null) {
                    con.close();
                }
            } catch (SQLException sqlException) {
                System.out.println(sqlException.getMessage());
            }
        }
        return true;
    }
}
