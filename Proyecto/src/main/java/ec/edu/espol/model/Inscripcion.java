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

//inscripciones.txt
//id|idmasc|idconc|valor|finsc

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
    public void saveFile(String nomfile){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true)))
        {
            pw.println(this.id+"|"+this.idMascotas+"|"+this.idConcurso+"|"+this.valor+"|"+this.fechainscripcion);       
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public static ArrayList<Inscripcion> readfromfile(String nomfile){
        ArrayList<Inscripcion> inscripciones = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomfile))){
            while(sc.hasNextLine()){
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                Inscripcion inscri = new Inscripcion(Integer.parseInt(tokens[0]),Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]),Double.parseDouble(tokens[3]),LocalDate.parse(tokens[4]));
                inscripciones.add(inscri);
            } 
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }        
        return inscripciones;
    }
    
    public static Inscripcion nextInscripcion (Scanner sc,int idmascota,int idconcurso){
        sc.useDelimiter("\n");
        //int id, int idMascotas, int idConcurso, double valor, LocalDate fechainscripcion
        System.out.println("Su id es:");
        int id = Criterio.readfromfile("inscripciones.txt").size() + 1;     
        System.out.println(id);
        System.out.println("Ingrese el valor de la inscripción: ");
        double valor = sc.nextDouble();
        System.out.println("Ingrese la fecha de la inscripción (yyyy-mm-dd):");
        LocalDate finsc = LocalDate.parse(sc.next());
        Inscripcion inscrip = new Inscripcion(id,idmascota,idconcurso,valor,finsc);
        return inscrip;  
           
    }
    @Override
    
    public String toString() {
        return String.valueOf(this.id)+"-"+this.idMascotas+"-"+this.idConcurso+"-"+this.valor+"-"+this.fechainscripcion;
        
    }
    
    
    
}
