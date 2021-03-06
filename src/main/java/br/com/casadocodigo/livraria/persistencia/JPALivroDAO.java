package br.com.casadocodigo.livraria.persistencia;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import br.com.casadocodigo.livraria.modelo.Livro;

@Transactional
public class JPALivroDAO implements LivroDAO {
	
	private final EntityManager manager;
	
	@Inject
	public JPALivroDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	@Deprecated
	public JPALivroDAO() {
		this(null);
	}

	@Override
	public void adiciona(Livro livro) {
		if (livro.getId() == null) {
			this.manager.persist(livro);
		} else {
			this.manager.merge(livro);
		}
	}

	@Override
	public List<Livro> todos() {
		return this.manager
				.createQuery("select l from Livro l", Livro.class)
				.getResultList();
	}

	@Override
	public Livro buscaPorIsbn(String isbn) {
		try {
			return this.manager
					.createQuery("select l from Livro l where l.isbn = :isbn",
							Livro.class).setParameter("isbn", isbn)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
