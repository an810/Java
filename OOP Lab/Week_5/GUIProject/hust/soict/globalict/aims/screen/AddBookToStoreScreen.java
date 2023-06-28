package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddBookToStoreScreen extends JFrame implements AddItemToStoreScreen {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfCost;
    private JTextField tfAuthor;

    public AddBookToStoreScreen(Store store)
    {
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(6, 2));

        tfTitle = new JTextField(10);
        cp.add(new JLabel("Title: "));
        cp.add(tfTitle);

        tfCategory = new JTextField(10);
        cp.add(new JLabel("Category: "));
        cp.add(tfCategory);

        tfCost = new JTextField(10);
        cp.add(new JLabel("Cost: "));
        cp.add(tfCost);

        tfAuthor = new JTextField(10);
        cp.add(new JLabel("Author: "));
        cp.add(tfAuthor);

        JPanel buttonPanel = new JPanel();

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            float cost = Float.parseFloat(tfCost.getText());
            String author = tfAuthor.getText();
            Book book = new Book(title, category, cost, author);
            store.addMedia((Media) book);
            this.dispose();
        });

        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.add(submitButton);

        cp.add(new JLabel());
        cp.add(buttonPanel);

        setTitle("Add Book");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
