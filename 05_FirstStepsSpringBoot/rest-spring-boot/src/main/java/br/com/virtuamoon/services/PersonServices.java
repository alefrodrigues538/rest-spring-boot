package br.com.virtuamoon.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.virtuamoon.model.Person;

@Service
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	public List<Person> findAll() {
		List<Person> persons = new ArrayList<>();
		
		//CHAMARIA O BANCO DE DADOS AQUI!
		
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons ;
	}
	
	public Person findById(String id) {
		
		logger.info("Finding one person!");
		
		//CHAMARIA O BANCO DE DADOS AQUI!
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Alef");
		person.setLastName("Fernando");
		person.setAddress("Franca - São Paulo");
		person.setGender("Male");
		return person;
	}
	
	public Person create(Person person) {

		logger.info("Creating one person!");
		
		//CHAMARIA O BANCO DE DADOS AQUI!
		
		return person;
	}
	
	public Person update(Person person) {
		
		logger.info("Updating one person!");
		
		//CHAMARIA O BANCO DE DADOS AQUI!
		
		return person;
	}
	
	public void delete(String id) {
		
		logger.info("Deleting one person!");
		
		//CHAMARIA O BANCO DE DADOS AQUI!
	}
	
	
	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person name " + i);
		person.setLastName("Person lastname " + i);
		person.setAddress("Person address " + i);
		person.setGender("Person gender " + i);
		return person;
	}

	
}
