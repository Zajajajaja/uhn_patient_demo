package com.example.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tom Collection class for Patients
 */
public class PatientList {

	private List<Patient> PatientList;

	public List<Patient> getPatientList() {

		if (PatientList == null) {

			PatientList = new ArrayList<>();

		}

		return PatientList;

	}

	public void setPatientList(List<Patient> PatientList) {
		this.PatientList = PatientList;
	}
}
