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
public class Mascota {
    private int idDueño;
    private String nombre;
    private String raza;
    private String tipo;
    private Date fechanacimiento;
    private Dueño dueño;
    private ArrayList<Inscripcion> inscripciones;
    
}
