/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package idao;

import static idao.iutilisateur.cnx;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ABDELLAH DIDI
 */
public class Site implements idao<Site>{
    
  
    
  
    public Site() {
    }
    public Site(String a) {
          String[] substrings = a.split("_");
          pays=substrings[0];
          ville=substrings[1];
          nom=substrings[2];     
    }
        public Site(String a,String b,String c) {
       
          pays=a;
          ville=b;
          nom=c;     
    }
    @Override
    public String toString() {
        return pays + "_" + ville + "_" + nom ;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    String pays ="";
    String ville ="";
    String nom ="";

  
    @Override
    public void add(Site a) {
    
      try {
        String query ="insert into sites  "
                + "values ('" +a.getPays()+"_"+a.getVille()+"_"+a.getNom()+"')";
        PreparedStatement st = cnx.prepareStatement(query);
   
        st.execute();
        System.out.println("add ok \n");
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage(),
                "Information", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("add  not ok \n");
    }
    }

    @Override
    public void delete(Site a) {
             try {
        String query ="delete from sites where   "
                + "code = '" +a.getPays()+"_"+a.getVille()+"_"+a.getNom()+"'";
        PreparedStatement st = cnx.prepareStatement(query);
   
        st.execute();
        System.out.println("suppression  ok \n");
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage()+" \n " +"delete from sites where   "
                + "code = '" +a.getPays()+"_"+a.getVille()+"_"+a.getNom()+"'" ,
                "Information", JOptionPane.INFORMATION_MESSAGE);
              System.out.println("suppression  ko \n");
    }
    }

    @Override
    public void update(Site a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean signup(Site a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void show(Site a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Site> lister() {
        
       List<Site> l = new ArrayList<>();
        try {
            String query = "SELECT * FROM sites";
            PreparedStatement st = cnx.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Site a = new Site();
           String[] substrings = rs.getString("code").split("_");
               a.setPays(substrings[0]);
               a.setVille(substrings[1]);
               a.setNom(substrings[2]);
                l.add(a);
            }
            System.out.println("lister ok\n");
        } catch (SQLException ex) {
            Logger.getLogger(iutilisateur.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("lister ko\n");
        }
        return l;
    
    }
     public List<Site> lister_where() {
        
       List<Site> l = new ArrayList<>();
        try {
            String query = "SELECT * FROM sites where code = '"+pays+"_"+ville+"_"+nom+"'";
            PreparedStatement st = cnx.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Site a = new Site();
           String[] substrings = rs.getString("code").split("_");
               a.setPays(substrings[0]);
               a.setVille(substrings[1]);
               a.setNom(substrings[2]);
                l.add(a);
            }
            System.out.println("lister ok\n");
        } catch (SQLException ex) {
            Logger.getLogger(iutilisateur.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("lister ko\n");
        }
        return l;
    
    }
     
    
     public List<Site> lister_ord() {
        
       List<Site> l = new ArrayList<>();
        try {
            String query = "SELECT  *  FROM sites ORDER BY code ; ";
            PreparedStatement st = cnx.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Site a = new Site();
           String[] substrings = rs.getString("code").split("_");
               a.setPays(substrings[0]);
               a.setVille(substrings[1]);
               a.setNom(substrings[2]);
                l.add(a);
            }
            System.out.println("lister ok\n");
        } catch (SQLException ex) {
            Logger.getLogger(iutilisateur.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("lister ko\n");
        }
        return l;
    
    }
    
       public List<Site> lister_like() {
        
       List<Site> l = new ArrayList<>();
        try {
            String query = "";
                        PreparedStatement st ; 
            if(pays != "" ){
                query = "SELECT  *  FROM sites where code LIKE '?_%' ORDER BY code ";
                 st = cnx.prepareStatement(query);
                        st.setString(1, pays);
            }
            
            else  if(ville  != "" ){
                query = "SELECT  *  FROM sites where code LIKE '?_?_%' ORDER BY code ";
                                 st = cnx.prepareStatement(query);
                        st.setString(1, pays);
                                st.setString(2, ville);
            }
            
            else {
                            query = "SELECT  *  FROM sites where code = '?_?_?'  ORDER BY code ";
                                             st = cnx.prepareStatement(query);
                                     st.setString(1, pays);
                                st.setString(2, ville);
                                         st.setString(3, nom);
            }
            

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Site a = new Site();
           String[] substrings = rs.getString("code").split("_");
               a.setPays(substrings[0]);
               a.setVille(substrings[1]);
               a.setNom(substrings[2]);
                l.add(a);
            }
            System.out.println("lister ok\n");
        } catch (SQLException ex) {
            Logger.getLogger(iutilisateur.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("lister ko\n");
        }
        return l;
    
    }
       
     
    
    public ResultSet ToResultSet() {
    Statement st;
    ResultSet rs = null;

    try {
        st = cnx.createStatement();
        String query = "SELECT * FROM sites ";
        rs = st.executeQuery(query);
        System.out.println("ResultSet obtenu avec succès.\n");
    } catch (SQLException ex) {
        System.out.println("Problème avec la requête : " + ex.getMessage());
    }

    return rs;
}
  
   

    
}


