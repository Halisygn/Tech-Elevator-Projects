package com.techelevator;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

    private List<Department> departments = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();
    private Map<String, Project> projects = new HashMap<>();
    private LocalDate today = LocalDate.now();


    /**
     * The main entry point in the application
     *
     * @param args
     */
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    private void run() {
        // create some departments
        createDepartments();

        // print each department by name
        printDepartments();

        // create employees
        createEmployees();

        // give Angie a 10% raise, she is doing a great job!

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
    private void createDepartments() {
        Department marketing = new Department(1, "Marketing");
        Department sales = new Department(2, "Sales");
        Department engineering = new Department(3, "Engineering");
        departments.add(marketing);
        departments.add(sales);
        departments.add(engineering);
    }

    /**
     * Print out each department in the collection.
     */
    private void printDepartments() {
        System.out.println("------------- DEPARTMENTS ------------------------------");
        for (Department department : departments) {
            System.out.println(department.getName());
        }
    }

    /**
     * Create employees and add them to the collection of employees
     */
    private void createEmployees() {
        Employee employee1 = new Employee();
        employee1.setEmployeeId(1);
        employee1.setFirstName("Dean");
        employee1.setLastName("Johnson");
        employee1.setEmail("djohnson@teams.com");
        employee1.setDepartment(departments.get(2));
        employee1.setHireDate(today);

        Employee employee2 = new Employee(2, "Angie", "Smith",
                "asmith@teams.com", getDepartmentByName("Engineering"), today);
        Employee employee3 = new Employee(3, "Margaret", "Thompson",
                "mtompson@teams.com", getDepartmentByName("Marketing"), today);
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employee2.raiseSalary(10);
    }

    /**
     * Print out each employee in the collection.
     */
    private void printEmployees() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        System.out.println("\n------------- EMPLOYEES ------------------------------");
        for (Employee employee : employees) {
            System.out.println(employee.getFullName() + " (" + currency.format(employee.getSalary()) + ") " +
                    employee.getDepartment().getName());
        }
    }

    /**
     * Create the 'Teams' project.
     */
    private void createTeamsProject() {
        Project project1 = new Project("TEam", "Project Management Software",
                today, today.plusDays(30));
        List<Employee> engineerEmployee = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getDepartment().getName().equalsIgnoreCase("Engineering")) {
                engineerEmployee.add(employee);
            }
        }
        project1.setTeamMembers(engineerEmployee);
        projects.put(project1.getName(), project1);
    }

    /**
     * Create the 'Marketing Landing Page' project.
     */
    private void createLandingPageProject() {
        Project project2 = new Project("Marketing Landing Page", "Lead Capture Landing Page for Marketing",
                today.plusDays(31), today.plusDays(31 + 7));
        List<Employee> marketingTeamList = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getDepartment().getName().equalsIgnoreCase("Marketing")) {
                marketingTeamList.add(employee);
            }
        }
        project2.setTeamMembers(marketingTeamList);
        projects.put(project2.getName(), project2);
    }

    /**
     * Print out each project in the collection.
     */
    private void printProjectsReport() {
        System.out.println("\n------------- PROJECTS ------------------------------");
        List<String> projectName = new ArrayList<>(projects.keySet());
        for (String name : projectName) {
            System.out.println(name + ": " + projects.get(name).getTeamMembers().size());
        }
    }

    private Department getDepartmentByName(String name) {
        for (Department department : departments) {
            if (department.getName().equalsIgnoreCase(name)) {
                return department;
            }
        }return null;
    }
}
