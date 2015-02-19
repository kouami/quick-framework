/**
 * 
 */
package com.quick.dao;

import java.util.List;

import com.quick.entities.Person;

/**
 * @author U329022
 *
 */
public interface PersonDao {
	
	public void create(Person p);
	public List<Person> retrieve();	
	public void update(Person p);
	public void delete(Person p);
	
}
