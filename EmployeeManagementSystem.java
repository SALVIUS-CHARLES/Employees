import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagementSystem {

    // Employee Class to Store Details
    static class Employee {
        String name;
        String department;
        double salary;
        String performanceReview;

        Employee(String name, String department, double salary, String performanceReview) {
            this.name = name;
            this.department = department;
            this.salary = salary;
            this.performanceReview = performanceReview;
        }

        @Override
        public String toString() {
            return "Name: " + name + ", Department: " + department + ", Salary: " + salary +
                    ", Performance Review: " + performanceReview;
        }
    }

    // Main Program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();

        int choice;
        do {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee by Name");
            System.out.println("4. Remove Employee by Name");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addEmployee(employees, scanner);
                    break;
                case 2:
                    viewAllEmployees(employees);
                    break;
                case 3:
                    searchEmployeeByName(employees, scanner);
                    break;
                case 4:
                    removeEmployeeByName(employees, scanner);
                    break;
                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    // Add Employee
    private static void addEmployee(ArrayList<Employee> employees, Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter department: ");
        String department = scanner.nextLine();

        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character

        System.out.print("Enter performance review: ");
        String performanceReview = scanner.nextLine();

        employees.add(new Employee(name, department, salary, performanceReview));
        System.out.println("Employee added successfully!");
    }

    // View All Employees
    private static void viewAllEmployees(ArrayList<Employee> employees) {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        System.out.println("\n--- Employee List ---");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    // Search Employee by Name
    private static void searchEmployeeByName(ArrayList<Employee> employees, Scanner scanner) {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();

        boolean found = false;
        for (Employee employee : employees) {
            if (employee.name.equalsIgnoreCase(name)) {
                System.out.println("Employee Found: " + employee);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Employee not found.");
        }
    }

    // Remove Employee by Name
    private static void removeEmployeeByName(ArrayList<Employee> employees, Scanner scanner) {
        System.out.print("Enter name to remove: ");
        String name = scanner.nextLine();

        boolean removed = employees.removeIf(employee -> employee.name.equalsIgnoreCase(name));
        if (removed) {
            System.out.println("Employee removed successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }
} 