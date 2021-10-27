package com.marksheet.MarksheetGenerator.service;

import java.io.ByteArrayInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.marksheet.MarksheetGenerator.entity.Student;

@Service
public class ExcelService {
	@Autowired
	private MarksheetService marksheetService;

  public ByteArrayInputStream load(int rollnumber) {
	  Student student = marksheetService.getdetails(rollnumber);

    ByteArrayInputStream in = ExcelHelper.exportToExcel(student);
    return in;
  }

}
