package org.example;

import java.util.ArrayList;

public class Project implements ProjectItem {
    private String name;
    private String details;
    private Contact owner;
    private ArrayList projectItems = new ArrayList();

    public Project() {}
    public Project(String name, String details, Contact owner) {
        this.name = name;
        this.details = details;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getDetails() {
        return details;
    }

    @Override
    public Contact getOwner() {
        return owner;
    }

    @Override
    public ArrayList getProjectItems() {
        return projectItems;
    }

    public ProjectItem getParent() {
        return null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setOwner(Contact owner) {
        this.owner = owner;
    }

    public void addProjectItem(ProjectItem element) {
        if(!projectItems.contains(element)) {
            projectItems.add(element);
        }
    }

    public void removeProjectItem(ProjectItem element) {
        projectItems.remove(element);
    }

    public String toString() {
        return name;
    }
}
