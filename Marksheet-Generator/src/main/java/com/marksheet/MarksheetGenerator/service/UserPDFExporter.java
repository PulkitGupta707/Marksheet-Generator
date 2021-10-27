package com.marksheet.MarksheetGenerator.service;

import java.awt.Color;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import com.marksheet.MarksheetGenerator.entity.Student;
 
 
public class UserPDFExporter {
    private Student student;
     
    public UserPDFExporter(Student student) {
        this.student = student;
    }
 
    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(8);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("Roll Number", font));
         
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("First name", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Last name", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Physics", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Chemistry", font));
        table.addCell(cell);  
        
        cell.setPhrase(new Phrase("Mathematics", font));
        table.addCell(cell); 
        
        cell.setPhrase(new Phrase("Java", font));
        table.addCell(cell); 
    }
     
    private void writeTableData(PdfPTable table) {
       
            table.addCell(String.valueOf(student.getRollnumber()));
            table.addCell(student.getFirstName());
            table.addCell(student.getLastName());
            table.addCell(student.getPhysics());
            table.addCell(student.getChemistry());
            table.addCell(student.getMaths());
            table.addCell(student.getJava());
        
    }
     
    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
        String Name = student.getFirstName() +"'s " + "Marksheet";
        Paragraph p = new Paragraph(Name, font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(7);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f, 3.0f, 2.5f});
        table.setSpacingBefore(10);
         
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table);
         
        document.close();
         
    }
}
