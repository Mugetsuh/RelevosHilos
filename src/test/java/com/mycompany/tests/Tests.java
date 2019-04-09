/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tests;

import com.mycompany.relevos.Utilitaria;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Clase que contiene los tests de la aplicación
 * @author German Garcia
 * @author Diego Rodriguez
 */
public class Tests {
    
    public Tests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Método que testea la generación de números aleatorios para los movivmientos de los corredores
     */
    @Test
    public void testAleatorio() {
        int pasos = Utilitaria.aleatorio();
        switch (pasos) {
            case 0:
                assertEquals(0, pasos);
                break;
            case 1:
                assertEquals(1, pasos);
                break;
            case 2:
                assertEquals(2, pasos);
                break;
            case 3:
                assertEquals(3, pasos);
                break;
            default:
                fail("El número está fuera del rango 0-3");
                break;
        }
    }
}
