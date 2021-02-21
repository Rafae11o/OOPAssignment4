package com.company.repositories.interfaces;

import com.company.entities.Project;

import java.util.List;

public interface IProjectRepository {
    int getTotalCostOfAllProjects();
    int getTotalCostOfProjectById(int id);
    boolean updateTotalCostOfProjectByID(int id, int newTotalCost);
    boolean createNewProject(String projectName);
    boolean deleteProjectByID(int id);
    Project getProjectByID(int id);
    List<Project> getAllProjects();
}
