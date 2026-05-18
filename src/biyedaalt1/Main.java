package biyedaalt1;

public class Main {
    public static void main(String[] args) {

        // static method дуудах
        Employee.showHospitalName();

        // объект үүсгэх
        Employee e1 = new Employee("GanErdene", "B.", 35, "Huuhed, Nyrai", 4500000);
        Employee e2 = new Employee("NandinErdene", "T.", 28, "Nuur am gajig zasal", 3200000);

        // хэвлэх
        e1.displayInfo();
        e2.displayInfo();
    }
}
