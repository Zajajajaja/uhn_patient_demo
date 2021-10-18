package com.example.demo;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class PatientTest {

	@Test
	public void createValidPatient() {
		String firstName = "Vlad";
		String lastName = "The Valid";
		Calendar c = Calendar.getInstance();
		c.set(1980, 05, 06);
		Date dob = c.getTime();
		
		Patient v = new Patient();
		v.setId(1);
		v.setFirstName(firstName);
		v.setLastName(lastName);
		v.setDateOfBirth(dob);
		
		Assert.notNull(v, "The patient class must not be null");
		Assert.isTrue((v.getId() == 1), "ID is still 1");
		Assert.isTrue((v.getFirstName() == "Vlad"),"First name is still Vlad");
		Assert.isTrue((v.getLastName() == "The Valid"),"Last name is still The Valid");
		Assert.isTrue((v.getDateOfBirth() == dob) ,"Date of birth is 1980, 05, 06");
	}
}
