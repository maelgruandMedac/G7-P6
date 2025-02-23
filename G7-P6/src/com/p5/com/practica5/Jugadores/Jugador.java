package com.practica5.Jugadores;

import com.practica5.Jugadores.Jugador;
import java.util.Date;
import com.practica5.Equipo;

/**
 * Clase que representa a un jugador de fútbol. El jugador tiene un nombre, fecha de nacimiento, 
 * país de origen, posición en el campo, dorsal, estado del traspaso y el equipo al que pertenece.
 * Además, puede solicitar un traspaso y ser transferido entre equipos.
 * 
 * @autor [Nombre del autor]
 */
public class Jugador {
   private String nombre;
   private Date fechaNacimiento;
   private String paisOrigen;
   private Poticion posicion; // "Delantero", "Defensa", etc.
   private int dorsal;
   private EstadoTraspaso traspaso;
   private Equipo equipo;
   private static int contadorJugadores = 0;

   /**
    * Constructor para crear un nuevo jugador con los atributos proporcionados.
    *
    * @param nombre El nombre del jugador.
    * @param fechaNacimiento La fecha de nacimiento del jugador.
    * @param paisOrigen El país de origen del jugador.
    * @param posicion La posición del jugador en el campo (por ejemplo, "Delantero").
    * @param dorsal El número de dorsal del jugador.
    * @param equipo El equipo al que pertenece el jugador.
    */
   public Jugador(String nombre, Date fechaNacimiento, String paisOrigen, Poticion posicion, int dorsal,
         Equipo equipo) {
      this.nombre = nombre;
      this.fechaNacimiento = fechaNacimiento;
      this.paisOrigen = paisOrigen;
      this.posicion = posicion;
      this.dorsal = dorsal;
      this.traspaso = EstadoTraspaso.SIN_SOLICITAR;
      this.equipo = equipo;
      contadorJugadores++; // Incrementar el contador de jugadores instanciados
   }

   // Getters y setters

   /**
    * Obtiene el nombre del jugador.
    *
    * @return El nombre del jugador.
    */
   public String getNombre() {
      return nombre;
   }

   /**
    * Establece el nombre del jugador.
    *
    * @param nombre El nuevo nombre del jugador.
    */
   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   /**
    * Obtiene la fecha de nacimiento del jugador.
    *
    * @return La fecha de nacimiento del jugador.
    */
   public Date getFechaNacimiento() {
      return fechaNacimiento;
   }

   /**
    * Establece la fecha de nacimiento del jugador.
    *
    * @param fechaNacimiento La nueva fecha de nacimiento del jugador.
    */
   public void setFechaNacimiento(Date fechaNacimiento) {
      this.fechaNacimiento = fechaNacimiento;
   }

   /**
    * Obtiene el país de origen del jugador.
    *
    * @return El país de origen del jugador.
    */
   public String getPaisOrigen() {
      return paisOrigen;
   }

   /**
    * Establece el país de origen del jugador.
    *
    * @param paisOrigen El nuevo país de origen del jugador.
    */
   public void setPaisOrigen(String paisOrigen) {
      this.paisOrigen = paisOrigen;
   }

   /**
    * Obtiene la posición del jugador en el campo.
    *
    * @return La posición del jugador.
    */
   public Poticion getPosicion() {
      return posicion;
   }

   /**
    * Establece la posición del jugador en el campo.
    *
    * @param posicion La nueva posición del jugador.
    */
   public void setPosicion(Poticion posicion) {
      this.posicion = posicion;
   }

   /**
    * Obtiene el número de dorsal del jugador.
    *
    * @return El número de dorsal del jugador.
    */
   public int getDorsal() {
      return dorsal;
   }

   /**
    * Establece el número de dorsal del jugador. El dorsal debe ser un valor mayor o igual a 0.
    *
    * @param dorsal El nuevo número de dorsal del jugador.
    */
   public void setDorsal(int dorsal) {
      if (dorsal >= 0)
         this.dorsal = dorsal;
   }

   /**
    * Obtiene el estado actual del traspaso del jugador.
    *
    * @return El estado del traspaso.
    */
   public EstadoTraspaso getTraspaso() {
      return traspaso;
   }

   /**
    * Establece el estado del traspaso del jugador.
    *
    * @param traspaso El nuevo estado del traspaso.
    */
   public void setTraspaso(EstadoTraspaso traspaso) {
      this.traspaso = traspaso;
   }

   /**
    * Establece el equipo del jugador. El jugador es agregado automáticamente al equipo.
    *
    * @param equipo El nuevo equipo del jugador.
    */
    public void equipoSet(Equipo equipo) {
      this.equipo = equipo; // Asignar el equipo al jugador
      equipo.agregarJugador(this); // Agregar el jugador al equipo
    
    }
    
   

   /**
    * Establece el nuevo equipo al que pertenece el jugador.
    *
    * @param nuevoClub El nuevo equipo del jugador.
    */
   public void setEquipo(Equipo nuevoClub) {
      this.equipo = nuevoClub;
   }

   public Equipo getEquipo(){
      return equipo;
   }

   /**
    * Solicita un traspaso para el jugador. Si ya ha solicitado un traspaso, se muestra un mensaje 
    * indicando que ya se ha solicitado. Si no, el estado del traspaso se cambia a "SOLICITADO".
    */
   public void solicitarTraspaso() {
      if (this.traspaso == EstadoTraspaso.SOLICITADO) {
         System.out.println("El jugador ya ha solicitado un traspaso.");
      } else {
         this.traspaso = EstadoTraspaso.SOLICITADO;
         System.out.println("El jugador " + this.nombre + " ha solicitado un traspaso.");
      }
   }
   public static int getContadorJugadores() {
      return contadorJugadores;
   }

   /**
    * Representa al jugador como una cadena de texto que incluye su nombre, fecha de nacimiento, 
    * dorsal, estado del traspaso y equipo.
    *
    * @return Una cadena que representa al jugador.
    */
   @Override
   public String toString() {
      return "Jugador: " + nombre + " " + this.fechaNacimiento + ", Dorsal: " + dorsal + ", Estado Traspaso: " 
             + traspaso + " " + "equipo " + equipo.getAbreviatura();
   }
}
