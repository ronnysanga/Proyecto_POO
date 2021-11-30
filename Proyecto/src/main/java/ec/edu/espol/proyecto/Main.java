/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.proyecto;

import ec.edu.espol.model.Dueño;
import java.util.Scanner;

/**
 *
 * @author dell
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner sc = new Scanner(System.in);
        Dueño yop = Dueño.nextDueño(sc);
        System.out.println(yop);

    }
    
}
