import java.util.Scanner;

public class adasgal {
    public static void calculate() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        System.out.print("gerin radius oruulnu (meter): ");
        double r = sc.nextDouble();

        if (r <= 0) {
            System.out.println("aldaa r 0s ih baih yste!");
            return;
        }

        double circumference = 2 * 3.14 * r;
                System.out.println("gerin busluurin urt 1: " + circumference + " mtr");
        double finalnumber = circumference * 3;

        System.out.println("gerin busluurin niit urt: " + finalnumber + " mtr");
    }
} 