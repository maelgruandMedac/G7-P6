/**
 * l
 */
package com.practica5;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.practica5.Entrenador.Entrenador;
import com.practica5.Entrenador.Formacion;
import com.practica5.Jugadores.Jugador;
import com.practica5.Jugadores.Poticion;

/**
 * Clase principal para simular un escenario de transferencia de jugadores en un juego de fútbol.
 * Esta clase crea equipos, jugadores, entrenadores y presidentes, y gestiona el proceso
 * de transferencia de jzzzzzzzzzugadores entre dos equipos.
 * 
 * @autor [Maël Gruand]
 * @author [Piero Infante]
 */
public class Main {

    /**
     * Crea una fecha de nacimiento a partir de un año, mes y día dados.
     * El mes comienza en 0, por lo que es necesario restar 1 al mes pasado como argumento.
     *
     * @param year El año de nacimiento.
     * @param month El mes de nacimiento (1-12).
     * @param day El día de nacimiento.
     * @return La fecha de nacimiento creada.
     */
    public static Date getFechaNacimiento(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day); // El mes comienza en 0
        return calendar.getTime();
    }

    /**
     * Método principal que simula el proceso de creación de equipos, jugadores, entrenadores y presidentes,
     * así como la gestión de las transferencias de jugadores entre dos equipos.
     *
     * @param args Los argumentos de la línea de comandos (no utilizados en este caso).
     */
    public static void main(String[] args) {
        Entrenador entrenador1 = new Entrenador("Guardiola", Formacion._433);
        Entrenador entrenador2 = new Entrenador("Mourinho", Formacion._442);
        ArrayList<Jugador> jugadoresEquipo1 = new ArrayList<Jugador>();
        ArrayList<Jugador> jugadoresEquipo2 = new ArrayList<Jugador>();

        // Creación de los presidentes
        Presidente presidente1 = new Presidente("Laporta");
        Presidente presidente2 = new Presidente("Perez");
        Equipo equipo1 = new Equipo("FCB", entrenador1, presidente1, jugadoresEquipo1);
        Equipo equipo2 = new Equipo("RMA", entrenador2, presidente2, jugadoresEquipo2);

        // Creación de los jugadores
        Jugador jugador1 = new Jugador("Messi", getFechaNacimiento(2000, 10, 20), "Argentina", Poticion.delantero, 10,
                equipo1);
        Jugador jugador2 = new Jugador("Ronaldo", getFechaNacimiento(2004, 2, 21), "Portugal", Poticion.delantero, 7,
                equipo2);

        // Añadir los jugadores a los equipos
        jugadoresEquipo1.add(jugador1);
        jugadoresEquipo2.add(jugador2);

        // Mostrar los equipos y sus jugadores
        System.out.println(equipo1);
        System.out.println(equipo2);

        // Simular una solicitud de traspaso
        System.out.println("\n--- SOLICITUD DE TRASPASO ---");
        jugador1.solicitarTraspaso();
        jugador2.solicitarTraspaso();
        
        System.out.println(jugador1);
        System.out.println(jugador2);

        // Decisión del entrenador
        System.out.println("\n--- DECISIÓN DEL ENTRENADOR ---");
        entrenador1.decidirTraspaso(jugador1, "Aceptar"); 
        System.out.println(jugador1);
        entrenador2.decidirTraspaso(jugador2, "Aceptar"); 
        System.out.println(jugador2);

        // Decisión del presidente
        System.out.println("\n--- DECISIÓN DEL PRESIDENTE ---");
        presidente1.decidirTraspaso(jugador1, "Aceptar"); 
        presidente2.decidirTraspaso(jugador2, "Aceptar"); 

        System.out.println(jugador1);
        System.out.println(jugador2);

        // Realización del traspaso
        System.out.println("\n--- TRASPASO REALIZADO ---");
        equipo1.hacerTransferencia(jugador1, equipo2);
        jugador1.setEquipo(equipo1);
        equipo2.hacerTransferencia(jugador2, equipo1);
        jugador2.setEquipo(equipo2);
        
        System.out.println(jugador1);
        System.out.println(jugador2);

        System.out.println(equipo1);
        System.out.println(equipo2);


        // MOSTRAR TOTAL DE PRESIDENTES CREADOS
        System.out.println("\n--- TOTAL DE PRESIDENTES CREADOS ---");
        System.out.println("Total de presidentes creados: " + Presidente.getcontadorPresidente());
        
        // MOSTRAR TOTAL DE ENTRENADORES CREADOS
        System.out.println("\n--- TOTAL DE ENTRENADORES CREADOS ---");
        System.out.println("Total de entrenadores creados: " + Entrenador.getContadorEntrenadores());

        // Mostrar total de  jugadores creados
        System.out.println("\n--- TOTAL DE JUGADORES CREADOS ---");
        System.out.println("Total de jugadores creados: " + Jugador.getContadorJugadores());

        //MOSTRAR TOTAL DE EQUIPOS CREADOS
        System.out.println("\n--- TOTAL DE EQUIPOS CREADOS ---");
        System.out.println("Total de equipos creados: " + Equipo.getContadorEquipos());
    }
}

