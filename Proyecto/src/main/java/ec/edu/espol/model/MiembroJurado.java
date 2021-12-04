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

//miembroJuradoss.txt
//id|perfil|nombreapellido|celular|email

public class MiembroJurado extends Persona {
    private String perfil;
    private ArrayList<Evaluacion> evaluaciones;

    public MiembroJurado(int id, String perfil, String nombres, String apellidos, String telefono, String email) {
        super(id, nombres, apellidos, telefono, email);
        this.perfil = perfil;
   
    }

    public String getPerfil() {
        return perfil;
    }

    public ArrayList<Evaluacion> getEvaluaciones() {
        return evaluaciones;
    }

    public int getId() {
        return id;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }
    
    
    
    public void saveFile(String nomfile){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true)))
        {
            //datosd1|mas1|mas2
            pw.println(this.id+"|"+this.perfil+"|"+this.nombres+"|"+this.apellidos+"|"+this.telefono+"|"+this.email); 
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
                String[] tokens = linea.split("\\|");
                MiembroJurado mj = new MiembroJurado(Integer.parseInt(tokens[0]),tokens[1],tokens[2],tokens[3],tokens[4],tokens[5]);
                mJurados.add(mj);
            }//se podia agregar a los dueños que habia     
     
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }        
        return mJurados;
    }
  
    public static MiembroJurado nextMiembroJurado (Scanner sc){
        sc.useDelimiter("\n");
        System.out.println("Su id es:");
        int id = MiembroJurado.readfromfile("miembroJurados.txt").size() + 1;     
        System.out.println(id);
        System.out.println("Ingrese perfil: ");
        String per = sc.next();
        System.out.println("Ingrese nombre: ");
        String nom = sc.next();
        System.out.println("Ingrese apellido: ");
        String ape = sc.next();
        System.out.println("Ingrese telefono: ");
        String phone = sc.next();
        System.out.println("Ingrese su email: ");
        String ema = sc.next();
          
        MiembroJurado jurado = new MiembroJurado(id, per, nom, ape, phone, ema);
        return jurado;  
           
    }
    
    public static int buscaId(String email){
        int id = 0;
        ArrayList<MiembroJurado> mjurados = MiembroJurado.readfromfile("miembroJurados.txt");
        for (MiembroJurado jurado: mjurados){
            String ema = jurado.getEmail();
            if (ema.equals(email)){
                id = jurado.getId();
            }
        }
        return id;
    }
        
 
    @Override
    public String toString() {
        return String.valueOf(this.id)+"-"+this.perfil+"-"+this.nombres+"-"+ this.apellidos+"-"+this.telefono+"-"+this.email;
    }
    
}
