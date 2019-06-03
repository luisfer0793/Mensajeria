package logic.beans;

import java.util.HashMap;
import java.util.Map;

public class Administrador {
    private static Lista usuariosRegistrados = new Lista();

    public static void registrarUsuario(Contacto contacto) {
        usuariosRegistrados.agregar(contacto);
    }

    public static Lista getUsuariosRegistrados() {
        return usuariosRegistrados;
    }

    public static Contacto usuarioEnLinea() {
        return usuariosRegistrados.buscar(Contacto::isOnLine);
    }
}
