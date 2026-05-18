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
        return baseSalary + baseSalary * 0.05 * yearsExperience;
    }
    public void display() {
        System.out.println("Engineer Medeelel");
        printBasicInfo();
        System.out.println("Heltes     : " + department);
        System.out.println("technology     : " + techStack);
        System.out.println("Turshlaga    : " + yearsExperience + " ajillasn jil");
        System.out.println("Bonus:   MNT  "
                + String.format("%,.0f", getExperienceBonus()));
                showAnnualSalary();
        System.out.println();  
    }
}
