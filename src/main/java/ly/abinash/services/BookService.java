package ly.abinash.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ly.abinash.dtos.BookDto;
import ly.abinash.entities.AuthorEntity;
import ly.abinash.entities.BookEntity;
import ly.abinash.repositories.AuthorRepository;
import ly.abinash.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private BookRepository bookRepository;
	
	public List<BookDto> getDummyBooks(){
		List<BookDto> bookList = new ArrayList<BookDto>();
		 BookDto b1 = new BookDto();
		 b1.setId(1);
		 b1.setName("Harry Porter");
		 b1.setDescription("Harrys magica adventure");
		 b1.setYear(2005);
		 
		 BookDto b2 = new BookDto();
		 b2.setId(2);
		 b2.setName("Fast And Furious");
		 b2.setDescription("Fast Cars");
		 b2.setYear(2018);
		 
		 bookList.add(b1);
		 bookList.add(b2);
		 
		 return bookList;
	}
	
	public BookDto getBookById(int bookId) {
		BookDto book = new BookDto();
		book.setId(1);
		book.setName("First Book");
		book.setDescription("First ever written book");
		book.setYear(1990);
		
		return book;
	}
	
	
	public BookDto getSingleDummyBook(String  name) {
		BookDto book = new BookDto();
		book.setId(1);
		book.setName("Hello book");
		book.setDescription("Very sad book");
		book.setYear(1980);
		
		return book;
	}
	
	public void saveBook(BookDto bookDto) {
		System.out.println("Book saved : " + bookDto.toString());
	}
	
	public void updateBook(int id, BookDto bookDto) {
		System.out.println("Book updated : " +id+ "  : " + bookDto.toString());
	}
	
	public void saveBookToAuthor(Long authorId, BookDto bookDto) throws Exception {
		AuthorEntity author = authorRepository.findById(authorId);
		if(author == null) {
			throw new Exception("Author Not Found. Please create it.");
		} else {
			BookEntity bookEntity = new BookEntity();
			bookEntity.setName(bookDto.getName());
			bookEntity.setDescription(bookDto.getDescription());
			bookEntity.setYear(bookDto.getYear());
			bookEntity.setAuthor(author);
			bookRepository.save(bookEntity);	
			
		}
	}
	
}
