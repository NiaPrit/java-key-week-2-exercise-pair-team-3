package com.techelevator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static List<Department> departments = new ArrayList();
    public static List<Employee> employees = new ArrayList();
    public static List<Employee> deptMarketing = new ArrayList();
    public static List<Employee> deptSales = new ArrayList();
    public static List<Employee> deptEngineering = new ArrayList();
    public static Map<String, Project> projects = new HashMap();


    /**
     * The main entry point in the application
     * @param args
     */
    public static void main(String[] args) {

        // create some departments
        createDepartments();

        // print each department by name
        printDepartments();

        // create employees
        createEmployees();

        // give Angie a 10% raise, she is doing a great job!
        employees.get(1).raiseSalary(10);
        // print all employees
        printEmployees();

        // create the TEams project
        createTeamsProject();
        // create the Marketing Landing Page Project
        createLandingPageProject();

        // print each project name and the total number of employees on the project
        printProjectsReport();

    }

    /**
     * Create departments and add them to the collection of departments
     */
    private static void createDepartments() {
        Department marketing = new Department(001, "Marketing");
        Department sales = new Department(002, "Sales");
        Department engineering = new Department(003, "Engineering");

        departments.add(marketing);
        departments.add(sales);
        departments.add(engineering);
    }

    /**
     * Print out each department in the collection.
     */
    private static void printDepartments() {
        System.out.println("------------- DEPARTMENTS ------------------------------");
        for (Department department : departments) {
            System.out.println(department.getName());
        }
    }

    /**
     * Create employees and add them to the collection of employees
     */
    private static void createEmployees() {
        Employee deanJohnson = new Employee();
        deanJohnson.setEmployeeId(001);
        deanJohnson.setFirstName("Dean");
        deanJohnson.setLastName("Johnson");
        deanJohnson.setEmail("djohnson@teams.com");
        deanJohnson.setDepartment(departments.get(2));
        deanJohnson.setHireDate("08/21/2020");
        employees.add(deanJohnson);

        Employee angieSmith = new Employee(001, "Angie", "Smith", "asmith@teams.com", departments.get(2), "08/21/2020");
        employees.add(angieSmith);

        Employee margaretThompson = new Employee(003, "Margaret", "Thompson", "mthompson@teams.com", departments.get(0), "08/21/2020");
        employees.add(margaretThompson);
    }

    /**
     * Print out each employee in the collection.
     */
    private static void printEmployees() {
        System.out.println("\n------------- EMPLOYEES ------------------------------");
        for (Employee employee : employees) {
            System.out.println(employee.getFullName() + " (" + employee.getSalary() + ") " + employee.getDepartment().getName());
        }

    }

    /**
     * Create the 'TEams' project.
     */
    private static void createTeamsProject() {
        Project teams = new Project("Teams", "Project Management Software", "10/10/2020", "11/10/2020");
        List engineering = new ArrayList();

        engineering.add(employees.get(0));
        engineering.add(employees.get(1));

        teams.setTeamMembers(engineering);

        projects.put(teams.getName(), teams);
    }

    /**
     * Create the 'Marketing Landing Page' project.
     */
    private static void createLandingPageProject() {
        Project landingPage = new Project("Marketing Landing Page", "Lead Capture Landing Page for Marketing", "10/10/2020", "10/17/2020");
        List marketing = new ArrayList();

        marketing.add(employees.get(2));

        landingPage.setTeamMembers(marketing);

        projects.put(landingPage.getName(), landingPage);
    }

    /**
     * Print out each project in the collection.
     */
    private static void printProjectsReport() {
        System.out.println("\n------------- PROJECTS ------------------------------");
        for (Map.Entry<String, Project> project : projects.entrySet()) {
            System.out.println(project.getKey() + ": " + project.getValue().getTeamMembers().size());
        }
    }

}
