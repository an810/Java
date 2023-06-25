package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;

import javax.naming.LimitExceededException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaStore extends JPanel {
    private Media media;
    private Cart cart;
    public void setCart(Cart cart) {
        this.cart = cart;
    }
    public MediaStore(Media media) {
        this.media = media;
        ButtonListioner listioner = new ButtonListioner();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(""+ media.getCost()+" $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton addToCart = new JButton("Add to cart");
        container.add(addToCart);
        addToCart.addActionListener(listioner);

        if (media instanceof Playable) {
            JButton play = new JButton("Play");
            container.add(play);
            play.addActionListener(listioner);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private class ButtonListioner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String s = e.getActionCommand();
            if (s.equals("Play")) {
                JDialog dialog = new JDialog();
                JLabel label = new JLabel("Playing box");
                dialog.add(label);
                dialog.setSize(100,100);
                dialog.setVisible(true);
            } else if (s.equals("Add to cart")) {
                try {
                    cart.addMedia(media);
                } catch (LimitExceededException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

}
