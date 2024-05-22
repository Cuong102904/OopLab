package hust.soict.globalict.screen.manager;

import hust.soict.globalict.aims.disc.CompactDisc;
import hust.soict.globalict.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField titleField, categoryField, artistField, directorField, costField, lengthField;

    public AddCompactDiscToStoreScreen(Store store) {
        super(store);
        JPanel panel = new JPanel(new GridLayout(8, 2));

        panel.add(new JLabel("Title:"));
        titleField = new JTextField();
        panel.add(titleField);

        panel.add(new JLabel("Category:"));
        categoryField = new JTextField();
        panel.add(categoryField);

        panel.add(new JLabel("Artist:"));
        artistField = new JTextField();
        panel.add(artistField);

        panel.add(new JLabel("Director:"));
        directorField = new JTextField();
        panel.add(directorField);

        panel.add(new JLabel("Length:"));
        lengthField = new JTextField();
        panel.add(lengthField);

        panel.add(new JLabel("Cost:"));
        costField = new JTextField();
        panel.add(costField);

        JButton addButton = new JButton("Add CD");
        addButton.addActionListener(e -> addCD());
        panel.add(new JLabel());
        panel.add(addButton);

        add(panel);
        setVisible(true);
    }

    private void addCD() {
        String title = titleField.getText();
        String category = categoryField.getText();
        String artist = artistField.getText();
        String director = directorField.getText();
        float cost = Float.parseFloat(costField.getText());
        int length = Integer.parseInt(lengthField.getText());

        CompactDisc cd = new CompactDisc(title, category, director, length, cost, artist);
        store.addMedia(cd);
        JOptionPane.showMessageDialog(this, "CD added successfully!");
    }
}
