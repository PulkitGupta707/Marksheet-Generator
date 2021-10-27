package com.marksheet.MarksheetGenerator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marksheet.MarksheetGenerator.dao.MarksheetDAO;
import com.marksheet.MarksheetGenerator.entity.Student;

@Service
public class MarksheetServiceImpl implements MarksheetService{
	
	@Autowired
	private MarksheetDAO marksheetDAO;
	
	@Override
	@Transactional
	public Student getdetails(int rollnumber) {
		
		return marksheetDAO.getdetails(rollnumber);
	
	}
}