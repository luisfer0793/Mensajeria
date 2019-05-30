package logic.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import logic.beans.Contacto;

public class LoginController {
    @FXML private TextField nombre;
    @FXML private TextField telefono;
    @FXML private PasswordField password;

    // Metodo para realizar acción desde el boton
    @FXML
    public void registrarse() {
        System.out.println(new Contacto(nombre.getText(), telefono.getText()));
    }

    @FXML
    public void iniciarSesion() {

    }
}
