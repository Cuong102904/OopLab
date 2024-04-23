import javax.swing.JOptionPane;

public class EquationTwoNumbers {

    public static void main(String[] args) {
        String strNum1, strNum2;

        strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ", "Input the first number",
                JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ", "Input the second number",
                JOptionPane.INFORMATION_MESSAGE);
        
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        double sum = num1 + num2;
        double hieu = num1 - num2;
        double multiply = num1 * num2;
        double division =0;
        if(num2 != 0){
            division = num1/num2;
        }
        JOptionPane.showMessageDialog(null,"Sum = " + sum + "\nHieu = " + hieu + "\nTich ="+ multiply + "\nDivision =" + division, "Calculate", JOptionPane.INFORMATION_MESSAGE);

                
        System.exit(0);

    }
}
