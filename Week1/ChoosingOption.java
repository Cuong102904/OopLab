import javax.swing.JOptionPane;

public class ChoosingOption {
    public static void main(String[] args) {
        String[] options = { "Yes, I do", "No, I don't", "Cancel" };

        int option = JOptionPane.showOptionDialog(null, "Do you want to change to first-class tickets?",
                "Confirm changes", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
                options[0]);
        // int option = JOptionPane.showConfirmDialog(null, "Do you want to change to
        // first-class ticket",
        // "Confirm changes", JOptionPane.YES_NO_CANCEL_OPTION);

        JOptionPane.showMessageDialog(null, "You choose: " + (option == JOptionPane.YES_OPTION ? "YES" : "NO"));
        System.exit(0);
    }
}
