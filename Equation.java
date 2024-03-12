import javax.swing.JOptionPane;

public class Equation {
    public static void main(String[] args) {
        first_degree_equation();
        solveSystem();
        second_degree_equation();
        System.exit(0);
    }

    public static void first_degree_equation() {
        String strNum1, strNum2;

        strNum1 = JOptionPane.showInputDialog(null, "Please input a: ", "Input the a",
                JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ", "Input the second number",
                JOptionPane.INFORMATION_MESSAGE);

        double a = Double.parseDouble(strNum1);
        double b = Double.parseDouble(strNum2);
        if (a == 0) {
            if (b == 0) {
                JOptionPane.showMessageDialog(null, "Phuong trinh vo so nghiem");
            } else {
                JOptionPane.showMessageDialog(null, "Phuong trinh vo nghiem");
            }
        } else {
            double x = -b / a;
            JOptionPane.showInputDialog(null, "x = " + x);
        }

    }

    public static void solveSystem() {
        String strNum1, strNum2, strNum3, strNum4;

        strNum1 = JOptionPane.showInputDialog(null, "Please input a1: ", "Input a1",
                JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null, "Please input b1: ", "Input b1",
                JOptionPane.INFORMATION_MESSAGE);
        strNum3 = JOptionPane.showInputDialog(null, "Please input a2: ", "Input a2",
                JOptionPane.INFORMATION_MESSAGE);
        strNum4 = JOptionPane.showInputDialog(null, "Please input b2: ", "Input b2",
                JOptionPane.INFORMATION_MESSAGE);

        double a1 = Double.parseDouble(strNum1);
        double b1 = Double.parseDouble(strNum2);
        double a2 = Double.parseDouble(strNum3);
        double b2 = Double.parseDouble(strNum4);

        double determinant = a1 * 1 - a2 * 1;

        if (determinant == 0) {
            JOptionPane.showMessageDialog(null, "Phuong trinh khong co nghiem");
        } else {
            double determinant1 = b1 * 1 - b2 * 1;
            double determinant2 = a1 * b2 - a2 * b1;
            double x = determinant1 / determinant;
            double y = determinant2 / determinant;

            JOptionPane.showMessageDialog(null, "x = " + x + "\ny = " + y);
        }
    }

    public static void second_degree_equation() {
        String str1, str2, str3;
        str1 = JOptionPane.showInputDialog(null, "Please input a: ", "Input a",
                JOptionPane.INFORMATION_MESSAGE);
        str2 = JOptionPane.showInputDialog(null, "Please input b: ", "Input b",
                JOptionPane.INFORMATION_MESSAGE);
        str3 = JOptionPane.showInputDialog(null, "Please input c: ", "Input c",
                JOptionPane.INFORMATION_MESSAGE);
        double a = Double.parseDouble(str1);
        double b = Double.parseDouble(str2);
        double c = Double.parseDouble(str3);
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    JOptionPane.showMessageDialog(null, "Phuong trinh vo so nghiem");
                } else {
                    JOptionPane.showMessageDialog(null, "Phuong trinh vo nghiem");
                }
            } else {
                double x = -c / b;
                JOptionPane.showInputDialog(null, "x = " + x);
            }
        } else {
            double delta = -(b * b) - 4 * a * c;
            if (delta < 0) {
                JOptionPane.showMessageDialog(null, "Phuong trinh vo so nghiem");
            } else if (delta == 0) {
                JOptionPane.showMessageDialog(null, "Phuong trinh co 1 nghiem: x =" + -b / (2 * a));
            } else {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                JOptionPane.showMessageDialog(null, "x1 = " + x1 + "\nx2 = " + x2);
            }
        }
    }
}
