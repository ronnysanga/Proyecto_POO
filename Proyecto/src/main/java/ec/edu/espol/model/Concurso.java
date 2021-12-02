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
public class Concurso {
    private int id;
    private double costo;
    private String nombre;
    private LocalDate fechaevento;
    private LocalDate fechainscripcion;
    private LocalDate fechaCierreinscripcion;
    private String tematica;
    private ArrayList<Inscripcion> inscripciones;
    private ArrayList<Premio> premios;
    private ArrayList<Criterio> criterios;

    public Concurso(int id, double costo, String nombre, LocalDate fechaevento, LocalDate fechainscripcion, LocalDate fechaCierreinscripcion, String tematica) {
        this.id = id;
        this.costo = costo;
        this.nombre = nombre;
        this.fechaevento = fechaevento;
        this.fechainscripcion = fechainscripcion;
        this.fechaCierreinscripcion = fechaCierreinscripcion;
        this.tematica = tematica;
    }
    
    public void saveFile(String nomfile){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true)))
        {
            //id, double costo, String nombre, Date fecha, Date fechainscripcion, Date fechaCierreinscripcion, String tematica
            pw.println(this.id+"|"+this.costo+"|"+this.nombre+"|"+this.fechaevento+"|"+this.fechainscripcion+"|"+this.fechaCierreinscripcion+"|"+this.tematica);        
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public static ArrayList<Concurso> readfromfile(String nomfile){
        ArrayList<Concurso> concursos = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomfile))){
            while(sc.hasNextLine()){
                String linea = sc.nextLine();
                String[] tokens = linea.split("|");
                //PREGUNTAR EL CAMBIO DE STRING A DATE
                //id, double costo, String nombre, Date fecha, Date fechainscripcion, Date fechaCierreinscripcion, String tematica
                Concurso conc = new Concurso(Integer.parseInt(tokens[0]),Double.parseDouble(tokens[1]),tokens[2], LocalDate.parse(tokens[3]), LocalDate.parse(tokens[4]),LocalDate.parse(tokens[5]),tokens[6]);
                concursos.add(conc);
            }//se podia agregar a los concursos que habia     
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }        
        return concursos;
    } 
    
    public static Concurso nextConcurso(Scanner sc){
        //id double costo, String nombre, Date fecha, Date fechainscripcion, Date fechaCierreinscripcion, String tematica
        System.out.println("Su id es:");
        int id = Dueño.readfromfile("concursos.txt").size() + 1;     
        System.out.println(id);
        System.out.println("Ingrese costo:");
        double cost = sc.nextDouble();
        System.out.println("Ingrese nombre:");
        String nom = sc.next();
        System.out.println("Ingrese fecha del evento(yyyy-mm-dd):");
        LocalDate fech = LocalDate.parse(sc.next());
        System.out.println("Ingrese fecha inscripcion(yyyy-mm-dd):");
        LocalDate finsp = LocalDate.parse(sc.next());
        System.out.println("Ingrese fecha Cierro inscripcion(yyyy-mm-dd):");
        LocalDate fcinsp = LocalDate.parse(sc.next());
        System.out.println("Ingrese su tematica:");
        String tem = sc.next();
                
        Concurso conc = new Concurso(id,cost,nom,fech,finsp,fcinsp,tem);   
        return conc;
        
    }

    @Override
    public String toString() {
        //id double costo, String nombre, Date fecha, Date fechainscripcion, Date fechaCierreinscripcion, String tematica
        return String.valueOf(this.id)+"-"+String.valueOf(this.costo)+"-"+this.nombre+"-"+String.valueOf(this.fechaevento)+"-"+String.valueOf(this.fechainscripcion)+"-"+String.valueOf(this.fechaCierreinscripcion)+"-"+this.tematica; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
