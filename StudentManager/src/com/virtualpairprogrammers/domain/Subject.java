package com.virtualpairprogrammers.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Subject 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(unique=true, nullable=false)
	private String subjectName;
	private int numberOfSemesters;
	
	@ManyToMany
	private Set<Tutor> qualifiedTutors;
	
	public Subject() {
	}
	
	public Subject(String subjectName, int numberOfSemesters)
	{
		this.subjectName = subjectName;
		this.numberOfSemesters = numberOfSemesters;
		this.qualifiedTutors = new HashSet<Tutor>();
	}
	
	public void addTutorToSubject(Tutor tutor)
	{
		this.qualifiedTutors.add(tutor);
		tutor.getSubjects().add(this);
	}
	
	public Set<Tutor> getQualifiedTutors()
	{
		return this.qualifiedTutors;
	}
	
	public String toString()
	{
		return this.subjectName + " lasts for " + this.numberOfSemesters + " semesters";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((subjectName == null) ? 0 : subjectName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		if (subjectName == null) {
			if (other.subjectName != null)
				return false;
		} else if (!subjectName.equals(other.subjectName))
			return false;
		return true;
	}
	
	
}
