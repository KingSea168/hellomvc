package com.king.ssh.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.king.ssh.entity.Person;
import com.king.ssh.service.PersonService;

@Controller
@RequestMapping(value="${adminPath}/person")
public class PersonController {
	@Autowired
	private PersonService personService;
	
	@RequestMapping(value="/main")
	public String main(Model model) {
		model.addAttribute("personlist", this.personService.getPersons());
		return "modules/person/main";
	}
	
	@RequestMapping(value="/addPrompt")
	public String savePrompt() {
		return "modules/person/addPerson";
	}
	
	@RequestMapping(value="/editPrompt")
	public String updatePrompt(Model model,String id) {
		model.addAttribute("person", this.personService.getPersonById(id));
		return "modules/person/editPerson";
	}
	
	@RequestMapping(value="/getPersons")
	@ResponseBody
	public List<Person> getPersons(){
		return personService.getPersons();
	}
	
	@RequestMapping(value="/getPersonById")
	@ResponseBody
	public Person getPersonById(String id){
		return personService.getPersonById(id);
	}
	
	@RequestMapping(value="/updatePerson")
	public String updatePerson(Person person){
		personService.updatePerson(person);
		return "redirect:main";
	}
	
	@RequestMapping(value="/savePerson")
	public String savePerson(Person person) {
		personService.savePerson(person);
		return "redirect:main";
	}
	
	@RequestMapping(value="/deletePersonById")
	public String deletePersonById(String id){
		personService.deletePersonById(id);
		return "redirect:main";
	}
}
