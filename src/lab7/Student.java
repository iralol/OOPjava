package lab7;

public class Student {
    //  Member data 
    private String name;
    private int    age;
    private String studentId;
    //  Constructor 
    public Student(String name, int age, String studentId) {
        this.name      = name;
        this.age       = age;
        this.studentId = studentId;
    }
    //  Getters 
    public String getName()      { return name;      }
    public int    getAge()       { return age;        }
    public String getStudentId() { return studentId;  }
    // toString : formatted display 
    @Override
    public String toString() {
        return String.format("| %-12s | %-3d | %-10s |", name, age, studentId);
    }
}

