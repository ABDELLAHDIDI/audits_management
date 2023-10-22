/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package idao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author maejj
 */
public class ajoutercheckliste extends javax.swing.JFrame {
    Dashboard d = null ;
    CheckList check=null;
    boolean update=false;
     CustomTableModel SectionModel=null;
     CustomTableModel SectionModel1=null;
//     DefaultTableModel     QuestionModel=null;
     CustomTableModel    QuestionModel=null;
  Section section = new Section();
Question question= new Question();
int selectedrow=0;
     List < CustomTableModel>    questions = new  ArrayList<>();
     
    /**
     * Creates new form ajoutercheckliste
     */
    public ajoutercheckliste() {
        initComponents();
        //tabsection
         check = new CheckList(tcheck.getText());
        
//      SectionModel =  (DefaultTableModel) tabsection.getModel();
//           QuestionModel =  (DefaultTableModel)  tabquestion.getModel();
           
    }
        public ajoutercheckliste(Dashboard d) {
        initComponents();
        this.d = d ;
        check = new CheckList(tcheck.getText());  
            Object [][] data=new Object [0][0];
            SectionModel =   new CustomTableModel(data);
            tabsection.setModel(SectionModel);
           QuestionModel =  new CustomTableModel(data);
           
                  tcheck.requestFocus();
           
    }
              public ajoutercheckliste(Dashboard d,CheckList checkList) {
        initComponents();
        update=true;
        this.d = d ;
        check = checkList ;  
        Object [][] data=new Object [0][0];
            SectionModel1 =   new CustomTableModel(data);
           //QuestionModel =  (DefaultTableModel)  tabquestion.getModel();
           tcheck.setText(check.getDescription());
              tcheck.requestFocus();
           load_Section();
           
    }

        
                public void load_Section(){
                    
                   SectionModel1.copy(section.ToResultSet(check.getId()) );
                    for (int i = 0; i <  SectionModel1.getRowCount() ; i++) {
                     Object [] [] data = new Object [0][0];
            questions.add( (new CustomTableModel(data)) );
                    }
                                  tabsection.setModel(    SectionModel1 );
                }
           
                           public void load_Question(int a ){
                                 selectedrow =  tabsection.getSelectedRow();
                   tabquestion.setModel(    questions.get(a));
                }
    
                           
     void commit(){
        if(update){
             check.update(check);
                    int check_id = check.getId();
                         for(int i=0;i<tabsection.getRowCount();i++){
                                    section.updateSection( new Section(Integer.parseInt(tabsection.getValueAt(i, -1).toString()),
                                            check_id ,tabsection.getValueAt(i, 0).toString())    );
                                    int section_id = Integer.parseInt(tabsection.getValueAt(i, -1).toString());
                                            for(int j =0;j<questions.get(i).getRowCount();j++){
                                             question.updateQuestion(new Question(
                                                     Integer.parseInt(questions.get(i).getValueAt(j, -1).toString()),
                                                     section_id,questions.get(i).getValueAt(j, 0).toString()));
                      }   
                   }        
        }
        else {
                        check.add(check);
                    int check_id = check.get_id();
                         for(int i=0;i<tabsection.getRowCount();i++){
                                    section.add( new Section(check_id ,tabsection.getValueAt(i, 0).toString()));
                                    int section_id =  section.get_id();
                                            for(int j =0;j<questions.get(i).getRowCount();j++){
                                             question.add(new Question(section_id,questions.get(i).getValueAt(j, 0).toString()));
                      }   
                   }        
                       
        }
     
     
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Check_List = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tcheck = new javax.swing.JTextField();
        SuivantSection = new javax.swing.JButton();
        Quiter = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Section = new javax.swing.JPanel();
        SuivantQuestion = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tsection = new javax.swing.JTextField();
        AjouterSection = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabsection = new javax.swing.JTable();
        RetourCheck = new javax.swing.JButton();
        SupprimerSection = new javax.swing.JButton();
        Question = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tquestion = new javax.swing.JTextField();
        AjouterQuestion = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabquestion = new javax.swing.JTable();
        Suivant3 = new javax.swing.JButton();
        Retour = new javax.swing.JButton();
        SupprimerQuestion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Gestion des Chek-Lists");
        setIconImage(  (new ImageIcon("./img/COFICAB.jpeg")).getImage()

        );
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 40));

        jLabel1.setText("CheckListe");

        tcheck.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                tcheckInputMethodTextChanged(evt);
            }
        });
        tcheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcheckActionPerformed(evt);
            }
        });

        SuivantSection.setBackground(new java.awt.Color(0, 204, 51));
        SuivantSection.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SuivantSection.setForeground(new java.awt.Color(255, 255, 255));
        SuivantSection.setText("SUIVANT");
        SuivantSection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuivantSectionActionPerformed(evt);
            }
        });

        Quiter.setText("QUITTER");
        Quiter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                QuiterMouseClicked(evt);
            }
        });
        Quiter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuiterActionPerformed(evt);
            }
        });

        jLabel4.setText("Veuillez insérer le nom de la check-list   : ");

        javax.swing.GroupLayout Check_ListLayout = new javax.swing.GroupLayout(Check_List);
        Check_List.setLayout(Check_ListLayout);
        Check_ListLayout.setHorizontalGroup(
            Check_ListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Check_ListLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(Check_ListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Check_ListLayout.createSequentialGroup()
                        .addGroup(Check_ListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Quiter, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(Check_ListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tcheck, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SuivantSection, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        Check_ListLayout.setVerticalGroup(
            Check_ListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Check_ListLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(Check_ListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tcheck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100)
                .addGroup(Check_ListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Quiter, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(SuivantSection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(181, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab1", Check_List);

        SuivantQuestion.setBackground(new java.awt.Color(0, 204, 51));
        SuivantQuestion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SuivantQuestion.setForeground(new java.awt.Color(255, 255, 255));
        SuivantQuestion.setText("SUIVANT");
        SuivantQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuivantQuestionActionPerformed(evt);
            }
        });

        jLabel2.setText("Section");

        AjouterSection.setBackground(new java.awt.Color(102, 153, 255));
        AjouterSection.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AjouterSection.setForeground(new java.awt.Color(255, 255, 255));
        AjouterSection.setText("Ajouter");
        AjouterSection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjouterSectionActionPerformed(evt);
            }
        });

        tabsection.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabsection.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabsectionMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabsection);

        RetourCheck.setText("RETOUR");
        RetourCheck.setPreferredSize(new java.awt.Dimension(78, 23));
        RetourCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetourCheckActionPerformed(evt);
            }
        });

        SupprimerSection.setBackground(new java.awt.Color(255, 51, 0));
        SupprimerSection.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SupprimerSection.setForeground(new java.awt.Color(255, 255, 255));
        SupprimerSection.setText("Supprimer");
        SupprimerSection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupprimerSectionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SectionLayout = new javax.swing.GroupLayout(Section);
        Section.setLayout(SectionLayout);
        SectionLayout.setHorizontalGroup(
            SectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SectionLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(SectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SectionLayout.createSequentialGroup()
                        .addComponent(RetourCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94)
                        .addComponent(SupprimerSection, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SuivantQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SectionLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tsection, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(AjouterSection, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4))
                .addGap(97, 97, 97))
        );
        SectionLayout.setVerticalGroup(
            SectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SectionLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(SectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tsection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AjouterSection, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(SectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RetourCheck, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(SuivantQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SupprimerSection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(54, 54, 54))
        );

        jTabbedPane1.addTab("tab2", Section);

        jLabel3.setText("Question ");

        tquestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tquestionActionPerformed(evt);
            }
        });

        AjouterQuestion.setBackground(new java.awt.Color(102, 153, 255));
        AjouterQuestion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AjouterQuestion.setForeground(new java.awt.Color(255, 255, 255));
        AjouterQuestion.setText("Ajouter");
        AjouterQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjouterQuestionActionPerformed(evt);
            }
        });

        tabquestion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabquestion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabquestionMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tabquestion);

        Suivant3.setBackground(new java.awt.Color(0, 204, 51));
        Suivant3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Suivant3.setForeground(new java.awt.Color(255, 255, 255));
        Suivant3.setText("Terminer");
        Suivant3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Suivant3ActionPerformed(evt);
            }
        });

        Retour.setText("Retour");
        Retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetourActionPerformed(evt);
            }
        });

        SupprimerQuestion.setBackground(new java.awt.Color(255, 51, 0));
        SupprimerQuestion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SupprimerQuestion.setForeground(new java.awt.Color(255, 255, 255));
        SupprimerQuestion.setText("Supprimer");
        SupprimerQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupprimerQuestionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout QuestionLayout = new javax.swing.GroupLayout(Question);
        Question.setLayout(QuestionLayout);
        QuestionLayout.setHorizontalGroup(
            QuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, QuestionLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(QuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(QuestionLayout.createSequentialGroup()
                        .addComponent(Retour, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(132, 132, 132)
                        .addComponent(SupprimerQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Suivant3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, QuestionLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tquestion, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(AjouterQuestion)))
                .addGap(75, 75, 75))
        );
        QuestionLayout.setVerticalGroup(
            QuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, QuestionLayout.createSequentialGroup()
                .addGroup(QuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(QuestionLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(QuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(AjouterQuestion)
                            .addComponent(tquestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(QuestionLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(QuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(QuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SupprimerQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Retour, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Suivant3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
        );

        jTabbedPane1.addTab("tab3", Question);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 680, 470));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
      d.setEnabled(true);
        dispose();
    }//GEN-LAST:event_formWindowClosing

    private void SuivantSectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuivantSectionActionPerformed
        // TODO add your handling code here:
        if(!tcheck.getText().isEmpty()){
            
             check.setDescription(tcheck.getText());
        jTabbedPane1.setSelectedIndex(1);
        }
    }//GEN-LAST:event_SuivantSectionActionPerformed

    private void tabsectionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabsectionMouseClicked
        // TODO add your handling code here:
             
               System.out.println("selectedrow = "+selectedrow+"\n");
//              tsection.setText(tabsection.getValueAt(row, 0).toString());
    }//GEN-LAST:event_tabsectionMouseClicked

    private void SuivantQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuivantQuestionActionPerformed
        // TODO add your handling code here:
  int row = tabsection.getRowCount();
    selectedrow =  tabsection.getSelectedRow();
  if(row != -1 && selectedrow != -1)
  {
      section.setId(Integer.parseInt(tabsection.getValueAt(selectedrow, -1).toString()));
      section.setDescription(tabsection.getValueAt(selectedrow, 0).toString());
       tabquestion.removeAll();

          try {
              if(question.ToResultSet(section.getId()).next() && questions.get(selectedrow).getRowCount() == 0 )
                             questions.get(selectedrow).copy(question.ToResultSet(section.getId()));
                  tabquestion.setModel(questions.get(selectedrow));
          } catch (SQLException ex) {
              Logger.getLogger(ajoutercheckliste.class.getName()).log(Level.SEVERE, null, ex);
          }

        jTabbedPane1.setSelectedIndex(2);
  }

    }//GEN-LAST:event_SuivantQuestionActionPerformed

    private void tabquestionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabquestionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabquestionMouseClicked

    private void Suivant3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Suivant3ActionPerformed
        // TODO add your handling code here:
        System.out.println("Terminer : \n les tables de question  : "+questions.size()+"\n");
        
        Iterator<CustomTableModel> it =  questions.iterator() ;
        String s="";
        int i=0;
          while(it.hasNext()){
              CustomTableModel var =it.next();
        if(   var.getRowCount() == 0 )
            s=s+tabsection.getValueAt(i, 0).toString()+"\n";
            i++;
          }
                                  if(!s.isEmpty()){
                                      int result = JOptionPane.showConfirmDialog(null, "Il y a la/les section(s) : \n  "
                                          +s+"\n  n'a/ont pas des questions !!!!!!!!"
                                          + "\n Vous voullez vraiment terminer ?  "
                            , "Confirmation", JOptionPane.OK_CANCEL_OPTION);
        
        if (result == JOptionPane.OK_OPTION) {
        
            commit();
            
          if(update) JOptionPane.showMessageDialog(null, "Vous avez bien modifié check list !",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            else JOptionPane.showMessageDialog(null, "Vous avez bien créer une nouvelle check list !",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        else return ;
                                  }
                                  else {
                                        commit();
            if(update) JOptionPane.showMessageDialog(null, "Vous avez bien modifié check list !",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            else JOptionPane.showMessageDialog(null, "Vous avez bien créer une nouvelle check list !",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
           
                                  }
        d.setEnabled(true);
        d.load_CheckList();
       d=null;
       dispose();
    }//GEN-LAST:event_Suivant3ActionPerformed

    private void RetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetourActionPerformed
        // TODO add your handling code here:
             jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_RetourActionPerformed

boolean frst=true;
     
    private void AjouterSectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjouterSectionActionPerformed
        // TODO add your handling code here:
        if(!tsection.getText().isEmpty()){
             Object [] [] data = new Object [0][0];
            questions.add( (new CustomTableModel(data)) );
            section=new Section(tsection.getText());
            if(frst && update) {
                section.setId(section.get_id()+1);
                frst=false;
                
                System.out.println("static id  = "+section.getId()+"\n max id = "+section.get_id()+"\n");
            }
            
  Object  [] newRowData = {section.getId(), tsection.getText()};
           if(update)    SectionModel1.addRow(section.getId(), tsection.getText());
           else     SectionModel.addRow(section.getId(), tsection.getText());
       // load_Section();

        tsection.setText("");
       tsection.requestFocus();
        }
    }//GEN-LAST:event_AjouterSectionActionPerformed

    private void RetourCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetourCheckActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_RetourCheckActionPerformed

    private void SupprimerSectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupprimerSectionActionPerformed
        // TODO add your handling code here:
        
              int row = tabsection.getSelectedRow();
        if(row !=-1 ){
            
             int result = JOptionPane.showConfirmDialog(null, "la suppression d'une section va supprimer aussi "
                     + "les questions associés  !!!  \n  Voullez  vous  vraiment la supprimer ? \n  "
                            , "Confirmation", JOptionPane.OK_CANCEL_OPTION);
        
        if (result == JOptionPane.OK_OPTION) {
        
                 questions.remove(row);
if(update)   {
    section.deleteSection(new Section(Integer.parseInt(tabsection.getValueAt(row, -1).toString())
            ,check.getId(),tabsection.getValueAt(row, 0).toString()));
       SectionModel1.removeRow(row);
}
else      SectionModel.removeRow(row);
            
           JOptionPane.showMessageDialog(null, "Vous avez bien supprimer une  check list !",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
        }
   // load_Section();
        }
      selectedrow=row;
    }//GEN-LAST:event_SupprimerSectionActionPerformed

    private void SupprimerQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupprimerQuestionActionPerformed
        // TODO add your handling code here:
        
                      int row = tabquestion.getSelectedRow();
        if(row !=-1 ){
         selectedrow =  tabsection.getSelectedRow();
         if(update)   
    question.deleteQuestion(new Question(Integer.parseInt(tabquestion.getValueAt(row, -1).toString())
            ,Integer.parseInt(tabsection.getValueAt(selectedrow, -1).toString()),tabquestion.getValueAt(row, 0).toString()));
      
        questions.get(selectedrow).removeRow(row);
   // load_Question();
            
        }
    }//GEN-LAST:event_SupprimerQuestionActionPerformed

    private void QuiterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuiterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QuiterActionPerformed

    private void QuiterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_QuiterMouseClicked
        // TODO add your handling code here:
       d.setEnabled(true);
      d=null;
        dispose();
    }//GEN-LAST:event_QuiterMouseClicked

    private void tcheckInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tcheckInputMethodTextChanged
        // TODO add your handling code here:
        check.setDescription(tcheck.getText());
    }//GEN-LAST:event_tcheckInputMethodTextChanged

    private void tcheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcheckActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tcheckActionPerformed

    private void tquestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tquestionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tquestionActionPerformed
boolean frst1=true;
    private void AjouterQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjouterQuestionActionPerformed
        // TODO add your handling code here:
          selectedrow =  tabsection.getSelectedRow();
           System.out.println("exterieru static id  = "+(new Question()).getId()+"\n");
                if(!tquestion.getText().isEmpty()){
                    
                                    if(frst1 && update) {
                question.setId(question.get_id());
                frst1=false;
                
                System.out.println("static id  = "+question.getId()+"\n max id = "+question.get_id()+"\n");
            }
                                    
                
               question = new Question(section.getId(),tquestion.getText());          
    System.out.println("static id  = "+question.getId()+"\n");
             if(update)   questions.get(selectedrow).addRow( question.getId_update() ,tquestion.getText());
             
             else   questions.get(selectedrow).addRow( section.getId(),tquestion.getText());
            
              
       // load_Question();
        tquestion.setText("");
       tquestion.requestFocus();
        
                }
    }//GEN-LAST:event_AjouterQuestionActionPerformed

    /**
     * @param args the command line arguments
     */
//      public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ajoutercheckliste().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AjouterQuestion;
    private javax.swing.JButton AjouterSection;
    private javax.swing.JPanel Check_List;
    private javax.swing.JPanel Question;
    private javax.swing.JButton Quiter;
    private javax.swing.JButton Retour;
    private javax.swing.JButton RetourCheck;
    private javax.swing.JPanel Section;
    private javax.swing.JButton Suivant3;
    private javax.swing.JButton SuivantQuestion;
    private javax.swing.JButton SuivantSection;
    private javax.swing.JButton SupprimerQuestion;
    private javax.swing.JButton SupprimerSection;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tabquestion;
    private javax.swing.JTable tabsection;
    private javax.swing.JTextField tcheck;
    private javax.swing.JTextField tquestion;
    private javax.swing.JTextField tsection;
    // End of variables declaration//GEN-END:variables
}
