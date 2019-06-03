package logic.beans;

import javafx.beans.property.*;

import java.util.ArrayList;
import java.util.List;

public class Contacto {
    // Atributos de la clase
    private StringProperty nombre;
    private StringProperty telefono;
    //private StringProperty password;
    private boolean onLine;
    private List<String> mensajes;
    private Lista contactos;

    // Metodo Constructor para usuarios nuevos
    public Contacto(String nombre, String telefono) {
        this.nombre = new SimpleStringProperty(nombre);
        this.telefono = new SimpleStringProperty(telefono);
        //this.password = new SimpleStringProperty(password);
        this.onLine = false;
        this.mensajes = new ArrayList<>();
        this.contactos = new Lista();
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
//    public String getPassword() {
//        return password.get();
//    }
//
//    public void setPassword(String password) {
//        this.password.set(password);
//    }
//
//    public StringProperty passwordProperty() {
//        return password;
//    }

    // Get (mensajes)
    public List<String> getMensajes() {
        return mensajes;
    }

    public void agregarMensaje(String mensaje) {
        this.mensajes.add(mensaje);
    }

    public boolean isOnLine() {
        return onLine;
    }

    public void setOnLine(boolean onLine) {
        this.onLine = onLine;
    }

    public Lista getContactos() {
        return contactos;
    }

    public void setContactos(Lista contactos) {
        this.contactos = contactos;
    }

    public void nuevoContacto(Contacto contacto) {
        contactos.agregar(contacto);
    }
    // Sobreescritura de Metodos
    @Override
    public String toString() {
        return String.format("[%s - %s - %s]", nombre.get(), telefono.get(), onLine);
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
