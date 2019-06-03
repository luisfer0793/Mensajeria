package logic.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import logic.beans.Administrador;
import logic.beans.Contacto;

public class LoginController {
    @FXML private TextField nombre;
    @FXML private TextField telefono;
    @FXML private PasswordField password;
    // Metodo para realizar acción desde el boton
    @FXML
    public void registrar() {
        String nombre, telefono, password;
        nombre = this.nombre.getText();
        telefono = this.telefono.getText();
        password = this.password.getText();
        Administrador.registrarUsuario(new Contacto(nombre, telefono));
    }

    @FXML
    public void iniciarSesion() {

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
