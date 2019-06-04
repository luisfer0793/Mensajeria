package logic.beans;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

public class Contacto {
    // Atributos de la clase
    private boolean onLine;
    private StringProperty nombre;
    private StringProperty telefono;
    private StringProperty password;
    private ObservableList<String> mensajes;
//    private ObservableList<String> emisores;
    private ObservableList<Contacto> contactos;

    // Metodo Constructor para usuarios nuevos
    public Contacto(String nombre, String telefono, String password) {
        this.onLine = false;
        this.nombre = new SimpleStringProperty(nombre);
        this.telefono = new SimpleStringProperty(telefono);
        this.password = new SimpleStringProperty(password);
        this.mensajes = FXCollections.observableArrayList();
//        this.emisores = FXCollections.observableArrayList();
        this.contactos = FXCollections.observableArrayList();
    }

    // Get - Set - Property (nombre)
    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    // Get - Set - Property (nombre)
    public String getTelefono() {
        return telefono.get();
    }

    public void setTelefono(String telefono) {
        this.telefono.set(telefono);
    }

    public StringProperty telefonoProperty() {
        return telefono;
    }

    // Get - Set - Property (nombre)
    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public StringProperty passwordProperty() {
        return password;
    }

    // Get (mensajes)
    public ObservableList<String> getMensajes() {
        return mensajes;
    }

    public void agregarMensaje(String mensaje) {
//        this.emisores.add(emisor);
        this.mensajes.add(mensaje);
    }

    public boolean isOnLine() {
        return onLine;
    }

    public void setOnLine(boolean onLine) {
        this.onLine = onLine;
    }

    // Get - Set (contactos)
    public ObservableList<Contacto> getContactos() {
        return contactos;
    }

    // Sobreescritura de Metodos
    @Override
    public String toString() {
        return String.format("[%s - %s - %s - %s]", nombre.get(), telefono.get(), password.get(), onLine);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        if (object == null)
            return false;
        if (!(object instanceof Contacto))
            return false;
        Contacto contacto = (Contacto)object;
        return contacto.getNombre().equals(this.nombre.get())
                && contacto.getTelefono().equals(this.telefono.get());
    }
}
