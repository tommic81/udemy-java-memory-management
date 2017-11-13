package com.virtualpairprogrammers.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import org.hibernate.annotations.BatchSize;

@Entity
@BatchSize(size=10)
public class Tutor 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(unique=true, nullable=false)
	private String staffId;
	private String name;

	private int salary;
	
	@OneToMany(mappedBy="supervisor", cascade={ CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Student> supervisionGroup;
	
	@ManyToMany(mappedBy="qualifiedTutors")
	private Set<Subject> subjectsQualifiedToTeach;
	
	@Version
	private int version;
	
	// The following two getters were added to support the web front end
	public int getId() {
		return id;
	}
	
	public String getStaffId() {
		return staffId;
	}
	
	public void setStaffId(String staffId) 
	{
		this.staffId = staffId;
	}

	// required by hibernate
	public Tutor() {}

	// "business constructor"
	public Tutor(String staffId, String name, int salary) 
	{
		super();
		this.staffId = staffId;
		this.name = name;
		this.salary = salary;
		this.supervisionGroup = new HashSet<Student>();
		this.subjectsQualifiedToTeach = new HashSet<Subject>();
	}
	
	public void doubleSalary()
	{
		this.salary = this.salary * 2;
	}
	
	public void addSubjectToQualifications(Subject subject)
	{
		this.subjectsQualifiedToTeach.add(subject);
		subject.getQualifiedTutors().add(this);
	}
	
	public void addStudentToSupervisionGroup(Student studentToAdd)
	{
		this.supervisionGroup.add(studentToAdd);
		studentToAdd.allocateSupervisor(this);
	}
	
	public Set<Subject> getSubjects()
	{
		return this.subjectsQualifiedToTeach;
	}
	
	public Set<Student> getSupervisionGroup()
	{
		Set<Student> unmodifiable = Collections.unmodifiableSet(this.supervisionGroup);
		return unmodifiable;
	}
	
	public Set<Student> getModifiableSupervisionGroup()
	{
		return this.supervisionGroup;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String toString()
	{
		return "Tutor: " + this.name + " (" + this.staffId + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((staffId == null) ? 0 : staffId.hashCode());
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
		Tutor other = (Tutor) obj;
		if (staffId == null) {
			if (other.staffId != null)
				return false;
		} else if (!staffId.equals(other.staffId))
			return false;
		return true;
	}

	public void createStudentAndAddToSupervisionGroup(String studentName, String enrollmentId,
			String street, String city, String zipOrPostcode) 
	{
		Student student = new Student(studentName, enrollmentId, street, city, zipOrPostcode);
		this.addStudentToSupervisionGroup(student);
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public int getSalary() 
	{
		// TODO Auto-generated method stub
		return this.salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}



}
