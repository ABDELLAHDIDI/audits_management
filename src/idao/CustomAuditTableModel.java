package idao;

import java.awt.Color;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public class CustomAuditTableModel extends AbstractTableModel {
    boolean a=false;
    private String[] columnNames = null;
    private Object[][] data;

    public CustomAuditTableModel(Object[][] data,boolean a) {
        this.a=a;
              if (a) 
            columnNames = new String[]{" N°d’audit", "Auditeur", "CheckList", "Date Création",  "Date Limite"};
         else 
            columnNames = new String[]{" N°d’audit", "Auditeur", "CheckList", "Date Création", "Date Réalisation", "Date Limite", "Score", "RatinI"};
        
              
        this.data = data;
    }

    @Override
    public int getColumnCount() {
        // Return the number of columns excluding the "ID" column
        return columnNames.length ;
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        // Skip the "ID" column when getting the value
        return data[row][col ];
    }

    @Override
    public String getColumnName(int col) {
        // Skip the "ID" column when getting the column name
        return columnNames[col ];
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        data[row][col ] = value;
        fireTableCellUpdated(row, col );
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        // Seule la colonne "Auditeur" est modifiable (colonne d'index 1)
        return col == 1;
    }

    public void addRow(int id, String auditeur, String checkList, java.lang.String date_creation, java.lang.String date_realisation, java.lang.String date_limite, float score, String niveau) {
          Object[] newRow ;
        if(a)   newRow  =  new Object[]  {id, auditeur, checkList, date_creation,date_limite};
        else  newRow = new Object[] {id, auditeur, checkList, date_creation, date_realisation, date_limite, score, niveau};
        
        Object[][] newData = new Object[data.length + 1][columnNames.length];

        // Copier les données existantes dans le nouveau tableau de données
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < columnNames.length; col++) {
                newData[row][col] = data[row][col];
            }
        }

        // Ajouter la nouvelle ligne à la fin du nouveau tableau de données
        newData[data.length] = newRow;
        data = newData;

        // Informer la table que les données ont changé
        fireTableDataChanged();
    }

    public void removeRow(int row) {
        Object[][] newData = new Object[data.length - 1][columnNames.length];
        // Copier les données existantes dans le nouveau tableau de données
        for (int row1 = 0, i = 0; i < data.length; i++) {
            if (i != row) {
                for (int col = 0; col < columnNames.length; col++) {
                    newData[row1][col] = data[i][col];
                }
                row1++;
            }
        }
        // Ajouter la nouvelle ligne à la fin du nouveau tableau de données
        data = newData;
        // Informer la table que la ligne a été supprimée
        fireTableRowsDeleted(row, row);
    }

//    public void copy(ResultSet oldData) {
//        try {
//            for (; oldData.next(); ) {
//        
//              Object    Auditeur , CheckList, Date_Création  , Date_Limite;
//              float Score=0;
//                String Niveau="", Date_Réalisation="";
//              if(oldData.getObject(5) != null ) 
//              {
//                        Date_Réalisation = oldData.getObject(5).toString();
//                        System.out.println("   Date_Réalisation =   "+oldData.getObject(5).toString()+"\n");
//              }
//              
//              if(oldData.getObject(7) != null)
//              {
//               Score= Float.parseFloat(oldData.getObject(7).toString());
//              }
//              if(oldData.getObject(8) != null)
//                     oldData.getObject(8).toString();
//                           
//              addRow(Integer.parseInt(oldData.getObject(1).toString()),
//                      oldData.getObject(3).toString(),
//                       (new CheckList(   Integer.parseInt(oldData.getObject(2).toString()) )).set_description(), 
//                       oldData.getObject(4).toString()
//                      , oldData.getObject(5).toString(),
//                        oldData.getObject(6).toString(),
//                        Score,
//                        Niveau);
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(CustomAuditTableModel.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("copy not ok\n");
//        }
//    }
    
    
    public void copy(ResultSet oldData) {
    try {
        for (; oldData.next(); ) {
            Object Auditeur, CheckList, Date_Création, Date_Limite;
            float Score = 0;
            String Niveau = "", Date_Réalisation = "";

            if (oldData.getObject(5) != null) {
                String dateValue = oldData.getObject(5).toString();
                if (!dateValue.equals("0000-00-00 00:00:00")) {
                    Date_Réalisation = dateValue;
                    System.out.println("Date_Réalisation = " + dateValue + "\n");
                } else {
                    Date_Réalisation = ""; // Handle the special case value
                    System.out.println("Date_Réalisation is '0000-00-00 00:00:00'\n");
                }
            }

            if (oldData.getObject(7) != null) {
                Score = Float.parseFloat(oldData.getObject(7).toString());
            }
            
            if (oldData.getObject(8) != null) {
                Niveau = oldData.getObject(8).toString();
            }

            addRow(Integer.parseInt(oldData.getObject(1).toString()),
                    oldData.getObject(3).toString(),
                    (new CheckList(Integer.parseInt(oldData.getObject(2).toString()))).set_description(),
                    oldData.getObject(4).toString(),
                    Date_Réalisation,
                    oldData.getObject(6).toString(),
                    Score,
                    Niveau);
        }
    } catch (Exception ex) {
        Logger.getLogger(CustomAuditTableModel.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("copy not ok\n");
    }
}  
    

    
    
    
    
    
    
    

}

