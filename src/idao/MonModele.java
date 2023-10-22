/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package idao;

/**
 *
 * @author maejj
 */


import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class MonModele extends AbstractTableModel {
    private int nbLig = 0;
    private int nbCol;
    private String[] titres;
    private ArrayList<Vector<String>> mesLignes = new ArrayList<Vector<String>>();

    private String tablename ="";
    public MonModele(ResultSet rs) {
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            tablename=rsmd.getTableName(1);
            System.out.println("tablename : "+tablename+"\n");
            nbCol = rsmd.getColumnCount();
            titres = new String[nbCol];
            for (int i = 0; i < nbCol; i++) {
                if("role".equals(rsmd.getColumnLabel(i + 1)))  titres[i] ="poste";
                else if("desactive".equals(rsmd.getColumnLabel(i + 1)))titres[i] ="statut";  
                else if("id".equalsIgnoreCase(rsmd.getColumnLabel(i + 1))
                        && "actions".equalsIgnoreCase(tablename))titres[i] ="N°d’action";  
                else if("id_audit".equalsIgnoreCase(rsmd.getColumnLabel(i + 1))
                        && "actions".equalsIgnoreCase(tablename))titres[i] ="N°d’audit";  
                else if("resp".equalsIgnoreCase(rsmd.getColumnLabel(i + 1))
                        && "actions".equalsIgnoreCase(tablename))titres[i] ="Deadline";  
                else   titres[i] = rsmd.getColumnLabel(i + 1);
            }
            Vector<String> ligne;
            while (rs.next()) {
                ligne = new Vector<String>();
                for (int i = 0; i < nbCol; i++) {
                    if("utilisateurs".equalsIgnoreCase(tablename)  ){
               if(i>0){
                        if(i == 9 && nbCol == 10 && titres[9].equals("statut") ) {
                     if(rs.getBoolean(10))   ligne.add("Desactif");
                     else    ligne.add("Actif");
                    }
                    ligne.add(rs.getObject(i + 1).toString());
               }
                    }
                    else{
                            if(i == 9 && nbCol == 10 && titres[9].equals("statut") ) {
                     if(rs.getBoolean(10))   ligne.add("Desactif");
                     else    ligne.add("Actif");
                    }
                    ligne.add(rs.getObject(i + 1).toString());
                    }
                }
                mesLignes.add(ligne);
                nbLig++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MonModele.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        return nbLig;
    }

    @Override
    public int getColumnCount() {
          if("utilisateurs".equalsIgnoreCase(tablename)  )
        return nbCol-1;
        return nbCol;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return mesLignes.get(rowIndex).get(columnIndex);
    }

    @Override
    public String getColumnName(int column) {
          if("utilisateurs".equalsIgnoreCase(tablename)  )
        return titres[column+1];
        return titres[column];
    }
}
