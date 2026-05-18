package biyedaalt2;

class Manager extends Employee {
    
    private String division;
    private int teamSize;
    private double bonusRate;
    public Manager(String name, int age, double baseSalary,
                String division, int teamSize, double bonusRate) {
        super(name, age, baseSalary);
        this.division = division;
        this.teamSize = teamSize;
        this.bonusRate = bonusRate;
    }
    private double getManagerBonus() {
        return baseSalary * bonusRate;
    }
    private double getTeamPayrollEstimate() {
        return teamSize * baseSalary * 0.8;
    }
    public void display() {
        System.out.println("Manager Medeelel");
        printBasicInfo();
        System.out.println("Hariutssn hesg         : " + division);
        System.out.println("Bagin hemjee        : " + teamSize + " people");
        System.out.println("Bonus huwi       : " + (bonusRate * 100) + "%");
        System.out.println("Manager Bonus    : " + getManagerBonus());
        System.out.println("Bagin tsalingin tosov: " + String.format("%,.0f", getTeamPayrollEstimate()));
        showAnnualSalary();
        System.out.println();   // Empty line for spacing
    }
}