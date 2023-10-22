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

public class Question implements idao<Question> {

    private static int id=0;
 public void setId(int id) {
       Question.id = id;
    }
    public int getId_update() {
        return id_update;
    }

    public void setId_update(int id_update) {
        this.id_update = id_update;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    int id_update=0;
      private int idSection;

    public int getIdSection() {
        return idSection;
    }

    public void setIdSection(int idSection) {
        this.idSection = idSection;
    }
    
    private String description;

    public Question() {
    }

    public Question( String description) {
 id++;
 id_update=id;
        this.description = description;
    }
       public Question( int idSection, String description) {
 Question.id++;
 id_update=id;
        this.description = description;
             this.idSection = idSection;
    }
       public Question( int idSection) {
             this.idSection = idSection;
    }
       public Question(int id_update, int idSection, String description) {

         this.id_update=id_update;
        this.description = description;
             this.idSection = idSection;
    }

    @Override
    public String toString() {
        return id + "_" + description;
    }

    public int getId() {
        return id;
    }

   

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    @Override
    public void add(Question question) {
        try {
            String query = "insert into questions ( id_section,description) values (?, ?)";
            PreparedStatement st = cnx.prepareStatement(query);
  
            st.setInt(1, question.getIdSection());
            st.setString(2, question.getdescription());
            st.execute();
            System.out.println("add  question ok \n");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("add not question  ok \n");
        }
    }

    @Override
    public void delete(Question question) {
        try {
            String query = "delete from questions where id = ?";
            PreparedStatement st = cnx.prepareStatement(query);
            st.setInt(1, question.getId_update());
            st.execute();
            System.out.println("suppression ok \n");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + "\n " + "delete from questions where id = " + question.getId(),
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("suppression ko \n");
        }
    }

    @Override
    public void update(Question question) {
        try {
            String query = "UPDATE questions SET description = ? WHERE id = ?";
            PreparedStatement st = cnx.prepareStatement(query);
            st.setString(1, question.getdescription());
            st.setInt(2, question.getId_update());
            st.executeUpdate();
            System.out.println("update ok\n");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public boolean signup(Question question) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void show(Question question) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Question> lister() {
        List<Question> l = new ArrayList<>();
        try {
            String query = "SELECT * FROM questions";
            PreparedStatement st = cnx.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Question question = new Question();
                question.setId(rs.getInt("id"));
                question.setdescription(rs.getString("description"));
                l.add(question);
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
            String query = "SELECT * FROM questions";
            rs = st.executeQuery(query);
            System.out.println("ResultSet obtained successfully.\n");
        } catch (SQLException ex) {
            System.out.println("Problem with the query: " + ex.getMessage());
        }

        return rs;
    }
    
        public ResultSet ToResultSet(int id_section) {
        Statement st;
        ResultSet rs = null;

        try {
            st = cnx.createStatement();
            String query = "SELECT * FROM questions  where id_section =  '"+id_section+"'";
            rs = st.executeQuery(query);
            System.out.println("ResultSet obtained successfully.\n");
        } catch (SQLException ex) {
            System.out.println("Problem with the query: " + ex.getMessage());
        }

        return rs;
        }
        
        public int get_id() {
            int d=-1;
         try {
        String query = "SELECT max(id) FROM questions";
            PreparedStatement st = cnx.prepareStatement(query);
            ResultSet rs = st.executeQuery();
     boolean v= rs.next();
           // System.out.println("rs.next()  = "+v+"\n");
            if (v) {
    d=    rs.getInt(1);
            }
            System.out.println("get_id_questions ok \n");
   
        } catch (SQLException ex) {
            Logger.getLogger(iutilisateur.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("get_id_questions   ko   d = "+d+"\n");
        }
                       return d; 
    }
        
        
        
        
         public    boolean isin(){
        boolean d=false ;
          try {
        String query = "SELECT * FROM questions where id  = ? ";
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
              public void updateQuestion (Question question){
         if(question.isin())
             question.update(question);
         else question.add(question);
         
     }
        
                      public void deleteQuestion (Question question){
         if(question.isin())
                  question.delete(question);
     }
   
          public List<Question> lister_where() {
        
       List<Question> l = new ArrayList<>();
        try {
            String query = "SELECT * FROM questions   where id_section  = '"+idSection+"'" ;
            PreparedStatement st = cnx.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                
                Question a = new Question(Integer.parseInt(rs.getString("id")),idSection,rs.getString("description"));
                
                l.add(a);
            }
            System.out.println("lister_where question   ok\n");
        } catch (SQLException ex) {
            Logger.getLogger(iutilisateur.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("lister_where question   ko\n");
        }
        return l;
    
    }
          public Question donnerQuestion() {
        
      Question l = null;
        try {
            String query = "SELECT * FROM questions   where id  = '"+id_update+"'" ;
            PreparedStatement st = cnx.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                
                 l = new Question(Integer.parseInt(rs.getString("id")),idSection,rs.getString("description"));
                
                
            }
            System.out.println("donner  question   ok\n");
        } catch (SQLException ex) {
            Logger.getLogger(iutilisateur.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("donner question   ko\n");
        }
        return l;
    
    }
        
    
}
