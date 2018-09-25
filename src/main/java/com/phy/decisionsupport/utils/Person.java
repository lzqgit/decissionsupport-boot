package com.phy.decisionsupport.utils;

import java.util.List;

public class Person {

	private Long id;
	
	private String name;
	
	private List<String> books;

	public Person(long id,String name){
		this.id=id;
		
		this.name=name;
	}
	
	public Person(long id,String name,List<String> books){
		this(id,name);
		this.books=books;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getBooks() {
		return books;
	}

	public void setBooks(List<String> books) {
		this.books = books;
	}
	
	
	
}
