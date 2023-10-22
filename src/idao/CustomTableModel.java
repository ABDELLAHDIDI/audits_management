/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package idao;

/**
 *
 * @author ABDELLAH DIDI
 */
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class CustomTableModel extends AbstractTableModel {
    private String[] columnNames = {"ID", "Description"};
    private Object[][] data;

    public CustomTableModel(Object[][] data) {
        this.data = data;
    }

    
      @Override
    public int getColumnCount() {
        // Return the number of columns excluding the "ID" column
        return columnNames.length - 1;
    }

    @Override
    public Object getValueAt(int row, int col) {
        // Skip the "ID" column when getting the value
        return data[row][col + 1];
    }

    @Override
    public String getColumnName(int col) {
        // Skip the "ID" column when getting the column name
        return columnNames[col + 1];
    }
    
    
    @Override
    public int getRowCount() {
        return data.length;
    }

//    @Override
//    public int getColumnCount() {
//        return columnNames.length;
//    }

//    @Override
//    public Object getValueAt(int row, int col) {
//        return data[row][col];
//    }

    @Override
    public void setValueAt(Object value, int row, int col) {
//        if (col == -1) {
//            // Empêcher la modification de la colonne ID
//            return;
//        }
        data[row][col+1] = value;
        fireTableCellUpdated(row, col+1);
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        // Seule la colonne "Description" est modifiable (colonne d'index 1)
        return col == 0;
    }

//    @Override
//    public String getColumnName(int col) {
//        return columnNames[col];
//    }
//    
     public void addRow(int id, String description) {
        Object[] newRow = {id, description};
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
        for (int row1 = 0, i=0; i < data.length; i++) {
            if(i != row ) 
                {
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
     
                public    void  copy(      ResultSet  oldData ) {  
                    try {
                
        for (; oldData.next(); ) 
            
           addRow(    Integer.parseInt(oldData.getObject(1 ).toString()) , oldData.getObject(3).toString() );
        
         } catch (SQLException ex) {
            Logger.getLogger(MonModele.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("copy not ok\n");
        }
              }
                public    void  copy_Check(      ResultSet  oldData ) {  
                    try {
                
        for (; oldData.next(); ) 
            
           addRow(    Integer.parseInt(oldData.getObject(1 ).toString()) , oldData.getObject(2).toString() );
        
         } catch (SQLException ex) {
            Logger.getLogger(MonModele.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("copy_Check not ok\n");
        }
              }
                
                
    
}
