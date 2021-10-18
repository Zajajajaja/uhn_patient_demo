package com.example.demo;

import java.util.Date;

/**
 * Patient class to contain variables for individual patients
 * 
 * @author Tom
 *
 */

public class Patient {

	public Patient() {
	}

	/**
	 * Class constructor for patient
	 */
	public Patient(Integer id, String firstName, String lastName, Date dateOfBirth) {

		super();

		this.id = id;

		this.firstName = firstName;

		this.lastName = lastName;

		this.dateOfBirth = dateOfBirth;

	}

	private Integer id;

	private String firstName;

	private String lastName;

	private Date dateOfBirth;

	/**
	 * Override of toString methods to handle json/human readable data
	 *
	 */
	@Override
	public String toString() {

		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth.toString() + "]";

	}

	// Getters and setters for the object

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
