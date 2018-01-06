package com.king.ssh.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.king.ssh.entity.Person;

@Repository
@Transactional
public class PersonDAO {

	@Resource
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public List<Person> getPersons(){
		return (List<Person>)this.getSession().createCriteria(Person.class).list();
	}
	
	public Person getPersonById(String id){
		return (Person)this.getSession().createQuery("from Person where id = ?").setParameter(0, id).uniqueResult();
	}
	
	public void updatePerson(Person person){
		this.getSession().update(person);
	}
	
	public void savePerson(Person person) {
		this.getSession().save(person);
	}
	
	public void deletePersonById(String id){
		this.getSession().createQuery("delete Person where id=?").setParameter(0, id).executeUpdate();	
	}
}
