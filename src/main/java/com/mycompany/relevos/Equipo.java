/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.relevos;

/**
 * Clase que contiene la información de todos los equipos de la carrera
 * @author German Garcia
 * @author Diego Rodriguez
 */
public class Equipo {

    /**
     * Almacena el nombre del equipo
     */
    private String nombre;

    /**
     * Almacena la posicion del corredor 1 del equipo
     */
    private int posicionActualC1;

    /**
     * Almacena la posicion del corredor 2 del equipo
     */
    private int posicionActualC2;

    /**
     * Almacena la posicion del corredor 3 del equipo
     */
    private int posicionActualC3;

    /**
     * Constructor que recibe los parametros necesarios para inicializar un equipo
     * 
     * @param nombre el nombre de equipo
     */
    public Equipo(String nombre) {
        this.setNombre(nombre);
        this.setPosicionActualC1(0);
        this.setPosicionActualC2(33);
        this.setPosicionActualC3(66);
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the posicionActualC3
     */
    public int getPosicionActualC3() {
        return posicionActualC3;
    }

    /**
     * @param posicionActualC3 the posicionActualC3 to set
     */
    public void setPosicionActualC3(int posicionActualC3) {
        this.posicionActualC3 = posicionActualC3;
    }

    /**
     * @return the posicionActualC2
     */
    public int getPosicionActualC2() {
        return posicionActualC2;
    }

    /**
     * @param posicionActualC2 the posicionActualC2 to set
     */
    public void setPosicionActualC2(int posicionActualC2) {
        this.posicionActualC2 = posicionActualC2;
    }

    /**
     * @return the posicionActualC1
     */
    public int getPosicionActualC1() {
        return posicionActualC1;
    }

    /**
     * @param posicionActualC1 the posicionActualC1 to set
     */
    public void setPosicionActualC1(int posicionActualC1) {
        this.posicionActualC1 = posicionActualC1;
    }
}