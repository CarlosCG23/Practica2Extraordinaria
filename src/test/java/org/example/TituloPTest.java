package org.example;

import org.apache.commons.lang.ObjectUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TituloPTest {
    Pelicula prueba = null;
    Float esperado = Float.parseFloat("0");

    @Before
    public void setUp() throws Exception {
        prueba = new Pelicula();
        esperado = (float) 1;
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void nuevoID() {
        nuevoID();
    }
}