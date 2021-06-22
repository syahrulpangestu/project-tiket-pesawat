package controllers;

import connectivity.ConnectionClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import models.Maskapai;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Label lblStatus1;

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
    private Button close;

    @FXML
    private GridPane pnHistory;

    @FXML
    private TableColumn<?, ?> tableHistoryId;

    @FXML
    private TableColumn<?, ?> tableHistoryMaskapai;

    @FXML
    private TableColumn<?, ?> tableHistoryTujuan;

    @FXML
    private TableColumn<?, ?> tableHistoryWaktu;

    @FXML
    private TableColumn<?, ?> tableHistoryJumlah;

    @FXML
    private TableColumn<?, ?> tableHistoryKelas;

    @FXML
    private TableColumn<?, ?> tableHistoryTotal;

    @FXML
    private TextField inputSearchHistory;

    @FXML
    private Button buttonSearchHistory;

    @FXML
    private GridPane pnShowMaskapai;

    @FXML
    private TableColumn<?, ?> tableShowMaskapaiId;

    @FXML
    private TableColumn<?, ?> tableShowMaskapai;

    @FXML
    private TableColumn<?, ?> tableShowMaskapaiAksi;

    @FXML
    private TextField inputSearchMaskapai;

    @FXML
    private Button buttonShowMaskapai;

    @FXML
    private GridPane pnShowTiket;

    @FXML
    private TableColumn<?, ?> tableShowTiketId;

    @FXML
    private TableColumn<?, ?> tableShowTiketMaskapai;

    @FXML
    private TableColumn<?, ?> tableShowTiketTujuan;

    @FXML
    private TableColumn<?, ?> tableShowTiketWaktu;

    @FXML
    private TableColumn<?, ?> tableShowTiketJumlah;

    @FXML
    private TableColumn<?, ?> tableShowTiketKelas;

    @FXML
    private TableColumn<?, ?> tableShowTiketStok;

    @FXML
    private TableColumn<?, ?> tableShowTiketAksi;

    @FXML
    private TextField inputSearchShowTiket;

    @FXML
    private Button buttonSearchShowTiket;

    @FXML
    private GridPane pnTiket;

    @FXML
    private ComboBox<String> optionMaskapai;

    @FXML
    private TextField inputTujuan;

    @FXML
    private DatePicker inputWaktu;

    @FXML
    private TextField inputStok;

    @FXML
    private TextField inputKelas;

    @FXML
    private Button createButtonTiket;

    @FXML
    private GridPane pnMaskapai;

    @FXML
    private TableView<Maskapai> tableViewMaskapai;

    @FXML
    private TableColumn<Maskapai, Integer> colIdMaskapai;

    @FXML
    private TableColumn<Maskapai, String> tableMaskapai;

    @FXML
    private TextField inputCreateMaskapai;

    @FXML
    private TextField inputUpdateMaskapai;

    @FXML
    private Button createButtonMaskapai;

    @FXML
    private Button updateButtonMaskapai;

    @FXML
    private Button deleteButtonMaskapai;

    @FXML
    private Pane pnlStatus;

    @FXML
    private Label lblStatus;

    @FXML
    void buttonCreateMaskapai(ActionEvent event) {
        if (event.getSource() == createButtonMaskapai){
            insertMaskapai();
        }else if (event.getSource() == updateButtonMaskapai){
            updateMaskapai();
        }else if (event.getSource() == deleteButtonMaskapai){
            deleteMaskapai();
        }
    }

    @FXML
    void buttonCreateTiket(ActionEvent event) {
        if(event.getSource() == createButtonTiket){
            insertTiket();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showMaskapai();
        showOptionMaskapai();
    }

    private void showOptionMaskapai() {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection =connectionClass.getConnection();
        Statement st;
        ObservableList<String> list = FXCollections.observableArrayList();
        try {
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM maskapai");
            while (rs.next()){
                list.add(rs.getString("namaMaskapai"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        optionMaskapai.setItems(null);
        optionMaskapai.setItems(list);
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

    public ObservableList<Maskapai> getMaskapaiList(){
        ObservableList<Maskapai> maskapaiList = FXCollections.observableArrayList();
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection =connectionClass.getConnection();
        String sql = "SELECT * FROM MASKAPAI";
        Statement st;
        ResultSet rs;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(sql);
            Maskapai maskapai;
            while (rs.next()){
                maskapai = new Maskapai(rs.getInt("idMaskapai"), rs.getString("namaMaskapai"));
                maskapaiList.add(maskapai);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return maskapaiList;
    }

    public void showMaskapai(){
        ObservableList<Maskapai> list = getMaskapaiList();
        colIdMaskapai.setCellValueFactory(new PropertyValueFactory<Maskapai, Integer>("idMaskapai"));
        tableMaskapai.setCellValueFactory(new PropertyValueFactory<Maskapai, String>("namaMaskapai"));
        tableViewMaskapai.setItems(list);
    }

    private void insertMaskapai(){
        String sql = "INSERT INTO maskapai (namaMaskapai) VALUES('"+inputCreateMaskapai.getText()+"')";
        executeQuery(sql);
        showMaskapai();
    }

    private void updateMaskapai(){
        String sql = "UPDATE maskapai SET namaMaskapai = '"+inputCreateMaskapai.getText()+"' WHERE idMaskapai = "+inputUpdateMaskapai.getText()+"";
        executeQuery(sql);
        showMaskapai();
    }

    private void insertTiket() {
        String sql = "INSERT INTO tiket (namaMaskapai, tujuan, waktu, stok, kelas) VALUES('"+optionMaskapai.getValue()+"','"+inputTujuan.getText()+"','"+inputWaktu.getValue()+"',"+inputStok.getText()+",'"+inputKelas.getText()+"')";
        executeQuery(sql);
        showMaskapai();
        System.out.println("lalalal"+inputWaktu.toString());
    }

    private void executeQuery(String sql) {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection =connectionClass.getConnection();
        Statement st;
        try {
            st = connection.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void deleteMaskapai(){
        String sql = "DELETE FROM maskapai WHERE idMaskapai = "+inputUpdateMaskapai.getText()+"";
        executeQuery(sql);
        showMaskapai();
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
        }else if(mouseEvent.getSource() == createButtonMaskapai){
            createButtonMaskapai.setStyle("-fx-background-color: #076180;");
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
        }else if(mouseEvent.getSource() == createButtonMaskapai){
            createButtonMaskapai.setStyle("-fx-background-color:  #006680;");
        }else if(mouseEvent.getSource() == close){
            close.setStyle("-fx-background-color: transparent;");
        }else if(mouseEvent.getSource() == history){
            history.setStyle("-fx-background-color: transparent;");
        }
    }
}