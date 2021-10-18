package com.example.demo;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(PatientController.class)
public class PatientControllerTest {

	@Autowired
	private PatientDAO patientDao;
	@Autowired
	private MockMvc mvc;

	@MockBean
	private UhnPatientServiceApplication service;

	@Test
	public void givenEmployees_whenGetEmployees_thenReturnJsonArray() throws Exception {
		Calendar c = Calendar.getInstance();
		c.set(1989, 11, 25);
		Patient alex = new Patient(1, "alex", "kolanko", c.getTime());

		List<Patient> allPatients = Arrays.asList(alex);
		patientDao.getAllPatients().setPatientList(allPatients);

		given(patientDao.getAllPatients().getPatientList()).willReturn(allPatients);

		mvc.perform(get("/patients/").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0].firstName", is(alex.getFirstName())))
				.andExpect(jsonPath("$[0].lastName", is(alex.getLastName())))
				.andExpect(jsonPath("$[0].dateOfBirth", is(alex.getDateOfBirth())))
				.andExpect(jsonPath("$[0].id", is(alex.getId())));
	}
}