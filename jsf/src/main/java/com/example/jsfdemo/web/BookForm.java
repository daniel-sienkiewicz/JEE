package com.example.jsfdemo.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jsfdemo.domain.Books;
import com.example.jsfdemo.service.BookMenager;

@SessionScoped
@Named("bookF")
public class BookForm implements Serializable{
	private Books book = new Books();
	
	@Inject
	private BookMenager bookMenager;

	public Books getBook() {
		return book;
	}

	public void setBook(Books book) {
		this.book = book;
	}
	
	//Akcja - dodawanie ksiazki
	public String addBookA(){
		bookMenager.addBook(book);
		return null; //nastepny widok do renderowania - jaki wyswietlic nastepny (null - pozostanie na tym samym widoku		
		//return "bookList"; - bookList.xhtml
	}
	
	public List<Books> getAllBooks(){
		return bookMenager.getAllBooks();
	}
}