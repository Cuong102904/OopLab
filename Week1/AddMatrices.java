import java.util.Scanner;
import java.util.Arrays;

public class AddMatrices {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter the row matrix : ");
        int row = scanner.nextInt();
        System.out.print("Enter the column matrix : ");
        int col = scanner.nextInt();
        System.out.println("Enter value of matrix 1:");
        double[][] matrix1 = inputMatrix(row, col);
        System.out.println("Enter value of matrix 2:");
        double[][] matrix2 = inputMatrix(row, col);
        System.out.println("The Add Matrix is:");
        double[][] result = add(matrix1, matrix2);
        System.out.println(Arrays.deepToString(result));
    }

    public static double[][] inputMatrix(int row, int col) {
        double[][] matrix = new double[row][col];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }
        return matrix;
    }

    public static double[][] add(double[][] matrix1, double[][] matrix2) {
        double[][] result = new double[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }
}
