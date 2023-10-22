/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package idao;

import com.toedter.calendar.JDayChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author maejj
 */
public class Dashboard extends javax.swing.JFrame {
iutilisateur a = new iutilisateur();
Site b = new Site();
private static final Color GREEN_COLOR = new Color(100, 255, 100);
 private static final Color RED_COLOR = new Color(255, 100, 100); 
    private static final Color BLUE_COLOR = new Color(0, 0 , 150);

    /**
     * Creates new form Dashboard
     */
 public Dashboard() {
        initComponents();
           
        
          ImageIcon logoIcon = new ImageIcon("./img/COFICAB.png"); // Replace "logo.png" with your logo file path
          ImageIcon logoIcon1 = new ImageIcon("./img/COFICAB.jpeg"); 
        // Set the logo as the JFrame icon
        setIconImage(logoIcon1.getImage());
    
        logo.setIcon(logoIcon);
          logo.setHorizontalAlignment(JLabel.CENTER);
        logo.setVerticalAlignment(JLabel.CENTER);
        
              Tpays.removeAllItems();
        Tville.removeAllItems();
        Tnom.removeAllItems();
        Tpays.setEditable(true) ;
        Tville.setEditable(true) ;
        Tnom.setEditable(true) ;
        load_list();

    }
 
    public Dashboard(iutilisateur u) {
        initComponents();
            user.setText(u.getUser().getNom()+" "+u.getUser().getPrenom());
        
          ImageIcon logoIcon = new ImageIcon("./img/COFICAB.png"); // Replace "logo.png" with your logo file path
          ImageIcon logoIcon1 = new ImageIcon("./img/COFICAB.jpeg"); 
        // Set the logo as the JFrame icon
        setIconImage(logoIcon1.getImage());
    
        logo.setIcon(logoIcon);
          logo.setHorizontalAlignment(JLabel.CENTER);
        logo.setVerticalAlignment(JLabel.CENTER);
        
              Tpays.removeAllItems();
        Tville.removeAllItems();
        Tnom.removeAllItems();
        Tpays.setEditable(true) ;
        Tville.setEditable(true) ;
        Tnom.setEditable(true) ;
        load_list();

    }
        public  void load_Audit(){
        
        Object [][]  data = new Object[0][0]; 
        
       CustomAuditTableModel x =   new CustomAuditTableModel(data,false);//Planning
    
       x.copy((new iaudit()).ToResultSet());

       tabaudit.setModel( x);
    
    }
            public void load_actions(){
        
    tabAction.setModel(new MonModele((new Action()).ToResultSet()));
    
    }
        
            void load(String a,String b ){//remplir la table audit filtré
        
        Object [][]  data = new Object[0][0]; 
        
       CustomAuditTableModel x =   new CustomAuditTableModel(data,false);
    
       x.copy((new iaudit()).ToResultSet(a,b));
       tabaudit.setModel( x);
    
    }
            
            
    private void load_list(){
            Site s = new Site();
         
             Iterator<Site> it =    s.lister_ord().iterator() ;
          String a="",b="",c="";
          while(it.hasNext()){
              Site var = it.next();
              if(!a.equals(var.getPays()))
        Tpays.addItem(var.getPays());
              if(!b.equals(var.getVille()))
        Tville.addItem(var.getVille());
              if(!c.equals(var.getNom()))
        Tnom.addItem(var.getNom());
              a=var.getPays();
              b=var.getVille();
              c=var.getNom();
        }
        
        }
    public void load_utilisateurs(){
        
    tabuser.setModel(new MonModele(a.ToResultSet()));
    }
        public void load_CheckList(){
              Object [][] data=new Object [0][0];
           CustomTableModel  model = new CustomTableModel(data);
            model.copy_Check((new CheckList()).ToResultSet() );
        
    tabCheck.setModel(model);
    
    
   //  SectionModel1.copy(section.ToResultSet(check.getId()) );
    }
        
      public void load_sites(){
      
   Object[][] data = new Object[0][0];


        String[] columnNames = {"Pays", "Ville", "Nom"};

        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);

        
        
                
          Iterator<Site> it =  b.lister().iterator() ;
          int i=0;
          while(it.hasNext()){
              Site var = it.next();

               String [] newRowData = {var.getPays(), var.getVille(), var.getNom()};
//              tableModel.removeRow(0);
 tableModel.addRow(newRowData);
            
          }
         
        
  Tsites.setModel(tableModel);
    }
      
          void load_site(){// remplir la liste des site dans l'audit
              tsite.removeAllItems();
         Site s = new Site();
         
             Iterator<Site> it =    s.lister().iterator() ;
             
     tsite.addItem(" ");
          while(it.hasNext())  tsite.addItem(it.next().toString());
    }
    void load_departement(){// remplir la liste des departement  dans l'audit
        tdpartement.removeAllItems();
         iutilisateur s = new iutilisateur();
         
             Iterator<String> it =   s.lister_departement().iterator();
     tdpartement.addItem(" ");
          while(it.hasNext())  tdpartement.addItem(it.next());
    } 
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        AuditButton = new javax.swing.JButton();
        DashButton = new javax.swing.JButton();
        PlanButton = new javax.swing.JButton();
        ActionButton = new javax.swing.JButton();
        Parametres = new javax.swing.JButton();
        signout = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        DashboardPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        UtilisateurPanel = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        AjouterUtilisateur = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabuser = new javax.swing.JTable();
        SitePanel = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tsites = new javax.swing.JTable();
        Tville = new javax.swing.JComboBox<>();
        Tnom = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Tpays = new javax.swing.JComboBox<>();
        ActionButton2 = new javax.swing.JButton();
        ActionButton1 = new javax.swing.JButton();
        PlannificationPanel = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        AfficherPlanning = new javax.swing.JButton();
        cal = new com.toedter.calendar.JCalendar();
        AuditPanel = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabaudit =  new JTable(){
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component component = super.prepareRenderer(renderer, row, column);

                if (!isRowSelected(row)) {
                    Date currentDate = new Date(); // Get the current date
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                    // Get the "Date Limite" value from the table model (assuming it's in column index 4)
                    Object dateLimiteValue = getModel().getValueAt(row, 5);
                    String NiveauValue = getModel().getValueAt(row, 7).toString();
                    if (dateLimiteValue instanceof String) {
                        try {
                            Date dateLimite = dateFormat.parse((String) dateLimiteValue);

                            if(NiveauValue!="" ){
                                component.setBackground(GREEN_COLOR);

                            }

                            else if (dateLimite.before(currentDate)) {
                                component.setBackground(RED_COLOR);
                            } else {
                                component.setBackground(BLUE_COLOR);
                            }
                        } catch (java.text.ParseException ex) {
                            // Handle parsing exception if needed
                        }
                    } else {
                        component.setBackground(getBackground());
                    }
                }

                return component;
            }
        };
        ;
        supprimerAudit = new javax.swing.JButton();
        ModifierAudit = new javax.swing.JButton();
        EffectuerAudit = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        tsite = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        tdpartement = new javax.swing.JComboBox<>();
        Rénititialer = new javax.swing.JButton();
        ExtractionAudit = new javax.swing.JButton();
        ActionPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabAction = new javax.swing.JTable();
        Settings = new javax.swing.JPanel();
        SiteButton = new javax.swing.JButton();
        UserButton = new javax.swing.JButton();
        ChekListButton = new javax.swing.JButton();
        CheckList = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabCheck = new javax.swing.JTable();
        AjouterCheckListe = new javax.swing.JButton();
        ModifierCheck = new javax.swing.JButton();
        SupprimerCheck = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Audig");
        getContentPane().setLayout(new java.awt.FlowLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(user, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 170));

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        AuditButton.setText("Audits");
        AuditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AuditButtonActionPerformed(evt);
            }
        });

        DashButton.setText("Dashboard");
        DashButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DashButtonActionPerformed(evt);
            }
        });

        PlanButton.setText("Planning");
        PlanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlanButtonActionPerformed(evt);
            }
        });

        ActionButton.setText("Plan d'action");
        ActionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionButtonActionPerformed(evt);
            }
        });

        Parametres.setText("Paramètres");
        Parametres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ParametresActionPerformed(evt);
            }
        });

        signout.setBackground(new java.awt.Color(255, 51, 51));
        signout.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        signout.setForeground(new java.awt.Color(255, 255, 255));
        signout.setText("Se Déconnecter");
        signout.setBorder(null);
        signout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(DashButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PlanButton, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                        .addComponent(AuditButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ActionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(Parametres, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(signout, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(DashButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PlanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AuditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ActionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Parametres, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(signout, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 130, 490));

        jLabel1.setBackground(new java.awt.Color(255, 204, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setText("Dashboard Here");

        javax.swing.GroupLayout DashboardPanelLayout = new javax.swing.GroupLayout(DashboardPanel);
        DashboardPanel.setLayout(DashboardPanelLayout);
        DashboardPanelLayout.setHorizontalGroup(
            DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardPanelLayout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(334, Short.MAX_VALUE))
        );
        DashboardPanelLayout.setVerticalGroup(
            DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardPanelLayout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(jLabel1)
                .addContainerGap(231, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab4", DashboardPanel);

        AjouterUtilisateur.setBackground(new java.awt.Color(0, 204, 51));
        AjouterUtilisateur.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AjouterUtilisateur.setForeground(new java.awt.Color(255, 255, 255));
        AjouterUtilisateur.setText("AJOUTER");
        AjouterUtilisateur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjouterUtilisateurActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(102, 153, 255));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("MODIFIER");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 51, 51));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("SUPPRIMER");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        tabuser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabuser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabuserMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabuser);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(AjouterUtilisateur, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(273, 273, 273)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 842, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AjouterUtilisateur, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout UtilisateurPanelLayout = new javax.swing.GroupLayout(UtilisateurPanel);
        UtilisateurPanel.setLayout(UtilisateurPanelLayout);
        UtilisateurPanelLayout.setHorizontalGroup(
            UtilisateurPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 940, Short.MAX_VALUE)
            .addGroup(UtilisateurPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UtilisateurPanelLayout.createSequentialGroup()
                    .addContainerGap(24, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        UtilisateurPanelLayout.setVerticalGroup(
            UtilisateurPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 492, Short.MAX_VALUE)
            .addGroup(UtilisateurPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UtilisateurPanelLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("tab1", UtilisateurPanel);

        Tsites.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Pays", "Ville", "Nom"
            }
        ));
        jScrollPane3.setViewportView(Tsites);

        Tville.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        Tnom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Tnom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TnomActionPerformed(evt);
            }
        });

        jLabel9.setText("Pays ");

        jLabel10.setText("Ville ");

        jLabel11.setText("Nom");

        Tpays.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Tpays.setToolTipText("");

        ActionButton2.setBackground(new java.awt.Color(255, 51, 51));
        ActionButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ActionButton2.setForeground(new java.awt.Color(255, 255, 255));
        ActionButton2.setText("SUPPRIMER");
        ActionButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionButton2ActionPerformed(evt);
            }
        });

        ActionButton1.setBackground(new java.awt.Color(0, 204, 51));
        ActionButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ActionButton1.setForeground(new java.awt.Color(255, 255, 255));
        ActionButton1.setText("AJOUTER");
        ActionButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(148, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Tville, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Tnom, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(Tpays, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(196, 196, 196)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ActionButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ActionButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 263, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(Tpays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(Tville, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(Tnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(ActionButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ActionButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout SitePanelLayout = new javax.swing.GroupLayout(SitePanel);
        SitePanel.setLayout(SitePanelLayout);
        SitePanelLayout.setHorizontalGroup(
            SitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SitePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        SitePanelLayout.setVerticalGroup(
            SitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SitePanelLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab2", SitePanel);

        AfficherPlanning.setText("AFFICHER");
        AfficherPlanning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AfficherPlanningActionPerformed(evt);
            }
        });

        cal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                calPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(681, Short.MAX_VALUE)
                .addComponent(AfficherPlanning, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(cal, javax.swing.GroupLayout.PREFERRED_SIZE, 914, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(20, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(435, Short.MAX_VALUE)
                .addComponent(AfficherPlanning, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(cal, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(61, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout PlannificationPanelLayout = new javax.swing.GroupLayout(PlannificationPanel);
        PlannificationPanel.setLayout(PlannificationPanelLayout);
        PlannificationPanelLayout.setHorizontalGroup(
            PlannificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PlannificationPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PlannificationPanelLayout.setVerticalGroup(
            PlannificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PlannificationPanelLayout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("tab5", PlannificationPanel);

        tabaudit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabaudit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabauditMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tabaudit);

        supprimerAudit.setBackground(new java.awt.Color(255, 51, 51));
        supprimerAudit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        supprimerAudit.setForeground(new java.awt.Color(255, 255, 255));
        supprimerAudit.setText("SUPPRIMER");
        supprimerAudit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerAuditActionPerformed(evt);
            }
        });

        ModifierAudit.setBackground(new java.awt.Color(102, 153, 255));
        ModifierAudit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ModifierAudit.setForeground(new java.awt.Color(255, 255, 255));
        ModifierAudit.setText("MODIFIER");
        ModifierAudit.setPreferredSize(new java.awt.Dimension(97, 23));
        ModifierAudit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifierAuditActionPerformed(evt);
            }
        });

        EffectuerAudit.setBackground(new java.awt.Color(0, 204, 51));
        EffectuerAudit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        EffectuerAudit.setText("EFFECTUER");
        EffectuerAudit.setPreferredSize(new java.awt.Dimension(97, 23));
        EffectuerAudit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EffectuerAuditActionPerformed(evt);
            }
        });

        jLabel12.setText("Site");

        tsite.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tsiteItemStateChanged(evt);
            }
        });

        jLabel13.setText("Departement ");

        tdpartement.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tdpartementItemStateChanged(evt);
            }
        });

        Rénititialer.setText("Rénititialer");
        Rénititialer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RénititialerActionPerformed(evt);
            }
        });

        ExtractionAudit.setBackground(new java.awt.Color(102, 153, 255));
        ExtractionAudit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ExtractionAudit.setForeground(new java.awt.Color(255, 255, 255));
        ExtractionAudit.setText("Extraction Excel");
        ExtractionAudit.setPreferredSize(new java.awt.Dimension(97, 23));
        ExtractionAudit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExtractionAuditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(EffectuerAudit, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(ModifierAudit, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(ExtractionAudit, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(supprimerAudit, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tsite, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tdpartement, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124)
                        .addComponent(Rénititialer))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 886, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tsite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tdpartement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(Rénititialer))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(supprimerAudit, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(ExtractionAudit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ModifierAudit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EffectuerAudit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout AuditPanelLayout = new javax.swing.GroupLayout(AuditPanel);
        AuditPanel.setLayout(AuditPanelLayout);
        AuditPanelLayout.setHorizontalGroup(
            AuditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AuditPanelLayout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        AuditPanelLayout.setVerticalGroup(
            AuditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab3", AuditPanel);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel3.setText("Listes des actions ");

        tabAction.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabAction.setName(""); // NOI18N
        tabAction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabActionMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tabAction);

        javax.swing.GroupLayout ActionPanelLayout = new javax.swing.GroupLayout(ActionPanel);
        ActionPanel.setLayout(ActionPanelLayout);
        ActionPanelLayout.setHorizontalGroup(
            ActionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ActionPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(ActionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 886, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ActionPanelLayout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 365, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        ActionPanelLayout.setVerticalGroup(
            ActionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ActionPanelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        jTabbedPane1.addTab("tab6", ActionPanel);

        SiteButton.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        SiteButton.setText("Sites");
        SiteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiteButtonActionPerformed(evt);
            }
        });

        UserButton.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        UserButton.setText("Utilisateurs");
        UserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserButtonActionPerformed(evt);
            }
        });

        ChekListButton.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        ChekListButton.setText("CheckList");
        ChekListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChekListButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SettingsLayout = new javax.swing.GroupLayout(Settings);
        Settings.setLayout(SettingsLayout);
        SettingsLayout.setHorizontalGroup(
            SettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SettingsLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(SiteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(UserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110)
                .addComponent(ChekListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
        );
        SettingsLayout.setVerticalGroup(
            SettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SettingsLayout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addGroup(SettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SiteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChekListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(174, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab7", Settings);

        tabCheck.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabCheck.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabCheckMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabCheck);

        AjouterCheckListe.setBackground(new java.awt.Color(0, 204, 51));
        AjouterCheckListe.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AjouterCheckListe.setForeground(new java.awt.Color(255, 255, 255));
        AjouterCheckListe.setText("AJOUTER");
        AjouterCheckListe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjouterCheckListeActionPerformed(evt);
            }
        });

        ModifierCheck.setBackground(new java.awt.Color(51, 153, 255));
        ModifierCheck.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ModifierCheck.setForeground(new java.awt.Color(255, 255, 255));
        ModifierCheck.setText("MODIFIER");
        ModifierCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifierCheckActionPerformed(evt);
            }
        });

        SupprimerCheck.setBackground(new java.awt.Color(255, 51, 51));
        SupprimerCheck.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SupprimerCheck.setForeground(new java.awt.Color(255, 255, 255));
        SupprimerCheck.setText("SUPPRIMER");
        SupprimerCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupprimerCheckActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 1, 36)); // NOI18N
        jLabel2.setText("Chek-Listes");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(AjouterCheckListe, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
                .addComponent(ModifierCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(177, 177, 177)
                .addComponent(SupprimerCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(336, 336, 336)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 889, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(24, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AjouterCheckListe, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel2)
                        .addGap(336, 336, 336)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ModifierCheck, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(SupprimerCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(34, 34, 34))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(76, 76, 76)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(92, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout CheckListLayout = new javax.swing.GroupLayout(CheckList);
        CheckList.setLayout(CheckListLayout);
        CheckListLayout.setHorizontalGroup(
            CheckListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CheckListLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        CheckListLayout.setVerticalGroup(
            CheckListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CheckListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab8", CheckList);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 940, 520));

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserButtonActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
        load_utilisateurs();
    }//GEN-LAST:event_UserButtonActionPerformed

    private void SiteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiteButtonActionPerformed
        jTabbedPane1.setSelectedIndex(2);
         load_sites();
         
        // TODO add your handling code here:
    }//GEN-LAST:event_SiteButtonActionPerformed

    private void AuditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AuditButtonActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(4);
        load_Audit();
        load_site();
        load_departement();
    }//GEN-LAST:event_AuditButtonActionPerformed

    private void tabuserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabuserMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tabuserMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:

        int row = tabuser.getSelectedRow();
        if(row != -1 )  {

            iutilisateur a = new iutilisateur();
            utilisateur u =new utilisateur(tabuser.getValueAt(row, 6).toString());
            a.delete(u);
            load_utilisateurs();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int row = tabuser.getSelectedRow();
        if(row != -1 )  {
            setEnabled(false);
            ajouteruser u = new ajouteruser(this,new utilisateur(tabuser.getValueAt(row, 3-1).toString(),tabuser.getValueAt(row, 1-1).toString()
                ,tabuser.getValueAt(row, 2-1).toString(),tabuser.getValueAt(row, 5-1).toString(),tabuser.getValueAt(row, 6-1).toString(),
                    tabuser.getValueAt(row, 4-1).toString(),
                tabuser.getValueAt(row, 7-1).toString()
                    ,     new Site ( tabuser.getValueAt(row, 8-1).toString()),Boolean.valueOf(tabuser.getValueAt(row, 9-1).toString())));
        u.setVisible(true);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void AjouterUtilisateurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjouterUtilisateurActionPerformed
        // TODO add your handling code here:
        setEnabled(false);
        ajouteruser u = new ajouteruser(this);
        u.setVisible(true);
    }//GEN-LAST:event_AjouterUtilisateurActionPerformed

    private void PlanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlanButtonActionPerformed
        // TODO add your handling code here:
                jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_PlanButtonActionPerformed

    private void DashButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DashButtonActionPerformed
        // TODO add your handling code here
                jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_DashButtonActionPerformed

    private void ActionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActionButtonActionPerformed
        // TODO add your handling code here:
                jTabbedPane1.setSelectedIndex(5);
                
                      load_actions();
    }//GEN-LAST:event_ActionButtonActionPerformed

    private void ActionButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActionButton1ActionPerformed
        // TODO add your handling code here:
        Site s = new Site();
        s.add( new Site(Tpays.getSelectedItem().toString(),Tville.getSelectedItem().toString(),Tnom.getSelectedItem().toString()));
        load_sites();
    }//GEN-LAST:event_ActionButton1ActionPerformed

    private void ActionButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActionButton2ActionPerformed
        // TODO add your handling code here:
        
                           int result = JOptionPane.showConfirmDialog(null, "Vous voullez vraiment supprimer ce site ?"
                             + " \nLes auditeurs de ce site vont être supprimés aussi!!!!", "Confirmation", JOptionPane.OK_CANCEL_OPTION);
        
        if (result == JOptionPane.OK_OPTION) {
            int row = Tsites.getSelectedRow();
            new Site().delete(new Site(Tsites.getValueAt(row, 0).toString()
                    ,Tsites.getValueAt(row, 1).toString(),Tsites.getValueAt(row, 2).toString()));
            load_sites();
        } 
    }//GEN-LAST:event_ActionButton2ActionPerformed

    private void ParametresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ParametresActionPerformed
        // TODO add your handling code here:
                        jTabbedPane1.setSelectedIndex(6);
    }//GEN-LAST:event_ParametresActionPerformed

    private void signoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signoutActionPerformed
        // TODO add your handling code here:
            this.dispose(); // fermer la fenêtre actuelle
    Login loginFrame = new Login(); // créer une nouvelle instance de la fenêtre de connexion
    loginFrame.setVisible(true); // afficher la fenêtre de connexion
    }//GEN-LAST:event_signoutActionPerformed

    private void TnomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TnomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TnomActionPerformed

    private void ChekListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChekListButtonActionPerformed
        // TODO add your handling code here:
        load_CheckList();
                        jTabbedPane1.setSelectedIndex(7);
    }//GEN-LAST:event_ChekListButtonActionPerformed

    private void tabCheckMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabCheckMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabCheckMouseClicked

    private void AjouterCheckListeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjouterCheckListeActionPerformed
        // TODO add your handling code here:
        setEnabled(false);
        ajoutercheckliste u = new ajoutercheckliste(this);
        u.setVisible(true);
    }//GEN-LAST:event_AjouterCheckListeActionPerformed

    private void ModifierCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifierCheckActionPerformed
        // TODO add your handling code here:
                int row = tabCheck.getSelectedRow();
        if(row != -1 )  {
            setEnabled(false);
            ajoutercheckliste u = new ajoutercheckliste(this,new CheckList(Integer.parseInt(tabCheck.getValueAt(row, -1).toString())
                    ,tabCheck.getValueAt(row, 0).toString()) ) ;
        u.setVisible(true);
        }
        
    }//GEN-LAST:event_ModifierCheckActionPerformed

    private void SupprimerCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupprimerCheckActionPerformed
        // TODO add your handling code here:
        int row = tabCheck.getSelectedRow();
        if(row != -1){
            
                                           
                                      int result = JOptionPane.showConfirmDialog(null, "Vous voulez vraiment supprimer une check list !!!!!!1"
                                              + "\n Cela va introduire la suppression des sections et des questions associés !!! "
                            , "Confirmation", JOptionPane.OK_CANCEL_OPTION);
        
        if (result == JOptionPane.OK_OPTION) {
        
   (new CheckList()).delete(new CheckList(
           Integer.parseInt(tabCheck.getValueAt(row, -1).toString())
           ,tabCheck.getValueAt(row, 0).toString()));
            
           JOptionPane.showMessageDialog(null, "Vous avez bien supprimer une  check list !",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
           load_CheckList();
        }
            
            
            
        }
    }//GEN-LAST:event_SupprimerCheckActionPerformed

    private void calPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_calPropertyChange
        // TODO add your handling code here:
        
           
       
    }//GEN-LAST:event_calPropertyChange

    private void AfficherPlanningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfficherPlanningActionPerformed
        // TODO add your handling code here:
        
 Date selectedDate = cal.getDate();
          Date now = new Date();
          
               SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
             
        String formattedDate = dateFormat.format(selectedDate);
        String formattedTime = timeFormat.format(now.getTime());
    
        System.out.println("Formatted date: " + formattedDate+" "+formattedTime);
        
         setEnabled(false);
       GestionPlanning u = new  GestionPlanning(this ,  formattedDate,formattedTime );
        u.setVisible(true);
        
    }//GEN-LAST:event_AfficherPlanningActionPerformed

    private void EffectuerAuditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EffectuerAuditActionPerformed
        // TODO add your handling code here:
   int row = tabaudit.getSelectedRow();
        if(row != -1 &&  "".equals(tabaudit.getValueAt(row, 4).toString())){
           int id = Integer.parseInt(tabaudit.getValueAt(row, 0).toString());
           String auditeur =tabaudit.getValueAt(row, 1).toString();
           CheckList ch = new CheckList(tabaudit.getValueAt(row, 2).toString());
            System.out.println("check list : "+ch.getDescription()+"\n");
           String date_creation = tabaudit.getValueAt(row, 3).toString();
           String date_realisation = tabaudit.getValueAt(row, 4).toString();
           String date_limite = tabaudit.getValueAt(row, 5).toString();
           float score = Float.parseFloat(tabaudit.getValueAt(row, 6).toString());
             String niveau = tabaudit.getValueAt(row, 7).toString();                              
                                     
          //  System.out.println("date_realisation : "+date_realisation+"\n"+"score : "+score+"\n"+"niveau : "+niveau+"\n");
     
         setEnabled(false);
      DynamicComponentsExample u = new  DynamicComponentsExample (this , new Audit(id,auditeur,ch
              ,date_creation,date_realisation,date_limite,score,niveau) );       
        } 
        
    }//GEN-LAST:event_EffectuerAuditActionPerformed

    private void ModifierAuditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifierAuditActionPerformed
        // TODO add your handling code here:
        
              int row = tabaudit.getSelectedRow();
        if(row != -1 &&  !"".equals(tabaudit.getValueAt(row, 4).toString())){
           int id = Integer.parseInt(tabaudit.getValueAt(row, 0).toString());
           String auditeur =tabaudit.getValueAt(row, 0).toString();
           CheckList ch = new CheckList(tabaudit.getValueAt(row, 2).toString());
            System.out.println("check list : "+ch.getDescription()+"\n");
           String date_creation = tabaudit.getValueAt(row, 3).toString();
           String date_realisation = tabaudit.getValueAt(row,4).toString();
           String date_limite = tabaudit.getValueAt(row, 5).toString();
           float score = Float.parseFloat(tabaudit.getValueAt(row,6).toString());
             String niveau = tabaudit.getValueAt(row, 7).toString();                              
                                     
          //  System.out.println("date_realisation : "+date_realisation+"\n"+"score : "+score+"\n"+"niveau : "+niveau+"\n");
     
         setEnabled(false);
      DynamicComponentsExample u = new  DynamicComponentsExample (this , new Audit(id,auditeur,ch
              ,date_creation,date_realisation,date_limite,score,niveau),true );       
        } 
        
    }//GEN-LAST:event_ModifierAuditActionPerformed

    private void supprimerAuditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerAuditActionPerformed
        // TODO add your handling code here:
                 int row = tabaudit.getSelectedRow();
        if(row != -1){
            
                                           
                                      int result = JOptionPane.showConfirmDialog(null, "Voulez vous  vraiment supprimer un audit  !!!!!!1"
                                              + "\n Cela va introduire la suppression des reponses  et  actions  associées !!! "
                            , "Confirmation", JOptionPane.OK_CANCEL_OPTION);
        
        if (result == JOptionPane.OK_OPTION) {
        
       int id = Integer.parseInt(tabaudit.getValueAt(row, 0).toString());
       Audit a=new Audit(id);
       (new iaudit()).delete(a);
       load_Audit();
       
        }
            
            
            
        }
    }//GEN-LAST:event_supprimerAuditActionPerformed

    private void tabauditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabauditMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabauditMouseClicked

    private void tsiteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tsiteItemStateChanged
        // TODO add your handling code here:

        if( tsite.getSelectedItem() != null &&   tdpartement.getSelectedItem()!= null ){
            if(!" ".equals(tsite.getSelectedItem().toString()) || !" ".equals(tdpartement.getSelectedItem().toString()))
            load(tsite.getSelectedItem().toString() , tdpartement.getSelectedItem().toString() );

        }
        else   if( tsite.getSelectedItem() != null ){
            if(!" ".equals(tsite.getSelectedItem().toString()) )
            load(tsite.getSelectedItem().toString()," " );
        }
        else if(    tdpartement.getSelectedItem()!= null ) {
            if(!" ".equals(tdpartement.getSelectedItem().toString()))
            load(" ", tdpartement.getSelectedItem().toString() );
        }

    }//GEN-LAST:event_tsiteItemStateChanged

    private void tdpartementItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tdpartementItemStateChanged
        // TODO add your handling code here:

        if( tsite.getSelectedItem() != null &&   tdpartement.getSelectedItem()!= null ){
            if(!" ".equals(tsite.getSelectedItem().toString()) || !" ".equals(tdpartement.getSelectedItem().toString()))
            load(tsite.getSelectedItem().toString() , tdpartement.getSelectedItem().toString() );

        }
        else   if( tsite.getSelectedItem() != null ){
            if(!" ".equals(tsite.getSelectedItem().toString()) )
            load(tsite.getSelectedItem().toString()," " );
        }
        else if(    tdpartement.getSelectedItem()!= null ) {
            if(!" ".equals(tdpartement.getSelectedItem().toString()))
            load(" ", tdpartement.getSelectedItem().toString() );
        }

    }//GEN-LAST:event_tdpartementItemStateChanged

    private void RénititialerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RénititialerActionPerformed
        // TODO add your handling code here:
        load_Audit();
        //load_list();
        tsite.setSelectedIndex(0);
        tdpartement.setSelectedIndex(0);
    }//GEN-LAST:event_RénititialerActionPerformed

    private void tabActionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabActionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabActionMouseClicked

    private void ExtractionAuditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExtractionAuditActionPerformed
        // TODO add your handling code here:
        
       int row = tabaudit.getSelectedRow();
        if(row != -1 &&  !"".equals(tabaudit.getValueAt(row, 4).toString())){
           int id = Integer.parseInt(tabaudit.getValueAt(row, 0).toString());
           String auditeur =tabaudit.getValueAt(row, 1).toString();
           CheckList ch = new CheckList(tabaudit.getValueAt(row, 2).toString());
            System.out.println("check list : "+ch.getDescription()+"\n");
           String date_creation = tabaudit.getValueAt(row, 3).toString();
           String date_realisation = tabaudit.getValueAt(row, 4).toString();
           String date_limite = tabaudit.getValueAt(row, 5).toString();
           float score = Float.parseFloat(tabaudit.getValueAt(row, 6).toString());
             String niveau = tabaudit.getValueAt(row, 7).toString();    
             
           try {
               (new  DynamicComponentsExample((new Audit(id,auditeur,ch
                       ,date_creation,date_realisation,date_limite,score,niveau)))).toExcel();
           } catch (Exception ex) {
               Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
           }
          
     JOptionPane.showMessageDialog(
                null,
                "Vous avez bien extrait un audit !!!!!!",
                "Information",
                JOptionPane.INFORMATION_MESSAGE
        );
          
        }
    }//GEN-LAST:event_ExtractionAuditActionPerformed

    
    
    

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ActionButton;
    private javax.swing.JButton ActionButton1;
    private javax.swing.JButton ActionButton2;
    private javax.swing.JPanel ActionPanel;
    private javax.swing.JButton AfficherPlanning;
    private javax.swing.JButton AjouterCheckListe;
    private javax.swing.JButton AjouterUtilisateur;
    private javax.swing.JButton AuditButton;
    private javax.swing.JPanel AuditPanel;
    private javax.swing.JPanel CheckList;
    private javax.swing.JButton ChekListButton;
    private javax.swing.JButton DashButton;
    private javax.swing.JPanel DashboardPanel;
    private javax.swing.JButton EffectuerAudit;
    private javax.swing.JButton ExtractionAudit;
    private javax.swing.JButton ModifierAudit;
    private javax.swing.JButton ModifierCheck;
    private javax.swing.JButton Parametres;
    private javax.swing.JButton PlanButton;
    private javax.swing.JPanel PlannificationPanel;
    private javax.swing.JButton Rénititialer;
    private javax.swing.JPanel Settings;
    private javax.swing.JButton SiteButton;
    private javax.swing.JPanel SitePanel;
    private javax.swing.JButton SupprimerCheck;
    private javax.swing.JComboBox<String> Tnom;
    private javax.swing.JComboBox<String> Tpays;
    private javax.swing.JTable Tsites;
    private javax.swing.JComboBox<String> Tville;
    private javax.swing.JButton UserButton;
    private javax.swing.JPanel UtilisateurPanel;
    private com.toedter.calendar.JCalendar cal;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel logo;
    private javax.swing.JButton signout;
    private javax.swing.JButton supprimerAudit;
    private javax.swing.JTable tabAction;
    private javax.swing.JTable tabCheck;
    private javax.swing.JTable tabaudit;
    private javax.swing.JTable tabuser;
    private javax.swing.JComboBox<String> tdpartement;
    private javax.swing.JComboBox<String> tsite;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}
