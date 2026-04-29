package lab6;

public class Matrix {
    // ─────────────────────────────────────────────────────────────────────────
    // Member data
    // ─────────────────────────────────────────────────────────────────────────
    private int[][] operand1;   // Matrix 1
    private int[][] operand2;   // Matrix 2
    private String  operator;   // "+", "-", or "*"
    // ─────────────────────────────────────────────────────────────────────────
    // Constructor
    // ─────────────────────────────────────────────────────────────────────────
    public Matrix(int[][] operand1, int[][] operand2, String operator) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = operator;
    }
    // ─────────────────────────────────────────────────────────────────────────
    // Private helper: addition
    //   Precondition : both matrices have the same dimensions
    // ─────────────────────────────────────────────────────────────────────────
    private int[][] addition(int[][] operand1, int[][] operand2) {
        int rows = operand1.length;
        int cols = operand1[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result[i][j] = operand1[i][j] + operand2[i][j];
        return result;
    }
    // ─────────────────────────────────────────────────────────────────────────
    // Private helper: subtraction
    //   Precondition : both matrices have the same dimensions
    // ─────────────────────────────────────────────────────────────────────────
    private int[][] subtraction(int[][] operand1, int[][] operand2) {
        int rows = operand1.length;
        int cols = operand1[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result[i][j] = operand1[i][j] - operand2[i][j];
        return result;
    }
    // ─────────────────────────────────────────────────────────────────────────
    // Private helper: multiplication
    //   Precondition : cols of operand1 == rows of operand2
    //   Result size  : operand1.rows  ×  operand2.cols
    // ─────────────────────────────────────────────────────────────────────────
    private int[][] multiplication(int[][] operand1, int[][] operand2) {
        int rows   = operand1.length;       // rows of result
        int cols   = operand2[0].length;    // cols of result
        int common = operand2.length;       // shared inner dimension
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                for (int k = 0; k < common; k++)
                    result[i][j] += operand1[i][k] * operand2[k][j];
        return result;
    }
    // ─────────────────────────────────────────────────────────────────────────
    // Public method: choose and execute the operation, then print the result
    // ─────────────────────────────────────────────────────────────────────────
    public int[][] chooseoperation() {
        int[][] result;
        switch (operator) {
            case "+":
                System.out.println("\nResult of Matrix1 + Matrix2:");
                result = addition(operand1, operand2);
                break;
            case "-":
                System.out.println("\nResult of Matrix1 - Matrix2:");
                result = subtraction(operand1, operand2);
                break;
            case "*":
                System.out.println("\nResult of Matrix1 * Matrix2:");
                result = multiplication(operand1, operand2);
                break;
            default:
                System.out.println("Unknown operator: " + operator);
                return null;
        }
        printmatrix(result);
        return result;
    }
    // ─────────────────────────────────────────────────────────────────────────
    // Private helper: pretty-print a matrix
    // ─────────────────────────────────────────────────────────────────────────
    void printmatrix(int[][] pmatrix) {
        // Find the widest number so columns stay aligned
        int width = 1;
        for (int[] row : pmatrix)
            for (int val : row)
                width = Math.max(width, String.valueOf(val).length());
        String fmt = "%" + (width + 1) + "d";
        for (int[] row : pmatrix) {
            System.out.print("[ ");
            for (int val : row)
                System.out.printf(fmt, val);
            System.out.println("  ]");
        }
    }
}