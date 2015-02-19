/**
 * 
 */
package com.quick.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.quick.entities.Person;

/**
 * @author U329022
 *
 */
@Repository	
@Transactional
public class PersonDaoImpl implements PersonDao {

	@Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;
	
	@Override
	public void create(Person p) {
        getCurrentSession().save(p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> retrieve() {
		return getCurrentSession().createQuery("from Person").list();
	}

	@Override
	public void update(Person p) {
		getCurrentSession().merge(p);
	}

	@Override
	public void delete(Person p) {
		getCurrentSession().delete(p);
	}
	
	private Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}

}
