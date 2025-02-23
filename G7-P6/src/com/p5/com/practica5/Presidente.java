package com.practica5;

import com.practica5.Jugadores.EstadoTraspaso;
import com.practica5.Jugadores.Jugador;

/**
 * Clase que representa a un presidente de un equipo de fútbol. El presidente tiene la capacidad
 * de decidir sobre los traspasos de los jugadores, siempre y cuando el entrenador haya aprobado
 * previamente el traspaso.
 * 
 * @autor [Nombre del autor]
 */
public class Presidente {
    private String nombre;
    private static int contadorPresidentes = 0; //Atributo estatico para contar instancias

    /**
     * Constructor para crear un nuevo presidente con el nombre proporcionado.
     *
     * @param nombre El nombre del presidente.
     */
    public Presidente(String nombre) {
        this.nombre = nombre;
        contadorPresidentes++; //Incrementa el contador al crear una instancia.
    }

    /**
     * Obtiene el nombre del presidente.
     *
     * @return El nombre del presidente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del presidente.
     *
     * @param nombre El nuevo nombre del presidente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static int getcontadorPresidente() {
        return contadorPresidentes;
    }

    /**
     * Método para que el presidente decida sobre un traspaso de un jugador.
     * El traspaso solo se puede aprobar o rechazar si el entrenador ha aprobado previamente
     * el traspaso del jugador. Si la decisión es "Aceptar", el presidente aprueba el traspaso;
     * si es "Rechazar", lo rechaza.
     *
     * @param jugador El jugador cuyo traspaso se está decidiendo.
     * @param decision La decisión del presidente sobre el traspaso ("Aceptar" o "Rechazar").
     */
    public void decidirTraspaso(Jugador jugador, String decision) {
        // Verifica si el entrenador ya ha aprobado el traspaso
        if (jugador.getTraspaso() == EstadoTraspaso.APROBADO_POR_ENTRENADOR) {
            if ("Aceptar".equalsIgnoreCase(decision)) {
                jugador.setTraspaso(EstadoTraspaso.APROBADO_POR_PRESIDENTE);
                System.out.println("El traspaso de " + jugador.getNombre() + " ha sido aprobado por el presidente.");
            } else if ("Rechazar".equalsIgnoreCase(decision)) {
                jugador.setTraspaso(EstadoTraspaso.RECHAZADO_POR_PRESIDENTE);
                System.out.println("El traspaso de " + jugador.getNombre() + " ha sido rechazado por el presidente.");
            } else {
                System.out.println("Decisión inválida. Use 'Aceptar' o 'Rechazar'.");
            }
        } else {
            System.out.println("El jugador " + jugador.getNombre() + " no ha sido aprobado por el entrenador para el traspaso.");
        }
    }

    /**
     * Método para representar al presidente como una cadena de texto.
     *
     * @return Una cadena que representa al presidente con su nombre.
     */
    @Override
    public String toString() {
        return "Presidente: " + nombre;
    }
}
