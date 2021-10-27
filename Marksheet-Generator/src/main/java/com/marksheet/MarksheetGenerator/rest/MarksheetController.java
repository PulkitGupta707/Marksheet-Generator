package com.marksheet.MarksheetGenerator.rest;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lowagie.text.DocumentException;
import com.marksheet.MarksheetGenerator.entity.Student;
import com.marksheet.MarksheetGenerator.service.ExcelService;
import com.marksheet.MarksheetGenerator.service.MarksheetService;
import com.marksheet.MarksheetGenerator.service.UserPDFExporter;


@Controller
@RequestMapping("/student")

public class MarksheetController {
	
	@Autowired
	private MarksheetService marksheetService;
	
	@GetMapping("/details/{rollnumber}")
	
	public String showDetails(@PathVariable int rollnumber, Model model) throws Exception {
		
			Student student = marksheetService.getdetails(rollnumber);
			 model.addAttribute("student", student);			 
			 return "details";
	}
	
	@GetMapping("/details/{r}/export/pdf")
	 public void exportToPDF(@PathVariable int r, HttpServletResponse response) throws DocumentException, IOException {
	
        response.setContentType("application/pdf");
        Date date = new Date();
        String strDateFormat = "yyyy-MM-dd_HH:mm:ss";
        DateFormat dateFormatter = new SimpleDateFormat(strDateFormat);
        String currentDateTime = dateFormatter.format(date);
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
                    
        Student student = marksheetService.getdetails(r);
         
        UserPDFExporter exporter = new UserPDFExporter(student);
        exporter.export(response);
         
    }
	
	 @Autowired
	  ExcelService fileService;
	@GetMapping("/details/{rollnumber}/export/excel")
	 public ResponseEntity<Resource> getFile(@PathVariable int rollnumber) {
		
		 Date date = new Date();
	     String strDateFormat = "yyyy-MM-dd_HH:mm:ss";
	     DateFormat dateFormatter = new SimpleDateFormat(strDateFormat);
	     String currentDateTime = dateFormatter.format(date);
	     String filename = currentDateTime+".xlsx";
	    InputStreamResource file = new InputStreamResource(fileService.load(rollnumber));

	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
	        .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
	        .body(file);
	  }
   

}
