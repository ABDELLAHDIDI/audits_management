/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package idao;

/**
 *
 * @author ABDELLAH DIDI
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.border.Border;

public class DynamicComponentsExample {

  
    
 
      Dashboard dashbord = null ; 
   Audit audit=null;
   boolean md=false ;
public DynamicComponentsExample (Dashboard a , Audit b ){
    dashbord=a;
    audit=b;
    
    createAndShowGUI() ;
}



public DynamicComponentsExample (Audit b){ audit=b;}
public DynamicComponentsExample (Dashboard a , Audit b ,boolean t){
    dashbord=a;
    audit=b;
    md=true;
//    Reponse r = new Reponse();
//    r.setId_audit(audit.getId());
//    Iterator<Reponse>  l=   r.lister_where().iterator();
//    while(l.hasNext()){
//        
//                
//    }
    createAndShowGUI() ;
    
}
//    public static  void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            createAndShowGUI();
//        });
//    }

       java.util.List<ActionAssociee> newFrame = new ArrayList<>();//pour indexe les action 
       java.util.List<Question> Listquestion = new ArrayList<>();//pour indexe les question 
       java.util.List<JCheckBox> Listvisuel= new ArrayList<>();//pour indexe les visuel
       java.util.List<JComboBox> Listcombobox = new ArrayList<>();//pour indexe les conforme
       java.util.List<JButton> ListModifier = new ArrayList<>();//pour indexe les modifier
       java.util.List<JButton> ListSupprimer = new ArrayList<>();//pour indexe les supprimer 
     JFrame frame = null;
    private  void createAndShowGUI() {
     frame = new JFrame("Auditer");
    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
          ImageIcon logoIcon1 = new ImageIcon("./img/COFICAB.jpeg"); 
        // Set the logo as the JFrame icon
        frame.setIconImage(logoIcon1.getImage());

    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
   
   

    
     JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());

      audit.getCheckList().getId_Planning();
    JLabel titleLabel = new JLabel("Effectuer l'audit : "+audit.getCheckList().getDescription());
    titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
    titleLabel.setHorizontalAlignment(SwingConstants.LEADING);
    
        titlePanel.add(titleLabel, BorderLayout.EAST);
   
    mainPanel.add(titleLabel);
    
    
      //mainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    Section s = new Section();
    s.setId_check_list(audit.getCheckList().getId_Planning());
    Iterator<Section> sectionIterator = s.lister_where().iterator();

    while (sectionIterator.hasNext()) {
        Section sc = sectionIterator.next();
        
        JPanel sectionPanel = new JPanel();
        sectionPanel.setLayout(new BorderLayout());

        JLabel sectionLabel = new JLabel(sc.getDescription());
   sectionLabel.setFont(new Font("Arial", Font.BOLD, 14));
        sectionPanel.add(sectionLabel, BorderLayout.CENTER);
  //sectionPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        JPanel questionPanel = new JPanel();
        
         mainPanel.add(sectionPanel);
        
        questionPanel.setLayout(new GridLayout(0, 1));//.setLayout(new FlowLayout(FlowLayout.CENTER));
                //questionPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));          
        Question q = new Question();
        q.setIdSection(sc.getId_update());
        Iterator<Question> questionIterator = q.lister_where().iterator();  
        Iterator<JCheckBox> itvisuel = Listvisuel.iterator();
        Iterator<JComboBox> itcombobox = Listcombobox.iterator();
        Iterator<JButton> itmodifier = ListModifier.iterator();
        Iterator<JButton> itsupprimer = ListSupprimer.iterator();
        //Iterator<ActionAssociee> itaction = newFrame.iterator();
           
       if(md==true){
            while (questionIterator.hasNext()) {
            Question qu = questionIterator.next();
             Listquestion.add(qu);
            JTextArea questionLabel = new JTextArea( );
            JScrollPane   jScrollPane1 = new JScrollPane();
            
            
        questionLabel.setColumns(20);
        questionLabel.setRows(1);
        questionLabel.setText(qu.getDescription());
        questionLabel.setEditable(false);
        jScrollPane1.setViewportView(questionLabel);
       
 
        
        
    Reponse x = new Reponse();
    x.setId_question(qu.getId_update());
    x=x.donnerReponse();
       JCheckBox    visuel = new javax.swing.JCheckBox();
         visuel.setText("visuel ");
         if("Visuel".equals(x.getVisuel())) visuel.setSelected(true);
         Listvisuel.add(visuel);
             
         System.out.println("Visuel  : "+x.getVisuel()+"\n"+"answerComboBox : "+x.getCombo()+"\n");
             
            JComboBox<String> answerComboBox = new JComboBox<>();
            answerComboBox.addItem("Conforme");
            answerComboBox.addItem("Non Conforme");
            answerComboBox.addItem("Non Applicable");
            
            answerComboBox.setSelectedItem(x.getCombo());
            
            
                Listcombobox.add(answerComboBox);
                
                  JButton Modifier = new JButton("Modifier");
            JButton Supprimer = new JButton("Supprimer");
                     System.out.println("************************************************************   \"Non Conforme\".equals(answerComboBox.getSelectedItem().toString())"
                             + " : "+  "Non Conforme".equals(answerComboBox.getSelectedItem().toString())  +"\n");
                     System.out.println("answerComboBox.getSelectedItem().toString() : "+answerComboBox.getSelectedItem().toString()+"\n");
          if("Non Conforme".equals(answerComboBox.getSelectedItem().toString())  || !visuel.isSelected()){
              if("Non Conforme".equals(answerComboBox.getSelectedItem().toString()) )
              answerComboBox.setEnabled(false);
              else 
                  visuel.setEnabled(false);
        
         ListModifier.add(Modifier);
         ListSupprimer.add(Supprimer);
            Modifier.setVisible(true);
            Supprimer.setVisible(true);
            Supprimer.setEnabled(true);
            Modifier.setEnabled(true);
            
            Action ac= new Action();
            ac.setId_reponse(x.getId());
            ac=ac.lister_where();
              System.out.println(" ************************************************************   ac == null  : ");
              System.out.println( (ac == null) +"\n");
            if(ac != null){
                
          ActionAssociee as = new ActionAssociee();
            
            as.set_tcause(ac.getCausesCreation());
            as.set_tcorr(ac.getActionsCorrectives());
            as.set_tdate(ac.getResp_date());
            as.set_tpro(ac.getProbleme_Resultat());
            as.set_tstatus(ac.getStatus());
            as.setTresp(ac.getResponsable());
            as.setL(newFrame);
            as.setModofier(Modifier);
            as.setSupprimer(Supprimer);
              if("Non Conforme".equals(answerComboBox.getSelectedItem().toString()) )
            as.setAnswerComboBox(answerComboBox);
              else
                as.setVisuel(visuel);
            
          Question q1 = new Question();
          Reponse xx = x.donnerReponse();
          q1.setId_update(xx.getId_question());
          q1=q1.donnerQuestion();
          as.set_tquestion(q1.getDescription());
          
          Audit au=new Audit();
          au.setId(x.getId_audit());
          au=(new iaudit()).donnerAudit(au);
            as.set_tAudit(au.getCheckList().getDescription());
            as.set_d(frame);
            as.setId_action(ac.getId());
            
            
            newFrame.add(as);
                System.out.println("newframe est ajoutée  !!!!\n ");
            }
            
          }else {
              
            Modifier.setVisible(false);
            Supprimer.setVisible(false);
            Supprimer.setEnabled(false);
            Modifier.setEnabled(false);
         ListModifier.add(Modifier);
         ListSupprimer.add(Supprimer);
          }
        
        
            visuel.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!visuel.isSelected()) {
          var a =   new ActionAssociee(frame,visuel,titleLabel.getText(),questionLabel.getText(),newFrame,Modifier,Supprimer);
        a.setVisible(true);
            frame.setEnabled(false);
        }
    }
});
            answerComboBox.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        if ( visuel.isSelected() && answerComboBox.getSelectedItem().equals("Non Conforme")) {
          var a =   new ActionAssociee(frame,answerComboBox,titleLabel.getText(),questionLabel.getText(),newFrame,Modifier,Supprimer);
        a.setVisible(true);
            frame.setEnabled(false);
        }
    }
});
            
                  Modifier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                     int j=0;
            for ( j = 0 ;ListModifier.get(j)!=Modifier;j++   );
        int i=0;
             for ( i=0 ; !newFrame.isEmpty() &&!newFrame.get(i).get_tquestion().equals(Listquestion.get(j).getDescription())   ;i++);
                System.out.println("newFrame.isEmpty()  : "+newFrame.isEmpty() +"\n");
           if(!newFrame.isEmpty()){
                 newFrame.get(i).setVisible(true);
            newFrame.get(i).set_modifier();
            frame.setEnabled(false);
           }
            }
        });
                        Supprimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              int result = JOptionPane.showConfirmDialog(null, "Voullez vous  vraiment supprimer cette action  ?"
                      , "Confirmation", JOptionPane.OK_CANCEL_OPTION);
        
        if (result == JOptionPane.OK_OPTION) {
            int j=0;
            for ( j = 0 ;ListSupprimer.get(j)!=Supprimer;j++   );
        
             int i=0;
             for ( i=0 ; !newFrame.get(i).get_tquestion().equals(Listquestion.get(j).getDescription())   ;i++);
             
              
               (new Action()).delete(new Action(newFrame.get(i).getId_action()));
                  newFrame.remove(i);
             
            ListModifier.get(j).setVisible(false);
            ListModifier.get(j).setVisible(false);
            Supprimer.setVisible(false);
            Supprimer.setEnabled(false);
            
            
                  if("Non Conforme".equals(answerComboBox.getSelectedItem().toString()) ){
                      Listcombobox.get(j).setEnabled(true);
                Listcombobox.get(j).setSelectedIndex(0);
                  }
                  else {
                      Listvisuel.get(j).setEnabled(true);
                Listvisuel.get(j).setSelected(true);
                  }
            
        } 
            }
        });
                       
        JPanel com =  new JPanel();
                   GroupLayout tquestionLayout = new javax.swing.GroupLayout(com);
        com.setLayout(tquestionLayout);
        tquestionLayout.setHorizontalGroup(
            tquestionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(tquestionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, 500, 500, 500)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 50, 50)
                .addComponent(visuel, 150,150,150)
                .addGap(20, 20, 20)
                .addComponent(answerComboBox, 150, 150, 150)
                .addGap(10,10,10)
                .addComponent(Modifier, 150, 150, 150)
                .addGap(10,10,10)
                .addComponent(Supprimer, 150, 150, 150)
                .addGap(10,10,10))
        );
        tquestionLayout.setVerticalGroup(
            tquestionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(tquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, 50, 50, 50)
              .addGap(50, 50, 50)
                .addComponent(answerComboBox, 20, 20, 20)
            .addGap(50, 50, 50)
                .addComponent(visuel, 20, 20, 20)
             .addGap(50, 50, 50)
                .addComponent(Modifier, 20, 20, 20)
             .addGap(50, 50, 50)
                .addComponent(Supprimer, 20, 20, 20)
             .addGap(50, 50, 50))
        );
        
      
           com.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 200)));
            questionPanel.add(com).setSize(100, 100);
            
   

                 
        }
       }
       else {
           
            while (questionIterator.hasNext()) {
            Question qu = questionIterator.next();
   Listquestion.add(qu);
//            JLabel questionLabel = new JLabel( qu.getDescription());
            JTextArea questionLabel = new JTextArea( );
            JScrollPane   jScrollPane1 = new JScrollPane();
            
            JButton Modifier = new JButton("Modifier");
            JButton Supprimer = new JButton("Supprimer");
         ListModifier.add(Modifier);
         ListSupprimer.add(Supprimer);
            Modifier.setVisible(false);
            Supprimer.setVisible(false);
            Supprimer.setEnabled(false);
            Modifier.setEnabled(false);
            
            
        questionLabel.setColumns(20);
        questionLabel.setRows(1);
        questionLabel.setText(qu.getDescription());
             questionLabel.setEditable(false);
        jScrollPane1.setViewportView(questionLabel);
       
             
       JCheckBox    visuel = new javax.swing.JCheckBox();
         visuel.setText("Visuel ");
         visuel.setSelected(true);
         Listvisuel.add(visuel);
             
                   visuel.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!visuel.isSelected()) {
          var a =   new ActionAssociee(frame,visuel,titleLabel.getText(),questionLabel.getText(),newFrame,Modifier,Supprimer);
        a.setVisible(true);
            frame.setEnabled(false);
        }
    }
});    
         
         
            JComboBox<String> answerComboBox = new JComboBox<>();
            answerComboBox.addItem("Conforme");
            answerComboBox.addItem("Non Conforme");
            answerComboBox.addItem("Non Applicable");
            
           Listcombobox.add(answerComboBox);
        
            answerComboBox.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (visuel.isSelected() && answerComboBox.getSelectedItem().equals("Non Conforme")) {
          var a =   new ActionAssociee(frame,answerComboBox,titleLabel.getText(),questionLabel.getText(),newFrame,Modifier,Supprimer);
        a.setVisible(true);
            frame.setEnabled(false);
        }
    }
});
            
                  Modifier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                     int j=0;
            for ( j = 0 ;ListModifier.get(j)!=Modifier;j++   );
        int i=0;
             for ( i=0 ; !newFrame.get(i).get_tquestion().equals(Listquestion.get(j).getDescription())   ;i++);
             newFrame.get(i).setVisible(true);
            newFrame.get(i).set_modifier();
            frame.setEnabled(false);
            }
        });
                        Supprimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              int result = JOptionPane.showConfirmDialog(null, "Voullez vous  vraiment supprimer cette action  ?"
                      , "Confirmation", JOptionPane.OK_CANCEL_OPTION);
        
        if (result == JOptionPane.OK_OPTION) {
            int j=0;
            for ( j = 0 ;ListSupprimer.get(j)!=Supprimer;j++   );
        
             int i=0;
             for ( i=0 ; !newFrame.get(i).get_tquestion().equals(Listquestion.get(j).getDescription())   ;i++);
             
             boolean v = false ;
              
                if(newFrame.get(i).answerComboBox != null) v=true;
                  newFrame.remove(i);
             
            ListModifier.get(j).setVisible(false);
            ListModifier.get(j).setVisible(false);
            Supprimer.setVisible(false);
            Supprimer.setEnabled(false);
            
            
               if(v){
                    Listcombobox.get(j).setEnabled(true);
                Listcombobox.get(j).setSelectedIndex(0);
               }else{
                   Listvisuel.get(j).setEnabled(true);
                   Listvisuel.get(j).setSelected(true);
               }
            
        } 
            }
        });
                       
        JPanel com =  new JPanel();
                   GroupLayout tquestionLayout = new javax.swing.GroupLayout(com);
        com.setLayout(tquestionLayout);
        tquestionLayout.setHorizontalGroup(
            tquestionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(tquestionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, 500, 500, 500)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 50, 50)
                .addComponent(visuel, 150,150,150)
                .addGap(20, 20, 20)
                .addComponent(answerComboBox, 150, 150, 150)
                .addGap(10,10,10)
                .addComponent(Modifier, 150, 150, 150)
                .addGap(10,10,10)
                .addComponent(Supprimer, 150, 150, 150)
                .addGap(10,10,10))
        );
        tquestionLayout.setVerticalGroup(
            tquestionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(tquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, 50, 50, 50)
              .addGap(50, 50, 50)
                .addComponent(answerComboBox, 20, 20, 20)
            .addGap(50, 50, 50)
                .addComponent(visuel, 20, 20, 20)
             .addGap(50, 50, 50)
                .addComponent(Modifier, 20, 20, 20)
             .addGap(50, 50, 50)
                .addComponent(Supprimer, 20, 20, 20)
             .addGap(50, 50, 50))
        );
        
      
           com.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));   
   
        
            questionPanel.add(com).setSize(100, 100);     
        }
       }
        mainPanel.add(questionPanel);
    }
        JScrollPane scrollPane = new JScrollPane(mainPanel); // Wrap mainPanel with a scroll pane
        
       
                JButton Terminer = new JButton("Terminer");
                JButton Quitter = new JButton("Quitter");
                
                
                
                                 Quitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            int result = JOptionPane.showConfirmDialog(null, "Voullez vous  vraiment quitter la page  ?"
                    +"\n Toutes les réponses seront négligées !!"
                      , "Confirmation", JOptionPane.OK_CANCEL_OPTION);
        
        if (result == JOptionPane.OK_OPTION) {
                 dashbord.setEnabled(true);
            frame.dispose();
        }
            }
        });
                                 Terminer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commit();
                 dashbord.setEnabled(true);
                 dashbord.load_Audit();
            frame.dispose();
        
            }
        });
                
                  
 JPanel Global =  new JPanel();
                   GroupLayout tquestionLayout = new javax.swing.GroupLayout(Global);
        Global.setLayout(tquestionLayout);
    tquestionLayout.setHorizontalGroup(
            tquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tquestionLayout.createSequentialGroup()
                .addGroup(tquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tquestionLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tquestionLayout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(Quitter, 100, 100, 100)
                        .addGap(30, 30, 30)
                        .addComponent(Terminer, 100, 100, 100))
                
                )
                .addContainerGap(466, Short.MAX_VALUE))
        );
        tquestionLayout.setVerticalGroup(
            tquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tquestionLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(tquestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Quitter, 50, 50, 50)
                    .addComponent(Terminer,50, 50, 50))
                .addContainerGap(114, Short.MAX_VALUE))
        );
                frame.add(Global);
       // frame.setMinimumSize(new Dimension(1350,1200));
       frame.addWindowListener(new WindowAdapter() {
    @Override
    public void windowClosing(WindowEvent e) {
       int result = JOptionPane.showConfirmDialog(null, "Voullez vous  vraiment quitter la page  ?"
                    +"\n Toutes les réponses seront négligées !!"
                      , "Confirmation", JOptionPane.OK_CANCEL_OPTION);
        
        if (result == JOptionPane.OK_OPTION) {
            dashbord.setEnabled(true);
            frame.dispose();
        }
    }
});
       
    frame.pack();
    frame.setVisible(true);
}
     void commit(){
         float  nbreq=0;
          Iterator<Question> itquestion = Listquestion.iterator();
        Iterator<JCheckBox> itvisuel = Listvisuel.iterator();
        Iterator<JComboBox> itcombobox = Listcombobox.iterator();
        Iterator<ActionAssociee> itaction = newFrame.iterator();
        int i =0;
     
       if(md){
           System.out.println("*********************************commit : modifier \n");
        while(itquestion.hasNext()){
            
           var question =  itquestion.next();
           var visuel =  itvisuel.next();
           var combo =  itcombobox.next();
           
             if("Conforme".equals(combo.getSelectedItem().toString()))
           {
              // if(visuel.isSelected()) 
               nbreq++;
             //  else nbreq= (float) (nbreq+0.5);
           }
           String v="";
           ActionAssociee action = null;
              Reponse r = null;
              Action a =null;
              
                r = new Reponse();
                r.setId_question(question.getId_update());
                r=r.donnerReponse();
                        if(visuel.isSelected()) v="Visuel";
                        else v="Non Visuel";
                r.setDescription(v+"_"+combo.getSelectedItem().toString());
                r.update(r);
                System.out.println(" **************   r.get_id() : "+r.getId()+"\n   "
                        + "!newFrame.isEmpty() && i<newFrame.size() == "+(!newFrame.isEmpty() && i<newFrame.size())+"\n");
           if(!newFrame.isEmpty() && i<newFrame.size()  ) {
               
               int j= Actionquestion(question.getDescription());
               if(j != -1) {
                   action = newFrame.get(j);
                   a = new Action(r.getId(), action.get_tpro(), action.get_tcause(),
                         action.get_tcorr(), action.get_tstatus(), action.get_tdate(),action.getTresp());
                   a.setId(action.getId_action());
                   a.updateAction(a);
             i++;
             }
               
           }
       }
       }
       else 
       {
           
        while(itquestion.hasNext()){
           var question =  itquestion.next();
           var visuel =  itvisuel.next();
           var combo =  itcombobox.next();
           if("Conforme".equals(combo.getSelectedItem().toString()))
           {
              // if(visuel.isSelected()) 
               nbreq++;
             //  else nbreq= (float) (nbreq+0.5);
           }
           
           
           ActionAssociee action = null;
              Reponse r = null;
              Action a =null;
                if(visuel.isSelected())
           r = new Reponse(0, audit.getId(),question.getId_update(), "Visuel", combo.getSelectedItem().toString());
           else 
                 r = new Reponse(0, audit.getId(),question.getId_update(), "Non Visuel", combo.getSelectedItem().toString());
            r.add(r);
            
           if(!newFrame.isEmpty() && i<newFrame.size()  ) {
               int j= Actionquestion(question.getDescription());
               if(j != -1) {
                             action = newFrame.get(j);
                   a = new Action(r.get_id(), action.get_tpro(), action.get_tcause(),
                         action.get_tcorr(), action.get_tstatus(), action.get_tdate(),action.getTresp());
             a.add(a);
             i++;
             }
           }
         
        }
        
    }
                Date selectedDate = new Date();
          Date now = new Date();
          
               SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
             
        String formattedDate = dateFormat.format(selectedDate);
        String formattedTime = timeFormat.format(now.getTime());
        audit.setDate_realisation(formattedDate+formattedTime);
        audit.setScore((nbreq/(float)(Listquestion.size())) * 100);
        if(audit.getScore() < 80 ) audit.setNiveau("C");
        else  if(audit.getScore() < 90 ) audit.setNiveau("B");
        else  audit.setNiveau("A");
        
        (new iaudit()).update(audit);

       }
     
     
     
     int  Actionquestion(String a){// verifier est ce que ce question a une action
         
         int i=0;
         
         while(!newFrame.isEmpty() && i<newFrame.size()){
             
            if(newFrame.get(i).get_tquestion().equals(a)) return i ;
            i++;
         }
         
         return -1 ;
     }
     
     
     
     public void toExcel() throws Exception{
   
         
         
      audit.getCheckList().getId_Planning();
 //   "Effectuer l'audit : "+audit.getCheckList().getDescription()
 

  Listquestion.add(new Question(-2, audit.getCheckList().getDescription()));
    Section s = new Section();
    s.setId_check_list(audit.getCheckList().getId_Planning());
    Iterator<Section> sectionIterator = s.lister_where().iterator();

    while (sectionIterator.hasNext()) {
        Section sc = sectionIterator.next();
         Listquestion.add(new Question(-1,sc.getDescription()));
                 // sc.getDescription() 

        
        
        
        Question q = new Question();
        q.setIdSection(sc.getId_update());
        Iterator<Question> questionIterator = q.lister_where().iterator();  
        Iterator<JCheckBox> itvisuel = Listvisuel.iterator();
        Iterator<JComboBox> itcombobox = Listcombobox.iterator();
        
         
          while (questionIterator.hasNext()) {
   
              
                     Question qu = questionIterator.next();
             Listquestion.add(qu);
//     qu.getDescription()
       
 
        
        
    Reponse x = new Reponse();
    x.setId_question(qu.getId_update());
    x=x.donnerReponse();
       JCheckBox    visuel = new javax.swing.JCheckBox();
         visuel.setText("visuel ");
         if("Visuel".equals(x.getVisuel())) visuel.setSelected(true);
         Listvisuel.add(visuel);
             
         System.out.println("Visuel  : "+x.getVisuel()+"\n"+"answerComboBox : "+x.getCombo()+"\n");
             
            JComboBox<String> answerComboBox = new JComboBox<>();
            answerComboBox.addItem("Conforme");
            answerComboBox.addItem("Non Conforme");
            answerComboBox.addItem("Non Applicable");
            
            answerComboBox.setSelectedItem(x.getCombo());
            
            
                Listcombobox.add(answerComboBox);
     
                
                
                
          if("Non Conforme".equals(answerComboBox.getSelectedItem().toString())  || !visuel.isSelected()){
              if("Non Conforme".equals(answerComboBox.getSelectedItem().toString()) )
              answerComboBox.setEnabled(false);
              else 
                  visuel.setEnabled(false);
        
            Action ac= new Action();
            ac.setId_reponse(x.getId());
            ac=ac.lister_where();
            
             
            if(ac != null){
                
          ActionAssociee as = new ActionAssociee();
          
          if("Non Conforme".equals(answerComboBox.getSelectedItem().toString()) )
            as.setAnswerComboBox(answerComboBox);
              else
                as.setVisuel(visuel);
          
          
          // remplissage de l'action 
            
            as.set_tcause(ac.getCausesCreation());
            as.set_tcorr(ac.getActionsCorrectives());
            as.set_tdate(ac.getResp_date());
            as.set_tpro(ac.getProbleme_Resultat());
            as.set_tstatus(ac.getStatus());
            as.setTresp(ac.getResponsable());
            as.set_tquestion(qu.getDescription());
            newFrame.add(as);
         
                System.out.println("newframe est ajoutée  !!!!\n ");
            }
            
          }
          
                 
        }
           
        }
          
        (new ExcelExporter()).exportToExcel(audit,Listquestion, Listvisuel, Listcombobox, newFrame,"output.xlsx")  ;
    }
          
          
          
       }
        
    
     
     
     
     
    

