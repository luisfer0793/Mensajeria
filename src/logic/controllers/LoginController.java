package logic.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import logic.beans.Administrador;
import logic.beans.Contacto;
import logic.beans.Lista;

public class LoginController {
    // Atributos para registro de nuevos usuarios
    @FXML private TextField nombre;
    @FXML private TextField telefono;
    @FXML private PasswordField password;
    // Atributos para login de usuarios
    @FXML private TextField nombreLogin;
    @FXML private PasswordField passwordLogin;
    // Atributos
    private Lista usuarios = Administrador.getUsuariosRegistrados();
    private Contacto usuarioEnLinea;

    @FXML
    public void iniciarSesion(ActionEvent event) throws Exception{
        usuarioEnLinea = usuarios.buscar(contacto -> contacto.getNombre().equals(nombreLogin.getText()) && contacto.getPassword().equals(passwordLogin.getText()));
        if (usuarioEnLinea == null) {
            Alert alertWindow = new Alert(Alert.AlertType.ERROR);
            alertWindow.setTitle("Error");
            alertWindow.setHeaderText("Usuario No Encontrado");
            alertWindow.setContentText("El usuario y contraseña son incorrectos.");
            alertWindow.show();
        }
        else {
            usuarioEnLinea.setOnLine(true);
            Parent root = FXMLLoader.load(getClass().getResource("/view/scenes/contacts.fxml"));
            Scene escenaContactos = new Scene(root);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(escenaContactos);
            window.show();
        }
    }

    @FXML
    public void registrar() {
        String nombre, telefono, password;
        nombre = this.nombre.getText();
        telefono = this.telefono.getText();
        password = this.password.getText();
        if (nombre.length() == 0 || telefono.length() == 0 || password.length() == 0) {
            Alert alertWindow = new Alert(Alert.AlertType.ERROR);
            alertWindow.setTitle("Error");
            alertWindow.setHeaderText("DATOS INCORRECTOS");
            alertWindow.setContentText("Los campos no deben estar vacios");
            alertWindow.show();
        }
        else {
            Administrador.registrarUsuario(new Contacto(nombre, telefono, password));
            Alert alertWindow = new Alert(Alert.AlertType.INFORMATION);
            alertWindow.setTitle("Registro");
            alertWindow.setHeaderText("REGISTRO EXITOSO");
            alertWindow.setContentText("Se registro el usuario " + nombre + " con exito.");
            alertWindow.show();
        }
    }

    @FXML
    public void verRegistrados() {
        Alert alertWindow = new Alert(Alert.AlertType.INFORMATION);
        alertWindow.setTitle("Usuarios Registrados");
        alertWindow.setHeaderText("Usuarios Registrados");
        alertWindow.setContentText(Administrador.getUsuariosRegistrados().imprimirLista());
        alertWindow.show();
    }


}
