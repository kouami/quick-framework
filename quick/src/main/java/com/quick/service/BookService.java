/**
 * 
 */
package com.quick.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quick.dao.ibatis.BookDao;
import com.quick.entities.Book;

/**
 * @author U329022
 *
 */
@Service
public class BookService {
	
	@Autowired
	private BookDao mapper;
	
	public void create(Book b){
		mapper.create(b);
	}
	
	public List<Book> retrieve(){
		return mapper.retrieve();
	}
	
	public void update(Book b){
		mapper.update(b);
	}
	
	public void updateByIsbn(String isbn, long id){
		mapper.updateByIsbn(isbn, id);
	}
	
	public void delete(long id){
		mapper.delete(id);
	}
}
