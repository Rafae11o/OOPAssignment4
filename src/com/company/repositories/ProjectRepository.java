package com.company.repositories;

import com.company.database.interfaces.IDB;
import com.company.entities.Project;
import com.company.repositories.interfaces.IProjectRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepository implements IProjectRepository {
    private final IDB db;

    public ProjectRepository(IDB db){
        this.db = db;
    }

    @Override
    public int getTotalCostOfAllProjects(){
        Connection con = null;
        try{
            con = db.getConnection();
            String sqlQuery = "SELECT SUM(totalcost) FROM projects";
            PreparedStatement statement = con.prepareStatement(sqlQuery);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                return result.getInt(1);
            }
        }catch (Exception ex){
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
        return Integer.parseInt(null);
    }

    @Override
    public int getTotalCostOfProjectById(int id){
        Connection con = null;
        try{
            con = db.getConnection();
            String sqlQuery = "SELECT totalcost FROM projects WHERE id=?";
            PreparedStatement statement = con.prepareStatement(sqlQuery);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                return result.getInt("totalcost");
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
        return Integer.parseInt(null);
    }

    @Override
    public boolean updateTotalCostOfProjectByID(int id, int newTotalCost){
        Connection con = null;
        try{
            con = db.getConnection();
            String sqlQuery = "UPDATE projects SET totalcost=? WHERE id=?";
            PreparedStatement statement = con.prepareStatement(sqlQuery);
            statement.setInt(1, newTotalCost);
            statement.setInt(2, id);
            return statement.execute();
        }catch (Exception ex){
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
        return true;
    }

    @Override
    public boolean createNewProject(String projectName){
        Connection con = null;
        try{
            con = db.getConnection();
            String sqlQuery = "INSERT INTO projects(name) VALUES(?)";
            PreparedStatement statement = con.prepareStatement(sqlQuery);
            statement.setString( 1, projectName);
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
        return false;
    }

    @Override
    public boolean deleteProjectByID(int id){
        Connection con = null;
        try{
            con = db.getConnection();
            String sqlQuery = "DELETE FROM projects WHERE id=?" ;
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
            } catch (SQLException sqlException){
                System.out.println(sqlException.getMessage());
            }
        }
        return false;
    }

    @Override
    public Project getProjectByID(int id){
        Connection con = null;
        try{
            con = db.getConnection();
            String sqlQuery = "SELECT id,name FROM projects WHERE id=?";
            PreparedStatement statement = con.prepareStatement(sqlQuery);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                return new Project(result.getInt("id"), result.getString("name"));
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        } finally {
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
    public List<Project> getAllProjects(){
        Connection con = null;
        try{
            con = db.getConnection();
            String sqlQuery = "SELECT id, name FROM projects";
            PreparedStatement statement = con.prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery();
            List<Project> allProjects = new ArrayList<>();
            while(resultSet.next()){
                allProjects.add(new Project(resultSet.getInt("id"), resultSet.getString("name")));
            }
            return allProjects;
        }catch (Exception ex){
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
}
