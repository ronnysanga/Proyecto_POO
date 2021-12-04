/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import java.util.ArrayList;


/**
 *
 * @author dell
 */

//dueños.txt
//id|direccion|nombre|apellido|celular|email

public class Dueño extends Persona{
    private String direccion;
    private ArrayList<Mascota> mascotas;

    public Dueño(int id, String direccion, String nombres, String apellidos, String telefono, String email) {
        super(id, nombres, apellidos, telefono, email);
        this.direccion = direccion;
        
    }
    
        public String getDireccion() {
        return direccion;
    }

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
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
            pw.println(this.id+"|"+this.direccion+"|"+this.nombres+"|"+this.apellidos+"|"+this.telefono+"|"+this.email); 
            //for mascotas y append           
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    //Corregir readfromfile
    public static ArrayList<Dueño> readfromfile(String nomfile){
        ArrayList<Dueño> dueños = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomfile))){
            while(sc.hasNextLine()){
            String linea = sc.nextLine();
            String[] tokens = linea.split("\\|");
            Dueño dueñ = new Dueño(Integer.parseInt(tokens[0]),tokens[1],tokens[2],tokens[3],tokens[4],tokens[5]);
            dueños.add(dueñ);
            }//se podia agregar a los dueños que habia     
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }        
        return dueños;
    }
    
    public static Dueño nextDueño(Scanner sc){
        //this.id+"|"+this.direccion+"|"+this.nombres+"|"+this.apellidos+"|"+this.telefono+"|"+this.email
        sc.useDelimiter("\n");
        System.out.println("Su id es:");
        int id = Dueño.readfromfile("dueños.txt").size() + 1;     
        System.out.println(id);
        System.out.println("Ingrese direccion: ");
        String direc = sc.next();
        System.out.println("Ingrese nombre: ");
        String nom = sc.next();
        System.out.println("Ingrese apellido: ");
        String ape = sc.next();
        System.out.println("Ingrese telefono: ");
        String phone = sc.next();
        System.out.println("Ingrese su email: ");
        String ema = sc.next();
                
        Dueño dueño = new Dueño(id ,direc ,nom ,ape ,phone ,ema);   
        return dueño;
        
    }

    public static int buscaId(String email){
        int id = 0;
        ArrayList<Dueño> dueños = Dueño.readfromfile("dueños.txt");
        for (Dueño due: dueños){
            String ema = due.getEmail();
            if (ema.equals(email)){
                id = due.getId();
            }
        }
        return id;
    }
    

   
    @Override
    
    public String toString() {
        return String.valueOf(this.id)+"-"+this.direccion +"-"+ this.nombres +"-"+ this.apellidos +"-"+this.telefono+"-"+this.email;
    }

}
