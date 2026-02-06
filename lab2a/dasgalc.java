import java.util.Scanner;

public class dasgalc {
    public static void calculate() {
        Scanner sc = new Scanner(System.in);

        System.out.print("A tseg ax ay: ");
        double ax = sc.nextDouble();
        double ay = sc.nextDouble();

        System.out.print("B tseg bx by: ");
        double bx = sc.nextDouble();
        double by = sc.nextDouble();

        System.out.print("C tseg cx cy: ");
        double cx = sc.nextDouble();
        double cy = sc.nextDouble();

        // Талуудын урт
        double AB = Math.sqrt(Math.pow(bx - ax, 2) + Math.pow(by - ay, 2));
        double BC = Math.sqrt(Math.pow(cx - bx, 2) + Math.pow(cy - by, 2));
        double CA = Math.sqrt(Math.pow(ax - cx, 2) + Math.pow(ay - cy, 2));

        // Героны томьёо
        double p = (AB + BC + CA) / 2;
        double temp= p * (p - AB) * (p - BC) * (p - CA);

        if (temp <= 0) {
            System.out.println("adla gurwaljin bolohgvi, taluud zov oruulna u!");
            return;
        }

        double area = Math.sqrt(temp);

        System.out.println("gurwaljin talbai: " + area);
    }
}
