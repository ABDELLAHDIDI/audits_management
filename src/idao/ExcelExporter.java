package idao;
import com.aspose.cells.Color;
import com.aspose.cells.Range;
import com.aspose.cells.Worksheet;
//import org.apache.poi.ss.usermodel.*;
import java.io.*;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class ExcelExporter {
    public void exportToExcel( Audit audit, List<Question> questions, List<JCheckBox> checkboxes, List<JComboBox> comboboxes,        java.util.List<ActionAssociee> newFrame , String filePath) throws Exception {
        try {
         
              // Load the Excel file
            com.aspose.cells.Workbook workbook = new com.aspose.cells.Workbook(filePath);

            // Access the first worksheet in the Excel file (index 0)
            Worksheet worksheet = workbook.getWorksheets().get(0);

            // Create a cell at the desired row and column
            int rowIndex = 3; // Row number where you want to add the data
            //int cellNum = 0; // Cell number (column) where you want to add the data
 

           String nom="";
            
            int i=0,j=0,k=0;
            
                   com.aspose.cells.Style customStyle = workbook.createStyle();
customStyle.getFont().setName("Arial");
customStyle.getFont().setSize(12);
//customStyle.getFont().setColor(com.aspose.cells.Color.getRed());
customStyle.getFont().setBold(true);
customStyle.setHorizontalAlignment(com.aspose.cells.TextAlignmentType.CENTER);
customStyle.setVerticalAlignment(com.aspose.cells.TextAlignmentType.CENTER);
customStyle.setBorder(com.aspose.cells.BorderType.TOP_BORDER, com.aspose.cells.CellBorderType.THICK, com.aspose.cells.Color.getBlack());
//customStyle.setBorder(com.aspose.cells.BorderType.BOTTOM_BORDER, com.aspose.cells.CellBorderType.THICK, com.aspose.cells.Color.getBlue());
//customStyle.setBorder(com.aspose.cells.BorderType.LEFT_BORDER, com.aspose.cells.CellBorderType.THICK, com.aspose.cells.Color.getBlue());
//customStyle.setBorder(com.aspose.cells.BorderType.RIGHT_BORDER, com.aspose.cells.CellBorderType.THICK, com.aspose.cells.Color.getBlue());
customStyle.setPattern(com.aspose.cells.BackgroundType.SOLID);
customStyle.setForegroundColor(com.aspose.cells.Color.getGray());


            // Set the data in the cell
            if(questions.get(j).getIdSection()==-2){
                
                   com.aspose.cells.Style customStyle1 = workbook.createStyle();
customStyle1.getFont().setName("Arial");
customStyle1.getFont().setSize(18);
customStyle1.getFont().setBold(true);
customStyle1.setHorizontalAlignment(com.aspose.cells.TextAlignmentType.CENTER);
customStyle1.setVerticalAlignment(com.aspose.cells.TextAlignmentType.CENTER);
                
                    com.aspose.cells.Cell cell = worksheet.getCells().get(0,1);
            cell.putValue(questions.get(j).getDescription());
nom=questions.get(j).getDescription();
               worksheet.getCells().getCell(0,1).setStyle(customStyle1);
               worksheet.getCells().getCell(0,2).setStyle(customStyle1);
               worksheet.getCells().getCell(0,3).setStyle(customStyle1);
               worksheet.getCells().getCell(0,4).setStyle(customStyle1);
               worksheet.getCells().getCell(0,5).setStyle(customStyle1);
               worksheet.getCells().getCell(0,6).setStyle(customStyle1);
               worksheet.getCells().getCell(0,7).setStyle(customStyle1);
               worksheet.getCells().getCell(0,8).setStyle(customStyle1);
               worksheet.getCells().getCell(0,9).setStyle(customStyle1);
               
               
               
                 com.aspose.cells.Style s = workbook.createStyle();
               s.getFont().setBold(true);
s.setHorizontalAlignment(com.aspose.cells.TextAlignmentType.CENTER);
s.setVerticalAlignment(com.aspose.cells.TextAlignmentType.CENTER);
            
             cell = worksheet.getCells().get(0,11);
            cell.putValue(audit.getDate_realisation().toString());
            cell.setStyle(s);
             cell = worksheet.getCells().get(0,13);
            cell.putValue(audit.getAuditeur()+" : "+(new iutilisateur()).set_nom_prenom((new utilisateur(audit.getAuditeur()))));
               cell.setStyle(s);
            
            
                System.out.println("questions.get(j).getDescription() : "+questions.get(j).getDescription() +"\n");
            j++;
            }

        // Export Question data
        for ( ;!checkboxes.isEmpty() && i<checkboxes.size() ;) {
            
            Question question = questions.get(j);
            if(question.getIdSection()== -1) {
            
                com.aspose.cells.Cell cell1 = worksheet.getCells().get(rowIndex, 0);
                cell1.putValue(question.getDescription());
            

        worksheet.getCells().getCell(rowIndex,0).setStyle(customStyle);
        worksheet.getCells().getCell(rowIndex,1).setStyle(customStyle);
        worksheet.getCells().getCell(rowIndex,2).setStyle(customStyle);
        worksheet.getCells().getCell(rowIndex,3).setStyle(customStyle);
        worksheet.getCells().getCell(rowIndex,4).setStyle(customStyle);
        worksheet.getCells().getCell(rowIndex,5).setStyle(customStyle);
          
          rowIndex++;
            }
            else {
                                 com.aspose.cells.Style x = workbook.createStyle();
x.setHorizontalAlignment(com.aspose.cells.TextAlignmentType.CENTER);
x.setVerticalAlignment(com.aspose.cells.TextAlignmentType.CENTER);
                
            JCheckBox checkbox = checkboxes.get(i);
                    
                    JComboBox combobox = comboboxes.get(i);
                            
           
            
                        com.aspose.cells.Cell cell1 = worksheet.getCells().get(rowIndex, 0);

            // Set the data in the cell
            cell1.putValue(question.getDescription());
            
            
            cell1 = worksheet.getCells().get(rowIndex, 2);

            // Set the data in the cell
            if(checkbox.isSelected())
            cell1.putValue("X");
            
            cell1 = worksheet.getCells().get(rowIndex, 3);

            // Set the data in the cell
            if(                  "Conforme".equals(combobox.getSelectedItem().toString()))
            cell1.putValue("X");
            else if(  "Non Conforme".equals(combobox.getSelectedItem().toString()))
            {
                 cell1 = worksheet.getCells().get(rowIndex, 4);
                    cell1.putValue("X");
            }
            else {
                cell1 = worksheet.getCells().get(rowIndex, 5);
                    cell1.putValue("X");
            }
            
            cell1.setStyle(x);
            
            if(!newFrame.isEmpty() && k<newFrame.size()&& newFrame.get(k).get_tquestion().equals(question.getDescription())   ){
                  com.aspose.cells.Style p = workbook.createStyle();
             
p.setHorizontalAlignment(com.aspose.cells.TextAlignmentType.CENTER);
p.setVerticalAlignment(com.aspose.cells.TextAlignmentType.CENTER);

                ActionAssociee as=newFrame.get(k);
                       
                         
                         worksheet.getCells().merge(rowIndex, 6, 1, 4);

// Write data into the merged cell

worksheet.getCells().get(rowIndex, 6).putValue(as.get_tpro());
           worksheet.getCells().get(rowIndex, 6).setStyle(p);
                
                         cell1 = worksheet.getCells().get(rowIndex, 10);
                    cell1.putValue(as.get_tcause());
                 cell1.setStyle(p);
                         cell1 = worksheet.getCells().get(rowIndex, 11);
                    cell1.putValue(as.get_tcorr());
                 cell1.setStyle(p);
                         cell1 = worksheet.getCells().get(rowIndex, 12);
                    cell1.putValue(as.getTresp());
                 cell1.setStyle(p);
                         cell1 = worksheet.getCells().get(rowIndex, 13);
                    cell1.putValue(as.get_tdate());
                 cell1.setStyle(p);
                         cell1 = worksheet.getCells().get(rowIndex, 14);
                    cell1.putValue(as.get_tstatus());
                 cell1.setStyle(p);
                
      
                k++;
            }
    
            i++;
            rowIndex++;
            }
            
              j++;
            
        }
        
        
        
        customStyle = workbook.createStyle();
customStyle.getFont().setName("Arial");
customStyle.getFont().setSize(12);

customStyle.getFont().setBold(true);
customStyle.setHorizontalAlignment(com.aspose.cells.TextAlignmentType.CENTER);
customStyle.setVerticalAlignment(com.aspose.cells.TextAlignmentType.CENTER);
customStyle.setBorder(com.aspose.cells.BorderType.TOP_BORDER, com.aspose.cells.CellBorderType.THICK, com.aspose.cells.Color.getBlack());
customStyle.setBorder(com.aspose.cells.BorderType.BOTTOM_BORDER, com.aspose.cells.CellBorderType.THICK, com.aspose.cells.Color.getBlue());
customStyle.setBorder(com.aspose.cells.BorderType.LEFT_BORDER, com.aspose.cells.CellBorderType.THICK, com.aspose.cells.Color.getBlue());
customStyle.setBorder(com.aspose.cells.BorderType.RIGHT_BORDER, com.aspose.cells.CellBorderType.THICK, com.aspose.cells.Color.getBlue());
customStyle.setPattern(com.aspose.cells.BackgroundType.SOLID);

        
           com.aspose.cells.Cell cell = worksheet.getCells().get(rowIndex+3, 13);
   cell.putValue("Raiting ");
            // Set the data in the cell
            cell = worksheet.getCells().get(rowIndex+3, 14);
            
            cell.putValue(audit.getNiveau());
            if("C".equals(audit.getNiveau())){
                
//            customStyle.getFont().setColor(com.aspose.cells.Color.getRed());
            customStyle.setForegroundColor(com.aspose.cells.Color.getRed());
            }
            else     if("C".equals(audit.getNiveau())){
                
          //  customStyle.getFont().setColor(com.aspose.cells.Color.getOrange());
            customStyle.setForegroundColor(com.aspose.cells.Color.getOrange());
            }
            else {
                
           // customStyle.getFont().setColor(com.aspose.cells.Color.getGreen());
            customStyle.setForegroundColor(com.aspose.cells.Color.getGreen());
            }
            
        cell.setStyle(customStyle);
         cell = worksheet.getCells().get(rowIndex+4, 13);
   cell.putValue("Score  ");
         cell = worksheet.getCells().get(rowIndex+4, 14);

            // Set the data in the cell
            cell.putValue(audit.getScore()+"");
        cell.setStyle(customStyle);
        
             // Save the changes to the Excel file
              nom = "./Exporter/"+nom+"_"+audit.getDate_realisation().split(" ")[0]+".xlsx";
            workbook.save(nom);
//RemoveExcelSheet.remove(nom);
            System.out.println("Data added to " + nom + " successfully.");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
  
}


}

