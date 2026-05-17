package lab10;

public class Worker extends Information{
    private String employeeCode;    // Ажилтны код
    private String branchName;      // Салбарын нэр
    private String employmentDate;  // Ажилд орсон огноо

    public Worker(String lastName, String firstName, String regNumber, 
                String birthDate, String employeeCode, 
                String branchName, String employmentDate) {
        super(lastName, firstName, regNumber, birthDate);
        this.employeeCode = employeeCode;
        this.branchName = branchName;
        this.employmentDate = employmentDate;
    }

    // Overriding info() method
    @Override
    public void info() {
        super.info();   // Call parent class info()
        
        System.out.println("Ajiltni medeelel:");
        System.out.println("Ajiltni kod: " + employeeCode);
        System.out.println("Salbariin ner: " + branchName);
        System.out.println("Ajildd orson ognoo: " + getYear(employmentDate) + " oni " 
                + getMonth(employmentDate) + " sarin " + getDay(employmentDate) + " odor");
    }
}
