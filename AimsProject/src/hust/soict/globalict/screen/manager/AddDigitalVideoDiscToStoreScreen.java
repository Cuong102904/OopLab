package hust.soict.globalict.screen.manager;

import hust.soict.globalict.aims.disc.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField titleField, categoryField, directorField, lengthField, costField;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);
        JPanel panel = new JPanel(new GridLayout(7, 2));

        panel.add(new JLabel("Title:"));
        titleField = new JTextField();
        panel.add(titleField);

        panel.add(new JLabel("Category:"));
        categoryField = new JTextField();
        panel.add(categoryField);

        panel.add(new JLabel("Director:"));
        directorField = new JTextField();
        panel.add(directorField);

        panel.add(new JLabel("Length:"));
        lengthField = new JTextField();
        panel.add(lengthField);

        panel.add(new JLabel("Cost:"));
        costField = new JTextField();
        panel.add(costField);

        JButton addButton = new JButton("Add DVD");
        addButton.addActionListener(e -> addDVD());
        panel.add(new JLabel());
        panel.add(addButton);

        add(panel);
        setVisible(true);
    }

    private void addDVD() {
        String title = titleField.getText();
        String category = categoryField.getText();
        String director = directorField.getText();
        int length = Integer.parseInt(lengthField.getText());
        float cost = Float.parseFloat(costField.getText());

        DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
        store.addMedia(dvd);
        JOptionPane.showMessageDialog(this, "DVD added successfully!");
    }
}
