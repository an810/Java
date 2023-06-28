package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddCDToStoreScreen extends JFrame implements AddItemToStoreScreen {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfDirector;
    private JTextField tfLength;
    private JTextField tfCost;
    private JTextField tfArtist;
    private JTextField tfTrackTitle;
    private JTextField tfTrackLength;

    public AddCDToStoreScreen(Store store)
    {
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(9, 2));

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

        tfArtist = new JTextField(10);
        cp.add(new Label("Artist: "));
        cp.add(tfArtist);

        tfTrackTitle = new JTextField(10);
        cp.add(new Label("Title of track: "));
        cp.add(tfTrackTitle);

        tfTrackLength = new JTextField(10);
        cp.add(new Label("Length of track: "));
        cp.add(tfTrackLength);

        JPanel buttonPanel = new JPanel(); // Use a JPanel for the button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            String director = tfDirector.getText();
            int length = Integer.parseInt(tfLength.getText());
            float cost = Float.parseFloat(tfCost.getText());
            String artist = tfArtist.getText();
            String trackTitle = tfTrackTitle.getText();
            int trackLength = Integer.parseInt(tfTrackLength.getText());
            Track track = new Track(trackTitle, trackLength);
            Media media = new CompactDisc(title, category, director, length, cost, artist, track);
            store.addMedia(media);
            this.dispose();
        });


        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.add(submitButton);

        cp.add(new JLabel());
        cp.add(buttonPanel);

        setTitle("Add CD");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
