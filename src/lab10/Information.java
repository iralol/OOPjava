package lab10;

public class Information {
    protected String lastName;      // Овог
    protected String firstName;     // Нэр
    protected String regNumber;     // Регистрийн дугаар
    protected String birthDate;     // Төрсөн огноо (yyyy-MM-dd форматтай)

    // Constructor
    public Information(String lastName, String firstName, String regNumber, String birthDate) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.regNumber = regNumber;
        this.birthDate = birthDate;
    }

    // Get full name: G.Batchuluun
    protected String getFullName() {
        if (lastName == null || lastName.isEmpty()) {
            return firstName;
        }
        String initial = lastName.substring(0, 1).toUpperCase();
        return initial + "." + firstName;
    }

    protected int getYear(String date) {
        if (date == null || date.length() < 4) return 0;
        return Integer.parseInt(date.substring(0, 4));
    }

    protected int getMonth(String date) {
        if (date == null || date.length() < 7) return 0;
        return Integer.parseInt(date.substring(5, 7));
    }

    protected int getDay(String date) {
        if (date == null || date.length() < 10) return 0;
        return Integer.parseInt(date.substring(8, 10));
    }

    protected void info() {
        System.out.println("Huwi hunii undsen medeelel:");
        System.out.println("Ovog ner: " + getFullName());
        System.out.println("Registriin dugaar: " + regNumber);
        System.out.println("Torson ognoo: " + getYear(birthDate) + " oni " 
                + getMonth(birthDate) + " sarin " + getDay(birthDate) + " odor");
    }
}
