package org.example;

import java.util.ArrayList;

public class Task implements ProjectItem {
    private String name;
    private String details;
    private Contact owner;
    private ArrayList projectItems = new ArrayList();
    private ProjectItem parent;
    private boolean primaryTask;

    public Task(ProjectItem parent) {
        this(parent, "", "", null, false);
    }

    public Task(ProjectItem parent, String name, String details,
                Contact owner, boolean primaryTask) {
        this.parent = parent;
        this.name = name;
        this.details = details;
        this.owner = owner;
        this.primaryTask = primaryTask;
    }

    public String getName() {
        return name;
    }

    /*
        getDetails() Method - Calls getDetails() method of each parent until it reaches a Project or Task. It
        returns a series of Strings representing all the details for a particular Task chain.
     */
    @Override
    public String getDetails() {
        if(primaryTask) {
            return details;
        } else {
            return parent.getDetails() + EOL_STRING + "\t" + details;
        }
    }

    /*
        getOwner() Method - Either returns its internally referenced owner, or that of its parent.
        The method call is passed on until a non-null owner is encountered, or it reaches the Project instance itself.

        Makes it easy to set up group of Tasks where a single individual is responsible for completion of a task
        and all its sub-tasks.
     */
    @Override
    public Contact getOwner() {
        if(owner == null) {
            return parent.getOwner();
        } else {
            return owner;
        }
    }

    @Override
    public ArrayList getProjectItems() {
        return projectItems;
    }

    @Override
    public ProjectItem getParent() {
        return parent;
    }

    public boolean isPrimaryTask() {
        return primaryTask;
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

    public void setParent(ProjectItem parent) {
        this.parent = parent;
    }

    public void setPrimaryTask(boolean primaryTask) {
        this.primaryTask = primaryTask;
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
