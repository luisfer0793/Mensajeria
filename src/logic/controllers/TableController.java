package logic.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import logic.beans.Administrador;
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
//    private Contacto contactoEnLinea = Administrador.usuarioEnLinea();
    private Contacto contactoEnLinea = new Contacto("Fernando", "57190312");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        columnaId.setCellValueFactory(new PropertyValueFactory<>("ID"));
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        contactoEnLinea.setOnLine(true);
        contactoEnLinea.nuevoContacto(new Contacto("Marlene", "04455226622"));
        if (contactoEnLinea != null)
            tablaContactos.setItems(contactoEnLinea.getContactos());
    }

    @FXML
    public void agregarContacto(ActionEvent actionEvent) {
        String nombre, telefono;
        nombre = textfieldNombre.getText();
        telefono = textfieldTelefono.getText();
        Contacto contacto = new Contacto(nombre, telefono);
        //contactoEnLinea.nuevoContacto(contacto);
        tablaContactos.getItems().add(contacto);
    }

    @FXML
    public void verContactos() {
        Alert alertWindow = new Alert(Alert.AlertType.INFORMATION);
        alertWindow.setTitle("Usuarios de " + contactoEnLinea.getNombre());
        alertWindow.setHeaderText("Usuarios Registrados de " + contactoEnLinea.getNombre());
        alertWindow.setContentText(contactoEnLinea.getContactos().toString());
        alertWindow.show();
    }
}
