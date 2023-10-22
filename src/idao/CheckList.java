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

public class CheckList implements idao<CheckList> {

    private int id;
    private String description;

    public CheckList() {
    }
       public CheckList(int id) {
       
     this.id = id;
     set_description();
    }

    public CheckList( String description) {
       
        this.description = description;
    }
        public CheckList(int id, String description) {
        this.id = id;
        this.description = description;
    }

    @Override
    public String toString() {
        return id + "_" + description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void add(CheckList checklist) {
        try {
            String query = "insert into check_lists ( description) values ( ?)";
            PreparedStatement st = cnx.prepareStatement(query);
            st.setString(1, checklist.getDescription());
            st.execute();
            System.out.println("add check_lists  ok \n");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("add  check_lists  not  ok \n");
        }
    }

    @Override
    public void delete(CheckList checklist) {
        try {
            String query = "delete from check_lists where id = ?";
            PreparedStatement st = cnx.prepareStatement(query);
            st.setInt(1, checklist.getId());
            st.execute();
            System.out.println("suppression ok \n");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + "\n " + "delete from check_lists where id = " + checklist.getId(),
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("suppression ko \n");
        }
    }

    @Override
    public void update(CheckList checklist) {
       try {
            String query = "UPDATE check_lists SET description = ? WHERE id = ?";
            PreparedStatement st = cnx.prepareStatement(query);
            st.setString(1, getDescription());
            st.setInt(2, getId());
            st.executeUpdate();
            System.out.println("update checklist ok\n");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Information", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("update checklist ko\n");
        }
    }

    @Override
    public boolean signup(CheckList checklist) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void show(CheckList checklist) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<CheckList> lister() {
        List<CheckList> l = new ArrayList<>();
        try {
            String query = "SELECT * FROM check_lists";
            PreparedStatement st = cnx.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CheckList checklist = new CheckList();
                checklist.setId(rs.getInt("id"));
                checklist.setDescription(rs.getString("description"));
                l.add(checklist);
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
            String query = "SELECT * FROM check_lists";
            rs = st.executeQuery(query);
            System.out.println("ResultSet obtained successfully.\n");
        } catch (SQLException ex) {
            System.out.println("Problem with the query: " + ex.getMessage());
        }

        return rs;
    }
    
    public int get_id() {
        int d =-1;
         try {
        String query = "SELECT max(id) FROM check_lists";
            PreparedStatement st = cnx.prepareStatement(query);
            ResultSet rs = st.executeQuery();
  boolean v= rs.next();
           // System.out.println("rs.next()  = "+v+"\n");
            if (v) {
    d=    rs.getInt(1);
            }
            System.out.println("get_id_check_lists ok d= "+d+"\n");
   
        } catch (SQLException ex) {
            Logger.getLogger(iutilisateur.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("get_id_check_lists   ko    d = "+d+"\n");
          
        }
                   return d;  
    }
    
    public String  set_description(){
        String d="";
         try {
            String query = "SELECT * FROM check_lists where id=?";
            PreparedStatement st = cnx.prepareStatement(query);
                st.setInt(1, id);
            ResultSet rs = st.executeQuery();
          rs.next();
                setDescription(rs.getString("description"));
                   System.out.println("set_description ok\n");
                   return rs.getString("description");
        } catch (SQLException ex) {
            Logger.getLogger(iutilisateur.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("set_description ok\n"); 
        }
         return d;
}
    
     public int getId_Planning() {
         
         
       int d =-1;
         try {
        String query = "SELECT id FROM check_lists where description = '"+description+"'";
            PreparedStatement st = cnx.prepareStatement(query);
            ResultSet rs = st.executeQuery();
  boolean v= rs.next();
           // System.out.println("rs.next()  = "+v+"\n");
            if (v) {
    d=    rs.getInt(1);
            }
            System.out.println("get_id_check_lists ok d= "+d+"\n");
   id = d;
        } catch (SQLException ex) {
            Logger.getLogger(iutilisateur.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("get_id_check_lists   ko    d = "+d+"\n");
          
        }
                   return d;  
    }

    
    
}
