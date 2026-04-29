package lab6;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Matrix Calculator ===");
        System.out.println("Supported operations: +  -  *");
        System.out.print("Enter operation (+, -, *): ");
        String op = sc.next().trim();
        if (!op.equals("+") && !op.equals("-") && !op.equals("*")) {
            System.out.println("Invalid operator. Please use +, -, or *.");
            sc.close();
            return;
        }
        // Read Matrix 1 
        System.out.println("\n--- Matrix 1 ---");
        System.out.print("Enter number of rows: ");
        int rows1 = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols1 = sc.nextInt();
        int[][] mat1 = new int[rows1][cols1];
        System.out.println("Enter the elements of Matrix 1 row by row:");
        for (int i = 0; i < rows1; i++) {
            System.out.print("  Row " + (i + 1) + ": ");
            for (int j = 0; j < cols1; j++)
                mat1[i][j] = sc.nextInt();
        }
        // ── Read Matrix 2 (with compatibility check) 
        System.out.println("\n--- Matrix 2 ---");
        int rows2, cols2;
        while (true) {
            System.out.print("Enter number of rows: ");
            rows2 = sc.nextInt();
            System.out.print("Enter number of columns: ");
            cols2 = sc.nextInt();
            boolean compatible;
            if (op.equals("+") || op.equals("-")) {
                // Addition / subtraction: dimensions must match exactly
                compatible = (rows2 == rows1) && (cols2 == cols1);
                if (!compatible)
                    System.out.printf(
                        "Incompatible size for '%s'. Matrix 2 must be %d×%d. Try again.%n",
                        op, rows1, cols1);
            } else {
                // Multiplication: cols of Matrix1 must equal rows of Matrix2
                compatible = (rows2 == cols1);
                if (!compatible)
                    System.out.printf(
                        "Incompatible size for '*'. Matrix 2 must have %d row(s). Try again.%n",
                        cols1);
            }
            if (compatible) break;
        }
        int[][] mat2 = new int[rows2][cols2];
        System.out.println("Enter the elements of Matrix 2 row by row:");
        for (int i = 0; i < rows2; i++) {
            System.out.print("  Row " + (i + 1) + ": ");
            for (int j = 0; j < cols2; j++)
                mat2[i][j] = sc.nextInt();
        }
        // ── Echo the input matrices 
        Matrix temp1 = new Matrix(mat1, mat1, "+");
        System.out.println("Matrix 1:");
        temp1.printmatrix(mat1);
        Matrix temp2 = new Matrix(mat2, mat2, "+");
        System.out.println("\nMatrix 2:");
        temp2.printmatrix(mat2);
        // ── Perform the chosen operation 
        Matrix calc = new Matrix(mat1, mat2, op);
        calc.chooseoperation();
        sc.close();
    }
}