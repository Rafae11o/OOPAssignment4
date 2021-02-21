package com.company.entities;

public class Project {
    private int id;
    private String name;
    private int totalCost;

    public Project() {
    }

    public Project(String name){
        this.setName(name);
    }

    public Project(int id, String name){
        this.setId(id);
        this.setName(name);
    }

    public Project(int id, String name, int totalCost){
        this.setId(id);
        this.setName(name);
        this.setTotalCost(totalCost);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString(){
        return "Project " + this.getName() + " with total cost " + this.getTotalCost();
    }
}
