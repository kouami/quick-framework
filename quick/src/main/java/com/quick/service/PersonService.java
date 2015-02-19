/**
 * 
 */
package com.quick.service;

import java.util.List;

import com.quick.entities.Person;

/**
 * @author U329022
 *
 */
public interface PersonService {
	
	public void createPerson(Person p);
	public List<Person> listAllPersons();
	public void updatePerson(Person p);
	public void deletePerson(Person p);
	
}
