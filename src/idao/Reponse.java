/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package idao;

/**
 *
 * @author ABDELLAH DIDI
 */
import static idao.iutilisateur.cnx;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reponse implements idao<Reponse> {
    private int id;
    private int id_audit;
    private int id_question;
    private String visuel;
    private String combo;
    private String description; // = visuel + "_" + combo

    // Constructeur
    public Reponse(int id, int id_audit, int id_question, String visuel, String combo) {
        this.id = id;
        this.id_audit = id_audit;
        this.id_question = id_question;
        this.visuel = visuel;
        this.combo = combo;
        this.description = visuel + "_" + combo;
    }
    public Reponse() {
        
    }

    // Getter and setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_audit() {
        return id_audit;
    }

    public void setId_audit(int id_audit) {
        this.id_audit = id_audit;
    }

    public int getId_question() {
        return id_question;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }

    public String getVisuel() {
        return visuel;
    }

    public void setVisuel(String visuel) {
        this.visuel = visuel;
    }

    public String getCombo() {
        return combo;
    }

    public void setCombo(String combo) {
        this.combo = combo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Méthode pour ajouter une réponse dans la base de données
    @Override
    public void add(Reponse reponse) {
        try {
            String query = "INSERT INTO reponses (id_audit, id_question, description) VALUES (?, ?, ?)";
            PreparedStatement st = cnx.prepareStatement(query);

            st.setInt(1, reponse.getId_audit());
            st.setInt(2, reponse.getId_question());
            st.setString(3, reponse.getDescription());

            st.execute();
            System.out.println("Ajout de la réponse OK \n");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Erreur lors de l'ajout de la réponse \n");
        }
    }

    // Méthode pour mettre à jour une réponse dans la base de données
    @Override
    public void update(Reponse reponse) {
        try {
            String query = "UPDATE reponses SET id_audit = ?, id_question = ?, description = ? WHERE id = ?";
            PreparedStatement st = cnx.prepareStatement(query);

            st.setInt(1, reponse.getId_audit());
            st.setInt(2, reponse.getId_question());
            st.setString(3, reponse.getDescription());
            st.setInt(4, reponse.getId());

            st.executeUpdate();
            System.out.println("Mise à jour de la réponse OK \n");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Erreur lors de la mise à jour de la réponse \n");
        }
    }

    // Méthode pour supprimer une réponse de la base de données
    @Override
    public void delete(Reponse reponse) {
        try {
            String query = "DELETE FROM reponses WHERE id = ?";
            PreparedStatement st = cnx.prepareStatement(query);

            st.setInt(1, reponse.getId());

            st.execute();
            System.out.println("Suppression de la réponse OK \n");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Erreur lors de la suppression de la réponse \n");
        }
    }

    // ... (autres membres de la classe)
    
    // Assurez-vous d'avoir une connexion active à la base de données

    @Override
    public boolean signup(Reponse a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void show(Reponse a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
        public List<Reponse> lister() {
        List<Reponse> reponses = new ArrayList<>();
        try {
            String query = "SELECT * FROM reponses";
            PreparedStatement st = cnx.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int id_audit = rs.getInt("id_audit");
                int id_question = rs.getInt("id_question");
                String description = rs.getString("description");
                // Vous pouvez récupérer les autres attributs si nécessaire

                Reponse reponse = new Reponse(id, id_audit, id_question, "", "");
                reponse.setDescription(description);
                // Assignez d'autres attributs si nécessaires

                reponses.add(reponse);
            }
            System.out.println("Liste des réponses OK \n");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Erreur lors de la liste des réponses \n");
        }
        return reponses;
    }

  public int get_id() { // donne id de la derniere reponse ajouter
            int d=-1;
         try {
        String query = "SELECT max(id) FROM reponses";
            PreparedStatement st = cnx.prepareStatement(query);
            ResultSet rs = st.executeQuery();
     boolean v= rs.next();
            if (v) {
    d=    rs.getInt(1);
            }
            System.out.println("get_id_reponses ok \n");
   
        } catch (SQLException ex) {
            Logger.getLogger(iutilisateur.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("get_id_reponses   ko   d = "+d+"\n");
        }
                       return d; 
    }
  
  
       public List<Reponse> lister_where() {//lister les reponses d'un audit 
        List<Reponse> reponses = new ArrayList<>();
        try {
            String query = "SELECT * FROM reponses where id_audit = '"+id_audit+"'";
            PreparedStatement st = cnx.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int id_audit = rs.getInt("id_audit");
                int id_question = rs.getInt("id_question");
                String description = rs.getString("description");
                // Vous pouvez récupérer les autres attributs si nécessaire

                Reponse reponse = new Reponse(id, id_audit, id_question, "", "");
                reponse.setDescription(description);
                reponse.split();
                // Assignez d'autres attributs si nécessaires

                reponses.add(reponse);
            }
            System.out.println("Liste des réponses OK \n");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Erreur lors de la liste des réponses \n");
        }
        return reponses;
    }

       void split(){
          String [] a =  description.split("_");
          visuel=a[0];
          combo=a[1];
       }

       
           public Reponse donnerReponse() {//donner  une  reponses d'une question  
      Reponse reponse = null;
        try {
            String query = "SELECT * FROM reponses where id_question = '"+id_question+"'";
            PreparedStatement st = cnx.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int id_audit = rs.getInt("id_audit");
                int id_question = rs.getInt("id_question");
                String description = rs.getString("description");
                // Vous pouvez récupérer les autres attributs si nécessaire

                 reponse = new Reponse(id, id_audit, id_question, "", "");
                reponse.setDescription(description);
                reponse.split();
                // Assignez d'autres attributs si nécessaires

              
            }
            System.out.println("donner  la réponse OK \n");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Erreur lors de la demende  de la  réponse \n");
        }
        return reponse;
    }
           
        
           
}
