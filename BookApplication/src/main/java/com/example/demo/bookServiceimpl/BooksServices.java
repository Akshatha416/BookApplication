package com.example.demo.bookServiceimpl;

import java.util.List;

import com.example.demo.BookAppEntity.BooksEntity;
import com.example.demo.Exception.DataNotFoundException;

public interface BooksServices {

public BooksEntity saveBook(BooksEntity booksentity) throws DataNotFoundException;
	
	public BooksEntity getBookById(Integer id) throws DataNotFoundException;
	
	public void deleteBookById(Integer id) throws DataNotFoundException;
	
	public List<BooksEntity> getBookByPrice(Double price)throws DataNotFoundException;

	public Integer updateBook(Integer id, BooksEntity bookEntity) throws DataNotFoundException;



}
