/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.util;

import ec.edu.espol.model.Concurso;
import ec.edu.espol.model.Criterio;
import ec.edu.espol.model.Dueño;
import ec.edu.espol.model.Mascota;
import ec.edu.espol.model.MiembroJurado;
import ec.edu.espol.model.Premio;
import java.util.Scanner;

/**
 *
 * @author dell
 */
public class MenuOpciones {
    
    public static void menu(){
        Scanner entrada = new Scanner(System.in);
        char op = ' ';
        do{
            System.out.println("Menu de opciones:\r\n"+
                    " 1. Dueño\r\n"+" 2. Mascota\r\n"+
                    " 3. Concurso\r\n"+" 4. Premio\r\n"+
                    " 5. Criterio\r\n"+" 6. Inscripcion\r\n"+
                    " 7. Miembro Jurado\r\n"+" 8. Evaluacion\r\n"+" 9. Salir");
            System.out.println("Opcion:");
            op = entrada.next().charAt(0);
            switch(op){
                case '1':
                    System.out.println("Ingreso la opcion 1");
                    System.out.println("Ingrese los datos del Dueño: ");
                    Dueño newdueño = Dueño.nextDueño(entrada);
                    newdueño.saveFile("dueños.txt");  
                    System.out.println("Sus datos fueron registrados");
                    break;
                    
                case '2':
                    System.out.println("Ingreso la opcion 2");
                    System.out.println("Ingrese los datos de la mascota: ");
                    Mascota newmasc = Mascota.nextMascota(entrada);
                    newmasc.saveFile("mascotas.txt");  
                    System.out.println("Sus datos fueron registrados");
                    break;                
                    
                case '3':
                    System.out.println("Ingreso la opcion 3");
                    System.out.println("Ingrese los datos del Concurso: ");
                    Concurso newconcurso = Concurso.nextConcurso(entrada);
                    newconcurso.saveFile("concursos.txt");  
                    System.out.println("Sus datos fueron registrados");
                    break;
                    
                case '4':
                    System.out.println("Ingreso la opcion 4");                   
                    Scanner sc = new Scanner(System.in);
                    sc.useDelimiter("\n");
                    System.out.println("Ingrese el nombre del concurso: ");
                    String nameConcurso = sc.next();
                    int idconc = Concurso.buscaId(nameConcurso);
                    System.out.println("Ingrese cuantos premios desea poner:");
                    int lugares = sc.nextInt();
                    System.out.println("Ingrese los datos de los Premios: ");
                    Premio.numPremios(lugares, idconc);
                    System.out.println("Sus datos fueron registrados");
                    break;
                    
                case '5':
                    System.out.println("Ingreso la opcion 5");
                    Scanner scc = new Scanner(System.in);
                    scc.useDelimiter("\n");
                    System.out.println("Ingrese el nombre del concurso: ");
                    String nombConcurso = scc.next();
                    int idConc = Concurso.buscaId(nombConcurso);
                    System.out.println("Ingrese cuantos criterios desea poner:");
                    int numCrit = scc.nextInt();
                    System.out.println("Ingrese los datos de los Criterios: ");
                    Criterio.numCriterios(numCrit, idConc);
                    System.out.println("Sus datos fueron registrados");
                    break;
                    
                case '6':
                    System.out.println("Ingreso la opcion 6");
                    break;
                    
                case '7':
                    System.out.println("Ingreso la opcion 7");
                    System.out.println("Ingrese los datos del Miembro del Jurado: ");
                    MiembroJurado newjurado = MiembroJurado.nextMiembroJurado(entrada);
                    newjurado.saveFile("miembroJurados.txt");  
                    System.out.println("Sus datos fueron registrados");
                    break;
                    
                case '8':
                    System.out.println("Ingreso la opcion 8");
                    break;
                    
                case '9':
                    System.out.println("Gracias por su tiempo");
                    break;
                    
                default:
                    System.out.println("Opcion no valida...");
                    break;
                    
            }
        }while(op != '9');
       
   }
    
}
