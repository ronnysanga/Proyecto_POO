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

//criterios.txt
//id|criterio|idconcurso

public class Criterio {
    private int id;
    private int idConcurso;
    private String descripcion;
    private ArrayList<Evaluacion> evaluaciones;
    private Concurso concurso;
    
    //cambio
    //id|descripcion

    public Criterio(int id, String descripcion,int idConcurso) {
        this.id = id;
        this.descripcion = descripcion;
        this.idConcurso = idConcurso;
    }
    
    public void saveFile(String nomfile){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true)))
        {
            
            pw.println(this.id+"|"+this.descripcion+"|"+this.idConcurso); 
                     
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
            String[] tokens = linea.split("\\|");
            Criterio crite = new Criterio(Integer.parseInt(tokens[0]),tokens[1],Integer.parseInt(tokens[2]));
            criterios.add(crite);
            }//se podia agregar a los premios que habia     
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }        
        return criterios;
    }
    public static Criterio nextCriterio (Scanner sc,int idcon){
        sc.useDelimiter("\n");
        System.out.println("Su id es:");
        int id = Criterio.readfromfile("criterios.txt").size() + 1;     
        System.out.println(id);
        System.out.println("Ingrese descripcion: ");
        String descrip = sc.next();
        Criterio criterios = new Criterio(id, descrip,idcon);
        return criterios;  
           
    }
    
    public static void numCriterios(int criterios,int idcon){
        for (int i = 1; i <= criterios; i++){
            System.out.println("Criterio: "+ i);
            Scanner sc = new Scanner(System.in);
            Criterio newcriterio = Criterio.nextCriterio(sc,idcon);
            newcriterio.saveFile("criterios.txt");
        }
    }   
    
    @Override
    
    public String toString() {
        return String.valueOf(this.id)+"-"+ this.descripcion;
    }
}
