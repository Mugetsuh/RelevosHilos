/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.relevos;

import java.util.logging.Level;
import java.util.logging.Logger;
import static com.mycompany.relevos.Utilitaria.*;

/**
 * Clase que contiene la información de todos los corredores de la carrera
 *
 * @author German Garcia
 * @author Diego Rodriguez
 */
public class Corredor extends Thread {

    /**
     * Almacena la posición inicial del corredor en la carrera
     */
    private int posicionInicial;

    /**
     * Almacena el equipo al que pertenece el corredor
     */
    Equipo equipo;

    /**
     * Constructor que recibe los parametros necesarios para inicializar a un
     * corredor
     *
     * @param posicionInicial la posición inicial del corredor en la carrera
     * @param equipo el equipo al que pertenece el corredor
     */
    public Corredor(int posicionInicial, Equipo equipo) {
        this.setPosicionInicial(posicionInicial);
        this.setEquipo(equipo);
    }

    /**
     * @return the posisionInicial
     */
    public int getPosicionInicial() {
        return posicionInicial;
    }

    /**
     * @param posicionInicial the posisionInicial to set
     */
    public void setPosicionInicial(int posicionInicial) {
        this.posicionInicial = posicionInicial;
    }

    /**
     * @return the equipo
     */
    public Equipo getEquipo() {
        return equipo;
    }

    /**
     * @param equipo the equipo to set
     */
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    /**
     * Ejecución principal de los hilos
     */
    @Override
    public void run() {
        if (getPosicionInicial() == 0) {
            while (true) {
                int pasoActual = avanzar(1);
                if (pasoActual >= 33) {
                    equipo.setPosicionActualC1(33);
                    synchronized (equipo) {
                        equipo.notifyAll();
                        setPosicionInicial(33);
                    }
                    break;
                }
            }
        } else {
            esperaHilos();
        }

        if (getPosicionInicial() == 33) {
            while (true) {
                int pasoActual = avanzar(2);
                if (pasoActual >= 66) {
                    equipo.setPosicionActualC2(66);
                    synchronized (equipo) {
                        equipo.notify();
                    }
                    break;
                }
            }
        } else {
            esperaHilos();
        }

        if (getPosicionInicial() == 66) {
            while (true) {
                int pasoActual = avanzar(3);
                if (pasoActual >= 99) {
                    break;
                }
            }
            equipo.setPosicionActualC3(100);
            System.out.println(equipo.getNombre() + " Es el ganador!!!!!!!!");
            System.exit(0);
        } else {
            esperaHilos();
        }
    }

    /**
     * Método encargado de calcular y asignar movimientos de cada corredor en la
     * carrera
     *
     * @param numCorredor el numero de corredor
     * @return la posición actual del corredor
     */
    public int avanzar(int numCorredor) {
        pausa(200);
        int pasos = aleatorio();
        if (numCorredor == 1) {
            StringBuffer equipo1 = new StringBuffer(100);
            equipo.setPosicionActualC1(equipo.getPosicionActualC1() + pasos);
            if (equipo.getPosicionActualC1() >= 33) {
                equipo.setPosicionActualC1(33);
            }
            equipo1 = mostrarPosicion();
            imprimePista(equipo.getNombre(), equipo1);
            return equipo.getPosicionActualC1();
        }
        if (numCorredor == 2) {
            StringBuffer equipo2 = new StringBuffer(100);
            equipo.setPosicionActualC2(equipo.getPosicionActualC2() + pasos);
            if (equipo.getPosicionActualC2() >= 66) {
                equipo.setPosicionActualC2(66);
            }
            equipo2 = mostrarPosicion();
            imprimePista(equipo.getNombre(), equipo2);
            return equipo.getPosicionActualC2();
        }
        if (numCorredor == 3) {
            StringBuffer equipo3 = new StringBuffer(100);
            equipo.setPosicionActualC3(equipo.getPosicionActualC3() + pasos);
            if (equipo.getPosicionActualC3() >= 99) {
                equipo.setPosicionActualC3(99);
            }
            equipo3 = mostrarPosicion();
            imprimePista(equipo.getNombre(), equipo3);
            return equipo.getPosicionActualC3();
        }
        return 0;
    }

    /**
     * Método que hace esperar el tueno de los hilos
     */
    public void esperaHilos() {
        synchronized (equipo) {
            try {
                equipo.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Método que posiciona a los corredores en la carrera
     *
     * @return la carrera de cada equipo
     */
    public StringBuffer mostrarPosicion() {
        StringBuffer carrera = new StringBuffer(
                "====================================================================================================");
        for (int i = 0; i <= carrera.length(); i++) {
            if (i == equipo.getPosicionActualC1()) {
                carrera.setCharAt(i, '1');
            } else if (i == equipo.getPosicionActualC2()) {
                carrera.setCharAt(i, '2');
            } else if (i == equipo.getPosicionActualC3()) {
                carrera.setCharAt(i, '3');
            }
        }
        return carrera;
    }
}
