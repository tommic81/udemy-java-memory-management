package com.virtualpairprogrammers.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.virtualpairprogrammers.dao.TutorDao;
import com.virtualpairprogrammers.domain.Tutor;

@Service
@Transactional
public class TutorManagement
{
	@Autowired
	private TutorDao dao;
	
    public List<Tutor> getAllTutors()
    {
    	return dao.getAllTutors();
    }
    
    public Tutor findTutorByIdWithSupervisionGroup(int id) throws NoResultsFoundException
    {
    	return dao.getTutorById(id);
    }

	public Tutor createNewTutor(Tutor newTutor) 
	{
    	// generate a Staff Id. This is a very cheap way of doing it but it is a very
    	// long id!
    	String staffId = UUIDGenerator.newUUID();
    	newTutor.setStaffId(staffId);
    	dao.save(newTutor);
    	return newTutor;
	}

	/*
	 * This feels a bit unnatural - consider moving the tranaction boundary upwards!
	 */
	public Map<String, Object> getTutorsAndSalaryBill()
	{
		// this will all be in a single transaction
		List<Tutor> tutors = dao.getAllTutors();
		long salaryBill = dao.getSalaryBill();

		Map<String, Object> results = new HashMap<String, Object>();
		results.put("allTutors", tutors);		
		results.put("salary", salaryBill);
		
		return results;
	}

	public long getSalaryBill() 
	{
		return dao.getSalaryBill();
	}
}
