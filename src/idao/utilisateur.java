/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package idao;

import java.util.*;
import java.util.logging.Logger;

/**
 *
 * @author ABDELLAH DIDI
 */
public class utilisateur {

       //  BufferedImage  avatar ="";
    
 String role ="";
 String  nom ="";
 String prenom ="";
 String email =""; 
 String  mot_de_passe ="";

 String matricule ="";
 String departement ="";
 Site site=null;
 boolean desactive = false;

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }
 
 
 
    public utilisateur( String role , String  nom , String prenom ,String email , String  mot_de_passe 
     ,String matricule ,String departement ,Site site ,boolean desactive )
    {
        
this.role = role;
this.nom = nom;
this.prenom = prenom;
this.email = email;
this.mot_de_passe = mot_de_passe;
this.matricule = matricule;
this.departement = departement;
this.desactive = desactive;
        this.site = site;
    }
    
       public utilisateur( String matricule )
    {
this.matricule = matricule;
    }
       public utilisateur( )
    {

    }
       
    
    public utilisateur(String email , String  mot_de_passe)
    {
    this.email = email;
    this.mot_de_passe = mot_de_passe;
    }
    
  
   public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public boolean getDesactive() {
        return desactive;
    }

    public void setDesactive(boolean desactive) {
        this.desactive = desactive;
    }
    
  boolean isEmail(String a){
      if(a.endsWith("@coficab.com")) return true;
      return false;
  }
 
}
