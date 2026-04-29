package lab7;
import java.util.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentManager {
    // Member data 
    private List<Student> students;
    // Constructor 
    public StudentManager() {
        students = new ArrayList<>();
    }
    // Add a student 
    public void addStudent(Student s) {
        // Prevent duplicate IDs
        for (Student existing : students) {
            if (existing.getStudentId().equalsIgnoreCase(s.getStudentId())) {
                System.out.println("  ✖  Student ID \"" + s.getStudentId()
                        + "\" already exists. Student not added.");
                return;
            }
        }
        students.add(s);
        System.out.println("  ✔  Student \"" + s.getName() + "\" added successfully.");
    }
    // Remove a student by ID 
    public void removeStudent(String studentId) {
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            if (s.getStudentId().equalsIgnoreCase(studentId)) {
                it.remove();
                System.out.println("  ✔  Student \"" + s.getName()
                        + "\" (ID: " + studentId + ") removed.");
                return;
            }
        }
        System.out.println("  ✖  No student found with ID: " + studentId);
    }
    // Find a student by ID 
    public Student findStudent(String studentId) {
        for (Student s : students)
            if (s.getStudentId().equalsIgnoreCase(studentId))
                return s;
        return null;
    }
    // Print all students 
    public void printAllStudents() {
        if (students.isEmpty()) {
            System.out.println("  (No students registered.)");
            return;
        }
        printHeader();
        for (Student s : students)
            System.out.println(s);
        printFooter();
        System.out.println("  Total: " + students.size() + " student(s).");
    }
    // Sort alphabetically by name (case-insensitive) 
    public void sortByName() {
        if (students.isEmpty()) {
            System.out.println("  (No students to sort.)");
            return;
        }
        students.sort(Comparator.comparing(
                s -> s.getName().toLowerCase()));
        System.out.println("  ✔  Students sorted by name.");
    }
    // Private print helpers 
    private void printHeader() {
        System.out.println("+──────────────+─────+────────────+");
        System.out.println("| Name         | Age | Student ID |");
        System.out.println("+──────────────+─────+────────────+");
    }
    private void printFooter() {
        System.out.println("+──────────────+─────+────────────+");
    }
}
