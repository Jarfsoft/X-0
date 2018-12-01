/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x0;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author Jarfsoft
 */
public class X0 {
    public static void main(String[] args) throws IOException {
        ArrayList<String> nombres=new ArrayList();
        ArrayList<Integer> puntajes=new ArrayList();
        Scanner leer= new Scanner(System.in);
        File file=new File("C:\\Users\\andre\\Documents\\NetBeansProjects\\x0\\Reportes\\Repo.doc");
        File file2=new File("C:\\Users\\andre\\Documents\\NetBeansProjects\\x0\\Reportes\\Repo2.doc");
        
        FileReader fr=new FileReader(file);
        FileReader fr2=new FileReader(file2);
        int op=0;
        while(op!=3){
            System.out.print("X-0\n\n--------------\n\n1. Jugar\n2. Reportes\n3. Salir\n\nSeleccion: ");
            op=leer.nextInt();
            if(op==1){
                System.out.print("\n\nJugador 1: ");
                String nombre=leer.next();
                if(nombres.isEmpty()){
                    nombres.add(nombre);
                    puntajes.add(0);
                }
                else{
                    int x;
                    for(x=0;x<nombres.size();x++){
                        if(nombre.equals(nombres.get(x))){
                            break;
                        }
                    }
                    if(x==nombres.size()){
                        nombres.add(nombre);
                        puntajes.add(0);
                    }
                }
                String nombre1;
                while(true){
                    System.out.print("\nJugador 2: ");
                    nombre1=leer.next();
                    if(nombre.equals(nombre1))
                        System.out.println("\n\nNombre en uso. Elegir otro.");
                    else{
                        int x;
                        for(x=0;x<nombres.size();x++){
                            if(nombre1.equals(nombres.get(x))){
                                break;
                            }
                        }
                        if(x==nombres.size()){
                            nombres.add(nombre1);
                            puntajes.add(0);
                        }
                        break;
                    }
                }
                System.out.print("Elegir caracter (Jugador 1): ");
                char j1=leer.next().charAt(0);
                char j2;
                while(true){
                    System.out.print("Elegir caracter (Jugador 2): ");
                    j2=leer.next().charAt(0);
                    if(j1==j2){
                        System.out.println("Caracter en uso. Elegir otro.");
                    }else
                        break;
                }
                
                JuegoX0 go=new JuegoX0(j1,j2);
                while(true){
                    System.out.println("\n\n");
                    go.imprimirTablero();
                    System.out.print("\nTurno de: "+nombre+"\nFila: ");
                    int f=leer.nextInt();
                    System.out.print("Columna: ");
                    int c=leer.nextInt();
                    go.marcarJugada(j1, f-1, c-1);
                    if(go.gane(j1)){
                        FileWriter fw3=new FileWriter(file2,true);
                        System.out.println(nombre+" gano a "+nombre1);
                        fw3.write(nombre+" gano a "+nombre1+"\n");
                        fw3.close();
                        puntajes.set(nombres.indexOf(nombre), (puntajes.get(nombres.indexOf(nombre))+1));
                        
                        break;
                    }
                    System.out.println("\n\n");
                    go.imprimirTablero();
                    System.out.print("\nTurno de: "+nombre1+"\nFila: ");
                    f=leer.nextInt();
                    System.out.print("Columna: ");
                    c=leer.nextInt();
                    go.marcarJugada(j2, f-1, c-1);
                    if(go.gane(j2)){
                        FileWriter fw3=new FileWriter(file2,true);
                        fw3.write(nombre1+" gano a "+nombre+"\n");
                        System.out.println(nombre1+" gano a "+nombre);
                        puntajes.set(nombres.indexOf(nombre1), (puntajes.get(nombres.indexOf(nombre1))+1));
                        fw3.close();
                        break;
                    }
                }
                FileWriter fw=new FileWriter(file,false);
                FileWriter fw1=new FileWriter(file,true);
                fw.write("");
                fw.close();
                for(int x=0;x<puntajes.size();x++){
                    fw1.write(puntajes.get(x)+"\n");
                }
                System.out.println("\n\n");
            }else if(op==2){
                System.out.println("\n\nPuntajes:");
                
                for(int x=0;x<puntajes.size();x++){
                    System.out.println("\n"+nombres.get(x)+": "+puntajes.get(x));
                }
                System.out.println("\n\nResultados anteriores:");
                int data;
                while((data=fr2.read())!=-1){
                    System.out.print((char)data);
                }
                fr2.close();
            }
        }
    }
    
}
