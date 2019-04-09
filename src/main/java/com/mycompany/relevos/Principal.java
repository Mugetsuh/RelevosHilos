/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.relevos;

/**
 * Clase que instancia equipos y corredores e inicializa la carrera
 * @author German Garcia
 * @author Diego Rodriguez
 */
public class Principal {

    private static final String ROJO = "\u001b[1;31m";
    private static final String VERDE = "\u001b[1;32m";
    private static final String AZUL = "\u001b[1;34m";
    /**
     * Método que se encarga de crear los equipos, corredores e inicializa la carrera 
     */
    public void principal() {

        Equipo equipo1 = new Equipo(ROJO + "Equipo 1");
        Equipo equipo2 = new Equipo(VERDE + "Equipo 2");
        Equipo equipo3 = new Equipo(AZUL + "Equipo 3");
        
        Corredor corredor1 = new Corredor(0, equipo1);
        Corredor corredor2 = new Corredor(33, equipo1);
        Corredor corredor3 = new Corredor(66, equipo1);
        Corredor corredor4 = new Corredor(0, equipo2);
        Corredor corredor5 = new Corredor(33, equipo2);
        Corredor corredor6 = new Corredor(66, equipo2);
        Corredor corredor7 = new Corredor(0, equipo3);
        Corredor corredor8 = new Corredor(33, equipo3);
        Corredor corredor9 = new Corredor(66, equipo3);  
        
        corredor1.start();
        corredor2.start();
        corredor3.start();
        corredor4.start();
        corredor5.start();
        corredor6.start();
        corredor7.start();
        corredor8.start();
        corredor9.start();
    }
}