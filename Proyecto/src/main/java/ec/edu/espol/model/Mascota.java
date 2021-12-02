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
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author dell
 */
public class Mascota {

    private int id;
    private String emailDueño;
    private String nombre;
    private String raza;
    private String tipo;
    private LocalDate fechanacimiento;
    private Dueño dueño;
    private ArrayList<Inscripcion> inscripciones;

    public Mascota(int id, String emailDueño, String nombre, String raza, String tipo, LocalDate fechanacimiento) {
        this.id = id;
        this.emailDueño = emailDueño;
        this.nombre = nombre;
        this.raza = raza;
        this.tipo = tipo;
        this.fechanacimiento = fechanacimiento;

    }

    public void saveFile(String nomfile) {
        try ( PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile), true))) {
            //int id, String emailDueño, String nombre, String raza, String tipo, LocalDate fechanacimiento
            pw.println(this.id + "|" + this.emailDueño + "|" + this.nombre + "|" + this.raza + "|" + this.tipo + "|" + this.fechanacimiento);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Mascota> readfromfile(String nomfile) {
        ArrayList<Mascota> mascotas = new ArrayList<>();
        try ( Scanner sc = new Scanner(new File(nomfile))) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                Mascota masc = new Mascota(Integer.parseInt(tokens[0]), tokens[1], tokens[2], tokens[3], tokens[4], LocalDate.parse(tokens[5]));
                mascotas.add(masc);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return mascotas;
    }

    public static Mascota nextMascota(Scanner sc) {
        //int id, String emailDueño, String nombre, String raza, String tipo, LocalDate fechanacimiento
        System.out.println("Su id es:");
        int id = Mascota.readfromfile("mascotas.txt").size() + 1;
        System.out.println(id);
        System.out.println("Ingrese email del dueño:");
        String emailDueño = sc.next();
        System.out.println("Ingrese nombre de la mascota:");
        String nombre = sc.next();
        System.out.println("Ingrese raza: ");
        String raza = sc.next();
        System.out.println("Ingrese tipo: ");
        String tipo = sc.next();
        System.out.println("Ingrese la fecha de nacimiento de la mascota (yyyy-mm-dd):");
        LocalDate fechanacimiento = LocalDate.parse(sc.next());
        Mascota masc = new Mascota(id, emailDueño, nombre, raza, tipo, fechanacimiento);
        return masc;
    }

    @Override
    public String toString() {
        //int id, String emailDueño, String nombre, String raza, String tipo, LocalDate fechanacimiento
        return String.valueOf(this.id)+"-"+this.emailDueño+"-"+this.nombre+"-"+this.raza+"-"+this.tipo+"-"+String.valueOf(this.fechanacimiento); //To change body of generated methods, choose Tools | Templates.
    }
    
   

}
