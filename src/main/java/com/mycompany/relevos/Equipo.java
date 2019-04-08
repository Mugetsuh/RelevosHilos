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
public class Equipo {
    
    private String nombre;
    private String inicio;
    private int posicionActual;

    public Equipo(String nombre, String inicio) {
        this.nombre = nombre;
        this.inicio = inicio;
        this.posicionActual = 0;
    }
    
    public synchronized String Impresion(){
        String imprimir= " ";
        imprimir = "\nGrupo : " + inicio + " ";
        for (int i = 0; i <= 100; i++) {
            if (i == 33){
                imprimir += "||";
            } else if (i == 66){
                imprimir += "||";
            } else if (i == posicionActual){
                imprimir +="*°";
            } else {
                imprimir += "¬";
            }
        }
        return imprimir;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public int getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(int posicionActual) {
        this.posicionActual = posicionActual;
    }    
}
