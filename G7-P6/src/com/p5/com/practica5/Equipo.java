package com.practica5;

import com.practica5.Entrenador.Entrenador;
import com.practica5.Jugadores.Jugador;
import com.practica5.Jugadores.EstadoTraspaso;
import java.util.ArrayList;

/**
 * Clase que representa un equipo de fútbol, con un nombre abreviado, un entrenador, un presidente
 * y una lista de jugadores. Permite realizar transferencias de jugadores entre equipos, agregar
 * jugadores a un equipo y gestionar la información del equipo.
 * 
 * @autor [Nombre del autor]
 */
public class Equipo {
    private String abreviatura;
    private Entrenador entrenador;
    private Presidente presidente;
    private ArrayList<Jugador> jugadores;
    private static int contadorEquipos = 0; //Variable de intensia

    /**
     * Constructor para crear un nuevo equipo.
     *
     * @param abreviatura La abreviatura del nombre del equipo (por ejemplo, "FCB" para Barcelona).
     * @param entrenador El entrenador del equipo.
     * @param presidente El presidente del equipo.
     * @param jugadores La lista de jugadores que pertenecen al equipo.
     */
    public Equipo(String abreviatura, Entrenador entrenador, Presidente presidente, ArrayList<Jugador> jugadores) {
        this.abreviatura = abreviatura;
        this.entrenador = entrenador;
        this.presidente = presidente;
        this.jugadores = jugadores;
        contadorEquipos ++;
    }

    /**
     * Método para agregar un jugador al equipo. Si el jugador no está ya en el equipo,
     * se añade a la lista de jugadores y se imprime un mensaje. Si el jugador ya está en el equipo,
     * se imprime un mensaje indicando que ya pertenece al equipo.
     *
     * @param jugador El jugador que se desea agregar al equipo.
     */
    public void agregarJugador(Jugador jugador) {
        if (!jugadores.contains(jugador)) {
            jugadores.add(jugador);
            System.out.println("Jugador " + jugador.getNombre() + " agregado al equipo " + abreviatura);
        } else {
            System.out.println("Jugador " + jugador.getNombre() + " ya está en el equipo.");
        }
    }
    public static int getContadorEquipos() {
        return contadorEquipos;
     }

    /**
     * Método para realizar un traspaso de un jugador a otro equipo. El traspaso solo se realiza
     * si el presidente del equipo ha aprobado el traspaso. Si el traspaso es aprobado, el jugador es
     * removido del equipo actual y agregado al nuevo equipo.
     *
     * @param jugador El jugador que se desea transferir.
     * @param nuevoEquipo El equipo al que se transferirá el jugador.
     */
    public void hacerTransferencia(Jugador jugador, Equipo nuevoEquipo) {
        if (jugador.getTraspaso() == EstadoTraspaso.APROBADO_POR_PRESIDENTE) {
            // Eliminar al jugador del equipo actual
            jugadores.remove(jugador);
            jugador.setEquipo(nuevoEquipo);
            // Agregar al jugador al nuevo equipo
            nuevoEquipo.agregarJugador(jugador);
            System.out.println("El jugador " + jugador.getNombre() + " ha sido movido a " + nuevoEquipo.abreviatura);
        } else {
            System.out.println("La transferencia no ha podido realizarse: " + jugador.getNombre()
                    + " no ha sido movido a " + nuevoEquipo.abreviatura);
        }
    }

    // Métodos getter y setter

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public Presidente getPresidente() {
        return presidente;
    }

    public void setPresidente(Presidente presidente) {
        this.presidente = presidente;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    /**
     * Método para representar el equipo como una cadena de texto.
     *
     * @return Una cadena que representa el equipo, incluyendo su nombre abreviado, presidente,
     *         entrenador y jugadores.
     */
    @Override
    public String toString() {
        return "Equipo : " +
                "nombre='" + this.abreviatura + '\'' +
                ", presidente=" + presidente +
                ", entrenador=" + entrenador +
                ", jugador=" + jugadores ;
    }
}
