package logic.beans;

public class Administrador {
    // Aquí se van a guardar todos los contactos que tengan un Nombre, Telefono y Contraseña.
    private static Lista usuariosRegistrados = new Lista();

    // Este metodo devuelve la lista de usuarios registrados.
    public static Lista getUsuariosRegistrados() {
        return usuariosRegistrados;
    }

    // Este metodo agrega un contacto a la lista de usuarios registrados.
    public static void registrarUsuario(Contacto contacto) {
        usuariosRegistrados.agregar(contacto);
    }

    // Este metodo devuelve el contacto que este dentro de la lista de usuarios registrados que este en linea.
    public static Contacto usuarioEnLinea() {
        return usuariosRegistrados.buscar(Contacto::isOnLine);
    }
}
