package logic.beans;

import java.util.function.Predicate;

public class Lista {
    // Clase interna tipo Nodo
    private class Nodo {
        private Nodo apuntador = null;
        private Contacto contacto;

        // Constructor Interno
        public Nodo(Contacto contacto) {
            this.contacto = contacto;
        }
    }

    // Atributos de la clase Lista
    private Nodo nodoSiguiente = null;
    private static int numeroContactos = 0;

    // Metodos de la clase Lista
    public boolean estaVacia() {
        return numeroContactos == 0;
    }

    public void agregar(Contacto contacto) {
        Nodo nodo = new Nodo(contacto);
        nodo.apuntador = nodoSiguiente;
        nodoSiguiente = nodo;
        numeroContactos++;
    }

    public Contacto buscar(Predicate<Contacto> condicion) {
        Nodo auxiliar = nodoSiguiente;
        while (auxiliar != null) {
            if (condicion.test(auxiliar.contacto))
                return auxiliar.contacto;
            auxiliar = auxiliar.apuntador;
        }
        return null;
    }
}
