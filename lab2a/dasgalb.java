
import java.util.Scanner;
public class dasgalb {
public static void calculate() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        System.out.print("ehni too orulnu: ");
        double a = sc.nextDouble();

        System.out.print("hoyrdah toog orulnu: ");
        double b = sc.nextDouble();

        if (a < 0 || b < 0) {
            System.out.println("adla ! negative too oruulj baigaa");
            return;
        }

        double arithmeticMean = (a + b) / 2;
        double geometricMean = Math.sqrt(a * b);

        System.out.println("Arithmetic dundaj: " + arithmeticMean);
        System.out.println("geometric dundaj: " + geometricMean);
    }
}