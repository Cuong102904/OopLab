import java.util.Scanner;

public class TriangleStar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n: ");
        int a = scanner.nextInt();

        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= (a - i); j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1;) {
                System.out.print("*");
                k++;
            }
            System.out.println();
        }
    }
}
