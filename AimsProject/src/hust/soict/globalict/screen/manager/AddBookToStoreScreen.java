package hust.soict.globalict.screen.manager;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField titleField, categoryField, costField;

    public AddBookToStoreScreen(Store store) {
        super(store);
        JPanel panel = new JPanel(new GridLayout(5, 2));

        panel.add(new JLabel("Title:"));
        titleField = new JTextField();
        panel.add(titleField);

        panel.add(new JLabel("Category:"));
        categoryField = new JTextField();
        panel.add(categoryField);

        panel.add(new JLabel("Cost:"));
        costField = new JTextField();
        panel.add(costField);

        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(e -> addBook());
        panel.add(new JLabel());
        panel.add(addButton);

        add(panel);
        setVisible(true);
    }

    private void addBook() {
        String title = titleField.getText();
        String category = categoryField.getText();
        float cost = Float.parseFloat(costField.getText());

        Book book = new Book(title, category, cost);
        store.addMedia(book);
        JOptionPane.showMessageDialog(this, "Book added successfully!");
    }
}
