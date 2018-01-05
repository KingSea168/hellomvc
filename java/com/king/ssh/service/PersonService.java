package com.king.ssh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.king.ssh.dao.PersonDAO;
import com.king.ssh.entity.Person;

@Service
public class PersonService {
	@Autowired
	private PersonDAO personDAO;
	
	public List<Person> getPersons(){
		return personDAO.getPersons();
	}
	
	public Person getPersonById(String id){
		return personDAO.getPersonById(id);
	}
	
	public void updatePerson(Person person){
		personDAO.updatePerson(person);
	}
	
	public void savePerson(Person person) {
		personDAO.savePerson(person);
	}
	
	public void deletePersonById(String id){
		personDAO.deletePersonById(id);
	}
}
