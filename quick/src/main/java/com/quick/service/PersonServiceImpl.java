/**
 * 
 */
package com.quick.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quick.dao.PersonDao;
import com.quick.entities.Person;

/**
 * @author U329022
 *
 */
@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDao personDao;
	
	@Override
	public void createPerson(Person p) {
		personDao.create(p);
	}

	@Override
	public List<Person> listAllPersons() {
		return personDao.retrieve();
	}

	@Override
	public void updatePerson(Person p) {
		personDao.update(p);
	}

	@Override
	public void deletePerson(Person p) {
		personDao.delete(p);
	}

}
