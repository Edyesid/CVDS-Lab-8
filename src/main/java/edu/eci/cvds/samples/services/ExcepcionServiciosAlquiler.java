package edu.eci.cvds.samples.services;

import org.apache.ibatis.exceptions.PersistenceException;

public class ExcepcionServiciosAlquiler extends Exception {

    public static final String VP_INVALIDO = "El vector de probabilidades que ingresó es inválido";

    public ExcepcionServiciosAlquiler(String message) {
        super(message);
    }

    public ExcepcionServiciosAlquiler(String message,PersistenceException ex) {
        super(message);
    }
}