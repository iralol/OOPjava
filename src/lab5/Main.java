package lab5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Heden toon deer statistic uildel guitsetgeh we? ");
        int n = sc.nextInt();

        double a[] = new double[n];

        for(int i = 0; i < n; i++) {
            System.out.printf("%d-r toog oruul: ", i+1);
            a[i] = sc.nextDouble();
        }

        System.out.println("\n varargs method hereglesen uildel: ");

        double mean = Statistics.meanVar(a);
        double sd = Statistics.sdVar(a);

        System.out.println("Mean = " + mean);
        System.out.println("Standard hemjee = " + sd);

        System.out.println("\n overloading method hereglesen uildel: ");

        if(n==2)
        {
            System.out.println("Mean = " + Statistics.mean(a[0],a[1]));
            System.out.println("SD = " + Statistics.sd(a[0],a[1]));
        }
        else if(n==3)
        {
            System.out.println("Mean = " + Statistics.mean(a[0],a[1],a[2]));
            System.out.println("SD = " + Statistics.sd(a[0],a[1],a[2]));
        }
        else if(n==4)
        {
            System.out.println("Mean = " + Statistics.mean(a[0],a[1],a[2],a[3]));
            System.out.println("SD = " + Statistics.sd(a[0],a[1],a[2],a[3]));
        }
        else if(n==5)
        {
            System.out.println("Mean = " + Statistics.mean(a[0],a[1],a[2],a[3],a[4]));
            System.out.println("SD = " + Statistics.sd(a[0],a[1],a[2],a[3],a[4]));
        }
        sc.close();
    }
}
