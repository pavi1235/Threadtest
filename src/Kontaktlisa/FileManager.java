/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Kontaktlisa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author pavpa01
 */
public class FileManager {

    public void saveToFile(ArrayList<Kontakt> list) {
try{
        FileOutputStream fileOut = new FileOutputStream("savedKontaktLista.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
       // Object objektet = null;
        //Object KontaktlistaJFrame = null;
        out.writeObject(list);
        out.flush();
        out.close();
        fileOut.close();
      } catch (IOException ex) {
            System.out.println("IOException is caught");
        }
    
        
    }

    public ArrayList<Kontakt> readFromFile() { 
        ArrayList<Kontakt> list = null;
       try{
       
        FileInputStream fileIn = new FileInputStream("savedKontaktLista.ser");
         } catch (IOException ex) {
            System.out.println("IOException is caught");
        }

        
        return list;

    }
}
