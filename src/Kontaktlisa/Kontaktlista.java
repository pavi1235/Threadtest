/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Kontaktlisa;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author pavpa01
 */
public class Kontaktlista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
       ArrayList<Kontakt>kontaktLista=new ArrayList<>();
          boolean körPogram = true;
        while (körPogram) {

        int val;
            do {
                System.out.println("\n Meny");
                System.out.println("1 Ny kontakt");
                System.out.println("2 Skriv ut förnamn ");
                System.out.println("3 Skriv ut efternamn ");
                System.out.println("0 avsluta ");

                val = input.nextInt();
                input.nextLine();
            switch (val) {
                case 1 -> {
                    System.out.print("ange Förnamn:");
                    String Förnamn = input.nextLine();
                    System.out.println("ange Efternamn:");
                    String Efternamn = input.nextLine();
                    System.out.println("ange Telefonnummer:");
                    String Telefonnummer = input.nextLine();
                    Kontakt kon = new Kontakt(Förnamn, Efternamn, Telefonnummer);
                    kontaktLista.add( kon);
                    
                }
                case 2 -> {
                    for(int i=0;i<kontaktLista.size();i++){
                        System.out.println(kontaktLista.get(i).getFörnamn() + "," + kontaktLista.get(i).getEfternamn() + "," + kontaktLista.get(i).getTelefonnummer());}
                }
                case 3 -> {
                    for(int i=0;i<kontaktLista.size();i++){
                        System.out.println(kontaktLista.get(i).getEfternamn() + "," + kontaktLista.get(i).getFörnamn() + "," + kontaktLista.get(i).getTelefonnummer());}
                }
                case 4 -> körPogram = false;
                default -> körPogram = false;
            }
            }while(  val !=0);
  
        }
    }
}
