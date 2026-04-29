package biyedaalt1;

public class Employee {
    
    // 1. Private гишүүн өгөгдлүүд (5 fields)
    private String firstName;
    private String lastName;
    private int age;
    private String department;
    private float salary;


    // 3. Parameterized constructor
    public Employee(String firstName, String lastName, int age, 
                    String department, float salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    // Private method 1 - Salary category тооцоолох (control structure ашигласан)
    private String calculateSalaryLevel() {
        if (salary >= 5000000) {
            return "Very High";
        } else if (salary >= 4000000) {
            return "High";
        } else if (salary >= 3000000) {
            return "Medium";
        } else if (salary >= 2000000) {
            return "Low";
        } else {
            return "Very Low";
        }
    }

    // Public method (мэдээлэл харуулах) - дэлгэцэнд гаргах
    public void displayInfo() {
        System.out.println("Ajiltnii medeelel: \n");
        System.out.println("Ner: " + firstName + " " + lastName);
        System.out.println("Nas: " + age);
        System.out.println("Takhim: " + department);
        System.out.println("Tsalin: " + salary + " MNT");

        String level = calculateSalaryLevel();
        System.out.println("Tsalinii zereg: " + level);

        // evaluatePerformance();
    }

    // Static method (3 дахь method)
    public static void showHospitalName() {
        System.out.println("Bayan-Undur Med \n");
    }
}