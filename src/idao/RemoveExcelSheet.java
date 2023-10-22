/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package idao;

/**
 *
 * @author ABDELLAH DIDI
 */
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class RemoveExcelSheet {
    public static void remove(String s) {
        String filePath = s; // Update with your file path
        int sheetIndexToRemove = 2; // Index of the sheet to be removed

        try {
            // Open the Excel file
            FileInputStream fis = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(fis); // For XLSX files

            // Remove the specified sheet
            if (sheetIndexToRemove >= 0 && sheetIndexToRemove < workbook.getNumberOfSheets()) {
                workbook.removeSheetAt(sheetIndexToRemove);
                System.out.println("Sheet removed successfully.");
            } else {
                System.out.println("Invalid sheet index.");
            }

            // Save the modified workbook
            FileOutputStream fos = new FileOutputStream(filePath);
            workbook.write(fos);

            // Close streams and workbook
            fis.close();
            fos.close();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
