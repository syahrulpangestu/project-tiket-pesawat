package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button createMaskapai;

    @FXML
    private Button createTiket;

    @FXML
    private Button showMaskapai;

    @FXML
    private Button showTiket;

    @FXML
    private Button history;

    @FXML
    private TextField input;

    @FXML
    private Button createButton;

    @FXML
    private Pane pnlStatus;

    @FXML
    private Button close;

    @FXML
    private Label lblStatus;

    @FXML
    private GridPane pnMaskapai;

    @FXML
    private GridPane pnTiket;

    @FXML
    private GridPane pnShowMaskapai;

    @FXML
    private GridPane pnShowTiket;

    @FXML
    private GridPane pnHistory;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void handleClicks(javafx.event.ActionEvent actionEvent) {
        if(actionEvent.getSource() == createMaskapai){
            lblStatus.setText("Create Maskapai");
            pnMaskapai.toFront();
//            pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(63, 43, 99), CornerRadii.EMPTY, Insets.EMPTY)));
        }else if(actionEvent.getSource() == createTiket){
            lblStatus.setText("Create Tiket");
            pnTiket.toFront();
        }else if(actionEvent.getSource() == showMaskapai){
            lblStatus.setText("Show Maskapai");
            pnShowMaskapai.toFront();
        }else if(actionEvent.getSource() == showTiket){
            lblStatus.setText("Show Tiket");
            pnShowTiket.toFront();
        }else if(actionEvent.getSource() == close){

        }else if(actionEvent.getSource() == history){
            lblStatus.setText("Show History");
            pnHistory.toFront();
        }
    }

    @FXML
    public void handleClose(MouseEvent actionEvent) {
        if(actionEvent.getSource() == close){
            System.exit(0);
        }
    }

    public void hover(MouseEvent mouseEvent) {
        if(mouseEvent.getSource() == createMaskapai){
            createMaskapai.setStyle("-fx-background-color: #076180;-fx-font-size:17;");
        }else if(mouseEvent.getSource() == createTiket){
            createTiket.setStyle("-fx-background-color: #076180;-fx-font-size:17;");
        }else if(mouseEvent.getSource() == showMaskapai){
            showMaskapai.setStyle("-fx-background-color: #076180;-fx-font-size:17;");
        }else if(mouseEvent.getSource() == showTiket){
            showTiket.setStyle("-fx-background-color: #076180;-fx-font-size:17;");
        }else if(mouseEvent.getSource() == createButton){
            createButton.setStyle("-fx-background-color: #076180;");
        }else if(mouseEvent.getSource() == close){
            close.setStyle("-fx-background-color: #076180;-fx-font-size:17;");
        }else if(mouseEvent.getSource() == history){
            history.setStyle("-fx-background-color: #076180;-fx-font-size:17;");
        }
    }

    public void unhover(MouseEvent mouseEvent) {
        if(mouseEvent.getSource() == createMaskapai){
            createMaskapai.setStyle("-fx-background-color:transparent;");
        }else if(mouseEvent.getSource() == createTiket){
            createTiket.setStyle("-fx-background-color: transparent;");
        }else if(mouseEvent.getSource() == showMaskapai){
            showMaskapai.setStyle("-fx-background-color: transparent;");
        }else if(mouseEvent.getSource() == showTiket){
            showTiket.setStyle("-fx-background-color: transparent;");
        }else if(mouseEvent.getSource() == createButton){
            createButton.setStyle("-fx-background-color:  #006680;");
        }else if(mouseEvent.getSource() == close){
            close.setStyle("-fx-background-color: transparent;");
        }else if(mouseEvent.getSource() == history){
            history.setStyle("-fx-background-color: transparent;");
        }
    }
}