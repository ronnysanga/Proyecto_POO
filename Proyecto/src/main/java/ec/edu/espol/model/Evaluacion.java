/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

/**
 *
 * @author dell
 */
public class Evaluacion {
    private int id;
    private int idinscripcion;
    private int idMiembroJurado;
    private int idCriterio;
    private double nota;
    private Inscripcion inscripcion;
    private MiembroJurado miembroJurado;
    private Criterio criterio;

    public Evaluacion(int id, int idinscripcion, int idMiembroJurado, int idCriterio, double nota) {
        this.id = id;
        this.idinscripcion = idinscripcion;
        this.idMiembroJurado = idMiembroJurado;
        this.idCriterio = idCriterio;
        this.nota = nota;
    }
    
    
    
}
