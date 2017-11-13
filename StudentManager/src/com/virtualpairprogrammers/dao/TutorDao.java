package com.virtualpairprogrammers.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.virtualpairprogrammers.domain.Tutor;
import com.virtualpairprogrammers.services.NoResultsFoundException;

// Note - this is a cut down version of the DAO so we don't need a real database.

@Component
public class TutorDao 
{

	public List<Tutor> getAllTutors() 
	{
		List<Tutor> results = new ArrayList<Tutor>();
		results.add(new Tutor("2020022","Chip",20000));
		results.add(new Tutor("2020022","Hank",40000));
		return results;		
	}

	public Tutor getTutorById(int id) throws NoResultsFoundException 
	{
		throw new NoResultsFoundException();
	}

	public void save(Tutor newTutor) 
	{
		// do nothing in this stub implementation
	}

	public long getSalaryBill() 
	{
		return 60000;
	}
}
