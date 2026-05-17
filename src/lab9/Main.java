package lab9;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        clock myClock = new clock();
        
        System.out.println("Choose clock setting:");
        System.out.println("1. Manual set");
        System.out.println("2. Auto set");
        int choice = scanner.nextInt();
        
        if (choice == 1) {
            // Example from your image: 2002-09-27 23:59:56
            myClock.setClock(2002, 9, 27, 23, 59, 56);
        } else {
            myClock.autoSetClock();
        }
        
        System.out.println("How many seconds to tick?");
        int ticks = scanner.nextInt();
        
        myClock.tickClock(ticks);
        
        scanner.close();   // ← Fixed the resource leak
    }
}
