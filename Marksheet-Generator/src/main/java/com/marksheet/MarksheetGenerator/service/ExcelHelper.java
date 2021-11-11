package com.marksheet.MarksheetGenerator.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.marksheet.MarksheetGenerator.entity.Student;


public class ExcelHelper {
  public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
  static String[] HEADERs = { "RollNumber", "First Name", "Last Name", "Physics", "Chemistry", "Mathematics", "Java" };
  static String SHEET = "Marksheet";

  public static ByteArrayInputStream exportToExcel(Student student) {

    try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
    	SHEET = student.getFirstName() +" " +student.getLastName()+SHEET;
       Sheet sheet = workbook.createSheet(SHEET);

      // Header
      Row headerRow = sheet.createRow(0);

      for (int col = 0; col < HEADERs.length; col++) {
        Cell cell = headerRow.createCell(col);
        cell.setCellValue(HEADERs[col]);
      }

      
        Row row = sheet.createRow(0);

        row.createCell(0).setCellValue(student.getRollnumber());
        row.createCell(1).setCellValue(student.getFirstName());
        row.createCell(2).setCellValue(student.getLastName());
        row.createCell(3).setCellValue(student.getPhysics());
        row.createCell(4).setCellValue(student.getChemistry());
        row.createCell(5).setCellValue(student.getMaths());
        row.createCell(6).setCellValue(student.getJava());
      

      workbook.write(out);
      return new ByteArrayInputStream(out.toByteArray());
    } catch (IOException e) {
      throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
    }
  }
}
