import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ognoo oruul (yyyy.mm.dd): ");
        String input = sc.nextLine();

        datetime dt = new datetime(input);
        dt.printdayofweek();
    }
}