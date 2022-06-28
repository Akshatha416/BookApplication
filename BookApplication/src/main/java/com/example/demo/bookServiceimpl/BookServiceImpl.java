package com.example.demo.bookServiceimpl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.BookAppEntity.BooksEntity;
import com.example.demo.Exception.DataNotFoundException;
import com.example.demo.bookRepository.BookRepository;

@Service
public class BookServiceImpl implements BooksServices {

	@Autowired
	 private BookRepository booksRepo;
	
   @Override
	public BooksEntity getBookById(Integer id) throws DataNotFoundException {
	  
	   Optional<BooksEntity> entity = booksRepo.findById(id);
        
	   if(entity.isEmpty()) {
		   throw new  DataNotFoundException ("Book not found with this ID:"+id);
	   }
	   
	   else {return entity.get();}
	}
   
   @Override

	public BooksEntity saveBook(BooksEntity bookentity) throws DataNotFoundException {
		
		BooksEntity entity = booksRepo.save(bookentity);
		
		if(entity.getId()==null) {
			throw new  DataNotFoundException ("Book ID not added successfully "+bookentity.getId());
		}
		
		else { return entity;}
		
		
	}
   
   @Override

	public Integer updateBook(Integer id, BooksEntity bookentity) throws DataNotFoundException {
		
	   Optional<BooksEntity> entity = booksRepo.findById(id);
	   
	   if(entity.isEmpty()) {
		   throw new  DataNotFoundException ("Book is not found with this ID:"+id+"to update");
		   
	   }
	   else {
	   
	   @SuppressWarnings("deprecation")
		BooksEntity bookEntity1 =booksRepo.getById(id);
		bookEntity1.setTitle(bookentity.getTitle());
		bookEntity1.setAuthor(bookentity.getAuthor());
		return booksRepo.save(bookEntity1).getId();
	   }
	}
   
   
   @Override

	public void deleteBookById(Integer id)  throws DataNotFoundException  {
		
		booksRepo.deleteById(id);
		
	}

   @Override
   
   public List<BooksEntity> getBookByPrice(Double price) throws DataNotFoundException  {

	   
	   List<BooksEntity> bookslist=booksRepo.getBookByPrice(price);
	   
	   if(bookslist.isEmpty()) {
		   throw new  DataNotFoundException("book is not found with  price greater than"+price);
	   }

	   else {
		   return bookslist;}
	   }
 
   
}
