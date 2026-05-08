/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Kontaktlisa;

/**
 *
 * @author pavpa01
 */
public class Kontakt {
 
    private String Förnamn;
private String Efternamn; 
private String Telefonnummer;
    public String getFörnamn;

public Kontakt (String F, String E, String T){ 
           this. Förnamn = F; 
            this.Efternamn= E;
            this.Telefonnummer=T; 

} 
public Kontakt (String F,String T) {
           this. Förnamn = F; 
           this.Telefonnummer=T;
           this.Efternamn="";
}

public void setTelefonnummer(String T){
    this.Telefonnummer=T;

}

  public String getFörnamn(){
      return this.Förnamn;
  }  
public String getEfternamn(){
    return this.Efternamn;
}
public String getTelefonnummer(){
    return this.Telefonnummer;
    
}
}



