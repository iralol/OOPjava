package lab10;

public class Main {
    public static void main(String[] args) {
        
        // Data from your image
        Worker worker = new Worker(
            "Batchuluun",        // lastName
            "G.",               // firstName (or Эрдэнэт etc.)
            "TA00231308",      // regNumber
            "2000/03/13",       // birthDate
            "P.IT13",           // employeeCode
            "Erdenet tsogtsolbor", // branchName
            "2017/09/05"        // employmentDate
        );

        worker.info();
    }
}
