package com.embl.test.emblcrudrest.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.embl.test.emblcrudrest.exceptions.PersonNotFoundExceptionHandler;
import com.embl.test.emblcrudrest.model.Person;
import com.embl.test.emblcrudrest.service.IPersonService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path="/rest/api")
public class CrudRestController {
	
	@Autowired
	IPersonService personService;
	
	@PostMapping(path="/createPerson")//post type request : http://localhost:8080/rest/api/createPerson
	public ResponseEntity<String> createPerson(@RequestBody Person person ) {
		Person newPerson = personService.createNewPeson(person);
		return new ResponseEntity<String>("Person Created with id : "+newPerson.getId(), HttpStatus.CREATED);
	}
	
	@GetMapping("/fetchAll")//get type request : http://localhost:8080/rest/api/fetchAll
	public Map<String, List<Person>> getPersonList(){
		Map<String, List<Person>> personDetailMap = personService.fetchAll();
		return personDetailMap;
	}
	
	@GetMapping("/fetchBy/{p_id}")//get type request : http://localhost:8080/rest/api/fetchBy/2
	public ResponseEntity<Map<String, Person>> getPersonById(@PathVariable("p_id") Integer personId){
		ResponseEntity<Map<String, Person>> response = null;
		Map<String, Person> personMap = null;
		try {
			personMap = personService.fetchById(personId);
		} catch (PersonNotFoundExceptionHandler e) {
			System.out.println(e.getLocalizedMessage());
		}
		
		if(personMap != null && personMap.size() > 0) {
			response = new ResponseEntity<Map<String, Person>>(personMap, HttpStatus.ACCEPTED);
		}else {
			response = new ResponseEntity<Map<String, Person>>(personMap, HttpStatus.NOT_FOUND);
		}
		return response;
	}
	
	@PutMapping(path="/updatePerson")//put type request : http://localhost:8080/rest/api/updatePerson
	public ResponseEntity<String> updatePersonData(@Valid @RequestBody Person personData){
		ResponseEntity<String> response = null;
		Map<String, Person> updated = null;
		try {
			updated = personService.updatePerson(personData);
		} catch (PersonNotFoundExceptionHandler e) {
			System.out.println(e.getLocalizedMessage());
		}
		if(updated != null && updated.size() > 0) {
			response = new ResponseEntity<String>("Person Updated with new records ", HttpStatus.ACCEPTED);
		}else {
			response = new ResponseEntity<String>("No Record found for Person with id "+updated.get("person").getId(), HttpStatus.NOT_FOUND);
		}
		return response;
	}

	@DeleteMapping(path="/deleteById/{p_id}")//delete type request : http://localhost:8080/rest/api/deleteById/2
	public ResponseEntity<String> deletePerson(@PathVariable("p_id") Integer personId){
		ResponseEntity<String> response = null;
		boolean isDeleted = false;
		try {
			isDeleted = personService.deletePersonById(personId);
		} catch (PersonNotFoundExceptionHandler e) {
			System.out.println(e.getLocalizedMessage());
		}
		if(isDeleted != false) {
			response = new ResponseEntity<String>("Person record with id "+personId+" is deleted", HttpStatus.ACCEPTED);
		}else {
			response = new ResponseEntity<String>("No Record found for Person with id "+personId, HttpStatus.NOT_FOUND);
		}
		return response;
	}
	
	@RequestMapping(value="/healthCheck", method=RequestMethod.GET)
	public ResponseEntity<String> checkHealthApplication(){
		return new ResponseEntity<String>("Application is up", HttpStatus.OK);
	}
}
