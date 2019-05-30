package logic.beans;

import javafx.beans.property.*;

public class Contacto {
    // Atributos de la clase
    private int id;
    private static int idContador = 0;
    private boolean enLinea;
    private StringProperty nombre;
    private StringProperty telefono;

    // Metodo Constructor
    public Contacto(String nombre, String telefono) {
        this.id = idContador++;
        this.enLinea = false;
        this.nombre = new SimpleStringProperty(nombre);
        this.telefono = new SimpleStringProperty(telefono);
    }

    // Get - Set (id)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    // Sobreescritura de Metodos
    @Override
    public String toString() {
        return String.format("ID: %d [%s - %s]", id, nombre.get(), telefono.get());
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
        return contacto.getId() == this.id
                && contacto.getNombre().equals(this.nombre.get())
                && contacto.getTelefono().equals(this.telefono.get());
    }
}
