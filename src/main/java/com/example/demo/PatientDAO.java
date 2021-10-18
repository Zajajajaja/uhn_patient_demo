package com.example.demo;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Repository;

/**
 * Class to create a list of patients, initially a static pre-defined list for
 * testing/the purposes of this exercise.
 * 
 * @author Tom P
 */

@Repository

public class PatientDAO {

	private static PatientList list = new PatientList();

	// This is just the sample data population and would not be done in a real
	// service unless it was coming from pre-existing data.
	static {

		Calendar c = Calendar.getInstance();
		c.set(1989, 7, 4);
		Date dob1 = c.getTime();
		c.set(1990, 5, 20);
		Date dob2 = c.getTime();
		c.set(1991, 1, 31);
		Date dob3 = c.getTime();

		list.getPatientList().add(new Patient(1, "Tom", "Phillips", dob1));

		list.getPatientList().add(new Patient(2, "Melanie", "Yeung", dob2));

		list.getPatientList().add(new Patient(3, "Bob", "Dobson", dob3));

	}

	/**
	 * @return PatientList
	 */
	public PatientList getAllPatients() {

		return list;
	}

	/**
	 * @param Patient
	 *
	 */
	public void addPatient(Patient patient) {
		list.getPatientList().add(patient);

	}

	/**
	 * @param Integer id
	 * @return Patient
	 *
	 */
	public Patient getPatientById(Integer id) {
		return list.getPatientList().stream().filter(patient -> id.equals(patient.getId())).findFirst().orElse(null);
	}

	/**
	 * @param String firstName
	 * @return Patient
	 */
	public Patient getPatientByFirstName(String firstName) {
		return list.getPatientList().stream().filter(patient -> firstName.equals(patient.getFirstName())).findFirst()
				.orElse(null);
	}
}
