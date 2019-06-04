package logic.beans;

import java.util.function.Predicate;

public class Lista {
    // Clase interna tipo Nodo
    private class Nodo {
        private Nodo apuntador = null;
        private Contacto contacto;

        // Constructor Interno de la clase Nodo
        public Nodo(Contacto contacto) {
            this.contacto = contacto;
        }
    }

    // Atributos de la clase Lista.
    private Nodo nodoSiguiente = null;
    private static int numeroContactos = 0;

    // Este metodo devuelve si la lista esta vacia o no.
    public boolean estaVacia() {
        return numeroContactos == 0;
    }

    // Este metodo agrega un nuevo Nodo a la lista.
    public void agregar(Contacto contacto) {
        Nodo nodo = new Nodo(contacto);
        nodo.apuntador = nodoSiguiente;
        nodoSiguiente = nodo;
        numeroContactos++;
    }

    // Este metodo devuelve el primer elemento que coincida con la condicion establecida, la condicion debe se un boolean.
    public Contacto buscar(Predicate<Contacto> condicion) {
        Nodo auxiliar = nodoSiguiente;
        while (auxiliar != null) {
            if (condicion.test(auxiliar.contacto))
                return auxiliar.contacto;
            auxiliar = auxiliar.apuntador;
        }
        return null;
    }

    public String imprimirLista() {
        Nodo auxiliar = nodoSiguiente;
        StringBuilder listaPersonas = new StringBuilder();
        while (auxiliar != null) {
            listaPersonas.append(auxiliar.contacto.toString()).append("\n");
            auxiliar = auxiliar.apuntador;
        }
        return listaPersonas.toString();
    }
}
