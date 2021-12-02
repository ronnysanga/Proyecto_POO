/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

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
    
    public Mascota(int idDueño, String nombre, String raza, String tipo, Date fechanacimiento) {
        this.idDueño = idDueño;
        this.nombre = nombre;
        this.raza = raza;
        this.tipo = tipo;
        this.fechanacimiento = fechanacimiento;
        
    }
    
    public static Object nextMascota(Scanner mas){
        System.out.println("ID del dueño: ");
            int idDueño = mas.nextInt();
        System.out.println("Ingrese nombre de la mascota: ");
            String nombre = mas.nextLine();
        System.out.println("Ingrese el tipo de animal: ");
            String tipo = mas.next();
        System.out.println("Ingrese la raza de animal: ");
            String raza = mas.nextLine();
        System.out.println("Ingrese la fecha de nacimiento de la mascota: ");
            String fecha = mas.next();
        
            return new Mascota(idDueño,nombre,tipo,raza,fecha);
    }
    
    public void saveFile(String nomfile){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true)))
        {
            pw.println(this.idDueño+"|"+this.nombre+"|"+this.raza+"|"+this.tipo+"|"+this.fechanacimiento);        
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
