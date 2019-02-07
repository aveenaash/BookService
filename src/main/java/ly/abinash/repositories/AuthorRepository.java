package ly.abinash.repositories;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.hibernate.NonUniqueResultException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ly.abinash.entities.AuthorEntity;

@Repository
public class AuthorRepository {

	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Transactional
	public AuthorEntity save(AuthorEntity author) {
		entityManager.persist(author);
		return author;
	}
	
	public AuthorEntity findByEmail(String email) {
		Query query = (Query) entityManager
				.createQuery("select a from AuthorEntity a where " + "a.email = :email ");
		query.setParameter("email", email);
		try {
			return (AuthorEntity) query.getSingleResult();
		} catch (NoResultException | NonUniqueResultException  e) {
			return null;
		}
	}
	
	public AuthorEntity findById(Long id) {
		return (AuthorEntity)entityManager.find(AuthorEntity.class, id);
	}
}
