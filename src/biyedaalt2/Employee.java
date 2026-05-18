package biyedaalt2;

    class Employee {
    protected String name;
    protected int age;
    protected double baseSalary;
    public Employee(String name, int age, double baseSalary) {
        this.name = name;
        this.age = age;
        this.baseSalary = baseSalary;
    }
    protected void printBasicInfo() {
        System.out.println("Ner       : " + name);
        System.out.println("Nas      : " + age);
        System.out.println("Undsen tsalin:   MNT" + baseSalary);
    }
    private double getAnnualSalary() {
        return baseSalary * 12;
    }
    protected void showAnnualSalary() {
        System.out.println("jlin tsalin: " 
                + String.format("%,.0f", getAnnualSalary()));
    }
}