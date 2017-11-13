package com.virtualpairprogrammers.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.virtualpairprogrammers.domain.Tutor;
import com.virtualpairprogrammers.services.NoResultsFoundException;
import com.virtualpairprogrammers.services.TutorManagement;

@Controller
@Transactional
public class ManageTutorsController
{
	@Autowired
	private TutorManagement tutorManagement;
	
	@RequestMapping("/displayAllTutors")
	public ModelAndView displayAllTutors()
	{    	
		List<Tutor> allTutors = tutorManagement.getAllTutors();
		long salaryBill = tutorManagement.getSalaryBill();
		
		Map<String, Object> results = new HashMap<String, Object>();
		results.put("allTutors", allTutors);
		results.put("salary", salaryBill);

		return new ModelAndView("/displayAllTutors.jsp", "results", results);	
	}
	
	@RequestMapping("/displayTutorDetail")
	public ModelAndView displayTutorDetail(@RequestParam("id") int id)
	{		
		try 
		{
			Tutor tutor = tutorManagement.findTutorByIdWithSupervisionGroup(id);
			return new ModelAndView("/displayTutorDetail.jsp", "tutor", tutor);			
		} 
		catch (NoResultsFoundException e) 
		{
			return new ModelAndView("/noResultsFound.jsp");
		}		
	}
	
}
