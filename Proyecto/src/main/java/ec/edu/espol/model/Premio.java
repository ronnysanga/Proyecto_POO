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

//premios.txt
//id|lugar|descripcion
public class Premio {
    private int id;
    private int lugar;
    private int idConcurso;
    private String descripcion;
    private Concurso concurso;
    
    //cambio

    public Premio(int id, int lugar, String descripcion) {
        this.id = id;
        this.lugar = lugar;
        this.descripcion = descripcion;
    }
  
    public void saveFile(String nomfile){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true)))
        {
            
            pw.println(this.id+"|"+this.lugar+"|"+this.descripcion); 
                     
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    //Corregir readfromfile
    public static ArrayList<Premio> readfromfile(String nomfile){
        ArrayList<Premio> premios = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomfile))){
            while(sc.hasNextLine()){
            String linea = sc.nextLine();
            String[] tokens = linea.split("\\|");
            Premio prem = new Premio(Integer.parseInt(tokens[0]),Integer.parseInt(tokens[1]),tokens[2]);
            premios.add(prem);
            }//se podia agregar a los premios que habia     
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }        
        return premios;
    }
    public static Premio nextPremio (Scanner sc){
        System.out.println("Su id es:");
        int id = Premio.readfromfile("premios.txt").size() + 1;     
        System.out.println(id);
        System.out.println("Ingrese lugar: ");
        int lug = sc.nextInt();
        System.out.println("Ingrese descripcion: ");
        String descrip = sc.next();        
        Premio premios = new Premio(id, lug, descrip);
        return premios;  
           
    }
    @Override
    
    public String toString() {
        return String.valueOf(this.id)+"-"+this.lugar +"-"+ this.descripcion;
    }


}


