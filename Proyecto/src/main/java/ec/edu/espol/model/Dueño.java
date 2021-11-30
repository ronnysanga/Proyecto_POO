/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.util.Scanner;

import java.util.ArrayList;


/**
 *
 * @author dell
 */
public class Dueño {
    private int id;
    private String nombres;
    private String apellidos;
    private String email;
    private String direccion;
    private ArrayList<Mascota> mascotas;

    public Dueño(String nombres, String apellidos, String email) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
    }
    
    
    public static Dueño nextDueño(Scanner ekisde){
        System.out.println("Ingrese sus nombres: ");
            String nom = ekisde.next();
        System.out.println("Ingrese sus apellidos: ");
            String ap = ekisde.next();
        System.out.println("Ingrese su email: ");
            String em = ekisde.next();
        
            return new Dueño(nom,ap,em);
        
    }

   
    @Override
    
    public String toString() {
        return "Due\u00f1o{" + "id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", email=" + email + '}';
    }

    
}
