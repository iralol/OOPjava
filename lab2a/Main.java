import java.util.Scanner;

public class Main {
public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\nSONGOLUUD");
            System.out.println("1. Mongol gerin busluurin urt tootsoloh");
            System.out.println("2. Arithmetic ba geometric dundaj");
            System.out.println("3. gurwaljin talbai");
            System.out.println("0. programs garah");
            System.out.print("songoltoo oruulna u: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    adasgal.calculate();
                    break;

                case 2:
                    dasgalb.calculate();
                    break;

                case 3:
                    dasgalc.calculate();
                    break;

                case 0:
                    System.out.println("programs garlaa. bayartai!");
                    return; // main-ээс гарна

                default:
                    System.out.println("tiim songolt bhgv.");
            }
        }
    }
}
