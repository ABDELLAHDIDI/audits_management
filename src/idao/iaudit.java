package idao;
import java.sql.*;
import static idao.iutilisateur.cnx;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class iaudit implements idao<Audit> {

    static Connection cnx = mysqlconnection.getConnexion();
    String query;
iaudit(){
}
    @Override
    public void add(Audit a) {
        try {
            query = "insert into audits ( auditeur, date_creation, date_realisation, date_limite, score, niveau,id_check_list) "
                    + "values (?, ?, ?, ?, ?, ?)";
            PreparedStatement st = cnx.prepareStatement(query);
            st.setString(1, a.getAuditeur());
            st.setString(2, a.getDate_creation());
            st.setString(3,a.getDate_realisation());
            st.setString(4,  a.getDate_limite() );
            st.setFloat(5, a.getScore());
            st.setString(6, a.getNiveau());
            st.setInt(7, a.getCheckList().getId());
            st.execute();
            System.out.println("add ok \n");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + "\n" + query,
                    "Information", JOptionPane.INFORMATION_MESSAGE);
               System.out.println("add ko \n");
        }
    }
    public void add_Planning(Audit a) {
        try {
            query = "insert into audits ( auditeur, date_creation,  date_limite,id_check_list, date_realisation) "
                    + "values (?, ?, ?, ?,NULL)";
            PreparedStatement st = cnx.prepareStatement(query);
            st.setString(1, a.getAuditeur());
            st.setString(2, a.getDate_creation()); 
            
            st.setString(3, a.getDate_limite());

            st.setInt(4, a.getCheckList().getId());
            st.execute();
            System.out.println("add ok \n");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + "\n" + query,
                    "Information", JOptionPane.INFORMATION_MESSAGE);
               System.out.println("add ko \n");
        }
    }
    public void update_Planning(Audit a) {
        try {
            query = "UPDATE audits SET  auditeur = ? , id_check_list=? ,  date_creation = ? , date_limite = ? WHERE id = ?  ";
            PreparedStatement st = cnx.prepareStatement(query);
            st.setString(1, a.getAuditeur());
            st.setInt(2, a.getCheckList().getId());
            st.setString(3, a.getDate_creation());
            st.setString(4, a.getDate_limite());
            st.setInt(5, a.getId());
            st.execute();
            System.out.println("update_Planning ok   id  : "+a.getId()+" \n");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + "\n" + query,
                    "Information", JOptionPane.INFORMATION_MESSAGE);
               System.out.println("update_Planning  ko  id : "+a.getId()+" \n" );
        }
    }

    @Override
    public void delete(Audit a) {
        try {
            query = "DELETE FROM audits WHERE id = ? ";
            PreparedStatement st = cnx.prepareStatement(query);
            st.setInt(1, a.getId());
           
            st.executeUpdate();
            System.out.println("delete ok\n");
        } catch (SQLException ex) {
            Logger.getLogger(iaudit.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("delete ko\n");
        }
    }

    @Override
    public void update(Audit a) {
        try {
            query = "UPDATE audits SET date_realisation = ?, date_limite = ?, score = ?, niveau = ?, id_check_list=? WHERE id = ? ";
            PreparedStatement st = cnx.prepareStatement(query);
            st.setString(1, a.getDate_realisation());
            st.setString(2, a.getDate_limite());
            st.setFloat(3, a.getScore());
            st.setString(4, a.getNiveau());
            st.setInt(5, a.getCheckList().getId());
            st.setInt(6, a.getId());
            st.executeUpdate();
            System.out.println("update ok\n");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + "\n" + query,
                    "Information", JOptionPane.INFORMATION_MESSAGE);
               System.out.println("update ko\n");
            
        }
    }

    @Override
    public boolean signup(Audit a) {
        // Implement the method as needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void show(Audit a) {
        // Implement the method as needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Audit> lister() {
        List<Audit> l = new ArrayList<>();
        try {
            query = "SELECT * FROM audits";
            PreparedStatement st = cnx.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Audit audit = new Audit();
                audit.setAuditeur(rs.getString("auditeur"));
                audit.setCheckList(new CheckList(rs.getString("id_check_list")));
                audit.setDate_creation(rs.getString("date_creation"));
                audit.setDate_realisation(rs.getString("date_realisation"));
                audit.setDate_limite(rs.getString("date_limite"));
                audit.setScore(rs.getInt("score"));
                audit.setNiveau(rs.getString("niveau"));
                l.add(audit);
            }
            System.out.println("ok\n");
        } catch (SQLException ex) {
            Logger.getLogger(iaudit.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ko\n");
        }
        return l;
    }

    public ResultSet ToResultSet() {
        Statement st;
        ResultSet rs = null;

        try {
            st = cnx.createStatement();
            query = "SELECT * FROM audits";
            rs = st.executeQuery(query);
            System.out.println("ResultSet obtained successfully.\n");
        } catch (SQLException ex) {
            System.out.println("Problem with the query: " + ex.getMessage());
        }

        return rs;
    }
    
    
        public ResultSet ToResultSetPlanning(String a) {
        Statement st;
        ResultSet rs = null;

        try {
            st = cnx.createStatement();
            query = "SELECT * FROM audits where date_realisation  IS NULL  and date_limite like '"+a+"%'";

            rs = st.executeQuery(query);
            System.out.println("ResultSet obtained successfully.\n");
            System.out.println("a = "+a+"\n");
        } catch (SQLException ex) {
            System.out.println("Problem with the query: " + ex.getMessage());
        }

        return rs;
    }
        public ResultSet ToResultSetPlanning(String a, String b,String c) {
        Statement st;
        ResultSet rs = null;

        try {
            st = cnx.createStatement();
           if(!" ".equals(b) && " ".equals(c) ) 
            query = "SELECT * FROM audits where date_realisation  IS NULL  and date_limite like '"+a+"%'"
                    +"and auditeur in (select matricule from utilisateurs where site = '"+b+"')";
           else    if(" ".equals(b) && !" ".equals(c) ) 
            query = "SELECT * FROM audits where date_realisation  IS NULL  and date_limite like '"+a+"%'"
                    +"and auditeur in (select matricule from utilisateurs where departement = '"+c+"')";
           else    
            query = "SELECT * FROM audits where date_realisation  IS NULL  and date_limite like '"+a+"%'"
                    +"and auditeur in (select matricule from utilisateurs where site = '"+b+"' and  departement = '"+c+"')";
            

            rs = st.executeQuery(query);
            System.out.println("ResultSet obtained successfully.\n");
            System.out.println("a = "+a+"\n");
        } catch (SQLException ex) {
            System.out.println("Problem with the query: " + ex.getMessage());
        }

        return rs;
    }

          public ResultSet ToResultSet(String b,String c) {
        Statement st;
        ResultSet rs = null;

        try {
            st = cnx.createStatement();
            
             if(!" ".equals(b) && " ".equals(c) ) 
            query = "SELECT * FROM audits where auditeur in (select matricule from utilisateurs where site = '"+b+"')";
           else    if(" ".equals(b) && !" ".equals(c) ) 
            query = "SELECT * FROM audits where  auditeur in (select matricule from utilisateurs where departement = '"+c+"')";
           else    
            query = "SELECT * FROM audits where auditeur in (select matricule from utilisateurs where site = '"+b+"' and  departement = '"+c+"')";
             
            rs = st.executeQuery(query);
            System.out.println("ResultSet obtained successfully.\n");
        } catch (SQLException ex) {
            System.out.println("Problem with the query: " + ex.getMessage());
        }

        return rs;
    }
          
      public Audit donnerAudit( Audit a) {
      Audit audit = null;
        try {
            query = "SELECT * FROM audits where id ='"+a.getId()+"'";
            PreparedStatement st = cnx.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                audit = new Audit();
                audit.setAuditeur(rs.getString("auditeur"));
                audit.setCheckList(new CheckList(rs.getInt("id_check_list")));
                audit.setDate_creation(rs.getString("date_creation"));
                audit.setDate_realisation(rs.getString("date_realisation"));
                audit.setDate_limite(rs.getString("date_limite"));
                audit.setScore(rs.getInt("score"));
                audit.setNiveau(rs.getString("niveau"));
            
            }
            System.out.println("donnerAudit ok\n");
        } catch (SQLException ex) {
            Logger.getLogger(iaudit.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("donnerAudit ko\n");
        }
        return audit;
    }
        
}
