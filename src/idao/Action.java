/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ABDELLAH DIDI
*/


package idao;

import static idao.iutilisateur.cnx;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Action implements idao<Action> {
    private int id;
    private int id_reponse;
    private String Probleme_Resultat;
    private String CausesCreation;
    private String ActionsCorrectives;
    private String Status;
    private String Resp_date;
    private String Responsable;

    // Constructors
    public Action(int id_reponse, String Probleme_Resultat, String CausesCreation, String ActionsCorrectives,
                  String Status, String Resp_date, String Responsable) {
        this.id_reponse = id_reponse;
        this.Probleme_Resultat = Probleme_Resultat;
        this.CausesCreation = CausesCreation;
        this.ActionsCorrectives = ActionsCorrectives;
        this.Status = Status;
        this.Resp_date = Resp_date;
        this.Responsable = Responsable;
    }

    public Action(int id) {
        this.id = id;
    }

    public Action() {
    }

    // Getter and setter methods for 'Responsable'
    public String getResponsable() {
        return Responsable;
    }

    public void setResponsable(String Responsable) {
        this.Responsable = Responsable;
    }

      public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_reponse() {
        return id_reponse;
    }

    public void setId_reponse(int id_reponse) {
        this.id_reponse = id_reponse;
    }

    public String getProbleme_Resultat() {
        return Probleme_Resultat;
    }

    public void setProbleme_Resultat(String Probleme_Resultat) {
        this.Probleme_Resultat = Probleme_Resultat;
    }

    public String getCausesCreation() {
        return CausesCreation;
    }

    public void setCausesCreation(String CausesCreation) {
        this.CausesCreation = CausesCreation;
    }

    public String getActionsCorrectives() {
        return ActionsCorrectives;
    }

    public void setActionsCorrectives(String ActionsCorrectives) {
        this.ActionsCorrectives = ActionsCorrectives;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getResp_date() {
        return Resp_date;
    }

    public void setResp_date(String Resp_date) {
        this.Resp_date = Resp_date;
    }
    
    @Override
    public void add(Action action) {
        try {
            String query = "INSERT INTO Actions (id_reponse, Probleme_Resultat, Causes_Creation, Actions_Correctives, Status, Resp, Responsable) " +
                           "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement st = cnx.prepareStatement(query);

            st.setInt(1, action.getId_reponse());
            st.setString(2, action.getProbleme_Resultat());
            st.setString(3, action.getCausesCreation());
            st.setString(4, action.getActionsCorrectives());
            st.setString(5, action.getStatus());
            st.setString(6, action.getResp_date());
            st.setString(7, action.getResponsable());

            st.execute();
            System.out.println("Ajout de l'action OK \n");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Erreur lors de l'ajout de l'action \n");
        }
    }

    @Override
    public void update(Action action) {
        try {
            String query = "UPDATE Actions SET id_reponse = ?, Probleme_Resultat = ?, Causes_Creation = ?, Actions_Correctives = ?, " +
                           "Status = ?, Resp = ?, Responsable = ? WHERE id = ?";
            PreparedStatement st = cnx.prepareStatement(query);

            st.setInt(1, action.getId_reponse());
            st.setString(2, action.getProbleme_Resultat());
            st.setString(3, action.getCausesCreation());
            st.setString(4, action.getActionsCorrectives());
            st.setString(5, action.getStatus());
            st.setString(6, action.getResp_date());
            st.setString(7, action.getResponsable());
            st.setInt(8, action.getId());

            st.executeUpdate();
            System.out.println("Mise à jour de l'action OK \n");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Erreur lors de la mise à jour de l'action \n");
        }
    }

    @Override
    public void delete(Action action) {
        try {
            String query = "DELETE FROM Actions WHERE id = ?";
            PreparedStatement st = cnx.prepareStatement(query);

            st.setInt(1, action.getId());

            st.execute();
            System.out.println("Suppression de l'action OK \n");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Erreur lors de la suppression de l'action \n");
        }
    }

    @Override
    public List<Action> lister() {
        List<Action> actions = new ArrayList<>();
        try {
            String query = "SELECT * FROM Actions";
            PreparedStatement st = cnx.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int id_reponse = rs.getInt("id_reponse");
                String Probleme_Resultat = rs.getString("Probleme_Resultat");
                String CausesCreation = rs.getString("Causes_Creation");
                String ActionsCorrectives = rs.getString("Actions_Correctives");
                String Status = rs.getString("Status");
                String Resp_date = rs.getString("Resp");
                String Responsable = rs.getString("Responsable");

                Action action = new Action(id_reponse, Probleme_Resultat, CausesCreation, ActionsCorrectives, Status, Resp_date, Responsable);
                action.setId(id);

                actions.add(action);
            }
            System.out.println("Liste des actions OK \n");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Erreur lors de la liste des actions \n");
        }
        return actions;
    }

    @Override
    public boolean signup(Action a) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void show(Action a) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Action lister_where() {
        Action action = null;
        try {
            String query = "SELECT * FROM Actions where id_reponse = ?";
            PreparedStatement st = cnx.prepareStatement(query);
            st.setInt(1, id_reponse);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int id_reponse = rs.getInt("id_reponse");
                String Probleme_Resultat = rs.getString("Probleme_Resultat");
                String CausesCreation = rs.getString("Causes_Creation");
                String ActionsCorrectives = rs.getString("Actions_Correctives");
                String Status = rs.getString("Status");
                String Resp_date = rs.getString("Resp");
                String Responsable = rs.getString("Responsable");

                action = new Action(id_reponse, Probleme_Resultat, CausesCreation, ActionsCorrectives, Status, Resp_date, Responsable);
                action.setId(id);
            }
            System.out.println("Donner action OK \n");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Erreur lors de la demande d'une action \n");
        }
        return action;
    }
    
    public boolean isin() {
        boolean d = false;
        try {
            String query = "SELECT * FROM actions where id = ? ";
            PreparedStatement st = cnx.prepareStatement(query);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            d = rs.next();
            System.out.println("Isin action OK \n");
        } catch (SQLException ex) {
            Logger.getLogger(iutilisateur.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Isin action KO\n");
        }
        return d;
    }

    public void updateAction(Action action) {
        if (action.isin())
            action.update(action);
        else
            action.add(action);
    }
    
    
    public ResultSet ToResultSet() {
        Statement st;
        ResultSet rs = null;

        try {
            st = cnx.createStatement();
            String query = "SELECT a.id, r.id_audit, a.Probleme_Resultat, a.Causes_Creation, a.Actions_Correctives,"
                    + " a.Responsable, a.Status, a.Resp FROM actions AS a JOIN reponses AS r ON a.id_reponse = r.id; ";
            rs = st.executeQuery(query);
            System.out.println("ResultSet obtained successfully.\n");
        } catch (SQLException ex) {
            System.out.println("Problem with the query: " + ex.getMessage());
        }

        return rs;
    }
    
}



//import java.sql.*;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class Action implements idao<Action> {
//    private int id;
//    private int id_reponse;
//    private String Probleme_Resultat;
//    private String CausesCreation;
//    private String ActionsCorrectives;
//    private String Status;
//    private String Resp_date; // Utilisé comme String pour la date
//
//    // Constructeur
//    public Action(int id_reponse, String Probleme_Resultat, String CausesCreation, String ActionsCorrectives,
//                  String Status, String Resp_date) {
//        this.id_reponse = id_reponse;
//        this.Probleme_Resultat = Probleme_Resultat;
//        this.CausesCreation = CausesCreation;
//        this.ActionsCorrectives = ActionsCorrectives;
//        this.Status = Status;
//        this.Resp_date = Resp_date;
//    }
//    public Action(int id) {
//        this.id = id;
//    }
//    public Action(){
//          
//    }
//
//    // Getter and setter methods

//
//    // Méthode pour ajouter une action dans la base de données
//    @Override
//    public void add(Action action) {
//        try {
//            String query = "INSERT INTO Actions (id_reponse, Probleme_Resultat, Causes_Creation, Actions_Correctives, Status, Resp) " +
//                           "VALUES (?, ?, ?, ?, ?, ?)";
//            PreparedStatement st = cnx.prepareStatement(query);
//
//            st.setInt(1, action.getId_reponse());
//            st.setString(2, action.getProbleme_Resultat());
//            st.setString(3, action.getCausesCreation());
//            st.setString(4, action.getActionsCorrectives());
//            st.setString(5, action.getStatus());
//            st.setString(6, action.getResp_date()); // Utilisé comme String pour la date
//
//            st.execute();
//            System.out.println("Ajout de l'action OK \n");
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            System.out.println("Erreur lors de l'ajout de l'action \n");
//        }
//    }
//
//    // Méthode pour mettre à jour une action dans la base de données
//    @Override
//    public void update(Action action) {
//        try {
//            String query = "UPDATE Actions SET id_reponse = ?, Probleme_Resultat = ?, Causes_Creation = ?, Actions_Correctives = ?, " +
//                           "Status = ?, Resp = ? WHERE id = ?";
//            PreparedStatement st = cnx.prepareStatement(query);
//
//            st.setInt(1, action.getId_reponse());
//            st.setString(2, action.getProbleme_Resultat());
//            st.setString(3, action.getCausesCreation());
//            st.setString(4, action.getActionsCorrectives());
//            st.setString(5, action.getStatus());
//            st.setString(6, action.getResp_date()); // Utilisé comme String pour la date
//            st.setInt(7, action.getId());
//
//            st.executeUpdate();
//            System.out.println("Mise à jour de l'action OK \n");
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            System.out.println("Erreur lors de la mise à jour de l'action \n");
//        }
//    }
//
//    // Méthode pour supprimer une action de la base de données
//    @Override
//    public void delete(Action action) {
//        try {
//            String query = "DELETE FROM Actions WHERE id = ?";
//            PreparedStatement st = cnx.prepareStatement(query);
//
//            st.setInt(1, action.getId());
//
//            st.execute();
//            System.out.println("Suppression de l'action OK \n");
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            System.out.println("Erreur lors de la suppression de l'action \n");
//        }
//    }
//
//    // Méthode pour lister toutes les actions de la base de données
//    @Override
//    public List<Action> lister() {
//        List<Action> actions = new ArrayList<>();
//        try {
//            String query = "SELECT * FROM Actions";
//            PreparedStatement st = cnx.prepareStatement(query);
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                int id_reponse = rs.getInt("id_reponse");
//                String Probleme_Resultat = rs.getString("Probleme_Resultat");
//                String CausesCreation = rs.getString("Causes_Creation");
//                String ActionsCorrectives = rs.getString("Actions_Correctives");
//                String Status = rs.getString("Status");
//                String Resp_date = rs.getString("Resp"); // Utilisé comme String pour la date
//
//                Action action = new Action(id_reponse, Probleme_Resultat, CausesCreation, ActionsCorrectives, Status, Resp_date);
//                action.setId(id);
//
//                actions.add(action);
//            }
//            System.out.println("Liste des actions OK \n");
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            System.out.println("Erreur lors de la liste des actions \n");
//        }
//        return actions;
//    }
//
//    @Override
//    public boolean signup(Action a) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public void show(Action a) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    public Action  lister_where() {// donner l' actions associée a une reponse 
//      //  List<Action> actions = new ArrayList<>();
//      Action action=null;
//        try {
//            String query = "SELECT * FROM Actions where id_reponse ='"+id_reponse+"'";
//            PreparedStatement st = cnx.prepareStatement(query);
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                int id_reponse = rs.getInt("id_reponse");
//                String Probleme_Resultat = rs.getString("Probleme_Resultat");
//                String CausesCreation = rs.getString("Causes_Creation");
//                String ActionsCorrectives = rs.getString("Actions_Correctives");
//                String Status = rs.getString("Status");
//                String Resp_date = rs.getString("Resp"); // Utilisé comme String pour la date
//
//                action = new Action(id_reponse, Probleme_Resultat, CausesCreation, ActionsCorrectives, Status, Resp_date);
//                action.setId(id);
//
//                //actions.add(action);
//            }
//            System.out.println("donner  action OK \n");
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            System.out.println("Erreur lors de la demende d'une  action \n");
//        }
//        return action;
//    }
//    
//        public    boolean isin(){ // verifier si l'action  existe 
//        boolean d=false ;
//          try {
//        String query = "SELECT * FROM actions where id  = ? ";
//            PreparedStatement st = cnx.prepareStatement(query);
//              st.setInt(1, id);
//            ResultSet rs = st.executeQuery();
//       d=rs.next();
// 
//            System.out.println("isin action   ok \n");
//        } catch (SQLException ex) {
//            Logger.getLogger(iutilisateur.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("isin action   ko\n");
//        }
//        
//        return d;    
//       }
//  
//           public void updateAction  (Action action){
//         if(action.isin())
//             action.update(action);
//         else action.add(action);
//         
//     }
//   
//}
