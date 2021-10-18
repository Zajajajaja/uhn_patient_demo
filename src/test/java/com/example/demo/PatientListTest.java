package com.example.demo;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class PatientListTest {

	@Test
	public void addPatientsToList() {

		PatientList pl = new PatientList();
		Calendar c = Calendar.getInstance();
		c.set(1989, 7, 4);
		Date dob1 = c.getTime();
		c.set(1990, 5, 20);
		Date dob2 = c.getTime();
		c.set(1991, 1, 31);
		Date dob3 = c.getTime();

		pl.getPatientList().add(new Patient(1, "Tom", "Phillips", dob1));

		pl.getPatientList().add(new Patient(2, "Melanie", "Yeung", dob2));

		pl.getPatientList().add(new Patient(3, "Bob", "Dobson", dob3));

		Assert.notNull(pl, "List is not null");
		Assert.isTrue(pl.getPatientList().size() == 3, "List has three elements");
		Assert.isTrue(pl.getPatientList().get(0).getId() == 1, "First element has ID of 1");
	}

}
