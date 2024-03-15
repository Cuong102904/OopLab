import java.util.Scanner;
import java.util.Arrays;

public class NumericArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the lenght of array: ");
        int n = scanner.nextInt();

        double[] array = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the element at " + (i + 1) + ": ");
            array[i] = scanner.nextDouble();
        }
        scanner.close();
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        double average = (sum / array.length);
        System.out.println("Average = " + average);
        System.out.println("Sum = " + sum);
        System.exit(0);
    }
}
