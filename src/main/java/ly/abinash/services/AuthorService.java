package ly.abinash.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ly.abinash.dtos.AuthorDto;
import ly.abinash.dtos.BookDto;
import ly.abinash.entities.AuthorEntity;
import ly.abinash.repositories.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	public AuthorDto saveAuthor(AuthorDto authorDto) throws Exception {
		AuthorEntity existingAuthor = authorRepository.findByEmail(authorDto.getEmail());
		if(existingAuthor == null) {
			AuthorEntity authorEntity = new AuthorEntity();
			authorEntity.setFullName(authorDto.getFullName());
			authorEntity.setEmail(authorDto.getEmail());
			return convert(authorRepository.save(authorEntity));
		} else {
			throw new Exception("Author Already Exists");
		}		
	}

	private AuthorDto convert(AuthorEntity authorEntity) {
		AuthorDto authorDto = null;
		if (authorEntity != null) {
			authorDto = new AuthorDto();
			authorDto.setId(authorEntity.getId());
			authorDto.setEmail(authorEntity.getEmail());
			authorDto.setFullName(authorEntity.getFullName());
		}
		return authorDto;
	}

	public void updateBook(int id, BookDto bookDto) {
		System.out.println("Book updated : " + id + "  : " + bookDto.toString());
	}

}
