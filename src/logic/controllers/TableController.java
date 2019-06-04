package logic.controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import logic.beans.Administrador;
import logic.beans.Contacto;
import logic.beans.Lista;

import java.net.URL;
import java.util.ResourceBundle;

public class TableController implements Initializable {
    @FXML private TextArea mensaje;
    @FXML private TextField numeroTelefono;
    @FXML private TableView<String> tablaMensajes;
//    @FXML private TableColumn<Contacto, String> columnaEmisor;
//    @FXML private TableColumn<Contacto, ObservableList<String>> columnaMensaje;
    // Propiedades que equivalen a los campos de texto para agregar un nuevo contacto.
    @FXML private TextField textfieldTelefono;
    @FXML private TextField textfieldNombre;
    @FXML private PasswordField textfieldPassword;
    // Propiedades que equivalen a la tabla general y a las columnas.
    @FXML private TableView<Contacto> tablaContactos;
    @FXML private TableColumn<Contacto, String> columnaNombre;
    @FXML private TableColumn<Contacto, String> columnaTelefono;
    // Propiedad que representa el usuario que esta en linea.
    private Contacto contactoEnLinea = null;
    private Lista contactos = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        contactoEnLinea = Administrador.usuarioEnLinea();
        if (contactoEnLinea != null)
            tablaContactos.setItems(contactoEnLinea.getContactos());
    }

    @FXML
    public void agregarContacto() {
        String nombre, telefono, password;
        Contacto contacto = null;
        nombre = textfieldNombre.getText();
        telefono = textfieldTelefono.getText();
        password = textfieldPassword.getText();
        if (nombre.length() == 0 || telefono.length() == 0 || password.length() == 0) {
            Alert alertWindow = new Alert(Alert.AlertType.ERROR);
            alertWindow.setTitle("Error");
            alertWindow.setHeaderText("DATOS INCORRECTOS");
            alertWindow.setContentText("Los campos no deben de estar vacíos");
            alertWindow.show();
        }
        else {
            Administrador.registrarUsuario(new Contacto(nombre, telefono, password));
            Alert alertWindow = new Alert(Alert.AlertType.INFORMATION);
            alertWindow.setTitle("Registro");
            alertWindow.setHeaderText("REGISTRO EXITOSO");
            alertWindow.setContentText("Se agregó el usuario " + nombre + " a los registros y a tus contactos.");
            alertWindow.show();
            contacto = new Contacto(nombre, telefono, password);
            tablaContactos.getItems().add(contacto);
        }
    }

    @FXML
    public void enviarMensaje() {
        String numeroTelefono, mensaje;
        numeroTelefono = this.numeroTelefono.getText();
        mensaje = this.mensaje.getText();
        contactos = Administrador.getUsuariosRegistrados();
        Contacto receptor = contactos.buscar(contacto -> contacto.getTelefono().equals(numeroTelefono));
        if (receptor == null) {
            Alert alertWindow = new Alert(Alert.AlertType.ERROR);
            alertWindow.setTitle("Error");
            alertWindow.setHeaderText("NUMERO DE TELEFONO INEXISTENTE");
            alertWindow.setContentText("El numero de telefono no pertenece a ninguno de tus contactos.");
            alertWindow.show();
        }
        else {
            Alert alertWindow = new Alert(Alert.AlertType.CONFIRMATION);
            alertWindow.setTitle("Exito");
            alertWindow.setHeaderText("MENSAJE ENVIADO");
            alertWindow.setContentText("El mensaje fue enviado con exito al numero " + numeroTelefono);
            alertWindow.show();
            receptor.agregarMensaje(contactoEnLinea.getTelefono() + " - " + mensaje + "\n");
        }
    }

    @FXML
    public void verMensajes() {
        if (contactoEnLinea.getMensajes().isEmpty()) {
            Alert alertWindow = new Alert(Alert.AlertType.INFORMATION);
            alertWindow.setTitle("Mensajes de " + contactoEnLinea.getNombre());
            alertWindow.setHeaderText("NO HAY MENSAJES NUEVOS");
            alertWindow.setContentText("Aun no has recibido mensajes de tus contactos.");
            alertWindow.show();
        }
        else {
            Alert alertWindow = new Alert(Alert.AlertType.INFORMATION);
            alertWindow.setTitle("Mensajes de " + contactoEnLinea.getNombre());
            alertWindow.setHeaderText("MENSAJES RECIBIDOS");
            alertWindow.setContentText(contactoEnLinea.getMensajes().toString());
            alertWindow.show();
        }
    }

    @FXML
    public void cerrarSesion(ActionEvent event) throws Exception {
        contactoEnLinea.setOnLine(false);
        Parent root = FXMLLoader.load(getClass().getResource("/view/scenes/login.fxml"));
        Scene escenaContactos = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(escenaContactos);
        window.show();
    }
}
