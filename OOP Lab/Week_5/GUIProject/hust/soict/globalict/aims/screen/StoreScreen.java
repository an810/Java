package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Media;
import javax.swing.*;
import hust.soict.globalict.aims.store.Store;
import javafx.event.ActionEvent;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class StoreScreen extends JFrame {
    private Store store;
    private Cart cart;
    private JPanel centerPanel;

    public StoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
    }
    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem btnAddDVD = new JMenuItem("Add DVD");
        btnAddDVD.addActionListener(e -> {
            AddDVDToStoreScreen addDVDToStoreScreen = new AddDVDToStoreScreen(store);
            addDVDToStoreScreen.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    SwingUtilities.invokeLater(() -> {
                        getContentPane().remove(centerPanel);
                        centerPanel = createCenter();
                        getContentPane().add(centerPanel, BorderLayout.CENTER);
                        getContentPane().revalidate();
                        getContentPane().repaint();
                    });
                }
            });
        });
        smUpdateStore.add(btnAddDVD);

        JMenuItem btnAddCD = new JMenuItem("Add CD");
        btnAddCD.addActionListener(e -> {
            AddCDToStoreScreen addCDToStoreScreen = new AddCDToStoreScreen(store);
            addCDToStoreScreen.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    SwingUtilities.invokeLater(() -> {
                        getContentPane().remove(centerPanel);
                        centerPanel = createCenter();
                        getContentPane().add(centerPanel, BorderLayout.CENTER);
                        getContentPane().revalidate();
                        getContentPane().repaint();
                    });
                }
            });
        });
        smUpdateStore.add(btnAddCD);

        JMenuItem btnAddBook = new JMenuItem("Add Book");
        btnAddBook.addActionListener(e -> {
            AddBookToStoreScreen addBookToStoreScreen = new AddBookToStoreScreen(store);
            addBookToStoreScreen.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    SwingUtilities.invokeLater(() -> {
                        getContentPane().remove(centerPanel);
                        centerPanel = createCenter();
                        getContentPane().add(centerPanel, BorderLayout.CENTER);
                        getContentPane().revalidate();
                        getContentPane().repaint();
                    });
                }
            });
        });
        smUpdateStore.add(btnAddBook);

        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View Store"));
        JMenuItem viewCartBtn = new JMenuItem("View Cart");
        viewCartBtn.addActionListener(e -> {
            CartScreen cartScreen = new CartScreen(cart, store);
        });
        menu.add(viewCartBtn);

        menu.add(viewCartBtn);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton cart = new JButton("View cart");
        cart.setPreferredSize(new Dimension(100, 50));
        cart.setMaximumSize(new Dimension(100, 50));

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (Media media : mediaInStore) {
            MediaStore cell = new MediaStore(media, cart);
            center.add(cell);
        }
        return center;
    }


}
