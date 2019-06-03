package logic.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import logic.beans.Contacto;

import java.net.URL;
import java.util.ResourceBundle;

public class TableController implements Initializable {
    // Propiedades que equivalen a los campos de texto para agregar un nuevo contacto.
    @FXML public PasswordField textfieldPassword;
    @FXML public TextField textfieldTelefono;
    @FXML public TextField textfieldNombre;
    // Propiedades que equivalen a la tabla general y a las columnas.
    @FXML private TableView<Contacto> tablaContactos;
    @FXML private TableColumn<Contacto, Integer> columnaId;
    @FXML private TableColumn<Contacto, String> columnaNombre;
    @FXML private TableColumn<Contacto, String> columnaTelefono;
    // Propiedad que representa el usuario que esta en linea.
    private Contacto contactoEnLinea = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        columnaId.setCellValueFactory(new PropertyValueFactory<>("ID"));
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
    }

    @FXML
    public void agregarContacto(ActionEvent actionEvent) {
        String nombre, telefono;
        nombre = textfieldNombre.getText();
        telefono = textfieldTelefono.getText();
        Contacto contacto = new Contacto(nombre, telefono);
        tablaContactos.getItems().add(contacto);
    }
}
