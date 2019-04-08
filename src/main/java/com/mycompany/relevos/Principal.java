/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.relevos;

/**
 *
 * @author German
 */
public class Principal {
    
    Equipo grupo1 = new Equipo("Rojo", "R");
    Equipo grupo2 = new Equipo("Amarillo", "A");
    Equipo grupo3 = new Equipo("Verde", "V");
    
    Corredor corredor1 = new Corredor(grupo1, "Corredor 1", 0);
    Corredor corredor2 = new Corredor(grupo1, "Corredor 2", 33);
    Corredor corredor3 = new Corredor(grupo1, "Corredor 3", 66);
    Corredor corredor4 = new Corredor(grupo2, "Corredor 4", 0);
    Corredor corredor5 = new Corredor(grupo2, "Corredor 5", 33);
    Corredor corredor6 = new Corredor(grupo2, "Corredor 6", 66);
    Corredor corredor7 = new Corredor(grupo3, "Corredor 7", 0);
    Corredor corredor8 = new Corredor(grupo3, "Corredor 8", 33);
    Corredor corredor9 = new Corredor(grupo3, "Corredor 9", 66);

    public void principal() {
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
