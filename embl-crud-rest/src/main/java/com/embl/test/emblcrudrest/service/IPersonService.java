package com.embl.test.emblcrudrest.service;

import java.util.List;
import java.util.Map;

import com.embl.test.emblcrudrest.exceptions.PersonNotFoundExceptionHandler;
import com.embl.test.emblcrudrest.model.Person;

public interface IPersonService {
	public Person createNewPeson(Person person);
	public Map<String, List<Person>> fetchAll();
	public Map<String, Person> fetchById(Integer personId) throws PersonNotFoundExceptionHandler;
	public Map<String, Person> updatePerson(Person person) throws PersonNotFoundExceptionHandler;
	public boolean deletePersonById(Integer id) throws PersonNotFoundExceptionHandler;
}
