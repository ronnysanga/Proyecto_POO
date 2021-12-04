/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author dell
 */
public class Inscripcion {
    private int id;
    private int idMascotas;
    private int idConcurso;
    private double valor;
    private double descuento;
    private LocalDate fechainscripcion;
    private Mascota mascotas;
    private Concurso concurso;
    private ArrayList<Evaluacion> evaluaciones;

    public Inscripcion(int id, int idMascotas, int idConcurso, double valor, LocalDate fechainscripcion) {
        this.id = id;
        this.idMascotas = idMascotas;
        this.idConcurso = idConcurso;
        this.valor = valor;
        this.fechainscripcion = fechainscripcion;
    }
    
    
    
    
}
