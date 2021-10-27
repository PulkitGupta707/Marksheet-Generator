package com.marksheet.MarksheetGenerator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="studentinfo")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="roll")
	private int rollnumber;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="physics")
	private String Physics;
	
	@Column(name="Chemistry")
	private String Chemistry;
	
	@Column(name="Maths")
	private String Maths;
	
	@Column(name="Java")
	private String Java;
	

	public Student() {
		
	}
	
	
	

	public int getRollnumber() {
		return rollnumber;
	}




	public void setRollnumber(int rollnumber) {
		this.rollnumber = rollnumber;
	}




	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPhysics() {
		return Physics;
	}

	public void setPhysics(String physics) {
		Physics = physics;
	}

	public String getChemistry() {
		return Chemistry;
	}

	public void setChemistry(String chemistry) {
		Chemistry = chemistry;
	}

	public String getMaths() {
		return Maths;
	}

	public void setMaths(String maths) {
		Maths = maths;
	}

	public String getJava() {
		return Java;
	}

	public void setJava(String java) {
		Java = java;
	}


	@Override
	public String toString() {
		return "Student [rollnumber=" + rollnumber + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", Physics=" + Physics + ", Chemistry=" + Chemistry + ", Maths=" + Maths + ", Java=" + Java + "]";
	}

	
}