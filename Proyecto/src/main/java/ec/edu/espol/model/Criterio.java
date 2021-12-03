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
import java.util.Scanner;

/**
 *
 * @author dell
 */
public class Criterio {
    private int id;
    private int idConcurso;
    private String descripcion;
    private ArrayList<Evaluacion> evaluaciones;
    private Concurso concurso;

    public Criterio(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }
    
    public void saveFile(String nomfile){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true)))
        {
            
            pw.println(this.id+"|"+this.descripcion); 
                     
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static ArrayList<Criterio> readfromfile(String nomfile){
        ArrayList<Criterio> criterios = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomfile))){
            while(sc.hasNextLine()){
            String linea = sc.nextLine();
            String[] tokens = linea.split("|");
            Criterio crite = new Premio((tokens[0]),tokens[1]);
            criterios.add(crite);
            }//se podia agregar a los premios que habia     
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }        
        return criterios;
    }
    public static Criterio nextCriterio (Scanner sc){
        System.out.println("Su id es:");
        System.out.println(Criterio.readfromfile("criterios.txt").size());
        int id = Criterio.readfromfile("criterios.txt").size() + 1;     
        System.out.println(id);
        System.out.println("Ingrese descripcion: ");
        String descrip = sc.next();
        
        Criterio criterios = new Premio(id, descrip);
        return criterios;  
           
    }
    @Override
    
    public String toString() {
        return String.valueOf(this.id)+"-"+ this.descripcion;
    }
}
