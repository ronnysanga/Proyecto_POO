/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.util.ArrayList;

/**
 *
 * @author dell
 */
public class Inscripcion {
    private int idMascotas;
    private int idConcurso;
    private double valor;
    private double descuento;
    private Mascota mascotas;
    private Concurso concurso;
    private ArrayList<Evaluacion> evaluaciones;
    
}
