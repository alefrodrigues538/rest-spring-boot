package br.com.virtuamoon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.virtuamoon.model.Person;
import br.com.virtuamoon.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonServices service;
	
//	private PersonServices service = new PersonServices();
	
	/**
	 * ---------------------------------------------------------
	 * FIRST CRUD WITH SPRINGBOOT FRAMEWORK
	 * ---------------------------------------------------------
	 */
	
	/**
	 * Find all Persons
	 * @return
	 */
	@RequestMapping(
			method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll() {
		return service.findAll();
	}
	
	/**
	 * Find Person BY ID
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}",
			method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable(value = "id") String id) {
		return service.findById(id);
	}
	
	/**
	 * Create/Add Person
	 * @param person
	 * @return
	 */
	@RequestMapping(
			method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person create(@RequestBody() Person person) {
		return service.create(person);
	}
	
	/**
	 * Update a Person
	 * @param person
	 * @return
	 */
	@RequestMapping(
			method=RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person update(@RequestBody() Person person) {
		return service.update(person);
	}
	
	/**
	 * Delete a Person
	 * @param id
	 */
	@RequestMapping(value="/{id}",
			method=RequestMethod.DELETE)
	public void delete(@PathVariable( value = "id") String id) {
		service.delete(id);
	}
	
}
