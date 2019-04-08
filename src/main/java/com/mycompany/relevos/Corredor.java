/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.relevos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author German
 */
public class Corredor extends Thread{
    
    Equipo equipo;
    private String nombre;
    private int posicionInicial;

    public Corredor(Equipo equipo, String nombre, int posicionInicial) {
        this.equipo = equipo;
        this.nombre = nombre;
        this.posicionInicial = posicionInicial;
    }
    
    @Override
    public void run(){
        if(posicionInicial == 0){
            sumarCarrera(1);
        }else if(posicionInicial == 33){
            sumarCarrera(2);
        }else if(posicionInicial == 66){
            sumarCarrera(3);
        }else{
            pausarHilo();
        }
    }

    private void sumarCarrera(int corredor) {
        while(true){
            if(corredor == 1){
                int posicionActual = sumar();
                if (posicionActual >= 33){
                    synchronized (equipo){
                        equipo.notifyAll();
                    }
                    break;
                }
            }
            if(corredor == 2){
                int posicionActual = sumar();
                if (posicionActual >=66){
                    synchronized (equipo){
                        equipo.notifyAll();
                    }
                    break;
                }
            }
            if(corredor == 3){
                int posicionActual = sumar();
                if (posicionActual >= 100){
                    System.out.println(equipo.getNombre() + 
                            " llego primero");
                    System.exit(0);
                }
            }
        }
   }

    private void pausarHilo() {
        synchronized (equipo) {
            try {
                equipo.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private int sumar() {        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
        }        
        int avanzar = Utilitaria.obtenerPasos();
        equipo.setPosicionActual(equipo.getPosicionActual() + avanzar);
        imprimir();        
        return equipo.getPosicionActual();        
    }

    private void imprimir() {
        if(equipo.Impresion().contains("R")){
            System.out.println("\033[31m" + equipo.Impresion());
        } else if(equipo.Impresion().contains("A")){
            System.out.println("\033[31m" + equipo.Impresion());
        } else if (equipo.Impresion().contains("V")){
            System.out.println("\033[31m" + equipo.Impresion());
        }
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPosicionInicial() {
        return posicionInicial;
    }

    public void setPosicionInicial(int posicionInicial) {
        this.posicionInicial = posicionInicial;
    }        
}
