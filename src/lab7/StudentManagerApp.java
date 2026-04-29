package lab7;

import java.util.Scanner;

public class StudentManagerApp {

    // Separator helper 
    private static void line() {
        System.out.println("─".repeat(44));
    }

    // Menu display 
    private static void showMenu() {
        System.out.println();
        line();
        System.out.println("        ★  STUDENT MANAGER  ★");
        line();
        System.out.println("  1. Add Student");
        System.out.println("  2. Delete Student");
        System.out.println("  3. Search Student");
        System.out.println("  4. Sort by Name");
        System.out.println("  5. View All Students");
        System.out.println("  6. Exit");
        line();
        System.out.print("  Select an option (1-6): ");
    }

    // main

    public static void main(String[] args) {
        Scanner        sc      = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            showMenu();
            String choice = sc.nextLine().trim();
            System.out.println();

            switch (choice) {

                // 1. Add Student
                case "1": {
                    System.out.println("  [ Add Student ]");
                    System.out.print("  Name       : ");
                    String name = sc.nextLine().trim();

                    int age = 0;
                    while (true) {
                        System.out.print("  Age        : ");
                        String ageStr = sc.nextLine().trim();
                        try {
                            age = Integer.parseInt(ageStr);
                            if (age > 0) break;
                            System.out.println("  Age must be a positive number.");
                        } catch (NumberFormatException e) {
                            System.out.println("  Invalid input – enter a number.");
                        }
                    }

                    System.out.print("  Student ID : ");
                    String id = sc.nextLine().trim();

                    manager.addStudent(new Student(name, age, id));
                    break;
                }

                //2. Delete Student 
                case "2": {
                    System.out.println("  [ Delete Student ]");
                    System.out.print("  Enter Student ID to delete: ");
                    String id = sc.nextLine().trim();
                    manager.removeStudent(id);
                    break;
                }

                // 3. Search Student 
                case "3": {
                    System.out.println("  [ Search Student ]");
                    System.out.print("  Enter Student ID to search: ");
                    String id = sc.nextLine().trim();

                    Student found = manager.findStudent(id);
                    if (found != null) {
                        System.out.println("  ✔  Student found:");
                        System.out.println("+──────────────+─────+────────────+");
                        System.out.println("| Name         | Age | Student ID |");
                        System.out.println("+──────────────+─────+────────────+");
                        System.out.println(found);
                        System.out.println("+──────────────+─────+────────────+");
                    } else {
                        System.out.println("  ✖  No student found with ID: " + id);
                    }
                    break;
                }

                // 4. Sort by Name 
                case "4": {
                    System.out.println("  [ Sort by Name ]");
                    manager.sortByName();
                    manager.printAllStudents();
                    break;
                }

                // 5. View All Students 
                case "5": {
                    System.out.println("  [ All Students ]");
                    manager.printAllStudents();
                    break;
                }

                // 6. Exit 
                case "6": {
                    System.out.println("  Goodbye!");
                    sc.close();
                    return;
                }

                default:
                    System.out.println("  Invalid option. Please enter 1-6.");
            }
        }
    }
}

