package com.example.demo.BookAppController;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;

import com.example.demo.BookAppEntity.BooksEntity;
import com.example.demo.Exception.DataNotFoundException;
import com.example.demo.bookServiceimpl.BooksServices;


@RestController

public class BookController {
	
	@Autowired
	private BooksServices bookServiceImpl;
	
	
	
	
	@GetMapping("/getBookById")
	
	public String getBookById(@RequestParam("id") Integer id) throws DataNotFoundException {
		
		BooksEntity bookEntity = bookServiceImpl.getBookById(id);
		
		return "book details with ID: " +bookEntity.getId() +" Author: " +bookEntity.getAuthor() + " Book Title: " +bookEntity.getTitle()
		+"Book Price:"+bookEntity.getPrice();
	}
	
	@PostMapping("/addBook")
	public String addBook(@RequestBody BooksEntity bookEntity) throws DataNotFoundException
	{
		 BooksEntity entity = bookServiceImpl.saveBook(bookEntity);
		 return "Book Added with Id: "  +entity.getId();
	}
	
	@DeleteMapping("/deleteBookById")
	public String deleteBook(@RequestParam("id") Integer id) throws DataNotFoundException
	{
		bookServiceImpl.deleteBookById(id);
		return "Book Deleted with Id:" +id;
		
	}
	
	@PutMapping("/updateBook")
	public String updatebooks(@RequestParam("id") Integer id, @RequestBody BooksEntity bookEntity)throws DataNotFoundException
	
	{
		
		Integer id1 = bookServiceImpl.updateBook(id, bookEntity);
		
		return "book updated with id: " +id1;
		
		
	}
	
	@GetMapping("/getBookByPrice")
	
	public List<BooksEntity> getBookByPrice(@RequestParam("price") Double price)throws DataNotFoundException{
		
		List<BooksEntity> bookEntity=bookServiceImpl.getBookByPrice(price);
		
		return bookEntity;
		
	}
	
	
}
