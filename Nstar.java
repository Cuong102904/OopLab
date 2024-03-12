import java.util.Scanner;

public class Nstar {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Moi nhap so luong tang: ");
        int a = keyboard.nextInt();
        int k = 0;
        for (int i = 1; i <= a; ++i, k = 0) {
            for (int space = 1; space <= a - i; ++space) {
                System.out.print("  ");
            }
            while (k != 2 * i - 1) {
                System.out.print("* ");
                ++k;
            }
            System.out.println();
        }
    }
}
