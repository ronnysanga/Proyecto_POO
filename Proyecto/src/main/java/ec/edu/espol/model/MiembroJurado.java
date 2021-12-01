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
public class MiembroJurado extends Persona {
    private String perfil;
    private ArrayList<Evaluacion> evaluaciones;
    private String direccion;
    private String id;

    public MiembroJurado(String perfil, String nombres, String apellidos, String telefono, String email) {
        super(nombres, apellidos, telefono, email);
        this.perfil = perfil;
   
    }
    public void saveFile(String nomfile){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true)))
        {
            //datosd1|mas1|mas2
            pw.println(this.perfil+"|"+this.nombres+"|"+this.apellidos+"|"+this.telefono+"|"+this.email); 
            //for mascotas y append           
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    //readfromfile
    public static ArrayList<MiembroJurado> readfromfile(String nomfile){
        ArrayList<MiembroJurado> mJurados = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomfile))){
            while(sc.hasNextLine()){
            String linea = sc.nextLine();
            String[] tokens = linea.split("|");
            MiembroJurado m = new MiembroJurado(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4]);
            mJurados.add(m);
            }//se podia agregar a los dueños que habia     
     
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }        
        return mJurados;
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
 
    @Override
    public String toString() {
        return String.valueOf(this.perfil)+"-"+this.nombres+"-"+ this.apellidos+"-"+this.telefono+"-"+this.email;
    }
    
}
