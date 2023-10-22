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

public class Section implements idao<Section> {

    private static int  id=0;
    int id_update = 0;

    public int getId_update() {
        return id_update;
    }

    public void setId_update(int id_update) {
        this.id_update = id_update;
    }
    private String description;
private int id_check_list=0;

//static void setId(int id){
//    Section.id=id;
//}
  public void setId(int  id) {
        Section.id = id;
    }
    public int getId_check_list() {
        return id_check_list;
    }

    public void setId_check_list(int id_check_list) {
        this.id_check_list = id_check_list;
    }
    public Section() {
    }
    
    public Section( String description) {
       id++;
        id_update=id;      
        this.description = description;
    }

    public Section( int id_check_list, String description) {
       id++;
               id_update=id; 
              this.id_check_list = id_check_list;
        this.description = description;
    }
    public Section( int id_update,int id_check_list, String description) {

              this. id_update=id_update; 
              this.id_check_list = id_check_list;
        this.description = description;
    }

    @Override
    public String toString() {
        return id + "_" + description;
    }

    public int  getId() {
        return id;
    }

  

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void add(Section section) {
        try {
            String query = "insert into sections ( id_check_list, description) values (?, ?)";
            PreparedStatement st = cnx.prepareStatement(query);
            st.setInt(1, section.getId_check_list());
            st.setString(2, section.getDescription());
            st.execute();
            System.out.println("add section ok \n");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("add not section  ok \n");
        }
    }

    @Override
    public void delete(Section section) {
        try {
            String query = "delete from sections where id = ?";
            PreparedStatement st = cnx.prepareStatement(query);
            st.setInt(1, section.getId_update());
            st.execute();
            System.out.println("suppression ok \n");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + "\n " + "delete from sections where id = " + section.getId_update(),
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("suppression ko \n");
        }
    }

     public void updateSection (Section section){
         if(section.isin())
             section.update(section);
         else section.add(section);
         
     }
    
    @Override
    public void update(Section section) {
        try {
            String query = "UPDATE sections SET description = ? WHERE id = ?";
            PreparedStatement st = cnx.prepareStatement(query);
            st.setString(1, section.getDescription());
            st.setInt(2, section.getId_update());
            st.executeUpdate();
            System.out.println("update ok\n");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public boolean signup(Section section) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void show(Section section) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Section> lister() {
        List<Section> l = new ArrayList<>();
        try {
            String query = "SELECT * FROM sections";
            PreparedStatement st = cnx.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Section section = new Section();
                section.setId(rs.getInt("id"));
                section.setDescription(rs.getString("description"));
                l.add(section);
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
            String query = "SELECT * FROM sections";
            rs = st.executeQuery(query);
            System.out.println("ResultSet obtained successfully.\n");
        } catch (SQLException ex) {
            System.out.println("Problem with the query: " + ex.getMessage());
        }

        return rs;
    }
    
    public ResultSet ToResultSet(int id_check) {
        Statement st;
        ResultSet rs = null;

        try {
            st = cnx.createStatement();
            String query = "SELECT * FROM sections where id_check_list =  '"+id_check+"'";
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
        String query = "SELECT max(id) FROM sections ";
            PreparedStatement st = cnx.prepareStatement(query);
            ResultSet rs = st.executeQuery();
      boolean v= rs.next();
           // System.out.println("rs.next()  = "+v+"\n");
            if (v) {
    d=    rs.getInt(1);
            }
            System.out.println("get_id_sections  ok \n");
        } catch (SQLException ex) {
            Logger.getLogger(iutilisateur.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("get_id_sections  ko\n");
        }
        
        return d; 
    } 
    
    public    boolean isin(){
        boolean d=false ;
          try {
        String query = "SELECT * FROM sections where id  = ? ";
            PreparedStatement st = cnx.prepareStatement(query);
              st.setInt(1, id_update);
            ResultSet rs = st.executeQuery();
       d=rs.next();
 
            System.out.println("isin  ok \n");
        } catch (SQLException ex) {
            Logger.getLogger(iutilisateur.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("isin  ko\n");
        }
        
        return d;    
       }
                       public void deleteSection (Section section){
         if(section.isin())
                  section.delete(section);
     }
                       
                       
                       
         public List<Section> lister_where() {
        
       List<Section> l = new ArrayList<>();
        try {
            String query = "SELECT * FROM sections  where id_check_list  = '"+id_check_list+"'" ;
            PreparedStatement st = cnx.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                
                Section a = new Section(Integer.parseInt(rs.getString("id")),0,rs.getString("description"));
                
                l.add(a);
            }
            System.out.println("lister_where section  ok\n");
        } catch (SQLException ex) {
            Logger.getLogger(iutilisateur.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("lister_where section  ko\n");
        }
        return l;
    
    }
                       
}
