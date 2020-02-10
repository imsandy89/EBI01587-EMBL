package com.embl.test.emblcrudrest.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.embl.test.emblcrudrest.exceptions.PersonNotFoundExceptionHandler;
import com.embl.test.emblcrudrest.model.Person;
import com.embl.test.emblcrudrest.repository.IPersonRepository;
import com.embl.test.emblcrudrest.service.IPersonService;

@Service
public class PersonServiceImpl implements IPersonService {
	
	@Autowired
	IPersonRepository repositoryPersonOperations;

	@Override
	public Person createNewPeson(Person person) {
		return repositoryPersonOperations.save(person);
	}

	@Override
	public Map<String, List<Person>> fetchAll() {
		List<Person> personList = repositoryPersonOperations.findAll();
		Map<String, List<Person>> responseMap = new HashMap<>();
			responseMap.put("person", personList);
		return responseMap;
	}

	@Override
	public Map<String, Person> fetchById(Integer personId) throws PersonNotFoundExceptionHandler {
		//Person person = repo.getOne(personId);
		Person person = repositoryPersonOperations.findById(personId).orElseThrow(() -> new PersonNotFoundExceptionHandler("Person for id "+personId+" not found"));
		Map<String, Person> responseMap = new HashMap<>();
			responseMap.put("person", person);
		return responseMap;
	}

	@Override
	public Map<String, Person> updatePerson(Person person) throws PersonNotFoundExceptionHandler{
		Person updated = null;
		Map<String, Person> responseMap = new HashMap<>();
		
		Person temp = repositoryPersonOperations.findById(person.getId()).orElseThrow(() -> new PersonNotFoundExceptionHandler("Person not found for id :"+person.getId()));
				
		if(temp != null) {
			updated = repositoryPersonOperations.save(person);
			responseMap.put("person", updated);
		}
		return responseMap;
	}

	@Override
	public boolean deletePersonById(Integer personId) throws PersonNotFoundExceptionHandler {
		boolean isDeleted = false;
		//repositoryPersonOperations.deleteById(personId);
		Person temp = repositoryPersonOperations.findById(personId).orElseThrow(() -> new PersonNotFoundExceptionHandler("Person not found for id :"+personId));
		if(temp != null) {
			repositoryPersonOperations.delete(temp);
			isDeleted = true;
		}
		
		return isDeleted;
	}

}
