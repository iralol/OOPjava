package biyedaalt2;

class Engineer extends Employee { //child class1
    private String department;
    private String techStack;
    private int yearsExperience;

    public Engineer(String name, int age, double baseSalary,
                    String department, String techStack, int yearsExperience) {
        
        super(name, age, baseSalary);
        
        this.department = department;
        this.techStack = techStack;
        this.yearsExperience = yearsExperience;
    }

    private double getExperienceBonus() {
        return baseSalary * 0.05 * yearsExperience;
    }

    public void display() {
        System.out.println("Engineer Profile");
        printBasicInfo();
        System.out.println("Department     : " + department);
        System.out.println("Tech Stack     : " + techStack);
        System.out.println("Experience     : " + yearsExperience + " years");
        System.out.println("Experience Bonus: $" + getExperienceBonus());
        showAnnualSalary();
        System.out.println();   // Empty line for spacing
    }
}
