package com.example.demo.Controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.BookAppEntity.BooksEntity;

@RestController
public class FlipkartAppController {

	@GetMapping("/getBookDeatilsById")
	public String getBookDetails(@RequestParam Integer id) 
	{
		HttpHeaders headers=new HttpHeaders();
		HttpEntity<String> entity= new HttpEntity<String>(headers);
		RestTemplate restTemplate =new RestTemplate();
		String entity2 =  restTemplate.exchange("http://localhost:8081/getBookById?id="+id,HttpMethod.GET,entity,String.class).getBody();
		return  entity2;
		
	}
	
	
	@PostMapping("/addBooksDetails")
	public String addBooksDetails(@RequestBody BooksEntity bookEntity) 
	{
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<BooksEntity> entity= new HttpEntity<BooksEntity>(bookEntity, headers);
		RestTemplate restTemplate =new RestTemplate();
		String entity2 = restTemplate.exchange("http://localhost:8081/addBook",HttpMethod.POST,entity,String.class).getBody();
		return  entity2;
		
	}
	
	@DeleteMapping("/deleteBooksDetailsById")
	public String deleteBooksDetails(@RequestParam("id") Integer id)
	{
		HttpHeaders headers=new HttpHeaders();
		HttpEntity<String> entity= new HttpEntity<String>(headers);
		RestTemplate restTemplate =new RestTemplate();
		String entity2 =  restTemplate.exchange("http://localhost:8081/deleteBookById?id="+id,HttpMethod.DELETE,entity,String.class).getBody();
		return  entity2;
	}
	
	@PutMapping("/updateBookDetails")
	public String updateBookDetails(@RequestParam("id") Integer id,@RequestBody BooksEntity bookEntity) 

	{
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<BooksEntity> entity= new HttpEntity<BooksEntity>(bookEntity, headers);
		RestTemplate restTemplate =new RestTemplate();
		String entity2 =  restTemplate.exchange("http://localhost:8081/updateBook?id="+id,HttpMethod.PUT,entity,String.class).getBody();
		return  entity2;
	}

}
