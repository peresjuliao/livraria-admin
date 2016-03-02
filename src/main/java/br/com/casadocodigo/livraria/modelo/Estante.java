package br.com.casadocodigo.livraria.modelo;

import java.util.List;

public interface Estante {
	
	void guarda(Livro livro);
	
	List<Livro> todoOsLivros();

	Livro buscaPorIsbn(String isbn);

}
