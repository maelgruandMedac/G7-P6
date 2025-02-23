package com.practica5.Entrenador;

import com.practica5.Jugadores.EstadoTraspaso;
import com.practica5.Jugadores.Jugador;

public class Entrenador {
    private String nombre;
    private Formacion formacionPreferida; // Ejemplo: "4-4-2", "4-3-3"
    private static int contadorEntrenadores = 0;

    // Constructeur
    public Entrenador(String nombre, Formacion formacionPreferida) {
        this.nombre = nombre;
        this.formacionPreferida = formacionPreferida;
        contadorEntrenadores++; // Incrementa el contador al crear una instancia
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Formacion getFormacionPreferida() {
        return formacionPreferida;
    }

    public void setFormacionPreferida(Formacion formacionPreferida) {
        this.formacionPreferida = formacionPreferida;
    }

    public static int getContadorEntrenadores() {
        return contadorEntrenadores;
    }

    public void decidirTraspaso(Jugador jugador, String decision) {
        if (jugador.getTraspaso() == EstadoTraspaso.SOLICITADO) {
            if ("Aceptar".equalsIgnoreCase(decision)) {
                jugador.setTraspaso(EstadoTraspaso.APROBADO_POR_ENTRENADOR);
                System.out.println("Le transfert de " + jugador.getNombre() + " a été accepté par l'entraîneur.");
            } else if ("Rechazar".equalsIgnoreCase(decision)) {
                jugador.setTraspaso(EstadoTraspaso.RECHAZADO_POR_ENTRENADOR);
                System.out.println("Le transfert de " + jugador.getNombre() + " a été rejeté par l'entraîneur.");
            } else {
                System.out.println("Décision invalide. Utilisez 'Aceptar' ou 'Rechazar'.");
            }
        } else {
            System.out.println("Le joueur " + jugador.getNombre() + " n'a pas demandé de transfert.");
        }
    }
    

    @Override
    public String toString() {
        return "Entrenador: " + nombre + ", Formación: " + formacionPreferida;
    }

}
