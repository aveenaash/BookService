package ly.abinash.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ly.abinash.dtos.BookDto;
import ly.abinash.services.BookService;

@RestController
@RequestMapping(value = "/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<BookDto> getAllBooks() {
		return bookService.getDummyBooks();
	}
	
	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	public BookDto getBookById(@PathVariable("id") int id) {
		return bookService.getBookById(id);
	}
	
	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public BookDto getBookByName(@RequestParam(value = "name", required = false) String name) {
		return bookService.getSingleDummyBook(name);
	}
	
	@RequestMapping(value = "/author/{authorId}", method = RequestMethod.POST)
	public void addBookToAuthor(@PathVariable Long authorId, @RequestBody BookDto bookDto) 
			throws Exception {
		bookService.saveBookToAuthor(authorId, bookDto);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public void saveBook(@RequestBody BookDto bookDto) {
		bookService.saveBook(bookDto);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void putBook(@PathVariable("id") int id, @RequestBody BookDto bookDto) {
		bookService.updateBook(id,bookDto);
	}
	
	

}
