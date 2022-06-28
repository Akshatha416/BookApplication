package com.example.demo.bookRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.BookAppEntity.BooksEntity;

@Repository
public interface BookRepository extends JpaRepository <BooksEntity, Integer> {
	
	@Query(value= "select * from books_entity where price>?1",nativeQuery=true) 
	public List<BooksEntity> getBookByPrice(Double price);
	
	

}
