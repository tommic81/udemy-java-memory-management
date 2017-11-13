package com.virtualpairprogrammers.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.virtualpairprogrammers.domain.Tutor;
import com.virtualpairprogrammers.services.TutorManagement;

@Controller
@RequestMapping("/addNewTutor")
public class AddNewTutorController 
{
	@Autowired
	private TutorManagement tutorManagement;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("/add-new-tutor.jsp", "tutor", new Tutor());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processForm(@Valid Tutor newTutor, Errors result) 
	{		
		if (result.hasErrors())
		{
			return new ModelAndView("/add-new-tutor.jsp", "tutor", newTutor);
		}
		tutorManagement.createNewTutor(newTutor);
		return new ModelAndView("/tutorAdded.jsp", "staffId", newTutor.getStaffId());
	}
}
