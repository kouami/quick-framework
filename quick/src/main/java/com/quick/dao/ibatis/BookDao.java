/**
 * 
 */
package com.quick.dao.ibatis;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.quick.entities.Book;

/**
 * @author U329022
 *
 */
public interface BookDao {
	
	final String INSERT = "insert into BOOK (TITLE, AUTHOR, ISBN) VALUES (#{title}, #{author}, #{isbn})";
	final String SELECT_ALL = "select * from BOOK";
	final String UPDATE = "update BOOK SET TITLE = #{title}, AUTHOR = #{author}, ISBN = #{isbn}";
	final String DELETE = "delete from BOOK where ID = #{id}";
	
	/**
	 * Insert an instance of Book into the database.
	 * @param book the instance to be persisted.
	 */
	@Insert(INSERT)
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void create(Book b);
	
	/**
	 * Returns the list of all Book instances from the database.
	 * @return the list of all Book instances from the database.
	 */
	@Select(SELECT_ALL)
	@Results(value = {
			@Result(property="id", column="ID"),
			@Result(property="title", column="TITLE"),
			@Result(property="author", column="AUTHOR"),
			@Result(property="isbn", column="ISBN")
	})
	public List<Book> retrieve();
	
	/**
	 * Updates an instance of Book in the database.
	 * @param book the instance to be updated.
	 */
	@Update(UPDATE)
	public void update(Book b);
	
	/**
	 * Updates an instance of Book in the database.
	 * @param isbn isbn value to be updated.
	 * @param id primary key value used for lookup.
	 */
	public void updateByIsbn(@Param("isbn") String isbn, @Param("id") long id);
	
	/**
	 * Delete an instance of Contact from the database.
	 * @param id primary key value of the instance to be deleted.
	 */
	@Delete(DELETE)
	public void delete(long id);
}
