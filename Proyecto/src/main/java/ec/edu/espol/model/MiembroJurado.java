/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author dell
 */
public class MiembroJurado extends Persona {
    private String perfil;
    private ArrayList<Evaluacion> evaluaciones;
    
    /**
     *
     * @param perfil
     */
    public MiembroJurado(String perfil) {
        this.perfil = perfil;
        
    }
    public static String nextMiembroJurado (Scanner scan){
        System.out.println("Ingrese su perfil: ");
          
        String perfil = scan.next();
        return perfil;  
           
    }
    
    //public void

    public String getPerfil() {
        return perfil;
    }

    public ArrayList<Evaluacion> getEvaluaciones() {
        return evaluaciones;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public void setEvaluaciones(ArrayList<Evaluacion> evaluaciones) {
        this.evaluaciones = evaluaciones;
    }
    
}
