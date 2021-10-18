package com.example.demo;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * 
 * Controller for RESTful operation.
 * 
 * @author Tom
 *
 */
@RestController
@RequestMapping(path = "/patients/")
public class PatientController {

	@Autowired
	private PatientDAO patientDao;

	/**
	 * Get mapping for whole list of patients
	 * 
	 * @return PatientList containing all of the patients currently
	 */
	@GetMapping(path = "", produces = "application/json")

	public PatientList getPatientList() {
		return patientDao.getAllPatients();
	}

	/**
	 * Get for /patients/id/{id} made with the prefix /id/ to avoid ambiguity with
	 * firstName get
	 * 
	 * @param id
	 * @return Patient
	 */
	@GetMapping(path = "/id/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id) {
		Patient p = patientDao.getPatientById(id);
		if (p == null) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setMessage("Record not found with ID: " + id);
			errorResponse.setStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
		} else {
			return (new ResponseEntity<>(p, HttpStatus.OK));
		}

	}

	/**
	 * Get for /patients/firstName/{firstName} made with the prefix /firstName/ to
	 * avoid ambiguity with {id} get
	 * 
	 * @param firstName
	 * @return Patient
	 */
	@GetMapping(path = "/firstName/{firstName}")
	public ResponseEntity<?> getByFirstName(@PathVariable String firstName) {
		Patient p = patientDao.getPatientByFirstName(firstName);
		if (p == null) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setMessage("Record not found with first name: " + firstName);
			errorResponse.setStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(p, HttpStatus.OK);
		}

	}

	/**
	 * POST mapping that consumes json formatted to patient profile excluding ID
	 * which is generated when the patientList is examined.
	 * 
	 * @param patient
	 * @return http_ok status
	 */
	@PostMapping(path = "/", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> addPatient(@RequestBody Patient patient) {

		Integer id = patientDao.getAllPatients().getPatientList().size() + 1;

		patient.setId(id);

		patientDao.addPatient(patient);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(patient.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}
}
