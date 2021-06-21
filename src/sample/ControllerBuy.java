package sample;

/**
 * @version 1.0
 * class untuk mengatur menu buy ticket
 */

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerBuy implements Initializable {


    @FXML
    private ComboBox listKotaAsal;

    @FXML
    private ComboBox listKotaTujuan;

    @FXML
    private ComboBox listKelasPenerbangan;

    @FXML
    private ComboBox listMaskapai;

    @FXML
    private Label label;

    @FXML
    private DatePicker datepicker;

    String valueAsal;

    String valueTujuan;

    String valueKelasPenerbangan;

    String valueMaskapai;

    String valueTanggalPergi;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        /**
         * List untuk kota asal
         */
        ObservableList<String> listAsal = FXCollections.observableArrayList("Surabaya", "Bali","Jakarta");
        listKotaAsal.setItems(listAsal);

        /**
         * List untuk kota tujuan
         */
        ObservableList<String> listTujuan = FXCollections.observableArrayList("Surabaya", "Bali","Jakarta");
        listKotaTujuan.setItems(listTujuan);

        /**
         * List untuk kelas penerbangan
         */
        ObservableList<String> listPenerbangan = FXCollections.observableArrayList("Ekonomi", "Business","First class");
        listKelasPenerbangan.setItems(listPenerbangan);

        /**
         * List untuk maskapai
         */
        ObservableList<String> listMaskapai = FXCollections.observableArrayList("Garuda Air", "Lion Air","Batik Air");
        this.listMaskapai.setItems(listMaskapai);

    }

    /**
     * Method select list kota asal
     * @param actionEvent
     */
    public void selectKotaAsal(ActionEvent actionEvent) {
        valueAsal = listKotaAsal.getSelectionModel().getSelectedItem().toString();
        //label.setText(s);
    }

    /**
     * Method select list kota tujuan
     * @param actionEvent
     */
    public void selectKotaTujuan(ActionEvent actionEvent) {
        valueTujuan = listKotaTujuan.getSelectionModel().getSelectedItem().toString();
    }

    /**
     * Method select tanggal pergi
     * @param actionEvent
     */
    public void selectTanggalPergi(ActionEvent actionEvent) {
        valueTanggalPergi = datepicker.getValue().toString();
        //System.out.println(datepicker.getValue());
        //label.setText(datepicker.getValue().toString());
    }

    /**
     * Method select list kelas penerbangan
     * @param actionEvent
     */
    public void selectKelasPenerbangan(ActionEvent actionEvent) {
        valueKelasPenerbangan = listKelasPenerbangan.getSelectionModel().getSelectedItem().toString();
    }

    /**
     * Method select list maskapai
     * @param actionEvent
     */
    public void selectMaskapai(ActionEvent actionEvent) {
        valueMaskapai = listMaskapai.getSelectionModel().getSelectedItem().toString();
    }

    /**
     * Method klik order
     * @param actionEvent
     */
    public void order(ActionEvent actionEvent) {
        if (valueAsal == null || valueTujuan == null || valueKelasPenerbangan == null || valueMaskapai == null || valueTanggalPergi == null){
            label.setText("Salah");
        }else if (valueAsal == valueTujuan){
            label.setText("ngawur gak kemana-mana anda");
        }else {
            label.setText("berhasil");
        }


    }


}
