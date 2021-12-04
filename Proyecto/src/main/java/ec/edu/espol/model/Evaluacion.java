/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

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
    public void saveFile(String nomfile){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true)))
        {
            pw.println(this.id+"|"+this.idinscripcion+"|"+this.idMiembroJurado+"|"+this.idCriterio+"|"+this.nota);       
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public static ArrayList<Evaluacion> readfromfile(String nomfile){
        ArrayList<Evaluacion> evaluaciones = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomfile))){
            while(sc.hasNextLine()){
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                //int id, int idinscripcion, int idMiembroJurado, int idCriterio, double nota
                Evaluacion evalu = new Evaluacion(Integer.parseInt(tokens[0]),Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]),Integer.parseInt(tokens[3]),Double.parseDouble(tokens[4]));
                evaluaciones.add(evalu);
            } 
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }        
        return evaluaciones;
    }
    
    public static Evaluacion nextEvaluacion (Scanner sc){
        sc.useDelimiter("\n");
        //int id, int idinscripcion, int idMiembroJurado, int idCriterio, double nota
        System.out.println("Su id es:");
        int id = Criterio.readfromfile("evaluaciones.txt").size() + 1;     
        System.out.println(id);
        System.out.println("Ingrese ID de la Inscripción: ");
        int insc = sc.nextInt();
        System.out.println("Ingrese el ID del Miembro del Jurado: ");
        int miem = sc.nextInt();
        System.out.println("Ingrese el ID del Criterio a evaluar: ");
        int crit = sc.nextInt();
        System.out.println("Ingrese la Nota: ");
        double nota = sc.nextDouble();
        Evaluacion evalu = new Evaluacion(id,insc,miem,crit,nota);
        return evalu;  
           
    }
    @Override
    
    public String toString() {
        //int id, int idinscripcion, int idMiembroJurado, int idCriterio, double nota
        return String.valueOf(this.id)+"-"+this.idinscripcion+"-"+this.idMiembroJurado+"-"+this.idCriterio+"-"+this.nota;
    }
}
