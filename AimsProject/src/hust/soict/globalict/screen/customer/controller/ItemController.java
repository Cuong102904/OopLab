package hust.soict.globalict.screen.customer.controller;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.disc.Playable;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.exception.PlayerException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ItemController {
    private Cart cart = new Cart();

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblTitle;

    private Media media;

    @FXML
    void btnAddToCartClicked(ActionEvent event) {
        try {
            cart.addMedia(media);
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION, "Media added successfully!");
            successAlert.showAndWait();
        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR, e.getMessage());
            errorAlert.showAndWait();
            e.printStackTrace();
        }
    }

    @FXML
    void btnPlayClicked(ActionEvent event) {
        try {
            if (media instanceof Playable) {
                ((Playable) media).play();
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Playing media.");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Media cannot be played.");
                alert.showAndWait();
            }
        } catch (PlayerException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
            alert.showAndWait();
        }
    }

    public void setData(Media media) {
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost() + "$");
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
        }
    }
}
