/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.relevos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que contiene métodos comunes en toda la aplicación
 * @author German Garcia
 * @author Diego Rodriguez
 */
public class Utilitaria {

    private static short contImpresion = 0;
    private static final String FF = "\u001b[0m";
    
    /**
     * Método que genera aleatoriamente los pasos de un corredor en la carrera
     * @return
     */
    public static int aleatorio() {
        return (int) (Math.random() * 3);
    }

    /**
     * Método que genera un tiempo de espera en la ejecición del programa
     * @param mills el tiempo de espera en milisegundos
     */
    public static void pausa(int mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException ex) {
            Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public synchronized static void imprimePista(String nombreEquipo, StringBuffer carrera) {
        System.out.println(nombreEquipo + ": " + carrera + FF);
        contImpresion++;
        if (contImpresion == 3) {
            System.out.println();
            contImpresion = 0;
        }
    }
}
