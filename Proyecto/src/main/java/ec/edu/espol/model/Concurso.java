/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author dell
 */
public class Concurso {
    private double costo;
    private String nombre;
    private Date fecha;
    private Date fechainscripcion;
    private Date fechaCierreinscripcion;
    private String tematica;
    private ArrayList<Inscripcion> inscripciones;
    private ArrayList<Premio> premios;
    private ArrayList<Criterio> criterios;
    
}
