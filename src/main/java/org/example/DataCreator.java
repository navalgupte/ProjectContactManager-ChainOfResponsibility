package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DataCreator {
    private static final String DEFAULT_FILE = "data.ser";

    public static void main(String[] args) {
        String filename;

        if(args.length == 1) {
            filename = args[0];
        } else {
            filename = DEFAULT_FILE;
        }

        serialize(filename);
    }

    public static void serialize(String filename) {
        try {
            serializeToFile(createData(), filename);
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    private static Serializable createData() {
        Contact contact1 = new ContactImpl("Dennis", "Moore", "Chief Architect", "U-Solutions");
        Contact contact2 = new ContactImpl("Jackie", "Robins", "Frontend Developer", "U-Solutions");
        Contact contact3 = new ContactImpl("Melanie", "Lemming", "Backend Developer", "U-Solutions");
        Contact contact4 = new ContactImpl("Neville", "Johnson", "Full-Stack Architect", "U-Solutions");

        Project project = new Project("Web-based Application", "Build a DLT-based Supply Chain solution ground-up.", contact1);
        Task task1 = new Task(project, "Application Frontend", "Research and Develop an intuitive, easy-to-use frontend.",
                contact4, true);
        Task task2 = new Task(project, "Application Backend", "Research and Develop a secure, immutable backend for scale.",
                contact2, true);
        Task task3 = new Task(project, "Application Data-Infrastructure", "Research and Develop data replication, sharding and placement strategies for efficient access.",
                null, true);
        Task task4 = new Task(project, "Frontend - Backend - Infrastructure Integration", "Test and Deploy Application.",
                null, false);

        project.addProjectItem(task1);
        project.addProjectItem(task2);
        project.addProjectItem(task3);
        project.addProjectItem(task4);

        Task task5 = new Task(task1, "React Application", "Build React Application that is the entry point of every user interaction.",
                null, false);
        Task task6 = new Task(task1, "Frontend Test Environment", "Build a Selenium-based test harness for the frontend.",
                null, false);

        Task task7 = new Task(task2, "JSP/NodeJS Server Application", "Build the backend elements using JSP/NodeJS.",
                null, false);
        Task task8 = new Task(task2, "Build-Test-Deploy Strategy", "Develop the build-test-deploy strategy for the application.",
                null, false);

        Task task9 = new Task(task3, "Structured Data Design", "Develop database schema for structured data - identify cost-effective database.",
                null, false);

        Task task10 = new Task(task4, "Deployment Infrastructure", "Develop deployment platform and strategy for application delivery.",
                contact4, false);

        task1.addProjectItem(task5);
        task1.addProjectItem(task6);

        task2.addProjectItem(task7);
        task2.addProjectItem(task8);

        task3.addProjectItem(task9);

        task4.addProjectItem(task10);

        return project;
    }

    private static void serializeToFile(Serializable content, String filename) throws IOException {
        ObjectOutputStream serOut = new ObjectOutputStream(new FileOutputStream(filename));
        serOut.writeObject(content);
        serOut.close();
    }
}
