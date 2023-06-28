package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddDVDToStoreScreen extends JFrame implements AddItemToStoreScreen {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfDirector;
    private JTextField tfLength;
    private JTextField tfCost;

    public AddDVDToStoreScreen(Store store) {
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(6, 2));

        tfTitle = new JTextField(10);
        cp.add(new JLabel("Title: "));
        cp.add(tfTitle);

        tfCategory = new JTextField(10);
        cp.add(new JLabel("Category: "));
        cp.add(tfCategory);

        tfDirector = new JTextField(10);
        cp.add(new JLabel("Director: "));
        cp.add(tfDirector);

        tfLength = new JTextField(10);
        cp.add(new JLabel("Length: "));
        cp.add(tfLength);

        tfCost = new JTextField(10);
        cp.add(new JLabel("Cost: "));
        cp.add(tfCost);

        JPanel buttonPanel = new JPanel(); // Use a JPanel for the button

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            String director = tfDirector.getText();
            int length = Integer.parseInt(tfLength.getText());
            float cost = Float.parseFloat(tfCost.getText());

            Media media = new DigitalVideoDisc(title, category, director, length, cost);
            store.addMedia(media);

            this.dispose();
        });

        buttonPanel.setLayout(new GridLayout(1, 2)); // Set the layout to 1 row and 2 columns
        buttonPanel.add(submitButton); // Add the button to the buttonPanel

        cp.add(new JLabel()); // Add an empty label to occupy the first column
        cp.add(buttonPanel); // Add the buttonPanel to the container

        setTitle("Add DVD");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
