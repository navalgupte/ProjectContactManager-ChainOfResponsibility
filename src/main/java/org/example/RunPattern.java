package org.example;

import java.io.File;
import java.util.Iterator;

public class RunPattern {
    public static void main(String[] args) {
        System.out.println("Example showing use of Chain of Responsibility Pattern");
        System.out.println("---- ---- ---- ---- ----");
        System.out.println("Deserializing Test Data..");
        System.out.println();
        if(!(new File("data.ser")).exists()) {
            DataCreator.serialize("data.ser");
        }
        System.out.println("Retrieving Test Data..");
        System.out.println();
        Project project = (Project) (DataRetriever.deserializeData("data.ser"));
        System.out.println("Retrieving Owner and Details for each Project Item..");
        System.out.println();
        getItemInfo(project);
        System.out.println("---- ---- ---- ---- ----");
    }

    private static void getItemInfo(ProjectItem item) {
        System.out.println("Project Item: " + item);
        System.out.println("    Owner: " + item.getOwner());
        System.out.println("    Details: " + item.getDetails());
        System.out.println();
        if(item.getProjectItems() != null) {
            for (Object subItem : item.getProjectItems()) {
                getItemInfo((ProjectItem) subItem);
            }
        }
    }
}