package ly.abinash.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ly.abinash.dtos.AuthorDto;
import ly.abinash.services.AuthorService;

@RestController
@RequestMapping(value = "/authors")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public AuthorDto saveBook(@RequestBody AuthorDto authorDto) throws Exception {
		return authorService.saveAuthor(authorDto);
	}
	

	
	

}
