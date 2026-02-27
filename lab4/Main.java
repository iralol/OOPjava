import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        System.out.print("Ognoo oruul (yyyy.mm.dd): ");
        String input = sc.nextLine();

        DateTime dt = new DateTime(input);
        dt.printdayofweek();
    }
}