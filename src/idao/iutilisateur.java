/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idao;
import idao.Site;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ABDELLAH DIDI
 */
public class iutilisateur implements idao<utilisateur> {
static Connection cnx = mysqlconnection.getConnexion();
   String query;
   utilisateur user=null;

    public utilisateur getUser() {
        return user;
    }

    public void setUser(utilisateur user) {
        this.user = user;
    }
    @Override
    public void add(utilisateur a) {
    try {
         query ="insert into utilisateurs (`role`, `nom`, `prenom`, `email`, `mot_de_passe`, `matricule`, `departement`, `site`, `desactive`) "
                + "values (?,?,?,?,?,?,?,?,?)";
        PreparedStatement st = cnx.prepareStatement(query);
        st.setString(1, a.getRole());
        st.setString(2, a.getNom());
        st.setString(3, a.getPrenom());
        st.setString(4, a.getEmail());
        st.setString(5, a.getMot_de_passe());
        st.setString(6, a.getMatricule());
        st.setString(7, a.getDepartement());
        st.setString(8, a.getSite()+"");
        st.setBoolean(9, a.getDesactive());
        st.execute();
        query=st.toString();
        System.out.println("add ok \n"+query);
    } catch (SQLException ex) {
       JOptionPane.showMessageDialog(null, ex.getMessage()+"\n"+query,
                "Information", JOptionPane.INFORMATION_MESSAGE);
    }
    }

 @Override
    public void delete(utilisateur a) {
        try {
             query = "DELETE FROM utilisateurs WHERE matricule = ?";
            PreparedStatement st = cnx.prepareStatement(query);
            st.setString(1, a.getMatricule());
            st.executeUpdate();
            System.out.println("delete ok\n");
        } catch (SQLException ex) {
            Logger.getLogger(iutilisateur.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("delete ko\n");
        }
    }


@Override
public void update(utilisateur a) {
    try {
         query = "UPDATE utilisateurs SET role = ?, nom = ?, prenom = ?, email = ?, mot_de_passe = ? , departement = ?"
                + ", site = ?, desactive = ? WHERE matricule = ?  ";
        PreparedStatement st = cnx.prepareStatement(query);
        st.setString(1, a.getRole());
        st.setString(2, a.getNom());
        st.setString(3, a.getPrenom());
        st.setString(4, a.getEmail());
        st.setString(5, a.getMot_de_passe());
        st.setString(6, a.getDepartement());
        st.setString(7, a.getSite()+"");
        st.setBoolean(8, a.getDesactive());
        st.setString(9, a.getMatricule());
        st.executeUpdate();
                query=st.toString();
        System.out.println("update ok\n"+st.toString());
    } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, ex.getMessage()+"\n"+query,
                "Information", JOptionPane.INFORMATION_MESSAGE);
    }
}

    @Override
    public boolean signup(utilisateur a) {
        try {
             query = "SELECT * FROM utilisateurs WHERE email = ? AND mot_de_passe = ?";
            PreparedStatement st = cnx.prepareStatement(query);
            st.setString(1, a.getEmail());
            st.setString(2, a.getMot_de_passe());
            ResultSet rs = st.executeQuery();
            if (rs.first()) {
                user = new utilisateur(rs.getString("role"), rs.getString("nom"), rs.getString("prenom")
                        , rs.getString("email"),  rs.getString("mot_de_passe"), rs.getString("matricule"),
                        rs.getString("departement"),  new Site(rs.getString("Site")) , rs.getBoolean("desactive"));
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(iutilisateur.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("AUTH ko\n");
            return false;
        }
    }


@Override
public void show(utilisateur a) {
    try {
         query = "SELECT * FROM utilisateurs";
        PreparedStatement st = cnx.prepareStatement(query);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            System.out.println("Role: " + rs.getString("role"));
            System.out.println("Nom: " + rs.getString("nom"));
            System.out.println("Prenom: " + rs.getString("prenom"));
            System.out.println("Email: " + rs.getString("email"));
            System.out.println("Mot de passe: " + rs.getString("mot_de_passe"));
            System.out.println("Matricule: " + rs.getString("matricule"));
            System.out.println("Departement: " + rs.getString("departement"));
            System.out.println("Site: " + rs.getString("Site"));
            System.out.println("Desactive: " + rs.getString("desactive"));
            System.out.println("-------------------------------------");
        }
    } catch (SQLException ex) {
        Logger.getLogger(iutilisateur.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("show ko\n");
    }
}


    @Override
    public List<utilisateur> lister() {
        List<utilisateur> l = new ArrayList<>();
        try {
             query = "SELECT * FROM utilisateurs";
            PreparedStatement st = cnx.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                utilisateur a = new utilisateur(
                    rs.getString("role"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("email"),
                    rs.getString("mot_de_passe"),
                    rs.getString("matricule"),
                    rs.getString("departement"),
                        new Site(  rs.getString("Site") )  ,
                    rs.getBoolean("desactive")
                );
                l.add(a);
            }
            System.out.println("ok\n");
        } catch (SQLException ex) {
            Logger.getLogger(iutilisateur.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ko\n");
        }
        return l;
    }
    
    
    
public ResultSet ToResultSet() {
    Statement st;
    ResultSet rs = null;

    try {
        st = cnx.createStatement();
         query = "SELECT * FROM utilisateurs";
        rs = st.executeQuery(query);
        System.out.println("ResultSet obtenu avec succès.\n");
    } catch (SQLException ex) {
        System.out.println("Problème avec la requête : " + ex.getMessage());
    }

    return rs;
}
////////////////////////////////////////////////////////////////////////////

 public String  set_nom_prenom(utilisateur a){
        String d="";
         try {
            String query = "SELECT nom,prenom FROM utilisateurs  where matricule =?";
            PreparedStatement st = cnx.prepareStatement(query);
                st.setString(1, a.getMatricule());
            ResultSet rs = st.executeQuery();
          rs.next();
              
                   System.out.println("set_description utilisateur  ok\n");
                   return rs.getString("nom")+" "+rs.getString("prenom");
        } catch (SQLException ex) {
            Logger.getLogger(iutilisateur.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("set_description utilisateur  ko\n"); 
        }
         return d;
}
 
 
     public List<String> lister_departement() {
        List<String> l = new ArrayList<>();
        try {
             query = "SELECT DISTINCT   departement  FROM utilisateurs ";
            PreparedStatement st = cnx.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
         String a = rs.getString("departement");
                l.add(a);
            }
            System.out.println("ok\n");
        } catch (SQLException ex) {
            Logger.getLogger(iutilisateur.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ko\n");
        }
        return l;
    }

    
   
}
