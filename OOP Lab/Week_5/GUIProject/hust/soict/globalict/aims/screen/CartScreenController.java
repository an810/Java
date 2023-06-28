package hust.soict.globalict.aims.screen;
import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import hust.soict.globalict.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.MenuItem;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Window;


import javax.swing.*;
import java.awt.*;
public class CartScreenController {
    private Cart cart;
    private Store store;
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnRemove;
    @FXML
    private TextField tfFilter;
    @FXML
    private Label total;
    @FXML
    private RadioButton radioBtnFilterId;
    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TableView<Media> tblMedia;
    @FXML
    private TableColumn<Media, String> colMediaTitle;
    @FXML
    private TableColumn<Media, String> colMediaCategory;
    @FXML
    private TableColumn<Media, Float> colMediaCost;

    public CartScreenController(Cart cart, Store store) {
        super();
        this.cart = cart;
        this.store = store;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        tblMedia.setItems(this.cart.getItemsOrderd());

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>() {
                    @Override
                    public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                        if (newValue != null) {
                            updateButtonBar(newValue);
                        }
                    }
                }
        );

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue != null) {
                    showFilteredMedia(newValue);
                }
            }
             void showFilteredMedia(String filter) {
                 cart.filterMediaByTitle(filter);
             }
        });
        updateLabelTotal();
    }

    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }
    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        tblMedia.getItems().remove(media);
        tblMedia.getSelectionModel().clearSelection();
        updateLabelTotal();
    }

    @FXML
    void btnPlayPressed(ActionEvent event) throws PlayerException {
//        Media media = tblMedia.getSelectionModel().getSelectedItem();

        JDialog playDialog = new JDialog();
        playDialog.setTitle("Play");
        playDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        JLabel label = new JLabel("Playing");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 16));

        playDialog.add(label);
        playDialog.setSize(100, 100);
        playDialog.setLocationRelativeTo(null); // Center the dialog on the screen
        playDialog.setVisible(true);

    }
    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        JDialog playDialog = new JDialog();
        playDialog.setTitle("Place Order");
        playDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        JLabel label = new JLabel("Thanks for choosing our store");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 16));

        playDialog.add(label);
        playDialog.setSize(100, 100);
        playDialog.setLocationRelativeTo(null); // Center the dialog on the screen
        playDialog.setVisible(true);
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        MenuItem menuItem = (MenuItem) event.getSource();
        MenuButton parrentMenuButton = (MenuButton) menuItem.getParentPopup().getOwnerNode();
        Scene currentScene = parrentMenuButton.getScene();
        Window currentWindow = currentScene.getWindow();
        currentWindow.hide();
        new StoreScreen(store, cart);
    }

    void updateLabelTotal() {
        String totalCost = Float.toString(cart.totalCost());
        total.setText(totalCost + "$");
    }
}
